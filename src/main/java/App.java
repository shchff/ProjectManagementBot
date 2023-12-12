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
