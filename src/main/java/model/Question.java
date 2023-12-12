package model;

public class Question {
    private String question;
    private TeamMember asker;

    public Question(String question, TeamMember asker) {
        this.question = question;
        this.asker = asker;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public TeamMember getAsker() {
        return asker;
    }

    public void setAsker(TeamMember asker) {
        this.asker = asker;
    }
}
