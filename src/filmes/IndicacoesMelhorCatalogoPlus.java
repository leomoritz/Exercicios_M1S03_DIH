package filmes;

import java.time.Duration;

import interfaces.IndicacoesCatalogo;
import plataforma.Plataforma;
import usuarios.Usuario;

public class IndicacoesMelhorCatalogoPlus implements IndicacoesCatalogo {

	@Override
	public Boolean addIndicacoesNovosFilme(String nomeNovoFilme, Usuario usuarioIndicou,
			Plataforma plataforma) throws Exception {

		IndicacaoFilmeCatalogo indicacaoFilmeCatalogo = new IndicacaoFilmeCatalogo(nomeNovoFilme, usuarioIndicou);

		if (validaPeriodoEntreIndicacoes(indicacaoFilmeCatalogo)) {
			indicacaoFilmeCatalogo.setDataUltimaIndicacao(indicacaoFilmeCatalogo.getDataIndicacao());
			indicacaoFilmeCatalogo.incrementaQtdIndicacao(1);
			plataforma.getCatalogo().getIndicacoesNovosFilmesUsuario().add(indicacaoFilmeCatalogo);
			return true;
		}

		return false;

	}

	private Boolean validaPeriodoEntreIndicacoes(IndicacaoFilmeCatalogo indicacaoFilmeCatalogo) throws Exception {

		Duration diferencaDuracao = Duration.between(indicacaoFilmeCatalogo.getDataUltimaIndicacao().atStartOfDay(),
													 indicacaoFilmeCatalogo.getDataIndicacao().atStartOfDay());

		long qtdDiferencaDias = diferencaDuracao.toDays();

		if (qtdDiferencaDias < 31 && indicacaoFilmeCatalogo.getQtdIndicacaoUsuario() >= 1) {
			throw new Exception("N�o foi poss�vel realizar a indica��o do filme!",
					new Throwable("J� existe um filme indicado neste m�s. "
							+ "Aguarde " + (31 - qtdDiferencaDias) + " para realizar uma nova indica��o."));
		}

		indicacaoFilmeCatalogo.setQtdIndicacaoUsuario(0);
		
		return true;

	}
}
