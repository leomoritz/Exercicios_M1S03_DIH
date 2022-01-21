package exceptions;

public class UsuarioJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaExisteException() {
		super("Usuário com este e-mail já existe na plataforma!");
	}

}
