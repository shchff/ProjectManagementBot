import controller.Controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateUtil;
import view.TelegramView;


public class App {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {
        Session session = sessionFactory.openSession();

        TelegramView telegramView = new TelegramView();
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
