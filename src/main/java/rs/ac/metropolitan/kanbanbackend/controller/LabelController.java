package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import lombok.*;
import rs.ac.metropolitan.kanbanbackend.service.LabelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
@RequiredArgsConstructor
public class LabelController {
	private final LabelService labelService;

	@GetMapping
	public ResponseEntity<List<Label>> getAll() {
		return ResponseEntity.ok(labelService.findAll());
	}

	@GetMapping("/{labelId}")
	public ResponseEntity<Label> getById(@PathVariable Integer labelId) {
		return ResponseEntity.ok(labelService.findById(labelId));
	}

	@PostMapping
	public ResponseEntity<Label> save(@RequestBody Label label) {
		return ResponseEntity.status(201).body(labelService.save(label));
	}

	@PutMapping
	public ResponseEntity<Label> update(@RequestBody Label label) {
		return ResponseEntity.ok(labelService.update(label));
	}

	@DeleteMapping("/{labelId}")
	public void deleteById(@PathVariable Integer labelId) {
		labelService.deleteById(labelId);
	}

	@GetMapping("/{labelId}/taskList")
	public ResponseEntity<List<Task>> getTaskList(@PathVariable Integer labelId) {
		return ResponseEntity.ok(labelService.findAllTaskListById(labelId));
	}

	@PostMapping("/{labelId}/taskList")
	public ResponseEntity<List<Task>> setTaskList(@PathVariable Integer labelId, @RequestBody List<Task> TaskList) {
		return ResponseEntity.ok(labelService.setTaskListById(labelId, TaskList));
	}

	@PutMapping("/{labelId}/taskList")
	public ResponseEntity<List<Task>> addTaskList(@PathVariable Integer labelId, @RequestBody List<Task> TaskList) {
		return ResponseEntity.ok(labelService.addTaskListById(labelId, TaskList));
	}

	@DeleteMapping("/{labelId}/taskList")
	public ResponseEntity<List<Task>> deleteTaskList(@PathVariable Integer labelId, @RequestBody List<Task> TaskList) {
		return ResponseEntity.ok(labelService.deleteTaskListById(labelId, TaskList));
	}

}

