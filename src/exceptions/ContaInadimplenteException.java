package exceptions;

public class ContaInadimplenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaInadimplenteException() {
		super("O serviço de pagamentos identificou uma pendência em sua conta. "
				+ "Favor entrar em contato com DevInFlix para normalizar o seu acesso e voltar a assistis os melhores "
				+ "filmes e séries na melhor plataforma que existe! Estamos te aguardando");
	}

}
