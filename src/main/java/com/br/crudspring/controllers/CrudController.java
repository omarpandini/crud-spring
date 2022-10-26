package com.br.crudspring.controllers;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.crudspring.models.MensagemErro;
import com.br.crudspring.models.Usuario;
import com.br.crudspring.repository.UsuarioRepository;

@RestController
public class CrudController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/{var}",method = RequestMethod.GET)
	public String olaMundo(@PathVariable String var) {
		Usuario usuario = new Usuario();
		usuario.setNome(var.toUpperCase());
		usuario.setIdade(37);
		usuarioRepository.save(usuario);
		return "Olá Mundo "+var;
	}
	
	//Retornando a lista de usuários
	@GetMapping(value="/listaUsuarios")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	//Método de salvar
	@PostMapping(value = "salvaUsuario")
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<?>salvar(@RequestBody Usuario usuario){
		
		//MensagemErro msg = new MensagemErro(1, "Erro 101010");
		
		//return new ResponseEntity<MensagemErro>(msg,HttpStatus.OK);
		Usuario user =  usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

}
