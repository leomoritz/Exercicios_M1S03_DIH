package main;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import exceptions.ContaNaoEncontradaException;
import exceptions.UsuarioNaoEncontradoException;
import filmes.CatalogoFilmes;
import telas.TelaAbertura;
import plataforma.Plataforma;
import telas.TelaCadastroConta;
import telas.TelaLogin;
import telas.TelaUsuario;
import usuarios.Conta;
import usuarios.Usuario;
import usuarios.enderecos.Endereco;
import util.UtilConversorData;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Plataforma devInFlix = new Plataforma(new CatalogoFilmes());
    private static final TelaAbertura telaAbertura = new TelaAbertura();
    private static final TelaCadastroConta cadastroConta = new TelaCadastroConta();

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        telaAbertura.apresentaTelaAbertura();
        int opcao = sc.nextInt();

        while(opcao != 0){

            if(opcao == 1){
                cadastroConta.formularioCadastroConta(devInFlix);
            }

            if(opcao == 2){

                Optional<Conta> conta = TelaLogin.apresentaTelaLogin(devInFlix);


            }

        }





    }





    private static void formularioTelaUsuario(Conta conta){

        TelaUsuario.apresentaTelaUsuario(conta);
        TelaUsuario.apresentaMenuTelaUsuario();
        int opcao = sc.nextInt();

        while(opcao != 0){

            if(opcao == 1){
                formularioCadastroPerfilUsuario(conta);
            }

            if(opcao == 2){
                TelaUsuario.retornaUsuariosDaConta(conta);
                System.out.print("Informe o nome do usuário que deseja remover de sua conta: ");
                String nomeUsuario = sc.nextLine();
                try {
                    devInFlix.removerUsuarioConta(conta, nomeUsuario);
                } catch (UsuarioNaoEncontradoException e) {
                    e.printStackTrace();
                }
            }

            if(opcao == 3){


            }

            if(opcao == 4){

            }

            if(opcao == 5){

            }

        }

    }

    private static void formularioCadastroPerfilUsuario(Conta conta) {

        System.out.println("Nome Completo: ");
        String nome = sc.nextLine();

        System.out.println("Data Nascimento: ");
        LocalDate dataNascimento = UtilConversorData.converteStringParaData(sc.nextLine());

        System.out.println("Rua: ");
        String rua = sc.nextLine();

        System.out.println("Número: ");
        String numero = sc.nextLine();

        System.out.println("Complemento: ");
        String complemento = sc.nextLine();

        System.out.println("CEP: ");
        String cep = sc.nextLine();

        System.out.println("Cidade: ");
        String cidade = sc.nextLine();

        System.out.println("UF: ");
        String uf = sc.nextLine();

        Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, uf);
        Usuario usuario = new Usuario(nome, endereco, dataNascimento);

        try {
            devInFlix.cadastrarUsuarioConta(conta, usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
