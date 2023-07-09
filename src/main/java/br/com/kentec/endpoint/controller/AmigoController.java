package br.com.kentec.endpoint.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.endpoint.DTO.AmigosDTO;
import br.com.kentec.endpoint.service.AmigoService;

@RestController
@RequestMapping("/projeto11/api/amizade")
public class AmigoController {
	
	@Autowired
	private AmigoService as;
	
	@GetMapping("/solicitarAmizade")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void solicitarAmizade(@RequestParam(value="id", required = true, defaultValue = "") Long id, 
			                     @RequestParam(value="idAmigo", required = true, defaultValue = "") Long idAmigo) {
		as.solicatarAmizade(id, idAmigo);
	}
	
	@GetMapping("/listarAmigos/{id}")
	public ResponseEntity<Iterable<AmigosDTO>> listarAmigos(@PathVariable Long id){
		return ResponseEntity.ok(as.listarAmigos(id));
	}
	
	@GetMapping("/verSolicitacao")
	public ResponseEntity<Optional<AmigosDTO>> verSolicitcao(@RequestParam(value="idMeu", required = false, defaultValue = "") Long idMeu, 
															 @RequestParam(value="idAmigo", required = false, defaultValue = "") Long idAmigo){
		System.out.println("MEU: ->"+ idMeu + "Amigo:"+ idAmigo);
		return ResponseEntity.ok(as.verSolicitacao(idMeu, idAmigo)); 
	}
}
