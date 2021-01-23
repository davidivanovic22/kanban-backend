package rs.ac.metropolitan.kanbanbackend.service.impl;

import rs.ac.metropolitan.kanbanbackend.entity.Role;
import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.repository.RoleRepository;
import rs.ac.metropolitan.kanbanbackend.service.RoleService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Integer RoleID) {
		return roleRepository.findById(RoleID)
				.orElseThrow(() -> new NoSuchElementException("RoleService.notFound"));
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role update(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteById(Integer RoleID) {
		roleRepository.deleteById(RoleID);
	}

	@Override
	public List<User> findAllUserListById(Integer RoleID) {
		return findById(RoleID).getUserList();
	}

	@Override
	public List<User> addUserListById(Integer RoleID, List<User> userList) {
		Role role = findById(RoleID);
		role.getUserList().addAll(userList);
		return roleRepository.save(role).getUserList();
	}

	@Override
	public List<User> setUserListById(Integer RoleID, List<User> userList) {
		Role role = findById(RoleID);
		role.setUserList(userList);
		return roleRepository.save(role).getUserList();
	}

	@Override
	public List<User> deleteUserListById(Integer RoleID, List<User> userList) {
		Role role = findById(RoleID);
		role.getUserList().removeAll(userList);
		return roleRepository.save(role).getUserList();
	}


}