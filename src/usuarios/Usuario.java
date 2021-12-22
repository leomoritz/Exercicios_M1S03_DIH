package usuarios;

import java.util.ArrayList;
import java.util.List;

import filmes.Filme;

public class Usuario {

	private String nome;
	private String endereco;
	private String dataNascimento;
	private List<String[]> recomendacoesRecebidas = new ArrayList<String[]>();
	private List<Filme> filmesCurtidos = new ArrayList<>();

	public Usuario(String nome, String endereco, String dataNascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

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

	private void addFilmesCurtidos(Filme filme) {
		filmesCurtidos.add(filme);
	}

	private void removeFilmesCurtidos(Filme filme) {
		filmesCurtidos.remove(filme);
	}

	public List<Filme> listaFilmesCurtidos() {
		return filmesCurtidos;
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
		this.addFilmesCurtidos(filme); // adc no usuario o filme que ele curtiu
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
			this.removeFilmesCurtidos(filme); // remove do usuario o filme que ele curtiu
		}
		return false;
	}

	public void recomendarFilme(Filme filme, String textoRecomendacao, Usuario usuarioOrigem, Usuario usuarioDestino) {
		usuarioDestino.recomendacoesRecebidas
				.add(new String[] { "Filme Recomendado: " + filme.getNome(), "Texto Recomendação: " + textoRecomendacao, "Usuário que recomendou: " + usuarioOrigem.getNome() });
	}
	
	public List<String[]> listarRecomendacoes(Usuario usuario){
		return usuario.recomendacoesRecebidas;
	}
}
