package quizportal.quizportal.model;

public class JWTrequest {

    private String username;
    private String password;

    public JWTrequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JWTrequest() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
