package plataforma;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import exceptions.AssinaturaPlanoJaExisteException;
import exceptions.AssinaturaPlanoNaoEncontradaException;
import exceptions.FilmeNaoEncontradoException;
import exceptions.UsuarioJaExisteException;
import exceptions.UsuarioNaoEncontradoException;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import filmes.IndicacoesMelhorCatalogoPlus;
import interfaces.GeneroMaisAssistido;
import interfaces.IndicacoesCatalogo;
import interfaces.ServicoPagamento;
import servicos.ServicoPagamentoBasico;
import usuarios.IndicacaoFilmeUsuario;
import usuarios.Usuario;
import usuarios.UsuarioAssinaturaPlano;

public class Plataforma implements GeneroMaisAssistido {

	private static final String nomePlataforma = "DevInFlix";
	private static final ServicoPagamento servicoPagamento = new ServicoPagamentoBasico();

	private final CatalogoFilmes catalogo;
	private Set<Usuario> usuarios;
	private final Set<Filme> filmesCurtidos;
	private final Set<GeneroAssistido> generosAssistidosPlataforma;
	private GeneroAssistido generoMaisAssistidoPlataforma;

	public Plataforma(CatalogoFilmes catalogo) {
		this.catalogo = catalogo;
		this.usuarios = new TreeSet<>();
		this.filmesCurtidos = new TreeSet<>();
		this.generosAssistidosPlataforma = new TreeSet<>();
	}

	public CatalogoFilmes getCatalogo() {
		return catalogo;
	}

	public Set<Usuario> getListaUsuarios() {
		return usuarios;
	}

	public Set<Filme> getFilmesCurtidos() {
		return filmesCurtidos;
	}

	public static String getNomeplataforma() {
		return nomePlataforma;
	}

	public static ServicoPagamento getServicopagamento() {
		return servicoPagamento;
	}

	public Set<GeneroAssistido> getGenerosAssistidosPlataforma() {
		return generosAssistidosPlataforma;
	}

	private Optional<GeneroAssistido> getGeneroMaisAssistidoPlataforma() {
		return Optional.ofNullable(generoMaisAssistidoPlataforma);
	}

	private void setGeneroMaisAssistidoPlataforma(GeneroAssistido generoMaisAssistidoPlataforma) {
		this.generoMaisAssistidoPlataforma = generoMaisAssistidoPlataforma;
	}

	private Optional<Usuario> getUsuario(Usuario usuario) {
		Iterator<Usuario> i = usuarios.stream().iterator();

		while (i.hasNext()) {
			if (usuario == i.next()) {
				return Optional.of(usuario);
			}
		}

		return Optional.empty();
	}

	private Optional<Exception> getExcecoesUsuario(Usuario usuario) {

		if (getUsuario(usuario).isEmpty()) {
			return Optional.of(new UsuarioNaoEncontradoException());
		}

		if (getUsuario(usuario).get().getPlano() == null) {
			return Optional.of(new AssinaturaPlanoNaoEncontradaException());
		}

		/*
		 * if (getUsuario(usuario).get().getPlano().getIsInadimplente()) { return
		 * Optional.of(new UsuarioInadimplenteException()); }
		 */

		return Optional.empty();
	}

	private Optional<Exception> getExcecoesFilme(Filme filme) {
		if (!getCatalogo().getFilmes().contains(filme)) {
			return Optional.of(new FilmeNaoEncontradoException());
		}

		return Optional.empty();
	}

	public Boolean cadastrarUsuario(Usuario usuario) throws Exception {

		if (this.usuarios.contains(usuario)) {
			throw new UsuarioJaExisteException();
		}

		this.usuarios.add(usuario);

		return true;
	}

	public Boolean assinarPlano(Usuario usuario, UsuarioAssinaturaPlano plano) throws Exception {

		if (getUsuario(usuario).isEmpty()) {
			throw new UsuarioNaoEncontradoException();
		}

		if (usuario.getPlano() != null) {
			throw new AssinaturaPlanoJaExisteException();
		}

		if (plano == null) {
			throw new AssinaturaPlanoNaoEncontradaException();
		}

		usuario.setPlano(plano);
		getServicopagamento().gerarParcelaPlanoContrato(usuario.getPlano());

		return true;

	}

