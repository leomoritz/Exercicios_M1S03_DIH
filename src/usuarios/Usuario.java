package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import filmes.Filme;
import filmes.GeneroAssistido;
import filmes.IndicacoesMelhorCatalogoPlus;
import interfaces.GeneroMaisAssistido;
import interfaces.IndicacoesCatalogo;

/**
 * Exercício 2 Classe responsável por representar o usuário do sistema
 * 
 * @author Leônidas Moritz Rosa
 *
 */

public class Usuario implements GeneroMaisAssistido, Comparable<Usuario> {

	private String nome;
	private final String email;
	private String endereco;
	private String dataNascimento;
	private UsuarioAssinaturaPlano plano;
	private GeneroAssistido generoMaisAssistidoUsuario;
	private IndicacoesCatalogo indicacoesCatalogoUsuario = new IndicacoesMelhorCatalogoPlus();

	private List<String> recomendacoesRecebidas = new ArrayList<>();
	private Set<GeneroAssistido> generosAssistidosUsuario = new TreeSet<>();
	private Set<Filme> filmesCurtidos = new TreeSet<>();
	private Set<Filme> filmesDescurtidos = new TreeSet<>();

	/**
	 * Construtor que instancia um usuário com plano assinado
	 * 
	 * @param nome
	 * @param endereco
	 * @param dataNascimento
	 * @param plano
	 */

	public Usuario(String nome, String email, String endereco, String dataNascimento, UsuarioAssinaturaPlano plano) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.plano = plano;
	}

	/**
	 * Construtor que instancia um usuário sem um plano assinado (não pode ver
	 * filmes)
	 * 
	 * @param nome
	 * @param endereco
	 * @param dataNascimento
	 */

	public Usuario(String nome, String email, String endereco, String dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	/*
	 * Getters & Setters
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
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

	public Optional<UsuarioAssinaturaPlano> getPlano() {
		return Optional.of(plano);
	}

	public void setPlano(UsuarioAssinaturaPlano plano) {
		this.plano = plano;
	}

	public List<String> getRecomendacoesRecebidas() {
		return this.recomendacoesRecebidas;
	}

	public IndicacoesCatalogo getIndicacoesCatalogoUsuario() {
		return indicacoesCatalogoUsuario;
	}

	public Set<GeneroAssistido> getGenerosAssistidosUsuario() {
		return generosAssistidosUsuario;
	}

	private GeneroAssistido getGeneroMaisAssistidoUsuario() {
		return generoMaisAssistidoUsuario;
	}

	private void setGeneroMaisAssistidoUsuario(GeneroAssistido generoMaisAssistidoUsuario) {
		this.generoMaisAssistidoUsuario = generoMaisAssistidoUsuario;
	}

	public Set<Filme> getFilmesCurtidos() {
		return filmesCurtidos;
	}

	public void addFilmeCurtido(Filme filme) {
		this.getFilmesCurtidos().add(filme);
	}
	
	public Set<Filme> getFilmesDescurtidos() {
		return filmesDescurtidos;
	}

	public void addFilmeDescurtido(Filme filme) {
		this.getFilmesDescurtidos().add(filme);
	}

	/**
	 * Implementação do exercício 8.
	 * 
	 * Adiciona generos assistidos pelo usuário em uma lista sem aceitar valores
	 * repetidos.
	 * 
	 * @param genero serve para verificar se o genero já existe ou não na lista
	 */

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {

		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

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

	/**
	 * Implementação do exercício 8. Percorre a lista até encontrar o gênero mais
	 * assitido pelo usuário.
	 * 
	 * @return o nome do gênero mais assitido caso o usuário já tenha visto filmes
	 *         na plataforma.
	 */

	@Override
	public String getGeneroMaisAssistido() {
		for (GeneroAssistido generoMaisAssistido : this.generosAssistidosUsuario) {

			if (getGeneroMaisAssistidoUsuario() == null
					|| generoMaisAssistido.getQtdAssistido() > getGeneroMaisAssistidoUsuario().getQtdAssistido()) {
				setGeneroMaisAssistidoUsuario(generoMaisAssistido);
			}
		}

		if (getGeneroMaisAssistidoUsuario() == null) {
			return "Você ainda não assistiu nenhum filme na plataforma!";
		}

		return getGeneroMaisAssistidoUsuario().getGeneroAssistido().name();

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Usuario o) {
		return nome.compareTo(o.getNome()) + email.compareTo(o.getEmail());
	}

}
