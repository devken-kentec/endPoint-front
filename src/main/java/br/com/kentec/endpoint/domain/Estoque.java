package br.com.kentec.endpoint.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
@SuppressWarnings("serial")
public class Estoque implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_entrada", nullable = false)
	private LocalDate dataEntrada;
	
	@Column(name="valor_compra", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorCompra;
	
	@Column(name="valor_transporte", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorTransporte;
	
	@Column(name="outros_valores", nullable = true, precision = 10, scale = 2)
	private BigDecimal ourtrosValores;
	
	@Column(name="total_compra", nullable = true, precision = 10, scale = 2)
	private BigDecimal totalCompra;
	
	@Column(name="margem_lucro", nullable = true, precision = 10, scale = 2)
	private BigDecimal margemLucro;
	
	@Column(name="valor_margem_lucro", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorMargemLucro;
	
	@Column(name="desconto_venda", nullable = true, precision = 10, scale = 2)
	private BigDecimal descontoVenda;
	
	@Column(name="valor_desconto_venda", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorDescontoVenda;
	
	@Column(name="valor_final_venda", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorFinalVenda;
	
	@Column(name="data_saida", nullable = true)
	private LocalDate dataSaida;
	
	@Column(name="estado_estoque", nullable = true, length = 20)
	private String estadoEstoque;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable = false)
	private Empresas empresa = new Empresas();
	
	@ManyToOne
	@JoinColumn(name="id_especificao_produto", nullable = false)
	private EspecificacaoProduto especificaoProduto = new EspecificacaoProduto();
	
	public Estoque() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public BigDecimal getValorTransporte() {
		return valorTransporte;
	}

	public void setValorTransporte(BigDecimal valorTransporte) {
		this.valorTransporte = valorTransporte;
	}

	public BigDecimal getOurtrosValores() {
		return ourtrosValores;
	}

	public void setOurtrosValores(BigDecimal ourtrosValores) {
		this.ourtrosValores = ourtrosValores;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}

	public BigDecimal getValorMargemLucro() {
		return valorMargemLucro;
	}

	public void setValorMargemLucro(BigDecimal valorMargemLucro) {
		this.valorMargemLucro = valorMargemLucro;
	}

	public BigDecimal getDescontoVenda() {
		return descontoVenda;
	}

	public void setDescontoVenda(BigDecimal descontoVenda) {
		this.descontoVenda = descontoVenda;
	}

	public BigDecimal getValorDescontoVenda() {
		return valorDescontoVenda;
	}

	public void setValorDescontoVenda(BigDecimal valorDescontoVenda) {
		this.valorDescontoVenda = valorDescontoVenda;
	}

	public BigDecimal getValorFinalVenda() {
		return valorFinalVenda;
	}

	public void setValorFinalVenda(BigDecimal valorFinalVenda) {
		this.valorFinalVenda = valorFinalVenda;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getEstadoEstoque() {
		return estadoEstoque;
	}

	public void setEstadoEstoque(String estadoEstoque) {
		this.estadoEstoque = estadoEstoque;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public EspecificacaoProduto getEspecificaoProduto() {
		return especificaoProduto;
	}

	public void setEspecificaoProduto(EspecificacaoProduto especificaoProduto) {
		this.especificaoProduto = especificaoProduto;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", dataEntrada=" + dataEntrada + ", valorCompra=" + valorCompra
				+ ", valorTransporte=" + valorTransporte + ", ourtrosValores=" + ourtrosValores + ", totalCompra="
				+ totalCompra + ", margemLucro=" + margemLucro + ", valorMargemLucro=" + valorMargemLucro
				+ ", descontoVenda=" + descontoVenda + ", valorDescontoVenda=" + valorDescontoVenda
				+ ", valorFinalVenda=" + valorFinalVenda + ", dataSaida=" + dataSaida + ", estadoEstoque="
				+ estadoEstoque + ", empresa=" + empresa + ", especificaoProduto=" + especificaoProduto + "]";
	}
}
