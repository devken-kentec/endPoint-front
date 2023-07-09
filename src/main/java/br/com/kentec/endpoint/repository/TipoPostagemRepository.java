package br.com.kentec.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.endpoint.domain.TipoPostagem;

@Repository
public interface TipoPostagemRepository extends JpaRepository<TipoPostagem, Long> {

}
