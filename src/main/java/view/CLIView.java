package view;

import controller.CLIController;
import request.Request;
import response.Response;

import java.util.Scanner;

public class CLIView implements View {
    private final CLIController controller;

    public CLIView(CLIController controller) {
        this.controller = controller;
    }

    public void startDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Я ProjectManagementBot! Введите ваш запрос:");
        while (true) {
            String input = scanner.nextLine();

            Request request = new Request(input);

            Response response = controller.handleWithResponse(request);

            System.out.println(response.getResponse());

            if (response.getResponse().equals("Работа бота завершена")) {
                break;
            }
        }
    }
}
