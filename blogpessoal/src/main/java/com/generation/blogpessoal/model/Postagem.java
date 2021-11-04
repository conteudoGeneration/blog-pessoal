package com.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Marcelo Barboza
 * 	Anotação @Entity responsavel por criar uma tabela na base de dados.
 *  Anotação @Table(name = "tb_postagem") define um nome para a tabela.
 *  Anotação @Id define o atributo id como um chave primária.
 *  Anotação @GeneratedValue(strategy = GenerationType.IDENTITY) define como auto-incremento
 *  Anotação @NotBlank não acessa 
 *  Anotação @UpdateTimestamp captura e insere no atributo a data e hora da criação ou atualização
 *  Anotação @Size define um tamanho minimo e maximo de caractéres para o atributo
 *  Anotação @ManyToOne cria um relacionamento muitos para um com a model/entity  Tema (o objeto tema assumo o papel de chave estrangeira)
 *  Anotação @JsonIgnoreProperties("postagem") inibe a recursividade no relacionamento 
 *  
 * */

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotBlank(message = "O atributo título é Obrigatório!") 
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	/*Insira os Getters and Setters*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	

}
