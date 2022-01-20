package exceptions;

public class AssinaturaPlanoNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AssinaturaPlanoNaoEncontradaException() {
        super("Desculpe, voc� ainda n�o possui uma assinatura na DevInFlix. Assine um de nossos planos e aproveite!");
    }

}
