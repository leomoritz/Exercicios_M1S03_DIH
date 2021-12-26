package filmes;

import interfaces.IndicacoesCatalogo;

public class IndicacoesMelhorCatalogo implements IndicacoesCatalogo {

	@Override
	public String addIndicacoesNovosFilme(String nomeNovoFilme, String usuarioIndicou, CatalogoFilmes catalogo) {
		catalogo.getIndicacoesNovosFilmes()
				.add("Filme indicado: " + nomeNovoFilme + " - Usuário que indicou: " + usuarioIndicou);
		return "Indicação do filme " + nomeNovoFilme + " realizada com sucesso! Muito obrigado por nos ajudar a tornar "
				+ "a DevInFlix na melhor plataforma de filmes que existe";

	}

	@Override
	public boolean removeIndicacoesNovosFilme(int indexIndicacao, CatalogoFilmes catalogo) {
		int tamanhoLista = catalogo.getIndicacoesNovosFilmes().size();
		catalogo.getIndicacoesNovosFilmes().remove(indexIndicacao);
		if (tamanhoLista < catalogo.getIndicacoesNovosFilmes().size()) {
			return true;
		}
		return false;
	}

}
