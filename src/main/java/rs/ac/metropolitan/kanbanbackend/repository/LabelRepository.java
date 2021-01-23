package rs.ac.metropolitan.kanbanbackend.repository;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface LabelRepository extends JpaRepository<Label, Integer> {

}