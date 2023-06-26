package br.com.kl.converters;

import br.com.kl.model.Produto;
import br.com.kl.repositorio.ProdutoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Optional;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    ProdutoRepository produtoRepository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("value: " + value);
        try {
            if (value != null && !value.isEmpty()) {
                Long id = Long.parseLong(value);
                Optional<Produto> produto = produtoRepository.findById(id);
                System.out.println("produto: " + produto);
                return produto;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if(value != null){
                return value.toString();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}
