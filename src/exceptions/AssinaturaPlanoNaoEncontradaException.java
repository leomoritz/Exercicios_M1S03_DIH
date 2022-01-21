package exceptions;

public class AssinaturaPlanoNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AssinaturaPlanoNaoEncontradaException() {
        super("Assinatura de plano n�o foi informada ou n�o existe!");
    }

}
