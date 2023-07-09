package br.com.kentec.endpoint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.endpoint.domain.TipoPostagem;
import br.com.kentec.endpoint.repository.TipoPostagemRepository;

@Service
public class TipoPostagemService {
	
	@Autowired
	private TipoPostagemRepository tpr;
	
	public Optional<TipoPostagem> findById(Long id){
		return tpr.findById(id);
	}
}
