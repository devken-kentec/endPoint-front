package br.com.kentec.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.Empresas;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresas, Long> {
	
	@Query("SELECT e FROM Empresas e WHERE UPPER(e.nomeFantasia) LIKE UPPER(:nomeEmpresa) ")
	Iterable<Empresas> findByNomeEmpresa(@Param("nomeEmpresa") String nomeEmpresa);
}
