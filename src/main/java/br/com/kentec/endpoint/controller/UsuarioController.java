package br.com.kentec.endpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.endpoint.domain.TipoPostagem;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.service.UsuarioService;
import br.com.kentec.endpoint.utilidade.Utils;

@RestController
@RequestMapping("/projeto11/api/home")
public class UsuarioController {
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private Utils uts;
	
	@GetMapping("/tipoPostagem")
	public ResponseEntity<List<TipoPostagem>> selectTipoPostagem(){
		return ResponseEntity.ok(uts.selectTipoPostagem());
	}
	
	@GetMapping("/pesquisa")
	public ResponseEntity<Iterable<Usuario>> findByNome(@RequestParam(value="nome", required = false, defaultValue = "") String nome){
		return ResponseEntity.ok(us.findByNome(nome));
	}
	
}
