package programa;

import enums.GeneroFilme;
import filmes.Filme;
import usuarios.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Filme filme1 = new Filme("Deus não está morto", "Teste sinopse", GeneroFilme.DRAMA,
				"https://devinflix.com.br/deusNaoEstaMorto");
		
		Filme filme2 = new Filme("Rambo", "Teste sinopse filme Rambo", 
				GeneroFilme.GUERRA, "https://devinflix.com.br/rambo");

		Usuario usuario1 = new Usuario("Leônidas Moritz Rosa", "Rua Frieda Jensen, nº 92, Itoupava Central",
				"17/02/1995");

		Usuario usuario2 = new Usuario("Bruna de Oliveira Rosa", "Rua Frieda Jensen, nº 92, Itoupava Central",
				"01/02/1995");

		usuario1.curtirFilme(filme1, usuario1);
		usuario2.curtirFilme(filme1, usuario2);
		usuario2.curtirFilme(filme1, usuario2);
		usuario1.curtirFilme(filme2, usuario1);
		usuario2.descurtirFilme(filme1, usuario2);
		
		System.out.println("Quantidade de curtidas do filme " + filme1.getNome() + ": " + filme1.getQtdCurtidas());

		/*
		 * usuario1.descurtirFilme(filme1, usuario1);
		 * System.out.println("Quantidade de curtidas do filme " + filme1.getNome() +
		 * ": " + filme1.getQtdCurtidas());
		 */

		// Lista usuarios que curtiram o filme
		System.out.println("\nLista de Usuários que curtiram o filme " + filme1.getNome() + ":");
		for (Usuario i : filme1.listaUsuarioCurtiu()) {
			System.out.println(i.getNome());
		}

		// Lista filmes curtidos pelo usuário
		System.out.println("\nLista de Filmes que o usuário " + usuario2.getNome() + " curtiu!");
		for (Filme i : usuario2.listaFilmesCurtidos()) {
			System.out.println(i.getNome());
		}

		System.out.println("\nLista de Filmes que o usuário " + usuario1.getNome() + " curtiu!");
		for (Filme i : usuario1.listaFilmesCurtidos()) {
			System.out.println(i.getNome());
		}
		
		//Recomendando Filme
		usuario1.recomendarFilme(filme1, "Me emocionou muito! Recomendo assistir", usuario1, usuario2);
		usuario1.recomendarFilme(filme2, "Filme excelente! Recomendo assistir", usuario1, usuario2);
		
		//Listando Recomendacoes recebidas pelo usuário
		System.out.println("\nFilmes recomendados: ");
		for(String[] i : usuario2.listarRecomendacoes(usuario2)) {
			for(int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}
		}

	}

}
