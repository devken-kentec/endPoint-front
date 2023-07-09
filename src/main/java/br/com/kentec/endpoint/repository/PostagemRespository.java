package br.com.kentec.endpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.Postagem;

@Repository
public interface PostagemRespository extends JpaRepository<Postagem, Long> {
	
	@Query("SELECT p FROM Postagem p "
			+ "JOIN p.usuario u "
			+ "WHERE u.id = :id ")
	List<Postagem> findByPostagemUsuarioId(@Param("id") Long id);

}
