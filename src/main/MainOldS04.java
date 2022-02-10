package main;

import plataforma.Plataforma;
import repositorios.CatalogoFilmeRepository;
import usuarios.Conta;
import usuarios.Usuario;
import util.UtilConversorData;

public class MainOldS04 {

    public static void main(String[] args) {

        Plataforma devinflix = null;

        Conta leonidas = new Conta("leogui.moritz@gmail.com", "12345678");
        Conta joaoPereira = new Conta("joao.pereira@gmail.com", "12345678");
        Conta andreDix = new Conta("andre.dix@gmail.com", "12345678");
        Conta joazinhoLegal = new Conta("joazinho.legal@gmail.com", "12345678");
        Conta brunoZago = new Conta("bruno.zago@gmail.com", "12345678");

        Usuario userLeonidas = new Usuario("Leônidas", null, UtilConversorData.converteStringParaData("17/02/1995"));
        Usuario userBruna = new Usuario("Bruna", null, UtilConversorData.converteStringParaData("01/02/1995"));
        Usuario userJoao = new Usuario("João", null, UtilConversorData.converteStringParaData("17/08/1992"));
        Usuario userHelena = new Usuario("Helena", null, UtilConversorData.converteStringParaData("05/07/1990"));
        Usuario userBruno = new Usuario("Bruno", null, UtilConversorData.converteStringParaData("30/04/2000"));
        Usuario userMaria = new Usuario("Maria", null, UtilConversorData.converteStringParaData("15/07/1998"));

        try {
            devinflix = new Plataforma(CatalogoFilmeRepository.getCatalogo());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
           devinflix.cadastrarConta(leonidas);
           devinflix.cadastrarConta(joaoPereira);
           devinflix.cadastrarConta(andreDix);
           devinflix.cadastrarConta(joazinhoLegal);
           devinflix.cadastrarConta(brunoZago);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            devinflix.cadastrarUsuarioConta(leonidas, userLeonidas);
            devinflix.cadastrarUsuarioConta(leonidas, userBruna);

            devinflix.cadastrarUsuarioConta(joaoPereira, userJoao);
            devinflix.cadastrarUsuarioConta(joaoPereira, userHelena);

            devinflix.cadastrarUsuarioConta(brunoZago, userBruno);
            devinflix.cadastrarUsuarioConta(brunoZago, userMaria);

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
            devinflix.curtirFilme(userLeonidas, devinflix.getCatalogo().getFilmePeloNome("O Rei Leão"));
            devinflix.curtirFilme(userBruna, devinflix.getCatalogo().getFilmePeloNome("Vingadores"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            devinflix.comentarFilme(devinflix.getCatalogo().getFilmePeloNome("O Rei Leão"), userLeonidas, "Filme fantástico!");
            devinflix.comentarFilme(devinflix.getCatalogo().getFilmePeloNome("Vingadores"), userBruna, "Filme emocionante!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
