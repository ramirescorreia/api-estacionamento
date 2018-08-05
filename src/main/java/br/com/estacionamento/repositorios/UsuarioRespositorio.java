package br.com.estacionamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.entidades.Usuario;

@Repository
public interface UsuarioRespositorio extends JpaRepository<Usuario, Long>{
	Usuario findByNomeUsuario(String nomeUsuario);
}
