package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.service.TaskService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
	private final TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		return ResponseEntity.ok(taskService.findAll());
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getById(@PathVariable Integer taskId) {
		return ResponseEntity.ok(taskService.findById(taskId));
	}

	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task) {
		return ResponseEntity.status(201).body(taskService.save(task));
	}

	@PutMapping
	public ResponseEntity<Task> update(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}

	@DeleteMapping("/{taskId}")
	public void deleteById(@PathVariable Integer taskId) {
		taskService.deleteById(taskId);
	}

	@GetMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> getlabelList(@PathVariable Integer taskId) {
		return ResponseEntity.ok(taskService.findAllLabelListById(taskId));
	}

	@PostMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> setlabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.setLabelListById(taskId, labelList));
	}

	@PutMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> addlabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.addLabelListById(taskId, labelList));
	}

	@DeleteMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> deletelabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.deleteLabelListById(taskId, labelList));
	}

}

