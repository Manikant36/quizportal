package quizportal.quizportal.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import quizportal.quizportal.model.Role;

public interface roleRepository extends  JpaRepository<Role,Long>
{
    
}
