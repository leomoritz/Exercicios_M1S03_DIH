package exceptions;

public class ContaNaoEncontradaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaNaoEncontradaException() {
		super("A conta informada n�o foi encontrada ou n�o existe na plataforma");
	}

}
