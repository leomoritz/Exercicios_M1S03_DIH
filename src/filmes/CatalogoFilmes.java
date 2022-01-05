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
	 * Utilizado TreeSet para n�o permitir elementos repetidos em rela��o aos
	 * g�neros mais assistidos. Implementado equals/hashcode e compareTo na classe
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

	// M�todos para adicionar e remover filmes do cat�logo
	public void addFilmeCatalogo(Filme filme) {
		filmes.add(filme);
	}

	public void removeFilmeCatalogo(Filme filme) {
		filmes.remove(filme);
	}

	// Retorna uma lista com apenas o nome dos filmes do cat�logo da DevInFlix
	public List<String> listarNomeFilmesCatologo() {
		List<String> listaFilmesCatalogo = new ArrayList<>();
		for (Filme filme : this.filmes) {
			listaFilmesCatalogo.add(filme.getNome());
		}
		return listaFilmesCatalogo;
	}

	// Retorna uma lista com o nome dos filmes indicados pelos usu�rios para o
	// cat�logo
	public List<String> listaIndicacoesNovosFilmes() {
		return indicacoesNovosFilmes;
	}

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {

		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

		/*
		 * Verifica inicialmente se a lista est� vazia ou se o genero ainda n�o existe.
		 * Se sim, adiciona um elemento. Se n�o, percorre a lista at� encontrar o
		 * g�nero, se encontrar, acrescenta a quantidade assistida
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
		 * Percorre a lista para validar qual � o genero mais assitido pelo usu�rio
		 */
		for (GeneroAssistido generoMaisAssistido : this.generosAssistidosCatalogo) {

			/*
			 * Valida se o g�nero mais assistido for vazio ou se a quantidade assistida do
			 * g�nero da lista for maior que o genero mais assistido
			 */
			if (this.generoMaisAssistidoCatalogo == null
					|| generoMaisAssistido.getQtdAssistido() > this.generoMaisAssistidoCatalogo.getQtdAssistido()) {
				this.generoMaisAssistidoCatalogo = generoMaisAssistido;
			}
		}

		/*
		 * Se houverem elementos com a mesma quantidade assistida o gen�ro mais
		 * assistido ser� retornado conforme ordem alfab�tica
		 */

		
		if (this.generoMaisAssistidoCatalogo == null) {
			return "Ainda nenhum filme foi assistido na plataforma. � necess�rio que haja pelo menos"
					+ " um filme assistido!";
		}

		return this.generoMaisAssistidoCatalogo.getGeneroAssistido().name();
	}

	// Retorna lista dos g�neros assistidos do c�talogo
	public Set<GeneroAssistido> listaGenerosAssistidosCatalogo() {
		return this.generosAssistidosCatalogo;
	}

}
