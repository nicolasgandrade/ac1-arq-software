package com8.ac1.controller;

import com8.ac1.model.Categoria;
import com8.ac1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping()
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaRepository.inserir(categoria);
    }

    @GetMapping()
    public List<Categoria> mostrarTodos() {
        return categoriaRepository.selecionarTodos();
    }
}
