package repository;

import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.Entity.ProjectEntity;

import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    private final SessionFactory sessionFactory;

    public ProjectRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Project findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, id);
        }
    }

    @Override
    public List<Project> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return null;
//                    session.createQuery("FROM Project", Project.class).list();
        }
    }


    @Override
    public void save(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setDescription(project.getDescription());
        projectEntity.setTitle(projectEntity.getTitle());
        projectEntity.setTimeStart(projectEntity.getTimeStart());
        projectEntity.setTimeEnd(projectEntity.getTimeEnd());

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(projectEntity);
            transaction.commit();
        }
    }

    @Override
    public void update(Project user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void delete(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(project);
            transaction.commit();
        }
    }
}
