package filmes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import comentarios.Comentario;
import enums.GeneroFilme;
import usuarios.Usuario;

public class Filme implements Comparable<Filme> {

	private String nome;
	private String sinopse;
	private GeneroFilme genero;
	private String linkFilme;
	private int qtdCurtidas;
	private Set<Usuario> usuariosCurtiu;
	private final Set<Comentario> comentarios;

	private static final List<GeneroFilme> generosFilmes = new ArrayList<>();
	// Inicializador estático da lista generosFilmes que servirá para pegar o enum
	// pela propriedade id
	static {
		for (GeneroFilme genero : GeneroFilme.values()) {
			generosFilmes.add(genero);
		}
	}

	public Filme(String nome, String sinopse, GeneroFilme genero, String linkFilme) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		this.linkFilme = linkFilme;
		this.usuariosCurtiu = new TreeSet<>();
		this.comentarios = new TreeSet<>();
	}

	public Filme(String nome, String sinopse, int idGenero, String linkFilme) {
		this.nome = nome;
		this.sinopse = sinopse;
		setGeneroById(idGenero);
		this.linkFilme = linkFilme;
		this.usuariosCurtiu = new TreeSet<>();
		this.comentarios = new TreeSet<>();
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

	// Método para pegar o enum pelo ID
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

	public Set<Usuario> getUsuariosCurtiu() {
		return usuariosCurtiu;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void addUsuarioCurtiu(Usuario usuario) {
		getUsuariosCurtiu().add(usuario);
	}

	public void removeUsuarioCurtiu(Usuario usuario) {
		getUsuariosCurtiu().remove(usuario);
	}

	public Set<Usuario> listaUsuarioCurtiu() {
		return getUsuariosCurtiu();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sinopse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sinopse, other.sinopse);
	}

	@Override
	public int compareTo(Filme o) {
		return nome.compareTo(o.getNome()) + sinopse.compareTo(o.getSinopse());
	}

}
