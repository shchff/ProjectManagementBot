package controller;

import model.project.Project;
import controller.command.Commands;
import view.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Facade - обработчик запросов
 */
public abstract class Facade {
    /**
     * Добавляет проект в базу данных
     * @param project - проект
     * @return response с сообщением о создании нового проекта
     */
    static public Response createProject(Project project) {
        // добавление в бд
        return new Response("Проект создан!\nНазвнание проекта: " + project.getProjectName() + "\nСроки: " + project.getDeadlines() + "\nОписание: " + project.getDescription());
    }

    /**
     * Отправляет сообщение о выходе из бота
     * @return response с сообщением о выходе
     */
    static public Response exitBot() {
        return new Response("Работа бота завершена");
    }

    /**
     * Оптравляет сообщение с информацией о боте
     * @return response сообщение с перечислением доступных команд
     */
    static public Response getHelp() {
        return new Response("Я - бот для работы с проектом. Вот список моих команд:\n " +
                "/create_project - создание проекта \n " +
                "/create_themes - редактирование тем проекта\n" +
                " /exit - завершение работы бота");
    }

    /**
     * Возвращает параметры, которые надо заполнить
     * @param command - комманда, в соответствии с которой надо вернуть параметры
     * @return список параметров
     */
    static public ArrayList<String> getParamsByCommand(Commands command) {
        ArrayList<String> response = new ArrayList<String>();
        if (command == Commands.CREATE_PROJECT) {
            String[] params = {"название", "сроки", "описание"};
            response.addAll(new ArrayList<String>(Arrays.asList(params)));
        }
        return response;
    }


    /**
     * Приветственное сообщение
     * @return response - сообщение приветсвования + (в будущем) внутренняя авторизация
     */
    public static Response getStartMessage() {
        return new Response("\"Привет! Я ProjectManagementBot! Введите ваш запрос:\"");
    }
}
