package telas;

import java.util.Scanner;

import plataforma.Plataforma;
import usuarios.Conta;

public class TelaCadastroConta extends Tela {

    @Override
    public void apresentaTelaAbertura() {

        System.out.println("################################");
        System.out.println("******** CADASTRO CONTA ********");
        System.out.println("################################");

    }

    public void formularioCadastroConta(Plataforma plataforma) {

        System.out.println("Email: ");
        String emailConta = getSc().nextLine();

        System.out.println("Senha: ");
        String senha = getSc().nextLine();

        Conta conta = new Conta(emailConta, senha);

        try {
            plataforma.cadastrarConta(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
