package view.response;

/**
 * Ответ на пользовательский запрос
 */
public class Response {

    private final String response;

    public Response(String response) {
        this.response = response;
    }

    /**
     * @return ответ на запрос пользователя
     */
    public String getResponse() {
        return response;
    }
}
