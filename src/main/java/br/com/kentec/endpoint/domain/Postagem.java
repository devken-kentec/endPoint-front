package br.com.kentec.endpoint.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="postagem")
@SuppressWarnings("serial")
public class Postagem  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="hora_data")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime horaData;
	
	@Column(name="titulo", nullable = true, length = 30)
	private String titulo;
	
	@Lob
	@Column(name="mensagem", nullable = true)
	private String mensagem;
	
	@Column(name="joinha", length = 10, nullable = true)
	private Integer joinha;
	
	@Column(name="visibilidade", length = 15, nullable = true)
	private String visibilidade;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_postagem", nullable = false)
	private TipoPostagem tipoPostagem = new TipoPostagem();
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario usuario = new Usuario();
	
	@Column(name="status", nullable = false, length = 10)
	private String status;
	
	@Column(name="link", nullable = true, length = 100)
	private String link;
	
	public Postagem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHoraData() {
		return horaData;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setHoraData(LocalDateTime horaData) {
		this.horaData = horaData;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getJoinha() {
		return joinha;
	}

	public void setJoinha(Integer joinha) {
		this.joinha = joinha;
	}

	public TipoPostagem getTipoPostagem() {
		return tipoPostagem;
	}

	public void setTipoPostagem(TipoPostagem tipoPostagem) {
		this.tipoPostagem = tipoPostagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Postagem [id=" + id + ", horaData=" + horaData + ", titulo=" + titulo + ", mensagem=" + mensagem
				+ ", joinha=" + joinha + ", visibilidade=" + visibilidade + ", tipoPostagem=" + tipoPostagem
				+ ", usuario=" + usuario + ", status=" + status + ", link=" + link + "]";
	}			
}
