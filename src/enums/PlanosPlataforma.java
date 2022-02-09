package enums;

public enum PlanosPlataforma {

	BASICO
	(9.90,	"Assista na TV, computador, celular ou tablet; Resolu��o 480p; Apenas 1 perfil"),
	PADRAO
	(6.90,	"Assista na TV, computador, celular ou tablet; Resolu��o 1080p; Acesso simult�neo em at� 2 aparelhos; De 2 at� 4 perfis"),
	FAMILIA
	(29.00,	"Assista na TV, computador, celular ou tablet; Resolu��o 4K+HDR; Acesso simult�neo em at� 4 aparelhos; Plano fam�lia com 5 perfis");

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
