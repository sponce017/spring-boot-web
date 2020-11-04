package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framewok!");
		return "index";
	}

	@RequestMapping("perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Saul");
		usuario.setApellido("Ponce");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("listar")
	public String usuarios(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("saul", "ponce", "saul@correo.com"));
		usuarios.add(new Usuario("john", "doe", "john@correo.com"));
		usuarios.add(new Usuario("jane", "doe", "jane@correo.com"));
		
		model.addAttribute("titulo", "Lista de usuarios:");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

}
