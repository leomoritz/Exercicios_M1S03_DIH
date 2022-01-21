package exceptions;

public class AssinaturaPlanoJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssinaturaPlanoJaExisteException() {
		super("Usuário informado já possui um plano assinado!");
	}

}
