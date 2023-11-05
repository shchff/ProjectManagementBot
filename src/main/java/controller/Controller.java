package controller;

import request.Request;
import response.Response;

/**
 * Контроллер
 */
public abstract class Controller {

    /**
     * Обрабатывает запрос и дожидается ответа.
     * @param request запрос пользователя.
     * @return ответ на запрос пользователя.
     */
    public abstract Response handleWithResponse(Request request);
}