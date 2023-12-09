package model;

public class User {

    private String username;
    private Role role;
    private Long userId;

    public User(String username, Role role, Long userId) {
        this.username = username;
        this.role = role;
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
