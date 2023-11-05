package controller;

/**
 * Член команды
 */
public abstract class TeamMember {

    private String memberID;
    private Role role;

    private void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}