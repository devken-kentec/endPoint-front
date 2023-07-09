package br.com.kentec.endpoint.DTO;

import java.time.LocalDateTime;

import br.com.kentec.endpoint.domain.Postagem;

public class PostagemDTO {
	private Long id;
	private String titulo;
	private LocalDateTime dataPostagem;
	private String mensagem;
	private Long tipoPostagem;
	private String tipoPostagemDescricao;
	private Long idUsuario;
	private String usuario;
	private String visibilidade;
	private String status;
	private String link;
	
	public PostagemDTO() {
		
	}
	
	public PostagemDTO(Postagem postagem) {
		this.id = postagem.getId();
		this.titulo = postagem.getTitulo();
		this.dataPostagem = postagem.getHoraData();
		this.mensagem = postagem.getMensagem();
		this.tipoPostagem = postagem.getTipoPostagem().getId();
		this.tipoPostagemDescricao = postagem.getTipoPostagem().getDescricao();
		this.idUsuario = postagem.getUsuario().getId();
		this.usuario = postagem.getUsuario().getNome();
		this.visibilidade = postagem.getVisibilidade();
		this.status = postagem.getStatus();
		this.link = postagem.getLink();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getTipoPostagem() {
		return tipoPostagem;
	}

	public void setTipoPostagem(Long tipoPostagem) {
		this.tipoPostagem = tipoPostagem;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoPostagemDescricao() {
		return tipoPostagemDescricao;
	}

	public void setTipoPostagemDescricao(String tipoPostagemDescricao) {
		this.tipoPostagemDescricao = tipoPostagemDescricao;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
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
		return "PostagemDTO [id=" + id + ", titulo=" + titulo + ", dataPostagem=" + dataPostagem + ", mensagem="
				+ mensagem + ", tipoPostagem=" + tipoPostagem + ", tipoPostagemDescricao=" + tipoPostagemDescricao
				+ ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", visibilidade=" + visibilidade + ", status="
				+ status + ", link=" + link + "]";
	}
}
