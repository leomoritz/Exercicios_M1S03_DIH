package enums;

public enum ClassificacaoEtaria {

    LIVRE(0),
    DEZ_ANOS(10),
    DOZE_ANOS(12),
    QUATORZE_ANOS(14),
    DEZESSEIS_ANOS(16),
    DEZOITO_ANOS(18);

    private int faixaEtaria;

    ClassificacaoEtaria(final int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public int getFaixaEtaria(){
        return this.faixaEtaria;
    }
}
