package com.braian.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braian.teste.exceptions.ServiceEx;
import com.braian.teste.model.Usuario;
import com.braian.teste.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Usuario loginUser(String user, String senha) throws ServiceEx {
		Usuario userLogin = userRepository.buscarLogin(user, senha);
		return userLogin;
	}
}
