/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author tr701
 */
@Stateless
public class VendaDAO extends AbstractDAO<Venda> {

    public List<Venda> buscarTodas() {

        EntityManager em = getEntityManager();
        TypedQuery<Venda> query = em.createNamedQuery("Venda.buscarTodas", Venda.class);

        return query.getResultList();
    }
}
