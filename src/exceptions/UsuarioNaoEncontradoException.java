package exceptions;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("Usuário informado não foi encontrado na plataforma DevInFlix!");
	}
	
	

}
