package quizportal.quizportal.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class userrole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userroleId;

    @ManyToOne
    private userlogin user;

    @ManyToOne
    private role role;

    public userrole(long userroleId, userlogin user, quizportal.quizportal.model.role role) {
        this.userroleId = userroleId;
        this.user = user;
        this.role = role;
    }

    public userrole() {
        super();
    }

    public long getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(long userroleId) {
        this.userroleId = userroleId;
    }

    public userlogin getUser() {
        return user;
    }

    public void setUser(userlogin user) {
        this.user = user;
    }

    public role getRole() {
        return role;
    }

    public void setRole(quizportal.quizportal.model.role roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "userrole [role=" + role + ", user=" + user + ", userroleId=" + userroleId + "]";
    }
    
    
    
   
}
