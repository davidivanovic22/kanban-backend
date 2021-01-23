package rs.ac.metropolitan.kanbanbackend.repository;

import rs.ac.metropolitan.kanbanbackend.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface StatusRepository extends JpaRepository<Status, Integer> {

}