package exceptions;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("Usu�rio informado n�o foi encontrado na plataforma DevInFlix!");
	}
	
	

}
