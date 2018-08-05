package br.com.estacionamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.entidades.Patio;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long>{
	List<Patio> findByDescricaoContaining(@Param("descricao") String descricao);
}
