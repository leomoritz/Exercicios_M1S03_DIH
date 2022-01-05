package filmes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import interfaces.GeneroMaisAssistido;

public class CatalogoFilmes implements GeneroMaisAssistido {

	private List<Filme> filmes = new ArrayList<>();
	private List<String> indicacoesNovosFilmes = new ArrayList<>();

	/*
	 * Utilizado TreeSet para não permitir elementos repetidos em relação aos
	 * gêneros mais assistidos. Implementado equals/hashcode e compareTo na classe
	 * GeneroAssistido
	 */
	private Set<GeneroAssistido> generosAssistidosCatalogo = new TreeSet<>();
	private GeneroAssistido generoMaisAssistidoCatalogo;

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

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {

		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

		/*
		 * Verifica inicialmente se a lista está vazia ou se o genero ainda não existe.
		 * Se sim, adiciona um elemento. Se não, percorre a lista até encontrar o
		 * gênero, se encontrar, acrescenta a quantidade assistida
		 */
		if (generosAssistidosCatalogo.isEmpty() || !generosAssistidosCatalogo.contains(novoGeneroAssistido)) {
			generosAssistidosCatalogo.add(novoGeneroAssistido);
		} else {
			for (GeneroAssistido generoAssistido : generosAssistidosCatalogo) {
				if (generoAssistido.equals(novoGeneroAssistido)) {
					generoAssistido.setQtdAssistido(generoAssistido.getQtdAssistido() + 1);
				}
			}
		}
	}

	@Override
	public String getGeneroMaisAssistido() {

		/*
		 * Percorre a lista para validar qual é o genero mais assitido pelo usuário
		 */
		for (GeneroAssistido generoMaisAssistido : this.generosAssistidosCatalogo) {

			/*
			 * Valida se o gênero mais assistido for vazio ou se a quantidade assistida do
			 * gênero da lista for maior que o genero mais assistido
			 */
			if (this.generoMaisAssistidoCatalogo == null
					|| generoMaisAssistido.getQtdAssistido() > this.generoMaisAssistidoCatalogo.getQtdAssistido()) {
				this.generoMaisAssistidoCatalogo = generoMaisAssistido;
			}
		}

		/*
		 * Se houverem elementos com a mesma quantidade assistida o genêro mais
		 * assistido será retornado conforme ordem alfabética
		 */

		
		if (this.generoMaisAssistidoCatalogo == null) {
			return "Ainda nenhum filme foi assistido na plataforma. É necessário que haja pelo menos"
					+ " um filme assistido!";
		}

		return this.generoMaisAssistidoCatalogo.getGeneroAssistido().name();
	}

	// Retorna lista dos gêneros assistidos do cátalogo
	public Set<GeneroAssistido> listaGenerosAssistidosCatalogo() {
		return this.generosAssistidosCatalogo;
	}

}
