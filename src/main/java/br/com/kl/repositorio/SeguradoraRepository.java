package br.com.kl.repositorio;

import br.com.kl.model.Seguradora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguradoraRepository extends JpaRepository<Seguradora, Long>{
    List<Seguradora> findByProdutoId(Long id);
}
