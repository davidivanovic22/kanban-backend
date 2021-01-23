package rs.ac.metropolitan.kanbanbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.repository.LabelRepository;
import rs.ac.metropolitan.kanbanbackend.service.LabelService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class LabelServiceImpl implements LabelService {
	private final LabelRepository labelRepository;

	@Override
	public List<Label> findAll() {
		return labelRepository.findAll();
	}

	@Override
	public Label findById(Integer labelId) {
		return labelRepository.findById(labelId)
				.orElseThrow(() -> new NoSuchElementException("LabelService.notFound"));
	}

	@Override
	public Label save(Label label) {
		return labelRepository.save(label);
	}

	@Override
	public Label update(Label label) {
		return labelRepository.save(label);
	}

	@Override
	public void deleteById(Integer labelId) {
		labelRepository.deleteById(labelId);
	}

	@Override
	public List<Task> findAllTaskListById(Integer labelId) {
		return findById(labelId).getTaskList();
	}

	@Override
	public List<Task> addTaskListById(Integer labelId, List<Task> taskList) {
		Label label = findById(labelId);
		label.getTaskList().addAll(taskList);
		return labelRepository.save(label).getTaskList();
	}

	@Override
	public List<Task> setTaskListById(Integer labelId, List<Task> taskList) {
		Label label = findById(labelId);
		label.setTaskList(taskList);
		return labelRepository.save(label).getTaskList();
	}

	@Override
	public List<Task> deleteTaskListById(Integer labelId, List<Task> taskList) {
		Label label = findById(labelId);
		label.getTaskList().removeAll(taskList);
		return labelRepository.save(label).getTaskList();
	}


}