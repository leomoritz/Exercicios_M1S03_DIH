package filmes;

import interfaces.IndicacoesCatalogo;
import plataforma.Plataforma;

public class IndicacoesMelhorCatalogoPadrao implements IndicacoesCatalogo {

	@Override
	public String addIndicacoesNovosFilme(String nomeNovoFilme, String usuarioIndicou, Plataforma plataforma) {
		plataforma.getIndicacoesNovosFilmes()
				.add("Filme indicado: " + nomeNovoFilme + " - Usu�rio que indicou: " + usuarioIndicou);
		return "Indica��o do filme " + nomeNovoFilme + " realizada com sucesso! Muito obrigado por nos ajudar a tornar "
				+ "a DevInFlix na melhor plataforma de filmes que existe";

	}

}
