package com.ravel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.cursomc.domain.Categoria;
import com.ravel.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	//Depencia instanciada pelo spring - inversao de controle ou injeção de dependencia
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		return obj;
		
	}
}
