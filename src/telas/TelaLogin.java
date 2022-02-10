package telas;

import java.util.Optional;
import java.util.Scanner;

import exceptions.ContaNaoEncontradaException;
import plataforma.Plataforma;
import usuarios.Conta;

public class TelaLogin {

    public static Optional<Conta> apresentaTelaLogin(Plataforma plataforma){

        Scanner sc = new Scanner(System.in);

        System.out.println("################################");
        System.out.println(" ************ LOGIN ************");
        System.out.println("################################");

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        sc.close();

        try {
            return Optional.of(plataforma.loginConta(email, senha));
        } catch (ContaNaoEncontradaException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
