/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CursoDAO;
import br.edu.ifsp.pep.entidade.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author tr701
 */
@Named
@RequestScoped
public class CursoController {
    
    @Inject
    private CursoDAO cursoDAO;
    
    public List<Curso> getCurso() {
        return this.cursoDAO.buscarTodos();
    }
}
