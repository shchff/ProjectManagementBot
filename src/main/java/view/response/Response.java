package view.response;

import java.util.ArrayList;

/**
 * Ответ на пользовательский запрос
 * response - текст ответа
 * responseUserIds - айди пользователей, которым вернётся ответ
 */
public class Response {
    private final String response;
    private final ArrayList<String> responseUserIds;

    public Response(String response, ArrayList<String> responseUserIds) {
        this.response = response;
        this.responseUserIds = responseUserIds;
    }

    public String getResponse() {
        return response;
    }
    public ArrayList<String> getResponseUserIds() {
        return responseUserIds;
    }
}
