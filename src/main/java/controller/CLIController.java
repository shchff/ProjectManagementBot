package controller;

import controller.command.Commands;
import controller.command.CreateProjectCommand;
import request.Request;
import response.Response;

import java.util.ArrayList;

public class CLIController extends Controller {

    private final Context context;

    public CLIController(State state) {
        this.context = new Context(state, Commands.NULL, 0, new ArrayList<String>());
    }

    private Response executeQuickCommand(Commands command) {
        if (command == Commands.EXIT){
            return new Response("Работа бота завершена");
        }
        else if (command == Commands.HELP) {
            return new Response("Я - бот для работы с проектом. Вот список моих команд:\n " +
                                "/createProject - создание проекта \n " +
                                "/createThemes - редактирование тем проекта\n" +
                                " /exit - завершение работы бота");
        }
        return null;
    }

    private Response executeLongCommand(Commands command, String arg) {
        if (command == Commands.CREATE_PROJECT) {
            if (context.iteration < 3) {
                if (context.iteration == 0) {
                    context.incrementIterator();
                    return new Response("Введи название");
                }
                else if (context.iteration == 1) {
                    context.incrementIterator();
                    context.args.add(arg);
                    return new Response("Введи сроки");
                }
                else if (context.iteration == 2) {
                    context.incrementIterator();
                    context.args.add(arg);
                    return new Response("Введи описание");
                }
            }
            else {
                context.args.add(arg);

                ArrayList<String> args = new ArrayList<>();
                args.addAll(context.args);

                CreateProjectCommand createProjectCommand = new CreateProjectCommand(command, args);
                context.resetContextToListening();
                return createProjectCommand.perform();
            }

        }
        return new Response("Нет такого параметра!");
    }

    private Response startLongCommand(Commands command) {

        context.startExecutingCommand(command);

        if (command == Commands.CREATE_PROJECT) {
            Response firstCommandResponse = executeLongCommand(command, "");
            return new Response("Начинается создание проекта\n" + firstCommandResponse.getResponse());
        }

        return null;
    }

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
            return executeLongCommand(context.command, request.getRequest());
        }

        return new Response("");
    }
}
