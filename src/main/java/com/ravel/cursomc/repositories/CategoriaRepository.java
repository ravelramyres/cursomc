package com.ravel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravel.cursomc.domain.Categoria;
	
//Objeto para realizar a busca de acesso a DADOS.
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
