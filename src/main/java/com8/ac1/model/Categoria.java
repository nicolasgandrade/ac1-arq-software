package com8.ac1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cat_nome", columnDefinition = "TINYTEXT")
    private String nome;
    @Column(name = "cat_descricao")
    private String descricao;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Categoria() {
    }

    public Categoria(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome='" + nome + '\'' + ", descricao='" + descricao + '\'' + '}';
    }
}
