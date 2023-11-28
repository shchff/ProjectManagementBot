package view.request;

/**
 * Запрос пользователя
 */
public class Request
{
    private final String request;
    private final String userId;

    public Request(String request, String userId) {
        this.request = request;
        this.userId = userId;
    }

    /**
     * @return возвращает запрос пользователя
     */
    public String getRequest() {
        return request;
    }

    public String getUserId() {
        return userId;
    }
}