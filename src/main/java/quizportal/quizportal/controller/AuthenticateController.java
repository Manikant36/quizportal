package quizportal.quizportal.controller;

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

import quizportal.quizportal.Helper.UserNotFoundException;
import quizportal.quizportal.SecurityConfig.JwtUtils;
import quizportal.quizportal.model.JWTrequest;
import quizportal.quizportal.model.JWTresponse;
import quizportal.quizportal.service.impl.UserDetailsServiceImpl;

@RestController
public class AuthenticateController {
    
    @Autowired
    private AuthenticationManager authenticationManager; 
    
    @Autowired
    private UserDetailsServiceImpl uServiceImpl;
    
    @Autowired
    private JwtUtils jwtUtils;


    // Generate token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JWTrequest jwtRequest) throws Exception {

        try {

            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());


        } catch (final UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException("User not found ");
        }

        /////////////authenticate

        UserDetails userDetails = this.uServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JWTresponse(token));
    }


    private void authenticate(String username, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }
    }


}
