package repository;

import model.project.Project;

import java.util.List;

public interface ProjectRepository {
    Project findById(int id);
    List<Project> findAll();
    void save(Project project);
    void update(Project project);
    void delete(Project project);
}
