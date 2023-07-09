package br.com.kentec.endpoint.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.endpoint.DTO.AmigosDTO;
import br.com.kentec.endpoint.domain.Amigos;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.repository.AmigoRepository;
import br.com.kentec.endpoint.repository.UsuarioRepository;

@Service
public class AmigoService {
	
	@Autowired
	private AmigoRepository ar;
	
	@Autowired
	private UsuarioRepository ur;
	
	public void solicatarAmizade(Long id, Long idAmigo) {
		Optional<Usuario> user = ur.findById(id);
		Optional<Usuario> amigo = ur.findById(idAmigo);
		
		if(user.isPresent() && amigo.isPresent()) {
			Amigos amizade = new Amigos();   
			amizade.setEu(user.get());
			amizade.setAmigo(amigo.get());
			amizade.setSolicitar("Solicitando");
			ar.save(amizade); 
		}
	}
	
	public Iterable<AmigosDTO> listarAmigos(Long id){
		return ar.listarAmigos(id).stream().map(AmigosDTO::new).collect(Collectors.toList());
	}
	
	public Optional<AmigosDTO> verSolicitacao(Long idMeu, Long idAmigo) {
		return ar.verSolicitacao(idMeu, idAmigo).map(AmigosDTO::new);
	}
	
	public Iterable<AmigosDTO> listarAmigosSolicitando(Long id){
		return ar.listarAmigosSolicitando(id).stream().map(AmigosDTO::new).collect(Collectors.toList());
	}
}
