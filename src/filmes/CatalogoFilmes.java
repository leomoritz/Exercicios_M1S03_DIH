package filmes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class CatalogoFilmes {

	private final Set<Filme> filmes;
	private final Set<IndicacaoFilmeCatalogo> indicacoesNovosFilmesUsuario;

	public CatalogoFilmes() {
		this.filmes = new TreeSet<>();
		this.indicacoesNovosFilmesUsuario = new TreeSet<>();
	}

	public Set<Filme> getFilmes() {
		return filmes;
	}

	public Set<IndicacaoFilmeCatalogo> getIndicacoesNovosFilmesUsuario() {
		return indicacoesNovosFilmesUsuario;
	}

	public void addFilmeCatalogo(Filme filme) {
		filmes.add(filme);
	}

	public void removeFilmeCatalogo(Filme filme) {
		filmes.remove(filme);
	}

	// Retorna uma lista com apenas o nome dos filmes do catálogo da DevInFlix
	public List<String> listarNomeFilmesCatologo() {
		List<String> listaFilmesCatalogo = new ArrayList<>();
		for (Filme filme : this.filmes) {
			listaFilmesCatalogo.add(filme.getNome());
		}
		return listaFilmesCatalogo;
	}

}
