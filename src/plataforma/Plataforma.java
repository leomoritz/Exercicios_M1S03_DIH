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
		assinarPlano(usuario, usuario.getPlano()); // Assina o plano ao cadastrar o usuário caso tenha
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

	// Métodos da plataforma

	/**
	 * Implementação do exercício 8 e 9 Permite o usuário assitir o filme caso
	 * possua um plano e esteja adimplente.
	 * 
	 * @param catalogo para verificar se o filme existe no catálogo da plataforma.
	 * @param filme    para consultar no catálogo e redirecionar o usuário para o
	 *                 link do player.
	 * @return textos com informações a respeito do plano, da inadimplência ou do
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
	 * Implementação extra do exercício 9. Método para permitir o usuátio a assinar
	 * um plano na criação do usuário ou depois.
	 * 
	 * @param plano que é utilizado para atribuir a assinatura ao usuário
	 * @Return false caso usuário já tenha um plano ou se houve problemas com o
	 *         pagamento.
	 * @return true caso a assinatura tenha sido realizada com sucesso
	 */

	public Boolean assinarPlano(Usuario usuario, UsuarioAssinaturaPlano plano) {

		int index = buscaIndexUsuario(usuario);

		// Se não tiver assinatura informada, não prossegue com a assinatura
		if (plano == null) {
			return false;
		}

		// Se não tiver assinatura, então adiciona
		if (getUsuarios().get(index).getPlano() == null) {
			getUsuarios().get(index).setPlano(plano);
		}

		// Se tiver assinatura, então gera a 1ª mensalidade
		if (getUsuarios().get(index).getPlano() != null) {
			getServicopagamento().gerarParcelaPlanoContrato(getUsuarios().get(index).getPlano());
		}

		return true;

	}

	/**
	 * Método que permite pagar parcela do plano (mensal/anual)
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
	 * Implementação Exercício 4 Permite recomendar um filme para outro objeto de
	 * usuário.
	 * 
	 * @param filme             que será recomendado pelo usuário.
	 * @param textoRecomendacao que contém a recomendação do usuário.
	 * @param usuarioDestino    que receberá a recomendação do usuário.
	 */

	public void recomendarFilme(Filme filme, String textoRecomendacao, Usuario origem, Usuario destino) {

		int indexUsuarioOrigem = buscaIndexUsuario(origem);
		int indexUsuarioDestino = buscaIndexUsuario(destino);

		getUsuarios().get(indexUsuarioDestino).getRecomendacoesRecebidas()
				.add("Filme Recomendado: " + filme.getNome().toUpperCase() + " - Texto Recomendação: "
						+ textoRecomendacao + " - Usuário que recomendou: "
						+ getUsuarios().get(indexUsuarioOrigem).getNome().toUpperCase());
	}

	/**
	 * Implementação Exercício 3 Adiciona a curtida do usuário no filme caso ainda
	 * não tenha curtido.
	 * 
	 * @param filme   que será verificado a curtida do usuário.
	 * @param usuario que será validado para adicionar a curtida.
	 * @return false caso já tenha curtido o filme
	 * @return true se ainda não curtiu
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
	 * Implementação Exercício 3 Permite descurtir o filme caso o usuário já tenha
	 * curtido.
	 * 
	 * @param filme   que será removido a curtida.
	 * @param usuario que será validado para remover a curtida.
	 * @return true caso tenha sido removida a curtida.
	 * @return false caso usuário ainda não tiver curtido o filme.
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
	 * Implementação exercício 5 e 7 Permite indicar filmes para o cátalogo de
	 * filmes da plataforma
	 * 
	 * @param indicacaoCatalogo interface com injeção de dependência devido as
	 *                          mudanças na regra de indicação
	 * @param nomeNovoFilme     utilizado para gravar na lista o nome do novo filme
	 *                          sugerido
	 * @param catalogo          para que seja possível gravar o nome do novo filme
	 *                          no objeto do catálogo
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
			return "Você ainda não assistiu nenhum filme na plataforma!";
		}

		return getGeneroMaisAssistidoPlataforma().getGeneroAssistido().name();

	}

}
