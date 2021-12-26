package usuarios;

import java.util.ArrayList;
import java.util.List;

import filmes.CatalogoFilmes;
import filmes.Filme;
import interfaces.IndicacoesCatalogo;

public class Usuario {

	private String nome;
	private String endereco;
	private String dataNascimento;
	private List<String> indicacoesFilmesUsuario = new ArrayList<>();
	private List<String> recomendacoesRecebidas = new ArrayList<>();
	private List<Filme> filmesCurtidos = new ArrayList<>();

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
	 * Verifica se o usuário já curtiu o filme: se sim, então não faz nada! se não,
	 * então incrementa uma curtida no filme e adiciona o usuario na lista de
	 * curtidas do filme e adiciona o filme na lista de curtidas do usuário.
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
	 * Verifica se o usuário já curtiu o filme: se sim, então remove a curtida e
	 * remove da lista de filmes curtidos! se não, então não faz nada!
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

	// Método para retornar uma lista dos filmes curtidos pelo usuário

	public List<Filme> listaFilmesCurtidos() {
		return filmesCurtidos;
	}

	// Método para recomendar filmes da plataforma DevInFlix para outro usuário

	public void recomendarFilme(Filme filme, String textoRecomendacao, Usuario usuarioDestino) {
		usuarioDestino.recomendacoesRecebidas
				.add("Filme Recomendado: " + filme.getNome().toUpperCase() + " - Texto Recomendação: "
						+ textoRecomendacao + " - Usuário que recomendou: " + this.getNome().toUpperCase());
	}

	// Método para listar as recomendações de filmes recebidas pelo usuário

	public List<String> listarRecomendacoes(Usuario usuario) {
		return usuario.recomendacoesRecebidas;
	}

	// Métodos para adicionar e remover indicações de filmes do catálogo de filmes

	public String indicarFilmeCatalogo(IndicacoesCatalogo indicacaoCatalogo, String nomeNovoFilme,
			CatalogoFilmes catalogo) {
		indicacoesFilmesUsuario.add(nomeNovoFilme);
		return indicacaoCatalogo.addIndicacoesNovosFilme(nomeNovoFilme, this.getNome(), catalogo);
	}

	public String removerIndicacaoFilmeCatalogo(IndicacoesCatalogo indicacaoCatalogo, int indexIndicacao,
			CatalogoFilmes catalogo) {
		if (indicacaoCatalogo.removeIndicacoesNovosFilme(indexIndicacao - 1, catalogo)) {
			indicacoesFilmesUsuario.remove(indexIndicacao);
			return "Indicação removida com sucesso!";
		}
		return "Não foi possível remover a indicação informada!";
	}

	// Método para retornar uma lista com as indicações do usuário ao catálogo

	public List<String> listarIndicacoesCatalogo() {
		return indicacoesFilmesUsuario;
	}

}
