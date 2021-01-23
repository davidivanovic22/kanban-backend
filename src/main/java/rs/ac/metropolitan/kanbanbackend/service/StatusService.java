package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Status;

import java.util.List;

public  interface StatusService {

	List<Status> findAll();

	Status save(Status status);

	Status update(Status status);

	Status findById(Integer statusID);

	void deleteById(Integer statusID);

}