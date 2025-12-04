/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author tr701
 */
@Stateless
public class CursoDAO extends AbstractDAO<Curso>{

    public List<Curso> buscarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Curso> query = em.createNamedQuery("Curso.buscarTodos", Curso.class);
        return query.getResultList();
    }

    public Curso buscarPeloId(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Curso.class, id);
    }

    public List<Curso> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Curso> query = em.createNamedQuery("Curso.buscarPeloNome", Curso.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}

