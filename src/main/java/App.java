import controller.Controller;
import org.hibernate.Session;
import view.TelegramView;


public class App {
    // Задача 3
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Controller controller = new Controller();
        TelegramView telegramView = new TelegramView(controller);
        telegramView.startDialog();
        session.close();
        HibernateUtil.shutdown();
    }
}
