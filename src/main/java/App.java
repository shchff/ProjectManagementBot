import controller.Controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateUtil;
import view.TelegramView;


public class App {
    // Задача 3

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {
        Session session = sessionFactory.openSession();

        Controller controller = new Controller();
        TelegramView telegramView = new TelegramView(controller);
        telegramView.startDialog();


        session.getTransaction().begin();

//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setDescription("ggh");
//
//        //==save, но save не надо юзать
//        session.persist(projectEntity);



//        for (ProjectEntity something : result) {
//            System.out.println(something);
//        }

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
