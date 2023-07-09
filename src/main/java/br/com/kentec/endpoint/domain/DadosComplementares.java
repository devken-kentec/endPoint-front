package br.com.kentec.endpoint.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dados_complemantares")
@SuppressWarnings("serial")
public class DadosComplementares implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="escola", nullable = true, length = 200)
	private String escola;
	
	@Column(name="faculdade", nullable = true, length = 200)
	private String faculdade;
	
	@Column(name="trabalho", nullable = true, length = 200)
	private String trabalho;
	
	@Column(name="estado_civil", nullable = true, length = 50)
	private String estadoCivil;
	
	@Column(name="telefone", nullable = true, length = 15)
	private String telefone;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable = true)
	private Usuario usuario = new Usuario();
	
	public DadosComplementares() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public String getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DadosComplementares [id=" + id + ", escola=" + escola + ", faculdade=" + faculdade + ", trabalho="
				+ trabalho + ", estadoCivil=" + estadoCivil + ", telefone=" + telefone + ", usuario=" + usuario + "]";
	}
}
