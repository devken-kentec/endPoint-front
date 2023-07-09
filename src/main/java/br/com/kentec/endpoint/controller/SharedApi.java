package br.com.kentec.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.endpoint.DTO.PostagemDTO;
import br.com.kentec.endpoint.service.PostagemService;

@RestController
@RequestMapping("/projeto11/api/sharedApi")
public class SharedApi {
	
	@Autowired
	private PostagemService ps;
	
	@GetMapping("/listarPostagem")
	public ResponseEntity<Iterable<PostagemDTO>> listarPostagem(){
		return ResponseEntity.ok(ps.listarPostagem());
	}
}
