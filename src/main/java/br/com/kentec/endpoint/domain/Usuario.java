package br.com.kentec.endpoint.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="usuario")
@SuppressWarnings("serial")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_nascimento", nullable = false, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataDeNascimento;
	
	@Column(name="nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name="sobreNome", nullable = true, length = 200)
	private String sobreNome;
	
	@Column(name="senha", nullable = false, length = 10)
	private String senha;
	
	@Column(name="email", nullable = false, length = 100)
	private String email; 
	
	@Column(name="status", nullable = false, length = 10)
	private String status;
	
	@Column(name="cep", nullable = true, length = 8)
	private String cep;
	
	@Column(name="termo_de_uso", nullable = false)
	private Boolean termoDeUso;
	
	@Column(name="setor", nullable = true)
	private String setor;
	
	@Column(name="foto", nullable = true)
	@Lob
	private byte[] foto;
	
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getTermoDeUso() {
		return termoDeUso;
	}

	public void setTermoDeUso(Boolean termoDeUso) {
		this.termoDeUso = termoDeUso;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dataDeNascimento=" + dataDeNascimento + ", nome=" + nome + ", sobreNome="
				+ sobreNome + ", senha=" + senha + ", email=" + email + ", status=" + status + ", cep=" + cep
				+ ", termoDeUso=" + termoDeUso + ", setor=" + setor + ", foto=" + Arrays.toString(foto) + "]";
	}
}
