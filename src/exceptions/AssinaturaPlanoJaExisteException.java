package exceptions;

public class AssinaturaPlanoJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssinaturaPlanoJaExisteException() {
		super("Usu�rio informado j� possui um plano assinado!");
	}

}
