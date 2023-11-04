package controller;

import controller.command.Commands;
import request.Request;
import response.Response;

public class CLIController extends Controller {

    private final Context context;

    public CLIController(State state) {
        this.context = new Context(state, Commands.NULL, 0);
    }

    private Response executeQuickCommand(Commands command) {
        if (command == Commands.EXIT){
            return new Response("Работа бота завершена");
        }
        else if (command == Commands.HELP) {
            return new Response("Я - бот для работы с проектом");
        }
        return null;
    }



    private Response executeLongCommand(Commands command, String arg) {
        if (command == Commands.CREATE_PROJECT) {
            // здесь выполняется создание проекта
            // context.iteration
            // if context.iteration = 0
            // context.iteration += 1
            // return new Response("Введи название");
            // if context.iteration = 1
            // context.iteration += 1
            // name = arg
            //  return new Response("Введи сроки");
            //  ...
            // if context.iteration = last
            // args = arg
            // context.iteration += 1
            // CreateProgectCommand.perform(args)
            // context.resetContextToListening();
            // return new Response("Проект создан")

            return new Response("А");
        }
        return new Response("Нет такой комманды!");
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

        return new Response("ЫЫЫЫЫ");
    }
}
