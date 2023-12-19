import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.Entity.ProjectEntity;
import repository.HibernateUtil;
import view.TelegramView;


public class App {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {

        TelegramView telegramView = new TelegramView();
        telegramView.startDialog();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setDescription("ggh");

        //==save, но save не надо юзать
        session.persist(projectEntity);



//        for (ProjectEntity something : result) {
//            System.out.println(something);
//        }

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
