package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;

import java.util.List;

public  interface TaskService {

	List<Task> findAll();

	Task save(Task task);

	Task update(Task task);

	Task findById(Integer taskID);

	void deleteById(Integer taskID);

	List<Label> findAllLabelListById(Integer taskID);

	List<Label> addLabelListById(Integer TaskID, List<Label> labelList);

	List<Label> setLabelListById(Integer TaskID, List<Label> labelList);

	List<Label> deleteLabelListById(Integer TaskID, List<Label> labelList);

}