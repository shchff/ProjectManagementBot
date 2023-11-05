package model;

import controller.Project;
import response.Response;
/**
 * Facade - обработчик запросов в компоненте model
 */
public abstract class Facade {
    /**
     * Добавляет проект в базу данных
     * @param project
     * @return response
     */
    static public Response createProject(Project project) {
        // добавление в бд
        return new Response("Проект создан");
    }
    static public Response exitBot() {
        return new Response("Работа бота завершена");
    }

    static public Response getHelp() {
        return new Response("Я - бот для работы с проектом. Вот список моих команд:\n " +
                "/createProject - создание проекта \n " +
                "/createThemes - редактирование тем проекта\n" +
                " /exit - завершение работы бота");
    }
}
