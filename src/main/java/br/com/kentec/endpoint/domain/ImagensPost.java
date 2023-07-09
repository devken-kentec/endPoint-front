package br.com.kentec.endpoint.domain;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.*;

@Entity
@Table(name="imagens_post")
@SuppressWarnings("serial")
public class ImagensPost implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Lob
	@Column(name="imagem")
	private byte[] imagem;
	
	@ManyToOne
	@JoinColumn(name="id_postagem")
	private Postagem postagem = new Postagem();
	
	
	public ImagensPost() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	@Override
	public String toString() {
		return "ImagensPost [id=" + id + ", imagem=" + Arrays.toString(imagem) + ", postagem=" + postagem + "]";
	}
}
