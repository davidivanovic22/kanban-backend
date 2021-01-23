package rs.ac.metropolitan.kanbanbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.repository.UserRepository;
import rs.ac.metropolitan.kanbanbackend.service.UserService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<Role> findAllRoleListById(Integer userId) {
		return findById(userId).getRoleList();
	}

	@Override
	public List<Role> addRoleListById(Integer userId, List<Role> RoleList) {
		User user = findById(userId);
		user.getRoleList().addAll(RoleList);
		return userRepository.save(user).getRoleList();
	}

	@Override
	public List<Role> setRoleListById(Integer userId, List<Role> RoleList) {
		User user = findById(userId);
		user.setRoleList(RoleList);
		return userRepository.save(user).getRoleList();
	}

	@Override
	public List<Role> deleteRoleListById(Integer userId, List<Role> RoleList) {
		User user = findById(userId);
		user.getRoleList().removeAll(RoleList);
		return userRepository.save(user).getRoleList();
	}


}