package quizportal.quizportal.model;

import java.util.*;

import javax.persistence.*;





@Entity
public class role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String rolename;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<userrole> userroles= new HashSet<>();
    
    public role(){
        super();
    }
    public role(int id, String rolename, Set<userrole> userroles) {
        this.id = id;
        this.rolename = rolename;
        this.userroles = userroles;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public Set<userrole> getUserroles() {
        return userroles;
    }
    public void setUserroles(Set<userrole> userroles) {
        this.userroles = userroles;
    }
    @Override
    public String toString() {
        return "role [id=" + id + ", rolename=" + rolename + ", userroles=" + userroles + "]";
    }

    
    
}
