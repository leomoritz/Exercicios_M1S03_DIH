package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import interfaces.GeneroMaisAssistido;
import interfaces.IndicacoesCatalogo;

public class Usuario implements GeneroMaisAssistido {

	private String nome;
	private String endereco;
	private String dataNascimento;

	private List<String> indicacoesFilmesUsuario = new ArrayList<>();
	private List<String> recomendacoesRecebidas = new ArrayList<>();
	private List<Filme> filmesCurtidos = new ArrayList<>();

	/*
	 * Utilizado TreeSet para n�o permitir elementos repetidos em rela��o aos
	 * g�neros mais assistidos. Implementado equals/hashcode e compareTo na classe
	 * GeneroAssistido
	 */
	private Set<GeneroAssistido> generosAssistidosUsuario = new TreeSet<>();
	private GeneroAssistido generoMaisAssistidoUsuario;

	// Construtor
	public Usuario(String nome, String endereco, String dataNascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	// Getters & Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/*
	 * Verifica se o usu�rio j� curtiu o filme: se sim, ent�o n�o faz nada! se n�o,
	 * ent�o incrementa uma curtida no filme e adiciona o usuario na lista de
	 * curtidas do filme e adiciona o filme na lista de curtidas do usu�rio.
	 */
	public boolean curtirFilme(Filme filme, Usuario usuario) {
		List<Usuario> lista = filme.listaUsuarioCurtiu();
		if (lista.contains(usuario)) {
			return false;
		}
		filme.setQtdCurtidas(filme.getQtdCurtidas() + 1); // adiciona a curtida
		filme.addUsuarioCurtiu(usuario); // adc no filme o usuario que curtiu
		this.filmesCurtidos.add(filme); // adc no usuario o filme que ele curtiu
		return true;
	}

	/*
	 * Verifica se o usu�rio j� curtiu o filme: se sim, ent�o remove a curtida e
	 * remove da lista de filmes curtidos! se n�o, ent�o n�o faz nada!
	 */
	public boolean descurtirFilme(Filme filme, Usuario usuario) {
		List<Usuario> lista = filme.listaUsuarioCurtiu();
		if (lista.contains(usuario)) {
			filme.setQtdCurtidas(filme.getQtdCurtidas() - 1); // remove a curtida
			filme.removeUsuarioCurtiu(usuario); // remove do filme o usuario que curtiu
			this.filmesCurtidos.remove(filme);
			; // remove do usuario o filme que ele curtiu
		}
		return false;
	}

	// M�todo para retornar uma lista dos filmes curtidos pelo usu�rio

	public List<Filme> listaFilmesCurtidos() {
		return filmesCurtidos;
	}

	// M�todo para recomendar filmes da plataforma DevInFlix para outro usu�rio

	public void recomendarFilme(Filme filme, String textoRecomendacao, Usuario usuarioDestino) {
		usuarioDestino.recomendacoesRecebidas
				.add("Filme Recomendado: " + filme.getNome().toUpperCase() + " - Texto Recomenda��o: "
						+ textoRecomendacao + " - Usu�rio que recomendou: " + this.getNome().toUpperCase());
	}

	// M�todo para listar as recomenda��es de filmes recebidas pelo usu�rio

	public List<String> listarRecomendacoes(Usuario usuario) {
		return usuario.recomendacoesRecebidas;
	}

	// M�todos para adicionar e remover indica��es de filmes do cat�logo de filmes

	public String indicarFilmeCatalogo(IndicacoesCatalogo indicacaoCatalogo, String nomeNovoFilme,
			CatalogoFilmes catalogo) {
		indicacoesFilmesUsuario.add(nomeNovoFilme);
		return indicacaoCatalogo.addIndicacoesNovosFilme(nomeNovoFilme, this.getNome(), catalogo);
	}

	public String removerIndicacaoFilmeCatalogo(IndicacoesCatalogo indicacaoCatalogo, int indexIndicacao,
			CatalogoFilmes catalogo) {
		if (indicacaoCatalogo.removeIndicacoesNovosFilme(indexIndicacao - 1, catalogo)) {
			indicacoesFilmesUsuario.remove(indexIndicacao);
			return "Indica��o removida com sucesso!";
		}
		return "N�o foi poss�vel remover a indica��o informada!";
	}

	// M�todo para retornar uma lista com as indica��es do usu�rio ao cat�logo

	public List<String> listarIndicacoesCatalogo() {
		return indicacoesFilmesUsuario;
	}

	// M�todo para assistir um filme
	public String assistirFilme(CatalogoFilmes catalogo, Filme filme) {
		if (catalogo.getFilmes().contains(filme)) {
			this.addGeneroAssistido(filme.getGenero());
			catalogo.addGeneroAssistido(filme.getGenero());
			return "Executando player para reproduzir o filme do link a seguir: " + filme.getLinkFilme();
		}
		return "Filme n�o encontrado no cat�logo";
	}

	/*
	 * M�todos de implementa��o da interface GeneroMaisAssistido. Tais m�todos
	 * possuem o objetivo de adicionar os g�neros assistidos pelo o usu�rio e
	 * retornar qual o g�nero mais assitido
	 */

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {

		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

		/*
		 * Verifica inicialmente se a lista est� vazia ou se o genero ainda n�o existe.
		 * Se sim, adiciona um elemento. Se n�o, percorre a lista at� encontrar o
		 * g�nero, se encontrar, acrescenta a quantidade assistida
		 */
		if (generosAssistidosUsuario.isEmpty() || !generosAssistidosUsuario.contains(novoGeneroAssistido)) {
			generosAssistidosUsuario.add(novoGeneroAssistido);
		} else {
			for (GeneroAssistido generoAssistido : generosAssistidosUsuario) {
				if (generoAssistido.equals(novoGeneroAssistido)) {
					generoAssistido.setQtdAssistido(generoAssistido.getQtdAssistido() + 1);
				}
			}
		}
	}

	@Override
	public GeneroFilme getGeneroMaisAssistido() {

		/*
		 * Percorre a lista para validar qual � o genero mais assitido pelo usu�rio
		 */
		for (GeneroAssistido generoMaisAssistido : this.generosAssistidosUsuario) {

			/*
			 * Valida se o g�nero mais assistido for vazio ou se a quantidade assistida do
			 * g�nero da lista for maior que o genero mais assistido
			 */
			if (this.generoMaisAssistidoUsuario == null
					|| generoMaisAssistido.getQtdAssistido() > this.generoMaisAssistidoUsuario.getQtdAssistido()) {
				this.generoMaisAssistidoUsuario = generoMaisAssistido;
			}
		}
		
		/*
		 * Se houverem elementos com a mesma quantidade assistida
		 * por padr�o o gen�ro mais assistido ser� considerado conforme ordem alfab�tica
		 */
		
		return this.generoMaisAssistidoUsuario.getGeneroAssistido();
	}

	// Retorna lista dos g�neros assistidos do c�talogo
	public Set<GeneroAssistido> listaGenerosAssistidosUsuario() {
		return this.generosAssistidosUsuario;
	}

}
