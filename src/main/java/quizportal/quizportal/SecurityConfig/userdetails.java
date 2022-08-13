/*package quizportal.quizportal.SecurityConfig;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import quizportal.quizportal.model.Authority;
import quizportal.quizportal.model.role;
import quizportal.quizportal.model.userlogin;
import quizportal.quizportal.model.userrole;




public class userdetails implements UserDetails
{
    
    private userlogin ulogin;

   

    public userdetails(userlogin ulogin) {
        this.ulogin = ulogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
       // SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(urole.getRole().getRolename());
        return null;
    }

    @Override
    public String getPassword() {
        
        return ulogin.getPassword();
    }

    @Override
    public String getUsername() {
       
        return ulogin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }   

}*/
