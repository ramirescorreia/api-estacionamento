package br.com.estacionamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.entidades.Usuario;
import br.com.estacionamento.repositorios.UsuarioRespositorio;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioRespositorio usuarioRespositorio;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsuarioController(UsuarioRespositorio usuarioRespositorio, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRespositorio = usuarioRespositorio;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/cadastrar")
	public void signUp(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuarioRespositorio.save(usuario);
	}
}
