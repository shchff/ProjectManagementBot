package controller;

import controller.command.Commands;
import controller.command.CreateProjectCommand;
import controller.command.ExitCommand;
import controller.command.HelpCommand;
import request.Request;
import response.Response;

import java.util.ArrayList;

/**
 * Контроллер командной строки
 */
public class CLIController extends Controller {

    private final Context context;

    /**
     * Конструктор контроллера
     */
    public CLIController() {
        this.context = new Context(State.LISTENING, Commands.NULL, 0, new ArrayList<String>(), new ArrayList<String>());
    }

    /**
     * Выполнение "бастрой" команды
     * @param command - выполняемая команда
     * @return response - результат
     */
    private Response executeQuickCommand(Commands command) {
        if (command == Commands.EXIT) {
            ExitCommand exitCommand = new ExitCommand(Commands.EXIT, context.args);
            return exitCommand.perform();
        }
        else if (command == Commands.HELP) {
            HelpCommand helpCommand = new HelpCommand(Commands.HELP, context.args);
            return helpCommand.perform();
        }
        return null;
    }

    /**
     * Выполнение "долгой" команды
     * @param arg
     * @return response
     */
    private Response executeLongCommand(String arg) {
        int iteration = context.iteration;
        if (iteration > 0) {
            context.args.add(arg);
        }

        if (iteration < context.params.size()) {
            context.incrementIterator();
            return new Response("Введите " + context.params.get(iteration));
        }

        ArrayList<String> args = new ArrayList<>(context.args);

        if (context.command == Commands.CREATE_PROJECT) {
            CreateProjectCommand createProjectCommand = new CreateProjectCommand(context.command, args);
            context.resetContextToListening();
            return createProjectCommand.perform();
        }
        return new Response("Нет такого параметра!");
    }

    /**
     * Начало выполнения "долгой" комманды
     * @param command
     * @return
     */
    private Response startLongCommand(Commands command) {

        context.startExecutingCommand(command);
        if (command == Commands.CREATE_PROJECT) {
            Response firstCommandResponse = executeLongCommand("");
            return new Response("Начинается создание проекта\n" + firstCommandResponse.getResponse());
        }

        return null;
    }
    /**
     * Обрабатывает запрос и дожидается ответа.
     * @param request запрос пользователя.
     * @return ответ на запрос пользователя.
     */
    @Override
    public Response handleWithResponse(Request request) {

        String requestString = request.getRequest();

        if (requestString.isEmpty()) {
            return new Response("Запрос отсутствует");
        }

        if (context.state == State.LISTENING) {
            if (requestString.charAt(0) == '/') {
                switch (requestString) {
                    case "/exit":
                        return executeQuickCommand(Commands.EXIT);
                    case "/help":
                        return executeQuickCommand(Commands.HELP);
                    case "/createProject":
                        return startLongCommand(Commands.CREATE_PROJECT);
                    default:
                        return new Response("Неизвестная команда");
                }
            }
            else {
                return new Response("Запрос не является командой");
            }
        }
        else if (context.state == State.EXECUTING) {
            return executeLongCommand(request.getRequest());
        }

        return new Response("");
    }
}
