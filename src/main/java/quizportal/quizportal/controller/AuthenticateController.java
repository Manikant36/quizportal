/*package quizportal.quizportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import quizportal.quizportal.SecurityConfig.JwtUtil;
import quizportal.quizportal.model.JWTrequest;
import quizportal.quizportal.model.JWTresponse;
import quizportal.quizportal.service.impl.userSecurityServiceImpl;

@RestController
public class AuthenticateController {
    
    @Autowired
    private AuthenticationManager authenticationManager; 
    
    @Autowired
    private userSecurityServiceImpl uServiceImpl;
    
    @Autowired
    private JwtUtil jwtUtil;


    // Generate token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JWTrequest jwtTrequest) throws Exception
    {

        try {
            
            authenticate(jwtTrequest.getUserName(),jwtTrequest.getPassword());

        } catch (UsernameNotFoundException e) {
            
            e.printStackTrace();

            throw new Exception("Username not found: "+e.getMessage());
        }

        // Authenticate user

        UserDetails userdetails = this.uServiceImpl.loadUserByUsername(jwtTrequest.getUserName());

        String generateTokenNew = this.jwtUtil.generateToken(userdetails);

        return ResponseEntity.ok(new JWTresponse(generateTokenNew));
    }

    // to Authenticate token
    private void authenticate(String username,String password) throws Exception
    {

        try {
            
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

          
           throw new Exception ("User Disabled : " +e.getMessage());
        } catch(BadCredentialsException e)
        {   
            
            throw new Exception("Invalid Credentials: " + e.getMessage());
        }

    }

}*/
