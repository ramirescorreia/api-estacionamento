package br.com.estacionamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.entidades.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{
	@Query("select estac from Estacionamento estac where estac.patio.id =:idPatio and estac.statusVaga = 'OCUPADA'")
	List<Estacionamento> findAllByIdPatio(@Param("idPatio") Long idPatio);
}
