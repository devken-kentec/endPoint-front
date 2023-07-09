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
@Table(name="detalhamento_servico")
@SuppressWarnings("serial")
public class DetalhamentoServico implements Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="prestador", nullable = true, length = 100)
	private String prestador;
	
	@Column(name="descricao", nullable = false, length = 250)
	private String descricao;
	
	@Column(name="codigo_detalhamento", nullable = true, length = 200)
	private String codigoDetalhamento;
	
	@Column(name="tempo_execucao", nullable = true, length = 50)
	private String tempoExecucao;
	
	@Column(name="observacao", nullable = false, length = 300)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="id_servico", nullable = false)
	private Servico servico = new Servico();
	
	public DetalhamentoServico() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoDetalhamento() {
		return codigoDetalhamento;
	}

	public void setCodigoDetalhamento(String codigoDetalhamento) {
		this.codigoDetalhamento = codigoDetalhamento;
	}

	public String getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(String tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "DetalhamentoServico [id=" + id + ", prestador=" + prestador + ", descricao=" + descricao
				+ ", codigoDetalhamento=" + codigoDetalhamento + ", tempoExecucao=" + tempoExecucao + ", observacao="
				+ observacao + ", servico=" + servico + "]";
	}
}	
