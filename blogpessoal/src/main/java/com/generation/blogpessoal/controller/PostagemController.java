package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

/**
 * @author Marcelo Barboza
 * 	Anotação @RestController define a classe como um controlador
 * 	Anotação @RequestMapping("/postagens") define um caminho para o controlador
 *  Anotação @CrossOrigin(value = "*", allowedHeaders = "*") libera requisições externas de outras origens ex: localhost:4200
 *  Anotação @GetMapping devine que o end point será acessado através do verbo Get 
 *  	Impotante: ao passarmos um value entre da anotaçao GetMapping definimos uma sub-rota no caso abaixo ficaria assim
 *      @GetMapping("/{id}") = localhost:8080/postagens/{id}  | {id} = a valor que esperamos do usuário
 * */

@RestController
@RequestMapping("/postagens")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	

}
