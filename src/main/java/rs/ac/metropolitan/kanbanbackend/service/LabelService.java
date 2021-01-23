package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;

import java.util.List;

public  interface LabelService {

	List<Label> findAll();

	Label save(Label label);

	Label update(Label label);

	Label findById(Integer LabelID);

	void deleteById(Integer LabelID);

	List<Task> findAllTaskListById(Integer labelID);

	List<Task> addTaskListById(Integer labelID, List<Task> taskList);

	List<Task> setTaskListById(Integer labelID, List<Task> taskList);

	List<Task> deleteTaskListById(Integer labelID, List<Task> taskList);

}