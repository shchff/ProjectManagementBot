import org.hibernate.SessionFactory;
import repository.Entity.ProjectEntity;
import repository.HibernateUtil;
import repository.ProjectRepository;
import repository.ProjectRepositoryImpl;
import view.TelegramView;


public class App {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {

        TelegramView telegramView = new TelegramView();
        telegramView.startDialog();

        ProjectRepository projectRepository = new ProjectRepositoryImpl();

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setDescription("main");

        projectRepository.save(projectEntity);


    }
}
