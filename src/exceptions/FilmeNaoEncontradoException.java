package exceptions;

public class FilmeNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
		super("Filme informado n�o foi encontrado ou n�o existe no cat�logo de filmes!");
	}

}
