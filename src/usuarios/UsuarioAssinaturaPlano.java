package usuarios;

import java.time.LocalDate;

import enums.PlanosPlataforma;

public class UsuarioAssinaturaPlano {

	private PlanosPlataforma planoContratado;
	private final LocalDate dataInicioContrato = LocalDate.now();
	private Boolean isInadimplente;
	private Double mensalidade;
	private LocalDate dataVencimentoMensalidade;

	/*
	 * Construtor da classe UsuarioAssinaturaPlano
	 */

	public UsuarioAssinaturaPlano(PlanosPlataforma planoContratado) {
		this.planoContratado = planoContratado;
		this.isInadimplente = true;
		this.mensalidade = 0.0;
	}

	/*
	 * Getters & Setters da classe UsuarioAssinaturaPlano
	 */

	public Boolean getIsInadimplente() {
		return isInadimplente;
	}

	public void setIsInadimplente(Boolean isInadimplente) {
		this.isInadimplente = isInadimplente;
	}

	public PlanosPlataforma getPlanoContratado() {
		return planoContratado;
	}

	public void setPlanoContratado(PlanosPlataforma planoContratado) {
		this.planoContratado = planoContratado;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public LocalDate getDataVencimentoMensalidade() {
		return dataVencimentoMensalidade;
	}

	public void setDataVencimentoMensalidade(LocalDate dataVencimentoMensalidade) {
		this.dataVencimentoMensalidade = dataVencimentoMensalidade;
	}

}
