package plataforma;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import exceptions.AssinaturaPlanoJaExisteException;
import exceptions.AssinaturaPlanoNaoEncontradaException;
import exceptions.ContaInadimplenteException;
import exceptions.ContaNaoEncontradaException;
import exceptions.FilmeNaoEncontradoException;
import exceptions.UsuarioNaoEncontradoException;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import filmes.IndicacoesMelhorCatalogoPlus;
import interfaces.GeneroMaisAssistido;
import interfaces.IndicacoesCatalogo;
import interfaces.ServicoPagamento;
import repositorios.ContaUsuarioRepository;
import repositorios.CatalogoFilmeRepository;
import servicos.ServicoPagamentoBasico;
import usuarios.Conta;
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

	public Plataforma(CatalogoFilmes catalogo) throws Exception {
		this.catalogo = catalogo;
		this.usuarios = new TreeSet<>();
		this.filmesCurtidos = new TreeSet<>();
		this.generosAssistidosPlataforma = new TreeSet<>();
		this.iniciaRepositórios();
	}

	private void iniciaRepositórios() throws Exception {
		
		new ContaUsuarioRepository();
		new CatalogoFilmeRepository();

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

	/* EXCEÇÕES DA PLATAFORMA */

	private Optional<Exception> getExcecoesPlataforma(Usuario usuario, Filme filme) {

		Conta contaUsuario = ContaUsuarioRepository.getContaPorUsuario(usuario);
		
		if(!ContaUsuarioRepository.getContas().contains(contaUsuario)) {
			return Optional.of(new ContaNaoEncontradaException());
		}

		if (contaUsuario.getPerfisDoUsuario().contains(usuario)) {
			return Optional.of(new UsuarioNaoEncontradoException());
		}

		if (contaUsuario.getPlano() == null) {
			return Optional.of(new AssinaturaPlanoNaoEncontradaException());
		}

		if (contaUsuario.isAdimplente()) {
			return Optional.of(new ContaInadimplenteException());
		}
		
		if (!getCatalogo().getFilmes().contains(filme)) {
			return Optional.of(new FilmeNaoEncontradoException());
		}

		return Optional.empty();
	}

	/* MÉTODOS PARA CADASTRO DA CONTA E PERFIS DE USUARIO */

	public Conta cadastrarConta(String email, String senha) throws Exception {

		boolean validaEmail = ContaUsuarioRepository.getContas().stream().anyMatch(conta -> conta.getEmail().equals(email));

		if (validaEmail) {
			throw new Exception("Desculpe, mas já existe uma conta com este e-mail cadastrado na plataforma!");
		}

		Conta conta = new Conta(email, senha);
		ContaUsuarioRepository.getContas().add(conta);
		return conta;

	}

	public Optional<Conta> loginConta(String email, String senha) {

		boolean validaLogin = ContaUsuarioRepository.getContas().stream()
				.anyMatch(conta -> conta.getEmail().equals(email) && conta.getSenha().equals(senha));

		if (validaLogin) {
			return Optional.of(ContaUsuarioRepository.getContaPorEmail(email));
		}

		return Optional.empty();

	}

	public Boolean cadastrarUsuarioConta(Conta conta, String nome, String endereco, String dataNascimento) throws Exception {
		
		if(conta.addPerfilConta(new Usuario(nome, endereco, dataNascimento))) {
			return true;
		}
		
		throw new IllegalArgumentException();
		
	}
	
	/*MÉTODOS PARA ASSINATURA DE PLANO E PARA PAGAMENTO DA MENSALIDADE*/

	public Boolean assinarPlano(Conta conta, UsuarioAssinaturaPlano plano) throws Exception {

		if (!ContaUsuarioRepository.getContas().contains(conta)) {
			throw new ContaNaoEncontradaException();
		}

		if (conta.getPlano() != null) {
			throw new AssinaturaPlanoJaExisteException();
		}

		conta.setPlano(plano);
		
		getServicopagamento().gerarParcelaPlanoContrato(conta.getPlano());

		return true;

	}

	public Boolean pagarParcelaPlano(Conta conta) {

		if (getServicopagamento().processaPagamentoPlanoContrato(conta.getPlano())) {
			return true;
		}

		return false;
	}
	
	/*MÉTODOS PARA INTERAGIR NA PLATAFORMA*/

	public Boolean assistirFilme(Usuario usuario, Filme filme) throws Exception {

		if (getExcecoesPlataforma(usuario, filme).isPresent()) {
			throw getExcecoesPlataforma(usuario, filme).get();
		}

		addGeneroAssistido(filme.getGenero());
		usuario.addGeneroAssistido(filme.getGenero());

		return true;

	}

	public void indicarFilmeOutroUsuario(Filme filme, String textoRecomendacao, Usuario usuarioOrigem,
			Usuario usuarioDestino) {

		IndicacaoFilmeUsuario recomendacao = new IndicacaoFilmeUsuario(filme, usuarioOrigem, textoRecomendacao);

		usuarioDestino.getIndicacoesRecebidas().add(recomendacao);

	}

	public boolean curtirFilme(Usuario usuario, Filme filme) throws Exception {

		if (getExcecoesPlataforma(usuario, filme).isPresent()) {
			throw getExcecoesPlataforma(usuario, filme).get();
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

		if (getExcecoesPlataforma(usuario, filme).isPresent()) {
			throw getExcecoesPlataforma(usuario, filme).get();
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
