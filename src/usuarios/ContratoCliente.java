package usuarios;

import enums.PlanosPlataforma;

public class ContratoCliente {

	private PlanosPlataforma planoContratado;
	//private static final LocalDate dataInicioContrato = LocalDate.now();
	private Double parcela;
	private Boolean isInadimplente = false;
	
	
	// Construtor da classe ContratoCliente
	public ContratoCliente(PlanosPlataforma planoContratado) {
		this.planoContratado = planoContratado;
		this.parcela = planoContratado.getPreco(); // primeira parcela do contrato
	}

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

	public Double getParcela() {
		return parcela;
	}
	
	public void setParcela(Double parcela) {
		this.parcela = parcela;
	}

}
