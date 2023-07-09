package br.com.kentec.endpoint.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.endpoint.DTO.UsuarioDTO;
import br.com.kentec.endpoint.domain.Cep;
import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.repository.UsuarioRepository;
import br.com.kentec.endpoint.utilidade.CepConsumerFeign;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private CepConsumerFeign ccp;

	public void gravarUsuario(UsuarioDTO usuarioDTO) {
		Usuario user = new Usuario();
		user.setDataDeNascimento(usuarioDTO.getDataDeNascimento());
		user.setNome(usuarioDTO.getNome());
		user.setSobreNome(usuarioDTO.getSobreNome());
		user.setEmail(usuarioDTO.getEmail());
		user.setCep(usuarioDTO.getCep());
		Cep cep = ccp.getCep(user.getCep()); 
		user.setSenha(usuarioDTO.getSenha());
		user.setStatus(usuarioDTO.getStatus());
		user.setTermoDeUso(usuarioDTO.getTermoDeUso());
		user.setSetor(cep.getBairro());
		ur.save(user);
	}
	
	public void alterarUsuario(UsuarioDTO usuarioDTO) {
		Optional<Usuario> user = ur.findById(usuarioDTO.getId());
		if(user.isPresent()) {
			user.get().setDataDeNascimento(usuarioDTO.getDataDeNascimento());
			user.get().setNome(usuarioDTO.getNome());
			user.get().setSobreNome(usuarioDTO.getSobreNome());
			user.get().setEmail(usuarioDTO.getEmail());
			user.get().setCep(usuarioDTO.getCep());
			Cep cep = ccp.getCep(user.get().getCep()); 
			user.get().setSenha(usuarioDTO.getSenha());
			user.get().setStatus(usuarioDTO.getStatus());
			user.get().setTermoDeUso(usuarioDTO.getTermoDeUso());
			user.get().setSetor(cep.getBairro());
			ur.save(user.get());
		}
	}
	
	public Optional<Usuario> findByEmail(String email){
		return ur.findByEmail(email);
	}
	
	public Iterable<Usuario> findByNome(String nome){
		return ur.findByNome("%" + nome + "%");
	}
	
	public Optional<Usuario> findById(Long id){
		return ur.findById(id);
	}
	
	public byte[] adicionarFoto(Part arquivo, Long id) {
		
		Optional<Usuario> user = ur.findById(id);
		
		return user.map(u -> {
			try {
				InputStream is = arquivo.getInputStream();
				byte[] bytes = new byte[(int) arquivo.getSize()];
				IOUtils.readFully(is, bytes);
				u.setFoto(bytes);
				ur.save(u);
				is.close();
				return bytes;
			} catch (IOException e) {
				return null;
			}
		}).orElse(null);
	}
}
