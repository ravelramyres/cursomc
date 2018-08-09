package com.ravel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.cursomc.domain.Categoria;
import com.ravel.cursomc.repositories.CategoriaRepository;
import com.ravel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	//Depencia instanciada pelo spring - inversao de controle ou injeção de dependencia
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj==null) {
			//Lança exceção caso nao exista
			throw new ObjectNotFoundException("Objeto não encontrado!Id:" + id
					+ ", Tipo:" + Categoria.class.getName());
		}
		return obj;
		
	}
}
