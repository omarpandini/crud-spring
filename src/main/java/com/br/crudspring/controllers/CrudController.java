package com.br.crudspring.controllers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.crudspring.models.Mensagem;
import com.br.crudspring.models.MensagensSistema;
import com.br.crudspring.models.Usuario;
import com.br.crudspring.repository.UsuarioRepository;

@RestController
public class CrudController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	// Retornando a lista de usuários
	@GetMapping(value = "/listaUsuarios")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuarios(@RequestParam String orderBy) {
		
		if(orderBy.isEmpty()) {
			orderBy = "nome";
		}
		
		
		
		List<Usuario> usuarios = usuarioRepository.findAll(Sort.by(Sort.Direction.ASC,orderBy));
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	// Método de salvar
	@PostMapping(value = "salvaUsuario")
	@ResponseBody /* Descrição da resposta */
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {

		// return new
		// ResponseEntity<Mensagem>(MensagensSistema.ERRO_VALOR_NUMERICO.retornaMensagem(),HttpStatus.OK);
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

	// Método de deletar
	@DeleteMapping(value = "deletarUsuario")
	@ResponseBody /* Descrição da resposta */
	public ResponseEntity<?> deletarUsuario(@RequestParam Long id) {

		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>(MensagensSistema.DELETE_OK.getDescricao(), HttpStatus.OK);
	}

	// Método de atualizar
	@PutMapping(value = "atualizar")
	@ResponseBody /* Descrição da resposta */
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {

		if (usuario.getId() == null) {
			return new ResponseEntity<String>(MensagensSistema.ERRO_CAMPO_VAZIO.getDescricao(), HttpStatus.OK);
		}
		
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

	// Método de Buscar o usuário pelo ID
	@GetMapping(value = "buscaById")
	@ResponseBody /* Descrição da resposta */
	public ResponseEntity<Usuario> buscaById(@RequestParam Long id) {

		Usuario usuario = usuarioRepository.findById(id).get();
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	// Método de Buscar o usuário pelo Nome
	@GetMapping(value = "buscarPorNome")
	@ResponseBody /* Descrição da resposta */
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam String nome) {

		List<Usuario> usuario = usuarioRepository.buscarPorNome(nome.trim().toUpperCase());
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	

}
