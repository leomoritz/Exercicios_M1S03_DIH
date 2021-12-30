package filmes;

import java.util.Objects;

import enums.GeneroFilme;

public class GeneroAssistido implements Comparable<GeneroAssistido> {

	private GeneroFilme generoAssistido;
	private Integer qtdAssistido;

	// Construtor
	public GeneroAssistido() {

	}

	public GeneroAssistido(GeneroFilme generoAssistido, int qtdAssistido) {
		this.generoAssistido = generoAssistido;
		this.qtdAssistido = qtdAssistido;
	}

	// Getters & Setters
	public GeneroFilme getGeneroAssistido() {
		return generoAssistido;
	}

	public void setGeneroAssistido(GeneroFilme generoAssistido) {
		this.generoAssistido = generoAssistido;
	}

	public int getQtdAssistido() {
		return qtdAssistido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(generoAssistido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneroAssistido other = (GeneroAssistido) obj;
		return generoAssistido == other.generoAssistido;
	}

	public void setQtdAssistido(int qtdAssistido) {
		this.qtdAssistido = qtdAssistido;
	}

	@Override
	public int compareTo(GeneroAssistido other) {
		return generoAssistido.compareTo(other.generoAssistido);
	}

}
