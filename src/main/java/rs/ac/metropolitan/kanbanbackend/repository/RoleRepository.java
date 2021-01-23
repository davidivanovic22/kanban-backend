package rs.ac.metropolitan.kanbanbackend.repository;

import rs.ac.metropolitan.kanbanbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface RoleRepository extends JpaRepository<Role, Integer> {

}