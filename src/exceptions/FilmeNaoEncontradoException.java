package exceptions;

public class FilmeNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
		super("Filme n�o foi encontrado no cat�logo de filmes!");
	}
	
	
}
