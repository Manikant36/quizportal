package quizportal.quizportal.service;
import java.util.*;

import quizportal.quizportal.model.userlogin;
import quizportal.quizportal.model.userrole;

public interface userService {
    
    public userlogin createUser(userlogin user, Set<userrole> userRoles) throws Exception;
}
