package rs.ac.metropolitan.kanbanbackend.repository;

import rs.ac.metropolitan.kanbanbackend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface TaskRepository extends JpaRepository<Task, Integer> {

}