package exceptions;

public class ContaInadimplenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaInadimplenteException() {
		super("O servi�o de pagamentos identificou uma pend�ncia em sua conta. "
				+ "Favor entrar em contato com DevInFlix para normalizar o seu acesso e voltar a assistis os melhores "
				+ "filmes e s�ries na melhor plataforma que existe! Estamos te aguardando");
	}

}
