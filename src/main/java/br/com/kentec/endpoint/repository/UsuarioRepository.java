package br.com.kentec.endpoint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE UPPER(u.email) LIKE  UPPER(:email) ")
	Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE UPPER(u.nome) LIKE  UPPER(:nome) ")
	Iterable<Usuario> findByNome(@Param("nome") String nome);

}
