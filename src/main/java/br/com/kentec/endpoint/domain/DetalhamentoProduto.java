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
@Table(name="detalhamento_produto")
@SuppressWarnings("serial")
public class DetalhamentoProduto implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="codigo_detalhamento", nullable = true, length = 200)
	private String codigoDetalhamento;
	
	@Column(name="unidade_medida", nullable = true, length = 15)
	private String undidadeMedida;
	
	@Column(name="unidade_venda", nullable = true, length = 15)
	private String undidadeVenda;
	
	@Column(name="peso", nullable = true, length = 5)
	private String peso;
	
	@Column(name="altura", nullable = true, length = 5)
	private String altura;
	
	@Column(name="largura", nullable = true, length = 5)
	private String largura;
	
	@Column(name="comprimento", nullable = true, length = 5)
	private String comprimento;  
	
	@Column(name="tamanho", nullable = true, length = 5)
	private String tamanho;
	
	@ManyToOne
	@JoinColumn(name="id_produto", nullable = false)
	private Produto produto = new Produto();
	
	public DetalhamentoProduto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoDetalhamento() {
		return codigoDetalhamento;
	}

	public void setCodigoDetalhamento(String codigoDetalhamento) {
		this.codigoDetalhamento = codigoDetalhamento;
	}

	public String getUndidadeMedida() {
		return undidadeMedida;
	}

	public void setUndidadeMedida(String undidadeMedida) {
		this.undidadeMedida = undidadeMedida;
	}

	public String getUndidadeVenda() {
		return undidadeVenda;
	}

	public void setUndidadeVenda(String undidadeVenda) {
		this.undidadeVenda = undidadeVenda;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getComprimento() {
		return comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "DetalhamentoProduto [id=" + id + ", codigoDetalhamento=" + codigoDetalhamento + ", undidadeMedida="
				+ undidadeMedida + ", undidadeVenda=" + undidadeVenda + ", peso=" + peso + ", altura=" + altura
				+ ", largura=" + largura + ", comprimento=" + comprimento + ", tamanho=" + tamanho + ", produto="
				+ produto + "]";
	}
}
