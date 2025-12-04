/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CursoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.entidade.Curso;
import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Venda;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tr701
 */
@Named
@SessionScoped
public class VendaController implements Serializable {

    @Inject
    private VendaDAO vendaDAO;

    @Inject
    private CursoDAO cursoDAO;

    private Curso cursoSelecionado = new Curso();

    private Venda venda = new Venda();

    private List<ItemVenda> itensVenda = new ArrayList<>();

    public VendaController() {
        System.out.println("Construtor");
    }

    public List<Curso> buscarCursoPeloNome(String query) {
        return cursoDAO.buscarPeloNome(query);
    }

    public void adicionar() {

        if (venda != null && cursoSelecionado != null && cursoSelecionado.getValor() != null) {

            if (venda.getId() <= 0 || cursoSelecionado.getValor().doubleValue() <= 0) {
                Mensagem.atencao("O código deve ser maior que zero.");
            } else {

                ItemVenda item = new ItemVenda();
                item.setCurso(cursoSelecionado);
                item.setVenda(venda);
                item.setValor(cursoSelecionado.getValor());

                itensVenda.add(item);
                Mensagem.sucesso("Curso cadastrado.");
            }

        } else {

            if (venda != null && cursoSelecionado.getValor() == null) {
                Mensagem.erro("Informe o Código");
            }
            if (cursoSelecionado != null && cursoSelecionado.getValor() == null) {
                Mensagem.erro("Informe o Curso");
            }
            if (cursoSelecionado != null && cursoSelecionado.getValor() == null) {
                Mensagem.erro("Informe o Valor");
            }
        }

    }

    public String verificarPagamento() {
        if (itensVenda != null && !itensVenda.isEmpty()) {

            return "/venda/pagamento";
        } else {

            Mensagem.atencao("Adicione pelo menos um Curso");
            return null;
        }
    }

    public void aplicarDesconto() {
        BigDecimal desconto = venda.getDesconto() != null
                ? venda.getDesconto()
                : BigDecimal.ZERO;

        for (ItemVenda item : itensVenda) {

            BigDecimal valorOriginal = item.getCurso().getValor();

            BigDecimal valorComDesconto = valorOriginal.multiply(
                    BigDecimal.ONE.subtract(desconto.divide(new BigDecimal("100")))
            );

            item.setValor(valorComDesconto);

        }

    }

    public String finalizar() {
        double totalCalculado = getValorTotal();
        
        venda.setItens(itensVenda);
        vendaDAO.inserir(venda);

        // Limpa os dados aqui!
        venda = new Venda();
        itensVenda = new ArrayList<>();
        cursoSelecionado = new Curso();

        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        Mensagem.sucesso("Venda Finzalizada: Total Pago: " + totalCalculado);
        return "/index?faces-redirect=true";
    }

    public double getValorTotal() {

        double valorTotal = 0;

        for (ItemVenda itemVenda : itensVenda) {
            if (itemVenda.getValor() != null) {
                valorTotal += itemVenda.getValor().doubleValue();
            }
        }

        return valorTotal;
    }

    public List<Curso> buscarTodosCursos() {
        return cursoDAO.buscarTodos();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

}
