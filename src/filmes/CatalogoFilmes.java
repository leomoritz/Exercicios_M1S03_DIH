package filmes;

import java.util.ArrayList;
import java.util.List;

import enums.GeneroFilme;

public class CatalogoFilmes {

	private List<Filme> filmes = new ArrayList<>();
	private List<String> indicacoesNovosFilmes = new ArrayList<>();
	private List<GeneroFilme> generosAssistidosCatalogo = new ArrayList<>();
	private GeneroFilme generoMaisAssistidoCatalogo;

	// Construtor
	public CatalogoFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	// Getters
	public List<Filme> getFilmes() {
		return filmes;
	}

	public List<String> getIndicacoesNovosFilmes() {
		return indicacoesNovosFilmes;
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

	// Retorna uma lista com o nome dos filmes indicados pelos usuários para o
	// catálogo
	public List<String> listaIndicacoesNovosFilmes() {
		return indicacoesNovosFilmes;
	}

	// Adiciona Genero Assistido pelo usuário em uma lista
	public void addGeneroAssistido(GeneroFilme genero) {
		this.generosAssistidosCatalogo.add(genero);
		genero.setCountPlus(genero.getCountPlus() + 1); // adiciona a quantidade de vezes que o genero foi assistido
	}

	/*
	 * Método que percorre a lista de generos assistidos e encontra o genero mais
	 * assistido da lista.
	 */
	public String getGeneroMaisAssistidoCatalogo() {
		for (GeneroFilme generoMaisAssistido : this.generosAssistidosCatalogo) {
			if (this.generoMaisAssistidoCatalogo == null
					|| generoMaisAssistido.getCountPlus() > this.generoMaisAssistidoCatalogo.getCountPlus()) {
				this.generoMaisAssistidoCatalogo = generoMaisAssistido;
			}
		}
		return this.generoMaisAssistidoCatalogo.name();
	}

}
