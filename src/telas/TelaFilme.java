package telas;

import filmes.Filme;
import plataforma.Plataforma;

public class TelaFilme {

    public static void apresentaTelaFilmes(){
        System.out.println("################################");
        System.out.println("************ FILMES ************");
        System.out.println("################################");
    }

    public static void apresentaMenuTelaFilmes(){
        System.out.println("1 - Cadastrar Perfis de Usuário" + "\n" + "2 - Excluir Perfil Usuário" + "\n" + "3 - Filmes" + "\n" + "4 - Séries" + "\n" + "5 - Informações da Conta" + "\n" + "0 - Logout" + "\n");

        System.out.print("Digite a opção acima desejada -> ");
    }


    public static void retornaFilmesCatalogo(Plataforma plataforma){

        for (Filme filme : plataforma.getCatalogo().getFilmes()) {
            System.out.println(" * " + filme.getNome());
        }

    }

    public static void retornaDadosDoFilmeSelecionado(Filme filme){

        System.out.println(filme.toString());

    }

}
