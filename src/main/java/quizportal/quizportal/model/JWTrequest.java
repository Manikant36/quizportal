package quizportal.quizportal.model;

public class JWTrequest {

    String username;
    String password;

    public JWTrequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JWTrequest() {
    }
    
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
