package br.com.kl.controller;

import br.com.kl.model.SeguradoraComissao;
import br.com.kl.repositorio.SeguradoraComissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seguradoraComissaos")
public class SeguradoraComissaoController
{

    @Autowired
    private SeguradoraComissaoRepository seguradoraComissaoRepository;

    @GetMapping
    public List<SeguradoraComissao> findAll() {
        return seguradoraComissaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody SeguradoraComissao seguradoraComissao) {
        seguradoraComissaoRepository.save(seguradoraComissao);
    }

    @PutMapping
    public void update(@RequestBody SeguradoraComissao seguradoraComissao){
        seguradoraComissaoRepository.save(seguradoraComissao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        seguradoraComissaoRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<SeguradoraComissao> getById(@PathVariable Long id){
        return seguradoraComissaoRepository.findById(id);
    }
}
