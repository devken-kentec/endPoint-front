package br.com.kentec.endpoint.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carrinho")
@SuppressWarnings("serial")
public class Carrinho implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable = false)
	private Empresas empresa = new Empresas();
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable = true)
	private Usuario usuario = new Usuario();
	
	@OneToOne
	@JoinColumn(name="id_estoque", nullable = true)
	private Estoque estoque = new Estoque();
	
	@OneToOne
	@JoinColumn(name="id_disponibilidade", nullable = true)
	private Disponibilidade disponibilidade = new Disponibilidade();
	
	public Carrinho() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", empresa=" + empresa + ", usuario=" + usuario + ", estoque=" + estoque
				+ ", disponibilidade=" + disponibilidade + "]";
	}
}
