package filmes;

import java.util.ArrayList;
import java.util.List;

import interfaces.IndicacoesCatalogo;

public class CatalogoFilmes {

	private List<Filme> filmes = new ArrayList<>();

	// Construtor
	public CatalogoFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	// Getters
	public List<Filme> getFilmes() {
		return filmes;
	}

	// Métodos para adicionar e remover filmes do catálogo
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
	
	//Retorna uma lista com o nome dos filmes indicados pelos usuários para o catálogo
	public List<String[]> listaIndicacoesNovosFilmes(IndicacoesCatalogo indicacoes){
		return indicacoes.listaIndicacoesNovosFilmes();
	}

}
