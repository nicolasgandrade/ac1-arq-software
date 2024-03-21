package com8.ac1.repository;

import com8.ac1.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    @Transactional
    public Categoria editar(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    @Transactional
    public void excluir(Categoria categoria) {
        entityManager.remove(categoria);
    }

    public void excluir(int id) {
        excluir(entityManager.find(Categoria.class, id));
    }

    public List<Categoria> selecionarTodos() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public Categoria selecionarPorId(int id) {
        String jpql = "SELECT c FROM Categoria c WHERE c.id = :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
