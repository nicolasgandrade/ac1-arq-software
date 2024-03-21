package com8.ac1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "prod_nome", columnDefinition = "TINYTEXT")
    private String nome;
    @Column(name = "prod_qtd")
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private Categoria categoria;

    public Produto() {
    }

    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome='" + nome + '\'' + ", quantidade=" + quantidade + ", categoria=" + categoria + '}';
    }
}
