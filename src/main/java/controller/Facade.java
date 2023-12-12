package controller;

import model.Project;
import controller.command.Commands;
import view.response.RequestedTypes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Facade - обработчик запросов
 */
public abstract class Facade {
    /**
     * Добавляет проект в базу данных
     * @param project - проект
     * @return string с сообщением о создании нового проекта
     */
    static public String createProject(Project project) {
        // добавление в бд
        return "Проект создан!\nНазвание проекта: " + project.getProjectName() + "\nСроки: " + project.getDeadlines().getStart() + " - " + project.getDeadlines().getEnd()  + "\nОписание: " + project.getDescription();
    }

    /**
     * Отправляет сообщение о выходе из бота
     * @return string с сообщением о выходе
     */
    static public String exitBot() {
        return "Работа бота завершена";
    }

    /**
     * Отправляет сообщение с информацией о боте
     * @return string сообщение с перечислением доступных команд
     */
    static public String getHelp() {
        return "Я - бот для работы с проектом. Вот список моих команд:\n " +
                "/create_project - создание проекта \n " +
                "/create_themes - редактирование тем проекта\n" +
                " /exit - завершение работы бота";
    }

    /**
     * Возвращает параметры, которые надо заполнить
     * @param command - команда, в соответствии с которой надо вернуть параметры
     * @return список параметров
     */
    static public ArrayList<Param> getParamsByCommand(Commands command) {
        ArrayList<Param> response = new ArrayList<>();
        if (command == Commands.CREATE_PROJECT) {
            Param[] params = {new Param("название", RequestedTypes.TEXT), new Param("начало", RequestedTypes.DATE), new Param("окончание", RequestedTypes.DATE), new Param("описание", RequestedTypes.TEXT)};

            response.addAll(new ArrayList<>(Arrays.asList(params)));
        }
        return response;
    }


    /**
     * Приветственное сообщение
     * @return String - сообщение "Привет!..." + (в будущем) внутренняя авторизация
     */
    public static String getStartMessage(String id) {
        return "\"Привет! Я ProjectManagementBot! Ваши проекты: .... Ваша должность: .... Введите ваш запрос:\"";
    }
}
