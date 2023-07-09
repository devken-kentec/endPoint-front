package br.com.kentec.endpoint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.DadosComplementares;
import br.com.kentec.endpoint.domain.Usuario;

@Repository
public interface DadosComplementaresRepository extends JpaRepository<DadosComplementares, Long> {
	
	Optional<DadosComplementares> findByUsuario(Usuario usuario);
	
}
