package br.com.kentec.endpoint.DTO;

import br.com.kentec.endpoint.domain.Amigos;

public class AmigosDTO {
	
	private Long id;
	private String solicitar;
	private Long idUsuario;
	private String usuario;
	private Long idAmigo;
	private String amigo;
	
	public AmigosDTO(Amigos amigo) {
		this.id = amigo.getId();
		this.solicitar = amigo.getSolicitar();
		this.idUsuario = amigo.getEu().getId();
		this.usuario = amigo.getEu().getNome();
		this.idAmigo = amigo.getAmigo().getId();
		this.amigo = amigo.getAmigo().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSolicitar() {
		return solicitar;
	}

	public void setSolicitar(String solicitar) {
		this.solicitar = solicitar;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
	}

	public String getAmigo() {
		return amigo;
	}

	public void setAmigo(String amigo) {
		this.amigo = amigo;
	}

	@Override
	public String toString() {
		return "AmigosDTO [id=" + id + ", solicitar=" + solicitar + ", idUsuario=" + idUsuario + ", usuario=" + usuario
				+ ", idAmigo=" + idAmigo + ", amigo=" + amigo + "]";
	}
}
