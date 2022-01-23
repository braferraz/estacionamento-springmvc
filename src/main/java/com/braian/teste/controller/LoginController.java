package com.braian.teste.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.braian.teste.exceptions.ServiceEx;
import com.braian.teste.model.Usuario;
import com.braian.teste.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private VeiculoController vC;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("/")
	public @ResponseBody ModelAndView logar(Usuario usuario, BindingResult br) throws ServiceEx {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("/");
		}
		
		Usuario userLogin = userService.loginUser(usuario.getUsu(), usuario.getSenha());
		if(userLogin == null) {
			mv.addObject("msg", "Usuário não encontrado, verifique seu usuário e senha e tente novamente.");
		}
		else {
			return vC.sistema();
		}
		return mv;
	}
	
	
}
