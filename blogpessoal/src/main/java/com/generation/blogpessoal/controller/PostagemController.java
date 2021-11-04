package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

/**
 * @author Marcelo Barboza
 * 	Anotação @RestController define a classe como um controlador
 * 	Anotação @RequestMapping("/postagens") define um caminho para o controlador
 *  Anotação @CrossOrigin(value = "*", allowedHeaders = "*") libera requisições externas de outras origens ex: localhost:4200
 *  Anotação @GetMapping define que o end point será acessado através do verbo Get 
 *  Anotação @PathVariable define que o valor será recebido pela nossa ApiRest através da uri
 *  	Impotante: ao passarmos um value entre da anotaçao GetMapping definimos uma sub-rota no caso abaixo ficaria assim
 *      @GetMapping("/{id}") = localhost:8080/postagens/{id}  | {id} = a valor que esperamos do usuário
 *  Anotação @PostMapping define que o end point será acessado através do verbo Post (Criação/Insert)
 *  Anotação @RequestBody define que o valor será recebido pela Body na requisição
 *  Anotação @PutMapping define que o end point será acessado através do verbo Put (Atualização/Update)
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
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitle(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return repository.findById(postagem.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

}
