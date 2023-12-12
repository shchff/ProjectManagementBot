package controller;

import controller.command.*;
import view.request.Request;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Контроллер
 */
public class Controller {

    private final Context context;

    /**
     * Конструктор контроллера
     */
    public Controller() {
        this.context = new Context(State.LISTENING, Commands.NULL, 0, new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Выполнение "быстрой" команды
     * @param command - выполняемая команда
     * @return response - результат
     */
    private Response executeQuickCommand(Commands command, String requestUserId) {
        if (command == Commands.EXIT) {
            ExitCommand exitCommand = new ExitCommand(Commands.EXIT, context.getArgs(), requestUserId);
            return exitCommand.perform();
        }
        else if (command == Commands.HELP) {
            HelpCommand helpCommand = new HelpCommand(Commands.HELP, context.getArgs(), requestUserId);
            return helpCommand.perform();
        }
        else if (command == Commands.START) {
            StartCommand startCommand = new StartCommand(Commands.START, context.getArgs(), requestUserId);
            return startCommand.perform();
        }
        return null;
    }

    /**
     * Выполнение "долгой" команды
     * @param arg - аргумент команды
     * @return response
     */
    private Response executeLongCommand(String arg, String requestUserId) {
        int iteration = context.getIteration();
        if (iteration > 0) {
            context.addArg(arg);
        }

        if (iteration < context.getParams().size()) {
            context.incrementIterator();
            return new Response("Введите " + context.getParams().get(iteration).getName(), new ArrayList<>(Collections.singletonList(requestUserId)), context.getParams().get(iteration).getRequestedTypes());
        }

        ArrayList<String> args = new ArrayList<>(context.getArgs());

        if (context.getCommand() == Commands.CREATE_PROJECT) {
            CreateProjectCommand createProjectCommand = new CreateProjectCommand(context.getCommand(), args, requestUserId);
            context.resetContextToListening();
            return createProjectCommand.perform();
        }
        else if (context.getCommand() == Commands.ADD_QUESTION) {
            AddQuestionCommand addQuestionCommand = new AddQuestionCommand(context.getCommand(), args, requestUserId);
            context.resetContextToListening();
            return addQuestionCommand.perform();
        }
        else if (context.getCommand() == Commands.ADD_TEAM_MEMBER) {
            AddTeamMemberCommand addTeamMemberCommand = new AddTeamMemberCommand(context.getCommand(), args, requestUserId);
            context.resetContextToListening();
            return addTeamMemberCommand.perform();
        }

        return new Response("Нет такого параметра!", new ArrayList<>(Collections.singletonList(requestUserId)));
    }

    /**
     * Начало выполнения "долгой" команды
     * @param command - выполняемая команда
     * @return response
     */
    private Response startLongCommand(Commands command, String requestUserId) {

        context.startExecutingCommand(command);
        if (command == Commands.CREATE_PROJECT) {
            Response firstCommandResponse = executeLongCommand("", requestUserId);
            return new Response("Начинается создание проекта\n" + firstCommandResponse.getResponse(), new ArrayList<>(Collections.singletonList(requestUserId)));
        }
        else if (command == Commands.ADD_QUESTION) {
            Response firstCommandResponse = executeLongCommand("", requestUserId);
            return new Response("Добавление вопроса:\n" + firstCommandResponse.getResponse(), new ArrayList<>(Collections.singletonList(requestUserId)));
        }
        else if (command == Commands.ADD_TEAM_MEMBER) {
            Response firstCommandResponse = executeLongCommand("", requestUserId);
            return new Response("Добавление участника:\n" + firstCommandResponse.getResponse(), new ArrayList<>(Collections.singletonList(requestUserId)));
        }
        return null;
    }
    /**
     * Обрабатывает запрос и дожидается ответа.
     * @param request запрос пользователя.
     * @return ответ на запрос пользователя.
     */

    public Response handleWithResponse(Request request) {

        String requestString = request.getRequest();

        String requestUserId = request.getUserId();

        if (requestString.isEmpty()) {
            return new Response("Запрос отсутствует", new ArrayList<>(Collections.singletonList(requestUserId)));
        }

        if (context.getState() == State.LISTENING) {
            if (requestString.charAt(0) == '/') {
                switch (requestString) {
                    case "/exit":
                        return executeQuickCommand(Commands.EXIT, requestUserId);
                    case "/help":
                        return executeQuickCommand(Commands.HELP, requestUserId);
                    case "/create_project":
                        return startLongCommand(Commands.CREATE_PROJECT, requestUserId);
                    case "/add_question":
                        return startLongCommand(Commands.ADD_QUESTION, requestUserId);
                    case "/add_team_member":
                        return startLongCommand(Commands.ADD_TEAM_MEMBER, requestUserId);
                    case "/start":
                        return executeQuickCommand(Commands.START, requestUserId);
                    default:
                        return new Response("Неизвестная команда", new ArrayList<>(Collections.singletonList(requestUserId)));
                }
            }
            else {
                return new Response("Запрос не является командой", new ArrayList<>(Collections.singletonList(requestUserId)));
            }
        }
        else if (context.getState() == State.EXECUTING) {
            return executeLongCommand(request.getRequest(), requestUserId);
        }

        return new Response("", new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
