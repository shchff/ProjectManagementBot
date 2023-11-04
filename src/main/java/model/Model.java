package model;

import request.Request;
import response.Response;

public class Model {
    public Response processRequest(Request request) {
        String input = request.getRequest();
        // Логика обработки входящего запроса бота
        String output = "Ответ на входной запрос: " + input;
        return new Response(output);
    }
}