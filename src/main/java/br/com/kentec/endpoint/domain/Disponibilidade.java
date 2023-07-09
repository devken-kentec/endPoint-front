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
@Table(name="disponibilidade")
@SuppressWarnings("serial")
public class Disponibilidade implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_entrada", nullable = false)
	private LocalDate dataEntrada;
	
	@Column(name="valor_servico", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorServico;
	
	@Column(name="valor_transporte", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorTransporte;
	
	@Column(name="outros_valores", nullable = true, precision = 10, scale = 2)
	private BigDecimal ourtrosValores;
	
	@Column(name="total_servico", nullable = true, precision = 10, scale = 2)
	private BigDecimal totalCompra;
	
	@Column(name="margem_lucro", nullable = true, precision = 10, scale = 2)
	private BigDecimal margemLucro;
	
	@Column(name="valor_margem_lucro", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorMargemLucro;
	
	@Column(name="desconto_servico", nullable = true, precision = 10, scale = 2)
	private BigDecimal descontoServico;
	
	@Column(name="valor_desconto_servico", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorDescontoServico;
	
	@Column(name="valor_final_servico", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorFinalServico;
	
	@Column(name="data_saida", nullable = true)
	private LocalDate dataSaida;
	
	@Column(name="estado_disponibilidade", nullable = true, length = 20)
	private String estadoDisponibilidade;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable = false)
	private Empresas empresa = new Empresas();
	
	@ManyToOne
	@JoinColumn(name="id_especificao_servico", nullable = false)
	private EspecificacaoProduto especificaoServico = new EspecificacaoProduto();
	
	public Disponibilidade() {
		
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

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
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

	public BigDecimal getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(BigDecimal descontoServico) {
		this.descontoServico = descontoServico;
	}

	public BigDecimal getValorDescontoServico() {
		return valorDescontoServico;
	}

	public void setValorDescontoServico(BigDecimal valorDescontoServico) {
		this.valorDescontoServico = valorDescontoServico;
	}

	public BigDecimal getValorFinalServico() {
		return valorFinalServico;
	}

	public void setValorFinalServico(BigDecimal valorFinalServico) {
		this.valorFinalServico = valorFinalServico;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getEstadoDisponibilidade() {
		return estadoDisponibilidade;
	}

	public void setEstadoDisponibilidade(String estadoDisponibilidade) {
		this.estadoDisponibilidade = estadoDisponibilidade;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public EspecificacaoProduto getEspecificaoServico() {
		return especificaoServico;
	}

	public void setEspecificaoServico(EspecificacaoProduto especificaoServico) {
		this.especificaoServico = especificaoServico;
	}

	@Override
	public String toString() {
		return "Disponibilidade [id=" + id + ", dataEntrada=" + dataEntrada + ", valorServico=" + valorServico
				+ ", valorTransporte=" + valorTransporte + ", ourtrosValores=" + ourtrosValores + ", totalCompra="
				+ totalCompra + ", margemLucro=" + margemLucro + ", valorMargemLucro=" + valorMargemLucro
				+ ", descontoServico=" + descontoServico + ", valorDescontoServico=" + valorDescontoServico
				+ ", valorFinalServico=" + valorFinalServico + ", dataSaida=" + dataSaida + ", estadoDisponibilidade="
				+ estadoDisponibilidade + ", empresa=" + empresa + ", especificaoServico=" + especificaoServico + "]";
	}
}
