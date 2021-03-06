package filmes;

import java.util.ArrayList;
import java.util.List;

import enums.GeneroFilme;
import usuarios.Usuario;

public class Filme {

	private String nome;
	private String sinopse;
	private GeneroFilme genero;
	private String linkFilme;
	private int qtdCurtidas;
	private List<Usuario> usuariosCurtidas = new ArrayList<>();
	private static final List<GeneroFilme> generosFilmes = new ArrayList<>();

	// Inicializdor est?tico da lista generosFilmes que servir? para pegar o enum pela propriedade id
	static {
		for (GeneroFilme genero : GeneroFilme.values()) {
			generosFilmes.add(genero);
		}
	}

	// Construtores da classe
	public Filme(String nome, String sinopse, GeneroFilme genero, String linkFilme) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		this.linkFilme = linkFilme;
	}
	
	public Filme(String nome, String sinopse, int idGenero, String linkFilme) {
		this.nome = nome;
		this.sinopse = sinopse;
		setGeneroById(idGenero);
		this.linkFilme = linkFilme;
	}

	// Getters & Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public GeneroFilme getGenero() {
		return genero;
	}

	public void setGenero(GeneroFilme genero) {
		this.genero = genero;
	}

	// M?todo para pegar o enum pelo ID
	public void setGeneroById(int idGenero) {
		for (GeneroFilme genero : generosFilmes) {
			if (genero.getId() == idGenero) {
				this.setGenero(genero);
			}
		}
	}

	public String getLinkFilme() {
		return linkFilme;
	}

	public void setLinkFilme(String linkFilme) {
		this.linkFilme = linkFilme;
	}

	public int getQtdCurtidas() {
		return qtdCurtidas;
	}

	public void setQtdCurtidas(int qtdCurtidas) {
		this.qtdCurtidas = qtdCurtidas;
	}

	// M?todos criados para saber quais foram os usu?rios que curtiram este filme

	public void addUsuarioCurtiu(Usuario usuario) {
		this.usuariosCurtidas.add(usuario);
	}

	public void removeUsuarioCurtiu(Usuario usuario) {
		this.usuariosCurtidas.remove(usuario);
	}

	public List<Usuario> listaUsuarioCurtiu() {
		return usuariosCurtidas;
	}

}
