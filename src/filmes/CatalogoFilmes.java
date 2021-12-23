package filmes;

import java.util.ArrayList;
import java.util.List;

public class CatalogoFilmes {
	
	private List<Filme> filmes = new ArrayList<>();
	private List<String> indicacoesNovosFilmes = new ArrayList<>();
	
	//Construtor
	public CatalogoFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	
	//Getters
	public List<Filme> getFilmes() {
		return filmes;
	}

	public List<String> getIndicacoesNovosFilmes() {
		return indicacoesNovosFilmes;
	}
	
	//Métodos para adicionar e remover
	public void addFilmeCatalogo(Filme filme) {
		filmes.add(filme);
	}
	
	public void addIndicacoesNovosFilme(String indicacaoFilme) {
		indicacoesNovosFilmes.add(indicacaoFilme);
	}
	
	public void removeFilmeCatalogo(Filme filme) {
		filmes.remove(filme);
	}
	
	public void removeIndicacoesNovosFilme(String indicacaoFilme) {
		indicacoesNovosFilmes.remove(indicacaoFilme);
	}
	
	//Retorna uma lista com apenas o nome dos filmes do catálogo da DevInFlix
	public List<String> listarNomeFilmesCatologo(){
		List<String> listaFilmesCatalogo = new ArrayList<>();
		for (Filme filme : this.filmes) {
			listaFilmesCatalogo.add(filme.getNome());
		}
		return listaFilmesCatalogo;
	}
}
