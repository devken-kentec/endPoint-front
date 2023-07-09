package br.com.kentec.endpoint.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.endpoint.DTO.DadosComplementaresDTO;
import br.com.kentec.endpoint.domain.DadosComplementares;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.repository.DadosComplementaresRepository;

@Service
public class DadosComplementaresService {
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private DadosComplementaresRepository dcr;
	
	public Optional<DadosComplementaresDTO> findByUsusario(Long id){
		Optional<Usuario> user = us.findById(id); 
		return dcr.findByUsuario(user.get()).map(DadosComplementaresDTO::new);	
	}
	
	public void gavarDadosComplementares(DadosComplementaresDTO dadosComplementaresDTO) {
		Optional<Usuario> user = us.findById(dadosComplementaresDTO.getId());
		if(user.isPresent()) {
			DadosComplementares dados = new DadosComplementares();
			dados.setEscola(dadosComplementaresDTO.getEscola());
			dados.setFaculdade(dadosComplementaresDTO.getFaculdade());
			dados.setTrabalho(dadosComplementaresDTO.getTrabalho());
			dados.setEstadoCivil(dadosComplementaresDTO.getEstadoCivil());
			dados.setTelefone(dadosComplementaresDTO.getTelefone());
			dados.setUsuario(user.get());
			dcr.save(dados);
		}
	}
	
	public void alterarDadosComplementares(DadosComplementaresDTO dadosComplementaresDTO) {
		Optional<DadosComplementares> dados = dcr.findById(dadosComplementaresDTO.getIdComplementar());
		if(dados.isPresent()) {
			dados.get().setEscola(dadosComplementaresDTO.getEscola());
			dados.get().setFaculdade(dadosComplementaresDTO.getFaculdade());
			dados.get().setTrabalho(dadosComplementaresDTO.getTrabalho());
			dados.get().setEstadoCivil(dadosComplementaresDTO.getEstadoCivil());
			dados.get().setTelefone(dadosComplementaresDTO.getTelefone());
			dcr.save(dados.get());
		}
	}
}
