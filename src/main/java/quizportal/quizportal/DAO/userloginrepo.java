package quizportal.quizportal.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import org.springframework.data.mongodb.repository.Query;
// import org.springframework.data.repository.query.Param;

import quizportal.quizportal.model.userlogin;

public interface userloginrepo extends JpaRepository<userlogin,Long>
{   
    
    @Query("Select u from userlogin u where u.username= :username")
    public userlogin findByUsername(@Param("username") String username);

    
}
