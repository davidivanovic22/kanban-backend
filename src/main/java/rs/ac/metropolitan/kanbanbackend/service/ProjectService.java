package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Project;

import java.util.List;

public  interface ProjectService {

	List<Project> findAll();

	Project save(Project project);

	Project update(Project project);

	Project findById(Integer projectID);

	void deleteById(Integer projectID);

}