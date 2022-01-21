package filmes;

import interfaces.IndicacoesCatalogo;
import plataforma.Plataforma;
import usuarios.Usuario;

public class IndicacoesMelhorCatalogoPadrao implements IndicacoesCatalogo {

	@Override
	public Boolean addIndicacoesNovosFilme(String nomeNovoFilme, Usuario usuarioIndicou, Plataforma plataforma) {

		IndicacaoFilmeCatalogo indicacaoFilmeCatalogo = new IndicacaoFilmeCatalogo(nomeNovoFilme, usuarioIndicou);
		
		if (plataforma.getCatalogo().getIndicacoesNovosFilmesUsuario().add(indicacaoFilmeCatalogo)) {
			return true;
		}

		return false;
	}

}
