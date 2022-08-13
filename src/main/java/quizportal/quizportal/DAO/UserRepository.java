package quizportal.quizportal.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import quizportal.quizportal.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{   
    
    public User findByUsername(String username);

    
}
