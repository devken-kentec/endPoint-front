package br.com.kentec.endpoint.utilidade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.endpoint.domain.TipoPostagem;
import br.com.kentec.endpoint.repository.TipoPostagemRepository;

@Service
public class Utils {
	
	@Autowired
	private TipoPostagemRepository tpr;
	
	public List<TipoPostagem> selectTipoPostagem(){
		return tpr.findAll();
	}
}
