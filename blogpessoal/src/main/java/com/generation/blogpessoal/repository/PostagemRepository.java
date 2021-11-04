package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

/**
 * @author Marcelo Barboza
 * 	Anotação @Repository conjunto de boas praticas para expor um repository para o Spring boot
 * 
 * 	O metodo abstrato findAllByTituloContainingIgnoreCase(String titulo) trata-se de uma consulta personalizada que criamos através do 
 * 	nome do metodo consulte: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * 
 * */

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
