package interfaces;

import filmes.CatalogoFilmes;

public interface IndicacoesCatalogo {

	public String addIndicacoesNovosFilme(String nomeNovoFilme, String usuarioIndicou, CatalogoFilmes catalogo);

	public boolean removeIndicacoesNovosFilme(int indexIndicacao, CatalogoFilmes catalogo);

}
