package br.com.kentec.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.endpoint.domain.Empresas;
import br.com.kentec.endpoint.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository er;
	
	public Iterable<Empresas> findByNomeEmpresa(String nomeEmpresa) {
		return er.findByNomeEmpresa("%"+nomeEmpresa+"%");
	}
	
	public void salvarEmpresa(Empresas empresa) {
		er.save(empresa);
	}
}
