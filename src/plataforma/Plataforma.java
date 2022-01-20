package plataforma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import enums.GeneroFilme;
import exceptions.AssinaturaPlanoNaoEncontradaException;
import exceptions.FilmeNaoEncontradoException;
import exceptions.UsuarioInadimplenteException;
import exceptions.UsuarioNaoEncontradoException;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import interfaces.GeneroMaisAssistido;
import interfaces.ServicoPagamento;
import servicos.ServicoPagamentoBasico;
import usuarios.Usuario;
import usuarios.UsuarioAssinaturaPlano;

public class Plataforma implements GeneroMaisAssistido {

	private static final String nomePlataforma = "DevInFlix";
	private CatalogoFilmes catalogo;
	private List<Usuario> usuarios = new ArrayList<>();
	private Set<Usuario> usuariosSet = new TreeSet<>();

	private static final ServicoPagamento servicoPagamento = new ServicoPagamentoBasico();
	private Set<String> indicacoesNovosFilmes = new TreeSet<>();
	private Set<Filme> filmesCurtidos = new TreeSet<>();
	private Set<GeneroAssistido> generosAssistidosPlataforma = new TreeSet<>();
	private GeneroAssistido generoMaisAssistidoPlataforma;

	// Construtor
	public Plataforma(CatalogoFilmes catalogo) {
		this.catalogo = catalogo;
	}

	// Getters & Setters

