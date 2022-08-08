package quizportal.quizportal.model;

import java.util.HashSet;
import java.util.*;
import java.util.Set;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class userlogin 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String contact;
    private String password;
    private String about;
    private boolean enable=true;

    @Column(name = "socialmedia")
    private ArrayList<String> smprofile;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<userrole> userroles= new HashSet<>();


    
    public Set<userrole> getUserroles() {
        return userroles;
    }

    public void setUserroles(Set<userrole> userroles) {
        this.userroles = userroles;
    }

    public userlogin(long id, String username, String firstname, String lastname, String email, String contact,
            String password, ArrayList<String> smprofile, String about, boolean enable, Set<userrole> userroles) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.smprofile = smprofile;
        this.about = about;
        this.enable = enable;
        this.userroles = userroles;
    }

  
    public userlogin(){
        super();
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

  
    public String getUsername() {
        return username;
    }

       public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<String> getSmprofile() {
        return smprofile;
    }
    public void setSmprofile(ArrayList<String> smprofile) {
        this.smprofile = smprofile;
      
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public boolean isEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "userlogin [about=" + about + ", contact=" + contact + ", password=" + password + ", email=" + email + ", enable="
                + enable + ", firstname=" + firstname + ", id=" + id + ", lastname=" + lastname + ", smprofile="
                + smprofile + ", username=" + username + ", userroles=" + userroles + "]";
    }

    

}
