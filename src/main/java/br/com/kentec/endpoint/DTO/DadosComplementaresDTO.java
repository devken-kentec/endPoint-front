package br.com.kentec.endpoint.DTO;

import br.com.kentec.endpoint.domain.DadosComplementares;

public class DadosComplementaresDTO {
	
	private Long id;
	private Long idComplementar;
	private String escola;
	private String faculdade;
	private String trabalho;
	private String estadoCivil;
	private String telefone;
	
	public DadosComplementaresDTO() {
		
	}
	
	public DadosComplementaresDTO(DadosComplementares dadosComplementares) {
		this.id = dadosComplementares.getId();
		this.escola = dadosComplementares.getEscola();
		this.faculdade = dadosComplementares.getFaculdade();
		this.trabalho = dadosComplementares.getTrabalho();
		this.estadoCivil = dadosComplementares.getEstadoCivil();
		this.telefone = dadosComplementares.getTelefone();
		this.idComplementar = dadosComplementares.getUsuario().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdComplementar() {
		return idComplementar;
	}

	public void setIdComplementar(Long idComplementar) {
		this.idComplementar = idComplementar;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public String getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "DadosComplementaresDTO [id=" + id + ", idComplementar=" + idComplementar + ", escola=" + escola
				+ ", faculdade=" + faculdade + ", trabalho=" + trabalho + ", estadoCivil=" + estadoCivil
				+ ", telefone=" + telefone + "]";
	}
}
