package model;

import controller.Project;
import response.Response;

public abstract class Facade {
    static public Response createProject(Project project) {
        // добавление в бд
        return new Response("Проект создан");
    }
}
