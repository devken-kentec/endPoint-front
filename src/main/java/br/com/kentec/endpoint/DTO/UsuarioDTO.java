package br.com.kentec.endpoint.DTO;

import java.time.LocalDate;
import java.util.Arrays;

public class UsuarioDTO {
		
	private Long id;
	private LocalDate dataDeNascimento;
	private String nome;
	private String sobreNome;
	private String senha;
	private String email; 
	private String status;
	private String cep;
	private Boolean termoDeUso;
	private byte[] foto;
	
	public UsuarioDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Boolean getTermoDeUso() {
		return termoDeUso;
	}

	public void setTermoDeUso(Boolean termoDeUso) {
		this.termoDeUso = termoDeUso;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", dataDeNascimento=" + dataDeNascimento + ", nome=" + nome + ", sobreNome="
				+ sobreNome + ", senha=" + senha + ", email=" + email + ", status=" + status + ", cep=" + cep
				+ ", termoDeUso=" + termoDeUso + ", foto=" + Arrays.toString(foto) + "]";
	}
	
}
