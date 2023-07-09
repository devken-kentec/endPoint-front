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
@Table(name="produto")
@SuppressWarnings("serial")
public class Produto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 20)
	private Long id;
	
	@Column(name="descricao", nullable = false, length = 250)
	private String descricao;
	
	@Column(name="codigo_produto", nullable = true, length = 200)
	private String codigoProduto;
	
	@Column(name="observacao", nullable = false, length = 300)
	private String observacao;
	
	@Column(name="fabricante", nullable = true, length = 100)
	private String fabricante;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable = false)
	private Empresas empresa = new Empresas();
	
	public Produto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", codigoProduto=" + codigoProduto + ", observacao="
				+ observacao + ", fabricante=" + fabricante + ", empresa=" + empresa + "]";
	}
	
}
