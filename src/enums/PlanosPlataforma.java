package enums;

public enum PlanosPlataforma {

	BASICO
	(19.99,	"Assista na TV, computador, celular ou tablet; Resolu��o 480p"),
	PADRAO
	(29.99,	"Assista na TV, computador, celular ou tablet; Resolu��o 1080p; Acesso simult�neo em at� 2 aparelhos"),
	PREMIUM
	(39.99,	"Assista na TV, computador, celular ou tablet; Resolu��o 4K+HDR; Acesso simult�neo em at� 4 aparelhos");

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
