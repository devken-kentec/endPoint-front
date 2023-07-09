package br.com.kentec.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.endpoint.DTO.PostagemDTO;
import br.com.kentec.endpoint.service.PostagemService;


@RestController
@RequestMapping("/projeto11/api/postagem")
public class PostagemController {
	
	@Autowired
	private PostagemService ps;
	
	@GetMapping("/listarPostagemUsuarioId/{id}")
	public ResponseEntity<Iterable<PostagemDTO>> findByPostagemUsuarioId(@PathVariable("id") Long id){
		return ResponseEntity.ok(ps.findByPostagemUsuarioId(id));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarPostagem(@RequestBody PostagemDTO postagemDTO) {
		ps.gravarPostagem(postagemDTO);
	}
}
