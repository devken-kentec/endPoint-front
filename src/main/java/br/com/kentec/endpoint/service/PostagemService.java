package br.com.kentec.endpoint.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.endpoint.DTO.PostagemDTO;
import br.com.kentec.endpoint.domain.Postagem;
import br.com.kentec.endpoint.domain.TipoPostagem;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.repository.PostagemRespository;
import br.com.kentec.endpoint.repository.UsuarioRepository;

@Service
public class PostagemService {
	
	@Autowired
	private TipoPostagemService tps;
	
	@Autowired
	private PostagemRespository pr;
	
	@Autowired
	private UsuarioRepository ur;
	
	public void gravarPostagem(PostagemDTO postDTO) {
		
		TipoPostagem tp =  tps.findById(postDTO.getTipoPostagem()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo Postagem não Encontrado!"));
		
		Usuario user = ur.findById(postDTO.getIdUsuario()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não Encontrado!"));
			
		Postagem post = new Postagem();
		post.setHoraData(LocalDateTime.now());
		post.setTitulo(postDTO.getTitulo());
		post.setMensagem(postDTO.getMensagem());
		post.setTipoPostagem(tp);
		post.setVisibilidade(postDTO.getVisibilidade());
		post.setStatus(postDTO.getStatus());
		post.setLink(postDTO.getLink());
		post.setUsuario(user);
		
		pr.save(post);
	}
	
	public List<PostagemDTO> listarPostagem(){
		return pr.findAll().stream().map(PostagemDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<PostagemDTO> findByPostagemUsuarioId(Long id) {
		return pr.findByPostagemUsuarioId(id).stream().map(PostagemDTO::new).collect(Collectors.toList());
	}
}
