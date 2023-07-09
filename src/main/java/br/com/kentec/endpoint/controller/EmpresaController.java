package br.com.kentec.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.endpoint.domain.Empresas;
import br.com.kentec.endpoint.service.EmpresaService;

@RestController
@RequestMapping("/projeto11/api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService es;
	
	@GetMapping("/pesquisa/{nomeEmpresa}")
	public ResponseEntity<Iterable<Empresas>> listarEmpresas(@PathVariable("nomeEmpresa") String nomeEmpresa) {
		return ResponseEntity.ok(es.findByNomeEmpresa(nomeEmpresa ));
	}
	
	@PostMapping()
	public void salvarEmpresa(@RequestBody Empresas empresa) {
		es.salvarEmpresa(empresa);
	}
}
