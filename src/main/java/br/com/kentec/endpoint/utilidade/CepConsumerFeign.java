package br.com.kentec.endpoint.utilidade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.kentec.endpoint.domain.Cep;

@FeignClient(value="cep-consumer",
				url="https://viacep.com.br/ws")
public interface CepConsumerFeign {
	
	@GetMapping("/{cep}/json")
	Cep getCep(@PathVariable("cep") String cep); 
}
