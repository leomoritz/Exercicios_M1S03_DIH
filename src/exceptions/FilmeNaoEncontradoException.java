package exceptions;

public class FilmeNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
		super("Filme informado não foi encontrado ou não existe no catálogo de filmes!");
	}

}
