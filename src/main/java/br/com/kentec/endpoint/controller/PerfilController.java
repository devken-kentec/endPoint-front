package br.com.kentec.endpoint.controller;

import java.util.Optional;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.endpoint.DTO.AmigosDTO;
import br.com.kentec.endpoint.DTO.DadosComplementaresDTO;
import br.com.kentec.endpoint.DTO.UsuarioDTO;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.service.AmigoService;
import br.com.kentec.endpoint.service.DadosComplementaresService;
import br.com.kentec.endpoint.service.UsuarioService;

@RestController
@RequestMapping("/projeto11/api/perfil")
public class PerfilController {
		
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private DadosComplementaresService dcs;
	
	@Autowired
	private AmigoService as;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(us.findById(id));
	}
	
	@GetMapping("/amigos/{id}")
	public ResponseEntity<Optional<Usuario>> findByPerfilAmigosId(@PathVariable("id") Long id){
		return ResponseEntity.ok(us.findById(id)); //implementar
	}
	
	@GetMapping("/dadosComplementares/{id}")
	public ResponseEntity<Optional<DadosComplementaresDTO>> findByUsuario(@PathVariable("id") Long id){
		return ResponseEntity.ok(dcs.findByUsusario(id)) ;
	}
	
	@PutMapping("/alterarUsuario")
	public void alterarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		us.alterarUsuario(usuarioDTO);
	} 
	
	@PostMapping("/dadosComplementares")
	public void gravarDadosComplementares(@RequestBody DadosComplementaresDTO dadosComplementaresDTO) {
		dcs.gavarDadosComplementares(dadosComplementaresDTO);
	}
	
	@PutMapping("/dadosComplementares")
	public void alterarDadosComplementares(@RequestBody DadosComplementaresDTO dadosComplementaresDTO) {
		dcs.alterarDadosComplementares(dadosComplementaresDTO);
	}
	
	@GetMapping("/listarAmigos/{id}")
	public ResponseEntity<Iterable<AmigosDTO>> listarAmigos(@PathVariable("id") Long id){
		return ResponseEntity.ok(as.listarAmigos(id));
	}
	
	@GetMapping("/listarAmigosSolicitando/{id}")
	public ResponseEntity<Iterable<AmigosDTO>> listarAmigosSolicitando(@PathVariable("id") Long id){
		return ResponseEntity.ok(as.listarAmigosSolicitando(id));
	}
	
	@PutMapping("/arquivo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void adicionarFoto(@RequestParam("arquivo") Part arquivo, @PathVariable("id") Long id) {
		us.adicionarFoto(arquivo, id);
	}
	
}
