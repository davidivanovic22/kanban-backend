package rs.ac.metropolitan.kanbanbackend.repository;

import rs.ac.metropolitan.kanbanbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}