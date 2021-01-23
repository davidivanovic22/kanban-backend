package rs.ac.metropolitan.kanbanbackend.service;


import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.LoginDTO;
import rs.ac.metropolitan.kanbanbackend.entity.dto.RegisterDTO;

public interface AuthService {
	String login(LoginDTO loginDTO);
	User register(RegisterDTO registerDTO);
}
