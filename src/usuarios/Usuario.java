package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Servicos.ServicoPagamentoBasico;
import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import interfaces.GeneroMaisAssistido;
import interfaces.IndicacoesCatalogo;
import interfaces.ServicoPagamento;

public class Usuario implements GeneroMaisAssistido {

	private String nome;
	private String endereco;
	private String dataNascimento;
	private ContratoCliente contrato;
	private static final ServicoPagamento servicoPagamento = new ServicoPagamentoBasico();

	private List<String> indicacoesFilmesUsuario = new ArrayList<>();
	private List<String> recomendacoesRecebidas = new ArrayList<>();
	private List<Filme> filmesCurtidos = new ArrayList<>();
	private Set<GeneroAssistido> generosAssistidosUsuario = new TreeSet<>();
	private GeneroAssistido generoMaisAssistidoUsuario;

	// Construtores da classe
	public Usuario(String nome, String endereco, String dataNascimento, ContratoCliente contrato) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.contrato = contrato;
	}

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

	public GeneroAssistido getGeneroMaisAssistidoUsuario() {
		return generoMaisAssistidoUsuario;
	}

	public void setGeneroMaisAssistidoUsuario(GeneroAssistido generoMaisAssistidoUsuario) {
		this.generoMaisAssistidoUsuario = generoMaisAssistidoUsuario;
	}

	public ContratoCliente getContrato() {
		return contrato;
	}

	public void setContrato(ContratoCliente contrato) {
		this.contrato = contrato;
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

	// Método para assistir um filme
	public String assistirFilme(CatalogoFilmes catalogo, Filme filme) {

		if (getContrato() == null) {
			return "Olá " + this.nome + "! "
					+ "Parece que você ainda não possui um plano assinado na plataforma para assistir filmes. "
					+ "Assine um de nossos planos e venha fazer parte da melhor plataforma de filmes que existe :)";
		}

		if (!servicoPagamento.validaPagamentoPlanoContrato(contrato)) {
			return  "Olá " + this.nome + "! "
					+ "O serviço de pagamentos identificou uma pendência de pagamento. "
					+ "Favor entrar em contato com DevInFlix para normalizar o seu acesso e voltar"
					+ "a assistis os melhores filmes na melhor plataforma que existe!" + "Estamos te aguardando :)";
		}

		if (catalogo.getFilmes().contains(filme)) {
			this.addGeneroAssistido(filme.getGenero());
			catalogo.addGeneroAssistido(filme.getGenero());
			return "Olá " + this.nome + "! "
					+ "Executando player para reproduzir o filme do link a seguir: " + filme.getLinkFilme();
		}
		return "Filme não encontrado no catálogo";

	}

	/*
	 * Métodos de implementação da interface GeneroMaisAssistido. Tais métodos
	 * possuem o objetivo de adicionar os gêneros assistidos pelo o usuário e
	 * retornar qual o gênero mais assitido
	 */

	@Override
	public void addGeneroAssistido(GeneroFilme genero) {

		GeneroAssistido novoGeneroAssistido = new GeneroAssistido(genero, 1);

		/*
		 * Verifica inicialmente se a lista está vazia ou se o genero ainda não existe.
		 * Se sim, adiciona um elemento. Se não, percorre a lista até encontrar o
		 * gênero, se encontrar, acrescenta a quantidade assistida
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
	public String getGeneroMaisAssistido() {

		/*
		 * Percorre a lista para validar qual é o genero mais assitido pelo usuário
		 */
		for (GeneroAssistido generoMaisAssistido : this.generosAssistidosUsuario) {

			/*
			 * Valida se o gênero mais assistido for vazio ou se a quantidade assistida do
			 * gênero da lista for maior que o genero mais assistido
			 */
			if (getGeneroMaisAssistidoUsuario() == null
					|| generoMaisAssistido.getQtdAssistido() > getGeneroMaisAssistidoUsuario().getQtdAssistido()) {
				setGeneroMaisAssistidoUsuario(generoMaisAssistido);
			}
		}

		/*
		 * Se houverem elementos com a mesma quantidade assistida por padrão o genêro
		 * mais assistido será considerado conforme ordem alfabética
		 */
		if (getGeneroMaisAssistidoUsuario() == null) {
			return "Você ainda não assistiu nenhum filme na plataforma!";
		}

		return getGeneroMaisAssistidoUsuario().getGeneroAssistido().name();

	}

	// Retorna lista dos gêneros assistidos do cátalogo
	public Set<GeneroAssistido> listaGenerosAssistidosUsuario() {
		return this.generosAssistidosUsuario;
	}

	// Método que permite pagar parcela do plano (mensal/anual)
	public void pagarParcelaPlano() {
		servicoPagamento.processaPagamentoPlanoContrato(contrato, contrato.getPlanoContratado().getPreco());
	}

}
