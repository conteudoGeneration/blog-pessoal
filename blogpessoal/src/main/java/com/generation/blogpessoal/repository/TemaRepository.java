package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Tema;

/**
 * @author Marcelo Barboza
 * 	Anotação @Repository conjunto de boas praticas para expor um repository para o Spring boot
 * 
 * 	O metodo abstrato findAllByTituloContainingIgnoreCase(String descricao) trata-se de uma consulta personalizada que criamos através do 
 * 	nome do metodo consulte: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * 
 * */

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
