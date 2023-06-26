package br.com.kl.controller;

import br.com.kl.model.Produto;
import br.com.kl.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController
{

    @Autowired
    private ProdutoRepository produtoRepositorio;

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepositorio.findAll();
    }

    @PostMapping
    public void save(@RequestBody Produto produto) {
        produtoRepositorio.save(produto);
    }

    @PutMapping
    public void update(@RequestBody Produto produto){
        produtoRepositorio.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        produtoRepositorio.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Produto> getById(@PathVariable Long id){
        return produtoRepositorio.findById(id);
    }
}
