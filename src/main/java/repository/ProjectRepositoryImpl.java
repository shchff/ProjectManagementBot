package repository;

import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(project);
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
