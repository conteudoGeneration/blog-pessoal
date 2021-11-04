package com.generation.blogpessoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.repository.PostagemRepository;

/**
 * @author Marcelo Barboza
 * 	Anotação @RestController define a classe como um controlador
 * 	Anotação @RequestMapping("/postagens") define um caminho para o controlador
 *  Anotação @CrossOrigin(value = "*", allowedHeaders = "*") libera requisições externas de outras origens ex: localhost:4200
 * */

@RestController
@RequestMapping("/postagens")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	

}
