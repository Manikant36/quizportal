package quizportal.quizportal.service;
import java.util.*;

import quizportal.quizportal.model.User;
import quizportal.quizportal.model.UserRole;

public interface userService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);
}
