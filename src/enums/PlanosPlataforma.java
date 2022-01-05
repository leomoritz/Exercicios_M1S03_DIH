package enums;

public enum PlanosPlataforma {

	BASICO
	(19.99,	"Assista na TV, computador, celular ou tablet; Resolução 480p"),
	PADRAO
	(29.99,	"Assista na TV, computador, celular ou tablet; Resolução 1080p; Acesso simultâneo em até 2 aparelhos"),
	PREMIUM
	(39.99,	"Assista na TV, computador, celular ou tablet; Resolução 4K+HDR; Acesso simultâneo em até 4 aparelhos");

	private Double preco;
	private String caracteristicas;

	PlanosPlataforma(double preco, String caracteristicas) {
		this.preco = preco;
		this.caracteristicas = caracteristicas;
	}

	public Double getPreco() {
		return preco;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public String detalhesPlano() {
		return name() + " - " + getPreco() + " - " + getCaracteristicas();
	}

}
