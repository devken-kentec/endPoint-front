package br.com.kentec.endpoint.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="amigos")
@SuppressWarnings("serial")
public class Amigos implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true, length = 11)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario eu = new Usuario();
	
	@ManyToOne
	@JoinColumn(name="id_amigo", nullable = false)
	private Usuario amigo = new Usuario();
	
	@Column(name="solicitar", nullable = true, length = 15)
	private String solicitar;
	
	public Amigos() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getEu() {
		return eu;
	}

	public void setEu(Usuario eu) {
		this.eu = eu;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}

	public String getSolicitar() {
		return solicitar;
	}

	public void setSolicitar(String solicitar) {
		this.solicitar = solicitar;
	}

	@Override
	public String toString() {
		return "Amigos [id=" + id + ", eu=" + eu + ", amigo=" + amigo + ", solicitar=" + solicitar + "]";
	}
	
}
