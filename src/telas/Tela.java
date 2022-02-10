package telas;

import java.util.Locale;
import java.util.Scanner;

public abstract class Tela {

    private final Scanner sc = new Scanner(System.in);

    public abstract void apresentaTelaAbertura();

    public Scanner getSc() {
        return sc;
    }
}
