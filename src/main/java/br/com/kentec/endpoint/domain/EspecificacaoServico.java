package br.com.kentec.endpoint.domain;

import java.io.Serializable;
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
@Table(name="especificacao_servico")
@SuppressWarnings("serial")
public class EspecificacaoServico implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="dia", nullable = false, length = 20)
	private LocalDate dia;
	
	@Column(name="horario", nullable = true, length = 100)
	private String horario;
	
	@Column(name="codigo_especificacao", nullable = true, length = 200)
	private String codigoEspecificacao;
	
	@ManyToOne
	@JoinColumn(name="id_detalhamentos_ervico", nullable = false)
	private DetalhamentoServico detalhamentoServico = new DetalhamentoServico();
	
	public EspecificacaoServico() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCodigoEspecificacao() {
		return codigoEspecificacao;
	}

	public void setCodigoEspecificacao(String codigoEspecificacao) {
		this.codigoEspecificacao = codigoEspecificacao;
	}

	public DetalhamentoServico getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(DetalhamentoServico detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	@Override
	public String toString() {
		return "EspecificacaoServico [id=" + id + ", dia=" + dia + ", horario=" + horario + ", codigoEspecificacao="
				+ codigoEspecificacao + ", detalhamentoServico=" + detalhamentoServico + "]";
	}

}
