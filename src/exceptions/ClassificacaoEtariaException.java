package exceptions;

public class ClassificacaoEtariaException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ClassificacaoEtariaException() {
        super("A classifica��o et�ria deste conte�do impede que voc� consiga acess�-lo.");
    }
}
