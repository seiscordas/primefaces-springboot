package br.com.kl.controller;

import br.com.kl.model.Seguradora;
import br.com.kl.repositorio.SeguradoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seguradoras")
public class SeguradoraController
{

    @Autowired
    private SeguradoraRepository seguradoraRepository;

    @GetMapping
    public List<Seguradora> findAll() {
        return seguradoraRepository.findAll();
    }

    @GetMapping("/seguradorasProduto/{id}")
    public List<Seguradora> findByProductId(@PathVariable Long id) {
        return seguradoraRepository.findByProdutoId(id);
    }

    @PostMapping
    public void save(@RequestBody Seguradora seguradora) {
        seguradoraRepository.save(seguradora);
    }

    @PutMapping
    public void update(@RequestBody Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        seguradoraRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Seguradora> getById(@PathVariable Long id){
        return seguradoraRepository.findById(id);
    }
}
