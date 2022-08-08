package quizportal.quizportal.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import quizportal.quizportal.service.impl.userSecurityServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class mySecurityConfig extends WebSecurityConfigurerAdapter
{   
    // @Autowired
    // private JWTauthenticationEntryPoint unathorizedHandler;

    // @Autowired
    // private JWTauthenticationFilter JWTauthenticationFilter;
    
    // @Autowired
    // private userSecurityServiceImpl userSecurityServiceImpl; 

    

   @Bean
   protected UserDetailsService getuserDetailsService() {
      
       return new userSecurityServiceImpl()  ;
   }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(this.getuserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        // auth.userDetailsService(this.userDetailsService()).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().withUser("manikant").password("password").roles("Admin");
      
      
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http
        .httpBasic()
        
        .disable()
        .cors()
        .disable()
        .authorizeHttpRequests()
        .antMatchers("/user/").hasRole("Admin")
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest().authenticated();
       .and()
        .exceptionHandling()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
       /*http.addFilterBefore(JWTauthenticationFilter, UsernamePasswordAuthenticationFilter.class);*/

       http.
       httpBasic()
       .and()
       .authorizeRequests()
       .antMatchers("/user/").hasAnyRole("Admin","User")
       .antMatchers(HttpMethod.OPTIONS).permitAll()
       .anyRequest().authenticated()
       .and()
       .formLogin();
       
        
    }
    
}
