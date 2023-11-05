package request;

/**
 * Запрос пользователя
 */
public class Request
{

    private final String request;

    public Request(String request) {
        this.request = request;
    }

    /**
     * @return возвращает запрос пользователя
     */
    public String getRequest() {
        return request;
    }
}