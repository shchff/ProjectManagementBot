package view.request;

/**
 * Запрос пользователя
 */
public class Request
{

    private final String request;
    private final Long userId;

    public Request(String request, Long userId) {
        this.request = request;
        this.userId = userId;
    }

    /**
     * @return возвращает запрос пользователя
     */
    public String getRequest() {
        return request;
    }
}