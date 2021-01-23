package rs.ac.metropolitan.kanbanbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.repository.TaskRepository;
import rs.ac.metropolitan.kanbanbackend.service.TaskService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task findById(Integer TaskID) {
		return taskRepository.findById(TaskID)
				.orElseThrow(() -> new NoSuchElementException("TaskService.notFound"));
	}

	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task update(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteById(Integer TaskID) {
		taskRepository.deleteById(TaskID);
	}

	@Override
	public List<Label> findAllLabelListById(Integer TaskID) {
		return findById(TaskID).getLabelList();
	}

	@Override
	public List<Label> addLabelListById(Integer TaskID, List<Label> LabelList) {
		Task task = findById(TaskID);
		task.getLabelList().addAll(LabelList);
		return taskRepository.save(task).getLabelList();
	}

	@Override
	public List<Label> setLabelListById(Integer TaskID, List<Label> LabelList) {
		Task task = findById(TaskID);
		task.setLabelList(LabelList);
		return taskRepository.save(task).getLabelList();
	}

	@Override
	public List<Label> deleteLabelListById(Integer TaskID, List<Label> LabelList) {
		Task task = findById(TaskID);
		task.getLabelList().removeAll(LabelList);
		return taskRepository.save(task).getLabelList();
	}


}