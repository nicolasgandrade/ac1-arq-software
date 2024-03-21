package com8.ac1;

import com8.ac1.model.Categoria;
import com8.ac1.model.Produto;
import com8.ac1.repository.CategoriaRepository;
import com8.ac1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired CategoriaRepository categoriaRepository,
								  @Autowired ProdutoRepository produtoRepository) {
		return args -> {
			categoriaRepository.inserir(new Categoria(0, "Papelaria", "Produtos do setor de Papelaria"));
			categoriaRepository.inserir(new Categoria(0, "Eletronicos", "Produtos do setor de Eletrônicos"));

			produtoRepository.inserir(new Produto(0, "Lapiseira", 10));
			produtoRepository.inserir(new Produto(0, "Fone de ouvido", 4));

			System.out.println("\n\nLista de Categorias:");
			List<Categoria> listaCategorias = categoriaRepository.selecionarTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("\n\nLista de Produtos:");
			List<Produto> listaProdutos = produtoRepository.selecionarTodos();
			listaProdutos.forEach(System.out::println);

			Produto produto = produtoRepository.selecionarPorId(1);
			Categoria categoria = categoriaRepository.selecionarPorId(1);

			produto.setCategoria(categoria);
			produtoRepository.editar(produto);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
