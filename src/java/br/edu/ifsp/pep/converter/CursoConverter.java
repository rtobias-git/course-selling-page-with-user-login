package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CursoDAO;
import br.edu.ifsp.pep.entidade.Curso;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Curso.class)
public class CursoConverter implements Converter<Curso>{
    
    @Override
    public Curso getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        CursoDAO cursoDAO = CDI.current().select(CursoDAO.class).get();
        
        //Busca no BD
        return cursoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Curso curso) {
        return curso == null ? null : curso.getId().toString();
    }
      
}
