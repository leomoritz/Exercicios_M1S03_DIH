package telas;

import java.util.Locale;

import usuarios.Conta;
import usuarios.Usuario;

public class TelaUsuario {

    public static void apresentaTelaUsuario(Conta conta){
        System.out.println("################################");
        System.out.println("*********** BEM VINDO " + conta.getEmail().toUpperCase() + " **********");
        System.out.println("################################");
    }

    public static void apresentaMenuTelaUsuario() {

        System.out.println("1 - Cadastrar Novo Perfil" + "\n" + "2 - Excluir Perfil" + "\n" + "3 - Filmes" + "\n" + "4 - Séries" + "\n" + "5 - Informações da Conta" + "\n" + "0 - Logout" + "\n");

        System.out.print("Digite a opção acima desejada -> ");

    }

    public static void retornaUsuariosDaConta(Conta conta) {

        System.out.println("Usuários da Conta: ");
        for (Usuario u : conta.getPerfisDoUsuario()) {
            System.out.println(u.getNome());
        }

        System.out.println("\n");

    }



}
