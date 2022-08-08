/*package quizportal.quizportal.SecurityConfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import quizportal.quizportal.service.impl.userSecurityServiceImpl;

@Component
public class JWTauthenticationFilter extends OncePerRequestFilter
{   
    @Autowired
    private userSecurityServiceImpl userSecurityServiceImpl;

    @Autowired
    private JwtUtil JwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
                final String requestTokenHeader= request.getHeader("Authorization");
                System.out.println(requestTokenHeader);
                String username=null;
                String jwtToken=null;

                if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
                {
                  
                    jwtToken= requestTokenHeader.substring(7);
                    try{

                     username= this.JwtUtil.extractUsername(jwtToken);
                } catch(ExpiredJwtException e){
                       e.printStackTrace();
                       System.out.println("JWT token is expired");
                }catch(Exception e)
                {
                    e.printStackTrace();
                    System.out.println("Error");
                }
            }
                
                else{
                System.out.println("Invalid Toker,not start with bearer string");
                }

                //validating token

                if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                    final UserDetails loadUserByUsername = this.userSecurityServiceImpl.loadUserByUsername(username);

                    if(this.JwtUtil.validateToken(jwtToken, loadUserByUsername)){
                        
                        UsernamePasswordAuthenticationToken UsernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(loadUserByUsername,null,loadUserByUsername.getAuthorities());
                        UsernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthentication);
                    }
                }else
                {  
                    System.out.println("Token is not valid");
                } 

                filterChain.doFilter(request, response);
                
            }
    


}
*/