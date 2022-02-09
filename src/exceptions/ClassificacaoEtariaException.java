package exceptions;

public class ClassificacaoEtariaException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ClassificacaoEtariaException() {
        super("A classificação etária deste conteúdo impede que você consiga acessá-lo.");
    }
}
