package programa;

import filmes.Filme;
import plataforma.Plataforma;
import repositorios.CatalogoFilmeRepository;
import usuarios.Conta;
import usuarios.Usuario;

public class Main {

    public static void main(String[] args) {

        Plataforma devinflix = null;

        Conta leonidas = null;
        Conta joaoPereira = null;
        Conta andreDix = null;
        Conta joazinhoLegal = null;
        Conta brunoZago = null;

        Usuario userLeonidas = null;
        Usuario userBruna = null;
        Usuario userJoao = null;
        Usuario userHelena = null;
        Usuario userBruno = null;
        Usuario userMaria = null;

        try {
            devinflix = new Plataforma(CatalogoFilmeRepository.getCatalogo());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Filme reiLeao = devinflix.getCatalogo().getFilmes().stream().filter(filme -> filme.getNome().equals("O Rei Leão")).findFirst().get();
        Filme vingadores = devinflix.getCatalogo().getFilmes().stream().filter(filme -> filme.getNome().equals("Vingadores: Ultimato")).findFirst().get();

        try {
            leonidas = devinflix.cadastrarConta("leogui.moritz@gmail.com", "12345678");
            joaoPereira = devinflix.cadastrarConta("joao.pereira@gmail.com", "12345678");
            andreDix = devinflix.cadastrarConta("andre.dix@gmail.com", "12345678");
            joazinhoLegal = devinflix.cadastrarConta("joazinho.legal@gmail.com", "12345678");
            brunoZago = devinflix.cadastrarConta("bruno.zago@gmail.com", "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            userLeonidas = devinflix.cadastrarUsuarioConta(leonidas, "Leônidas", "Rua Frieda Jensen", "17/02/1995");
            userBruna = devinflix.cadastrarUsuarioConta(leonidas, "Bruna", "Rua Frieda Jensen", "01/02/1995");

            userJoao = devinflix.cadastrarUsuarioConta(joaoPereira, "João", "Rua X", "17/08/1992");
            userHelena = devinflix.cadastrarUsuarioConta(joaoPereira, "Helena", "Rua Y", "05/07/1990");

            userBruno = devinflix.cadastrarUsuarioConta(brunoZago, "Bruno", "Rua Teste", "30/04/2000");
            userMaria = devinflix.cadastrarUsuarioConta(brunoZago, "Maria", "Rua Teste", "15/07/1998");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            devinflix.indicarFilmeCatalogo("Homem Aranha: De Volta Para Casa", userLeonidas);
            devinflix.indicarFilmeCatalogo("Jogos Vorazes", userBruna);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            devinflix.curtirFilme(userLeonidas, reiLeao);
            devinflix.curtirFilme(userBruna, vingadores);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            devinflix.comentarFilme(reiLeao, userLeonidas, "Filme fantástico!");
            devinflix.comentarFilme(vingadores, userBruna, "Filme emocionante!");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
