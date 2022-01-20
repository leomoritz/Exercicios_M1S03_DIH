package exceptions;

public class FilmeNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
		super("Filme não foi encontrado no catálogo de filmes!");
	}
	
	
}
