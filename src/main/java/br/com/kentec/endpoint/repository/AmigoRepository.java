package br.com.kentec.endpoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.Amigos;

@Repository
public interface AmigoRepository extends JpaRepository<Amigos, Long> {
	
	@Query("SELECT a FROM Amigos a WHERE a.solicitar = 'Amigos' AND a.eu.id = :id ")
	List<Amigos> listarAmigos(@Param("id") Long id);
	
	@Query("SELECT a FROM Amigos a WHERE a.eu.id = :idMeu AND a.amigo.id = :idAmigo ")
	Optional<Amigos> verSolicitacao(@Param("idMeu") Long idMeu, @Param("idAmigo") Long idAmigo);
	
	@Query("SELECT a FROM Amigos a WHERE a.solicitar = 'Solicitando' AND a.eu.id = :id ")
	List<Amigos> listarAmigosSolicitando(@Param("id") Long id);
}
