package exceptions;

public class UsuarioJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaExisteException() {
		super("Usu�rio com este e-mail j� existe na plataforma!");
	}

}
