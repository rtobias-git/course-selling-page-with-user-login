package br.edu.ifsp.pep.entidade;

import java.io.Serializable;
import java.util.Objects;

public class ItemVendaPK implements Serializable {

    private Integer venda;
    private Integer curso;

    public Integer getVenda() {
        return venda;
    }

    public void setVenda(Integer venda) {
        this.venda = venda;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(venda, curso);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemVendaPK other = (ItemVendaPK) obj;
        return Objects.equals(this.venda, other.venda) && Objects.equals(this.curso, other.curso);
    }
}
