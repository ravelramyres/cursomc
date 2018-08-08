package com.ravel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ravel.cursomc.domain.Categoria;
import com.ravel.cursomc.repositories.CategoriaRepository;


//CommandLineRunner = Faz a classe implementar a interface (implementa o metodo auxiliar para executar a ação quando iniciar)
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//Instancia os objetos
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		//repositories salva os objetos
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
	}
}
