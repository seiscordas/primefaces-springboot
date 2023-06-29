package br.com.kl.beans;

import br.com.kl.model.Produto;
import br.com.kl.model.Seguradora;
import br.com.kl.repositorio.ProdutoRepository;
import br.com.kl.repositorio.SeguradoraRepository;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
@Named(value = "auxiliarBean")
@RequestScoped
public class AuxiliarBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Long produtoSelecionado;

    @Getter
    @Setter
    private Long seguradoraSelecionada;

    @Getter
    private List<Produto> produtos;

    @Getter
    private List<Seguradora> seguradoras;

    @Autowired
    private SeguradoraRepository seguradoraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void init() {
        produtos = completeProduto();
    }

    public List<Produto> completeProduto() {
        return produtoRepository.findAll();
    }

    public void updateSeguradoras() {
        seguradoras = completeSeguradora(produtoSelecionado);
        PrimeFaces.current().ajax().update("seguradoraComissoes:seguradora");
    }

    public List<Seguradora> completeSeguradora(Long id) {
        return seguradoraRepository.findByProdutoId(produtoSelecionado);
    }

    public void teste(Long id) {
        System.out.println("id: " + id);
        if(seguradoraSelecionada != null){
        }
        System.out.println("seguradoraSelecionada: " + seguradoraSelecionada);
    }
}
