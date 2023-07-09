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
@Table(name="especificacao_produto")
@SuppressWarnings("serial")
public class EspecificacaoProduto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 20)
	private Long id;
	
	@Column(name="codigo_especificacao", nullable = true, length = 200)
	private String codigoEspecificacao;
	
	@Column(name="cor", nullable = true, length = 15)
	private String cor;
	
	@Column(name="tamanho_numerico", nullable = true, length = 5)
	private Integer tamanhoNumerico;
	
	@ManyToOne
	@JoinColumn(name="id_detalhamento_produto", nullable = false)
	private DetalhamentoProduto detalhamentoProduto= new DetalhamentoProduto();
	
	public EspecificacaoProduto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoEspecificacao() {
		return codigoEspecificacao;
	}

	public void setCodigoEspecificacao(String codigoEspecificacao) {
		this.codigoEspecificacao = codigoEspecificacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getTamanhoNumerico() {
		return tamanhoNumerico;
	}

	public void setTamanhoNumerico(Integer tamanhoNumerico) {
		this.tamanhoNumerico = tamanhoNumerico;
	}

	public DetalhamentoProduto getDetalhamentoProduto() {
		return detalhamentoProduto;
	}

	public void setDetalhamentoProduto(DetalhamentoProduto detalhamentoProduto) {
		this.detalhamentoProduto = detalhamentoProduto;
	}

	@Override
	public String toString() {
		return "EspecificacaoProduto [id=" + id + ", codigoEspecificacao=" + codigoEspecificacao + ", cor=" + cor
				+ ", tamanhoNumerico=" + tamanhoNumerico + ", detalhamentoProduto=" + detalhamentoProduto + "]";
	}
}
