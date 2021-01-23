package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;

import java.util.List;

public  interface RoleService {

	List<Role> findAll();

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleID);

	void deleteById(Integer roleID);

	List<User> findAllUserListById(Integer roleID);

	List<User> addUserListById(Integer RoleID, List<User> userList);

	List<User> setUserListById(Integer RoleID, List<User> userList);

	List<User> deleteUserListById(Integer RoleID, List<User> userList);

}