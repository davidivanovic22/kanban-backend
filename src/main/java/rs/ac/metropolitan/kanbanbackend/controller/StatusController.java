package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.service.StatusService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stat")
@RequiredArgsConstructor
public class StatusController {
	private final StatusService statusService;

	@GetMapping
	public ResponseEntity<List<Status>> getAll() {
		return ResponseEntity.ok(statusService.findAll());
	}

	@GetMapping("/{statusId}")
	public ResponseEntity<Status> getById(@PathVariable Integer statusId) {
		return ResponseEntity.ok(statusService.findById(statusId));
	}

	@PostMapping
	public ResponseEntity<Status> save(@RequestBody Status status) {
		return ResponseEntity.status(201).body(statusService.save(status));
	}

	@PutMapping
	public ResponseEntity<Status> update(@RequestBody Status status) {
		return ResponseEntity.ok(statusService.update(status));
	}

	@DeleteMapping("/{statusId}")
	public void deleteById(@PathVariable Integer statusId) {
		statusService.deleteById(statusId);
	}

}

