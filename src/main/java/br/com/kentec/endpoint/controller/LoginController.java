package br.com.kentec.endpoint.controller;

import java.util.Optional;

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

import br.com.kentec.endpoint.DTO.UsuarioDTO;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.service.UsuarioService;

@RestController
@RequestMapping("/projeto11/api/login")
public class LoginController {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping("/autenticar/{email}")
	public ResponseEntity<Optional<Usuario>> findByEmail(@PathVariable String email){
		return ResponseEntity.ok(us.findByEmail(email));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		us.gravarUsuario(usuarioDTO);
	}
}
