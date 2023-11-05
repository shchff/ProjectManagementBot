package controller;


/**
 * Проект
 * projectName - название
 * deadlines - сроки
 * description - описание проекта
 */

public class Project {

    public Project(String projectName, String deadlines, String description) {
        this.projectName = projectName;
        this.deadlines = deadlines;
        this.description = description;
    }

    private String projectName;
    private String deadlines;
    private String description;
//    private List<TeamMember> TeamList;

}