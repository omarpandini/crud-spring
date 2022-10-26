package com.br.crudspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {
	
	@GetMapping(value = "/")
	public String olaMundo() {
		return "Olá Mundo";
	}

}
