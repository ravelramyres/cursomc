package com.ravel.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//classe implements serializable (Classe que implementa a serializable) para que o objeto possa ser gravado em arquivos exigencia do Java
//Entity para criar o banco.
@Entity
public class Categoria implements Serializable {

//	geração default
	private static final long serialVersionUID = 1L;
	
	//@Id - significa id
	//Generated value para informar que é primary key
	//atributos básicos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//Construtor vazio, cria o objeto sem jogar nada aos atributos
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	//metodos de acesso aos atributos (Gets e setters)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//hascode e equals **(Dois objetos para serem comparados pelos conteudos e nao ponteiro de memoria)**
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
