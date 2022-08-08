package quizportal.quizportal.model;

public class JWTresponse {

    String token;

    public JWTresponse(String token) {
        this.token = token;
    }

    public JWTresponse() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
