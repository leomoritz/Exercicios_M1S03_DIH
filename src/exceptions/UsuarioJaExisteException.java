package exceptions;

public class UsuarioJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaExisteException() {
		super("Desculpe, mas j� existe uma conta com este e-mail cadastrado na plataforma!");
	}

}
