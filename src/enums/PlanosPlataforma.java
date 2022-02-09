package enums;

public enum PlanosPlataforma {

	BASICO
	(9.90,	"Assista na TV, computador, celular ou tablet; Resolução 480p; Apenas 1 perfil"),
	PADRAO
	(6.90,	"Assista na TV, computador, celular ou tablet; Resolução 1080p; Acesso simultâneo em até 2 aparelhos; De 2 até 4 perfis"),
	FAMILIA
	(29.00,	"Assista na TV, computador, celular ou tablet; Resolução 4K+HDR; Acesso simultâneo em até 4 aparelhos; Plano família com 5 perfis");

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
