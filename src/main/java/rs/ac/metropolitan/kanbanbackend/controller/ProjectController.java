package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.service.ProjectService;
import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
	private final ProjectService projectService;

	@GetMapping
	public ResponseEntity<List<Project>> getAll() {
		return ResponseEntity.ok(projectService.findAll());
	}

	@GetMapping("/{projectID}")
	public ResponseEntity<Project> getById(@PathVariable Integer projectID) {
		return ResponseEntity.ok(projectService.findById(projectID));
	}

	@PostMapping
	public ResponseEntity<Project> save(@RequestBody Project project) {
		return ResponseEntity.status(201).body(projectService.save(project));
	}

	@PutMapping
	public ResponseEntity<Project> update(@RequestBody Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}

	@DeleteMapping("/{projectID}")
	public void deleteById(@PathVariable Integer projectID) {
		projectService.deleteById(projectID);
	}

}

