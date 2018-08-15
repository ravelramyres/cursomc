package com.ravel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ravel.cursomc.domain.Categoria;
import com.ravel.cursomc.domain.Cidade;
import com.ravel.cursomc.domain.Cliente;
import com.ravel.cursomc.domain.Endereco;
import com.ravel.cursomc.domain.Estado;
import com.ravel.cursomc.domain.Produto;
import com.ravel.cursomc.domain.enums.TipoCliente;
import com.ravel.cursomc.repositories.CategoriaRepository;
import com.ravel.cursomc.repositories.CidadeRepository;
import com.ravel.cursomc.repositories.ClienteRepository;
import com.ravel.cursomc.repositories.EnderecoRepository;
import com.ravel.cursomc.repositories.EstadoRepository;
import com.ravel.cursomc.repositories.ProdutoRepository;


//CommandLineRunner = Faz a classe implementar a interface (implementa o metodo auxiliar para executar a ação quando iniciar)
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//Instancia os objetos
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		//inicio fazer as associação
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		// fim fazer as associação
		
		//repositories salva os objetos
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		//===================================================//
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Urbelandia",est1);
		Cidade c2 = new Cidade(null,"Sao Paulo Cap",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		//===================================================//
		Cliente cli1 = new Cliente (null, "Maria Silva","maria@gmail.com","36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345676","29394959"));
		
		Endereco e1 = new Endereco(null,"Rua Flores", "300", "Apto 303", "Jardim", "999999",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Matos", "105", "Sala 800", "Centro", "555555",cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
	}
}
