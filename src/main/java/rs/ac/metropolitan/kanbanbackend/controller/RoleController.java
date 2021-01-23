package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.service.RoleService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> getAll() {
		return ResponseEntity.ok(roleService.findAll());
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<Role> getById(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findById(roleId));
	}

	@PostMapping
	public ResponseEntity<Role> save(@RequestBody Role rOLE) {
		return ResponseEntity.status(201).body(roleService.save(rOLE));
	}

	@PutMapping
	public ResponseEntity<Role> update(@RequestBody Role rOLE) {
		return ResponseEntity.ok(roleService.update(rOLE));
	}

	@DeleteMapping("/{roleId}")
	public void deleteById(@PathVariable Integer roleId) {
		roleService.deleteById(roleId);
	}

	@GetMapping("/{roleId}/userList")
	public ResponseEntity<List<User>> getUserList(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findAllUserListById(roleId));
	}

	@PostMapping("/{roleId}/userList")
	public ResponseEntity<List<User>> setUserList(@PathVariable Integer roleId, @RequestBody List<User> userList) {
		return ResponseEntity.ok(roleService.setUserListById(roleId, userList));
	}

	@PutMapping("/{roleId}/userList")
	public ResponseEntity<List<User>> addUserList(@PathVariable Integer roleId, @RequestBody List<User> userList) {
		return ResponseEntity.ok(roleService.addUserListById(roleId, userList));
	}

	@DeleteMapping("/{roleId}/userList")
	public ResponseEntity<List<User>> deleteUserList(@PathVariable Integer roleId, @RequestBody List<User> userList) {
		return ResponseEntity.ok(roleService.deleteUserListById(roleId, userList));
	}

}