	public CatalogoFilmes getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoFilmes catalogo) {
		this.catalogo = catalogo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void cadastrarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		assinarPlano(usuario, usuario.getPlano()); // Assina o plano ao cadastrar o usu�rio caso tenha
	}

	private int buscaIndexUsuario(Usuario usuario) {
		return this.getUsuarios().indexOf(usuario);
	}

	private Optional<Usuario> buscaUsuario(Usuario usuario) {
		Iterator i = usuariosSet.stream().iterator();

		while (i.hasNext()) {
			if (usuario == i.next()) {
				return Optional.of(usuario);
			}
		}

		return Optional.empty();
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

	private GeneroAssistido getGeneroMaisAssistidoPlataforma() {
		return generoMaisAssistidoPlataforma;
	}

	private void setGeneroMaisAssistidoPlataforma(GeneroAssistido generoMaisAssistidoPlataforma) {
		this.generoMaisAssistidoPlataforma = generoMaisAssistidoPlataforma;
	}

	public Set<String> getIndicacoesNovosFilmes() {
		return indicacoesNovosFilmes;
	}

	private Optional<Exception> validaPermissoesUsuarioPlataforma(Usuario usuario) {

		if (buscaUsuario(usuario).isEmpty()) {
			return Optional.of(new UsuarioNaoEncontradoException());
		}

		if (buscaUsuario(usuario).get().getPlano().isEmpty()) {
			return Optional.of(new AssinaturaPlanoNaoEncontradaException());
		}

		if (buscaUsuario(usuario).get().getPlano().get().getIsInadimplente()) {
			return Optional.of(new UsuarioInadimplenteException());
		}

		return Optional.empty();
	}

	private Optional<Exception> verificaExistenciaFilmeCatalogo(Filme filme) {
		if (!getCatalogo().getFilmes().contains(filme)) {
			return Optional.of(new FilmeNaoEncontradoException());
		}

		return Optional.empty();
	}

	// M�todos da plataforma

	/**
	 * Implementa��o do exerc�cio 8 e 9 Permite o usu�rio assitir o filme caso
	 * possua um plano e esteja adimplente.
	 * 
	 * @param catalogo para verificar se o filme existe no cat�logo da plataforma.
	 * @param filme    para consultar no cat�logo e redirecionar o usu�rio para o
	 *                 link do player.
	 * @return textos com informa��es a respeito do plano, da inadimpl�ncia ou do
	 *         acesso ao filme.
	 * @throws Exception
	 */
	public String assistirFilme(Usuario usuario, Filme filme) throws Exception {

		if (validaPermissoesUsuarioPlataforma(usuario).isPresent()) {
			throw validaPermissoesUsuarioPlataforma(usuario).get();
		}
		
		if(verificaExistenciaFilmeCatalogo(filme).isPresent()) {
			throw verificaExistenciaFilmeCatalogo(filme).get();
		}

		return filme.getLinkFilme(); //Retorna link do filme caso tudo esteja OK

	}

	/**
	 * Implementa��o extra do exerc�cio 9. M�todo para permitir o usu�tio a assinar
	 * um plano na cria��o do usu�rio ou depois.
	 * 
	 * @param plano que � utilizado para atribuir a assinatura ao usu�rio
	 * @Return false caso usu�rio j� tenha um plano ou se houve problemas com o
	 *         pagamento.
	 * @return true caso a assinatura tenha sido realizada com sucesso
	 */

	public Boolean assinarPlano(Usuario usuario, UsuarioAssinaturaPlano plano) {

		int index = buscaIndexUsuario(usuario);

		// Se n�o tiver assinatura informada, n�o prossegue com a assinatura
		if (plano == null) {
			return false;
		}

		// Se n�o tiver assinatura, ent�o adiciona
		if (getUsuarios().get(index).getPlano() == null) {
			getUsuarios().get(index).setPlano(plano);
		}

		// Se tiver assinatura, ent�o gera a 1� mensalidade
		if (getUsuarios().get(index).getPlano() != null) {
			getServicopagamento().gerarParcelaPlanoContrato(getUsuarios().get(index).getPlano());
		}

		return true;

	}

	/**
	 * M�todo que permite pagar parcela do plano (mensal/anual)
	 * 
	 * @return true caso o pagamento tenha sido realizado com sucesso.
	 * @return false caso tenha ocorrido problemas com o pagamento.
	 */

	public Boolean pagarParcelaPlano(Usuario usuario) {

		int index = buscaIndexUsuario(usuario);

		if (getServicopagamento().processaPagamentoPlanoContrato(getUsuarios().get(index).getPlano())) {
			return true;
		}

		return false;
	}

	/**
	 * Implementa��o Exerc�cio 4 Permite recomendar um filme para outro objeto de
	 * usu�rio.
	 * 
	 * @param filme             que ser� recomendado pelo usu�rio.
	 * @param textoRecomendacao que cont�m a recomenda��o do usu�rio.
	 * @param usuarioDestino    que receber� a recomenda��o do usu�rio.
	 */

	public void recomendarFilme(Filme filme, String textoRecomendacao, Usuario origem, Usuario destino) {

		int indexUsuarioOrigem = buscaIndexUsuario(origem);
		int indexUsuarioDestino = buscaIndexUsuario(destino);

		getUsuarios().get(indexUsuarioDestino).getRecomendacoesRecebidas()
				.add("Filme Recomendado: " + filme.getNome().toUpperCase() + " - Texto Recomenda��o: "
						+ textoRecomendacao + " - Usu�rio que recomendou: "
						+ getUsuarios().get(indexUsuarioOrigem).getNome().toUpperCase());
	}

	/**
	 * Implementa��o Exerc�cio 3 Adiciona a curtida do usu�rio no filme caso ainda
	 * n�o tenha curtido.
	 * 
	 * @param filme   que ser� verificado a curtida do usu�rio.
	 * @param usuario que ser� validado para adicionar a curtida.
	 * @return false caso j� tenha curtido o filme
	 * @return true se ainda n�o curtiu
	 */
	public boolean curtirFilme(Usuario usuario, Filme filme) {

		int index = buscaIndexUsuario(usuario);

		Set<Usuario> lista = filme.listaUsuarioCurtiu();

		if (lista.contains(getUsuarios().get(index))) {
			return false;
		}

		filme.setQtdCurtidas(filme.getQtdCurtidas() + 1);
		filme.addUsuarioCurtiu(getUsuarios().get(index));
		usuario.addFilmeCurtido(filme);
		getFilmesCurtidos().add(filme);
		return true;
	}

	/**
	 * Implementa��o Exerc�cio 3 Permite descurtir o filme caso o usu�rio j� tenha
	 * curtido.
	 * 
	 * @param filme   que ser� removido a curtida.
	 * @param usuario que ser� validado para remover a curtida.
	 * @return true caso tenha sido removida a curtida.
	 * @return false caso usu�rio ainda n�o tiver curtido o filme.
	 */
	public boolean descurtirFilme(Usuario usuario, Filme filme) {

		int index = buscaIndexUsuario(usuario);

		Set<Usuario> lista = filme.listaUsuarioCurtiu();

		if (lista.contains(getUsuarios().get(index))) {
			filme.setQtdCurtidas(filme.getQtdCurtidas() - 1);
			filme.removeUsuarioCurtiu(getUsuarios().get(index));
			usuario.addFilmeDescurtido(filme);
			getFilmesCurtidos().remove(filme);
			return true;
		}

		return false;
	}

	/**
	 * Implementa��o exerc�cio 5 e 7 Permite indicar filmes para o c�talogo de
	 * filmes da plataforma
	 * 
	 * @param indicacaoCatalogo interface com inje��o de depend�ncia devido as
	 *                          mudan�as na regra de indica��o
	 * @param nomeNovoFilme     utilizado para gravar na lista o nome do novo filme
	 *                          sugerido
	 * @param catalogo          para que seja poss�vel gravar o nome do novo filme
	 *                          no objeto do cat�logo
	 * @return
	 */
	public String indicarFilmeCatalogo(String nomeNovoFilme, Usuario usuario) {

		int index = buscaIndexUsuario(usuario);

		return getUsuarios().get(index).getIndicacoesCatalogoUsuario().addIndicacoesNovosFilme(nomeNovoFilme,
				getUsuarios().get(index).getNome(), this);
	}

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {
		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

		if (getGenerosAssistidosPlataforma().isEmpty()
				|| !getGenerosAssistidosPlataforma().contains(novoGeneroAssistido)) {
			getGenerosAssistidosPlataforma().add(novoGeneroAssistido);
		} else {
			for (GeneroAssistido generoAssistido : getGenerosAssistidosPlataforma()) {
				if (generoAssistido.equals(novoGeneroAssistido)) {
					generoAssistido.setQtdAssistido(generoAssistido.getQtdAssistido() + 1);
				}
			}
		}

	}

	@Override
	public String getGeneroMaisAssistido() {
		for (GeneroAssistido generoMaisAssistido : getGenerosAssistidosPlataforma()) {

			if (getGeneroMaisAssistidoPlataforma() == null
					|| generoMaisAssistido.getQtdAssistido() > getGeneroMaisAssistidoPlataforma().getQtdAssistido()) {
				setGeneroMaisAssistidoPlataforma(generoMaisAssistido);
			}
		}

		if (getGeneroMaisAssistidoPlataforma() == null) {
			return "Voc� ainda n�o assistiu nenhum filme na plataforma!";
		}

		return getGeneroMaisAssistidoPlataforma().getGeneroAssistido().name();

	}

}
