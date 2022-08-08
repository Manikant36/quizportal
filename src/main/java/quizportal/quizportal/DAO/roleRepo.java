package quizportal.quizportal.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import quizportal.quizportal.model.role;

public interface roleRepo extends  JpaRepository<role,Long>
{
    
}
