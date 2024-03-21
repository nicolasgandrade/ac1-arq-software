package com8.ac1.repository;

import com8.ac1.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto) {
        return entityManager.merge(produto);
    }

    @Transactional
    public Produto editar(Produto produto) {
        return entityManager.merge(produto);
    }

    @Transactional
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    public void excluir(int id) {
        excluir(entityManager.find(Produto.class, id));
    }

    public List<Produto> selecionarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto selecionarPorId(int id) {
        String jpql = "SELECT p FROM Produto p WHERE p.id = :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