	public Boolean pagarParcelaPlano(Usuario usuario) {

		if (getServicopagamento().processaPagamentoPlanoContrato(usuario.getPlano())) {
			return true;
		}

		return false;
	}

	public Boolean assistirFilme(Usuario usuario, Filme filme) throws Exception {

		if (getExcecoesUsuario(usuario).isPresent()) {
			throw getExcecoesUsuario(usuario).get();
		}

		if (getExcecoesFilme(filme).isPresent()) {
			throw getExcecoesFilme(filme).get();
		}

		addGeneroAssistido(filme.getGenero());
		usuario.addGeneroAssistido(filme.getGenero());

		return true;

	}

	public void indicarFilmeOutroUsuario(Filme filme, String textoRecomendacao, Usuario usuarioOrigem, Usuario usuarioDestino) {

		IndicacaoFilmeUsuario recomendacao = new IndicacaoFilmeUsuario(filme, usuarioOrigem, textoRecomendacao);

		usuarioDestino.getIndicacoesRecebidas().add(recomendacao);

	}

	public boolean curtirFilme(Usuario usuario, Filme filme) throws Exception {

		if (getExcecoesUsuario(usuario).isPresent()) {
			throw getExcecoesUsuario(usuario).get();
		}

		if (getExcecoesFilme(filme).isPresent()) {
			throw getExcecoesFilme(filme).get();
		}

		if (usuario.getFilmesCurtidos().contains(filme)) {
			return false;
		}

		filme.setQtdCurtidas(filme.getQtdCurtidas() + 1);
		filme.addUsuarioCurtiu(usuario);
		usuario.addFilmeCurtido(filme);
		getFilmesCurtidos().add(filme);
		return true;
	}

	public boolean descurtirFilme(Usuario usuario, Filme filme) throws Exception {

		if (getExcecoesUsuario(usuario).isPresent()) {
			throw getExcecoesUsuario(usuario).get();
		}

		if (getExcecoesFilme(filme).isPresent()) {
			throw getExcecoesFilme(filme).get();
		}

		if (!usuario.getFilmesCurtidos().contains(filme)) {
			return false;
		}

		filme.setQtdCurtidas(filme.getQtdCurtidas() - 1);
		filme.removeUsuarioCurtiu(usuario);
		usuario.addFilmeDescurtido(filme);
		getFilmesCurtidos().remove(filme);
		return true;

	}

	public Boolean indicarFilmeCatalogo(String nomeNovoFilme, Usuario usuario) throws Exception {

		IndicacoesCatalogo novaIndicacao = new IndicacoesMelhorCatalogoPlus();

		if (novaIndicacao.addIndicacoesNovosFilme(nomeNovoFilme, usuario, this)) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean addGeneroAssistido(GeneroFilme genero) {

		if (getGenerosAssistidosPlataforma().add(new GeneroAssistido(genero, 1))) {
			return true;
		}

		for (GeneroAssistido generoAssistido : getGenerosAssistidosPlataforma()) {
			if (generoAssistido.getGeneroAssistido().equals(genero)) {
				generoAssistido.setQtdAssistido(generoAssistido.getQtdAssistido() + 1);
				return true;
			}
		}

		return false;

	}

	@Override
	public GeneroFilme getGeneroMaisAssistido() {

		for (GeneroAssistido generoMaisAssistido : getGenerosAssistidosPlataforma()) {

			if (getGeneroMaisAssistidoPlataforma().isEmpty()) {
				setGeneroMaisAssistidoPlataforma(generoMaisAssistido);
			}

			if (generoMaisAssistido.getQtdAssistido() > getGeneroMaisAssistidoPlataforma().get().getQtdAssistido()) {
				setGeneroMaisAssistidoPlataforma(generoMaisAssistido);
			}
		}

		return getGeneroMaisAssistidoPlataforma().get().getGeneroAssistido();

	}
}
