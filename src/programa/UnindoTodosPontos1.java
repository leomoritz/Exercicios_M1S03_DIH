package programa;

import java.util.ArrayList;
import java.util.List;

import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.IndicacoesMelhorCatalogoPlus;
import interfaces.IndicacoesCatalogo;
import usuarios.Usuario;

public class UnindoTodosPontos1 {

	public static void main(String[] args) {

		// Instanciando 6 filmes e adicionando no catálogo de filmes.
		List<Filme> filmes = new ArrayList<>();

		Filme filme1 = new Filme("O Rei Leão",
				"Simba, um leão herdeiro do trono, " + "precisará enfrentar seu tio Scar e escapar de suas artimanhas "
						+ "para evitar perder seu posto como futuro rei.",
				GeneroFilme.ANIMACAO, "https://devinflix.com.br/oreileao");

		filmes.add(filme1);

		Filme filme2 = new Filme("Forrest Gump - O Contador de Histórias",
				"Quarenta anos " + "da história dos Estados Unidos, vistos pelos olhos de Forrest Gump "
						+ "(Tom Hanks), um rapaz com QI abaixo da média e boas intenções. "
						+ "Por obra do acaso, ele consegue participar de momentos cruciais, "
						+ "como a Guerra do Vietnã e Watergate, mas continua pensando no seu amor "
						+ "de infância, Jenny Curran.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/forrestgump");

		filmes.add(filme2);

		Filme filme3 = new Filme("Vingadores: Ultimato",
				"Os Vingadores unem forças para "
						+ "lutar contra Thanos, após o vilão eliminar metade dos seres vivos da " + "galáxia.",
				GeneroFilme.FANTASIA, "https://devinflix.com.br/vingadoresultimato");

		filmes.add(filme3);

		Filme filme4 = new Filme("À Espera de um Milagre",
				"1935, no corredor da morte de "
						+ "uma prisão sulista. Paul Edgecomb (Tom Hanks) é o chefe de guarda da "
						+ "prisão, que temJohn Coffey (Michael Clarke Duncan) como um de seus "
						+ "prisioneiros. Aos poucos, desenvolve-se entre eles uma relação incomum,"
						+ " baseada na descoberta de que o prisioneiro possui um dom mágico que é,"
						+ " ao mesmo tempo, misterioso e milagroso.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/aesperadeummilagre");

		filmes.add(filme4);

		Filme filme5 = new Filme("Star Wars: O Império Contra-ataca",
				"As forças imperais " + "comandadas por Darth Vader lançam um ataque contra os membros da "
						+ "resistência. Luke Skywalker tenta encontrar o Mestre Yoda, que poderá "
						+ "ensiná-lo a se tornar um Jedi. No entanto, Vader planeja levá-lo para "
						+ "o Lado Negro da \"Força\".",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/starwarsoimperiocontraataca");

		filmes.add(filme5);

		Filme filme6 = new Filme("De Volta para o Futuro",
				"Um jovem (Michael J. Fox) " + "aciona acidentalmente uma máquina do tempo construída por um "
						+ "cientista (Christopher Lloyd) em um Delorean, retornando aos anos 50. "
						+ "Lá conhece sua mãe (Lea Thompson), antes ainda do casamento com seu pai,"
						+ " que fica apaixonada por ele. Tal paixão põe em risco sua própria "
						+ "existência, pois alteraria todo o futuro.",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/devoltaparaofuturo");

		filmes.add(filme6);

		CatalogoFilmes catalogo = new CatalogoFilmes(filmes);

		// Instanciando 3 usuários
		Usuario usuario1 = new Usuario("João Silva", "Rua X", "05/02/1995");
		Usuario usuario2 = new Usuario("Pedro Lacerda", "Rua XY", "15/07/1990");
		Usuario usuario3 = new Usuario("Antonio Marques", "Rua XYZ", "14/02/2000");

		// Recomendando filmes para outros usuários
		usuario1.recomendarFilme(filme6, "Filme sensacional pra quem gosta de ficção " + "científica. Super recomendo!",
				usuario2);

		usuario1.recomendarFilme(filme5, "Filme incrível! Você precisa assistir", usuario2);

		// Curtindo/Descurtindo filmes
		if (!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " já curtiu esse filme!");
		}

		if (!usuario2.curtirFilme(filme2, usuario2)) {
			System.out.println(usuario2.getNome() + " já curtiu esse filme!");
		}

		if (!usuario3.curtirFilme(filme3, usuario3)) {
			System.out.println(usuario3.getNome() + " já curtiu esse filme!");
		}

		if (!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " já curtiu esse filme!");
		}

		if (usuario1.descurtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " ainda não curtiu esse filme!");
		}

		if (!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " já curtiu esse filme!");
		}

		// Indicando filmes novos para o catálogo da platagorma de filmes
		System.out.println("---------------------------");
		IndicacoesCatalogo indicacaoCatalogo1 = new IndicacoesMelhorCatalogoPlus();
		IndicacoesCatalogo indicacaoCatalogo2 = new IndicacoesMelhorCatalogoPlus();
		IndicacoesCatalogo indicacaoCatalogo3 = new IndicacoesMelhorCatalogoPlus();
		System.out
				.println(usuario1.indicarFilmeCatalogo(indicacaoCatalogo1, "Harry Potter e a Pedra Filosofal", catalogo)
						+ "\n" + usuario2.indicarFilmeCatalogo(indicacaoCatalogo2, "Tá Dando Onda", catalogo) + "\n"
						+ usuario3.indicarFilmeCatalogo(indicacaoCatalogo3, "Viva - A vida é uma festa", catalogo)
						+ "\n" + usuario1.indicarFilmeCatalogo(indicacaoCatalogo1, "Senhor dos Anéis", catalogo));

		// Listando quantidade de curtidas de cada filme da plataforma
		System.out.println("---------------------------");
		System.out.println("Quantidade de curtidas de cada filme");
		for (Filme i : catalogo.getFilmes()) {
			System.out.println("Filme " + i.getNome().toUpperCase() + ": " + i.getQtdCurtidas() + " curtida(s)");
		}

		// Listando recomendacoes de filmes que o usuário recebeu
		System.out.println("---------------------------");
		System.out.println("Recomendações de filmes do usuário " + usuario2.getNome() + ":\n");
		for (String i : usuario2.listarRecomendacoes(usuario2)) {
			System.out.println(i);
		}

		// Listando filmes que foram indicados para a plataforma
		System.out.println("---------------------------");
		System.out.println("Recomendações de filmes para o catálogo da plataforma: ");
		int aux = 1;
		for (String i : catalogo.listaIndicacoesNovosFilmes()) {
			System.out.println(aux + " - " + i);
			aux++;
		}

		// Testando a implementação de remoção de indicação dos filmes para o catálogo
		// da plataforma
		System.out.println("---------------------------");
		System.out.println(usuario1.removerIndicacaoFilmeCatalogo(indicacaoCatalogo1, 1, catalogo) + "\n");
		System.out.println("Recomendações de filmes para o catálogo da plataforma: ");
		aux = 1;
		for (String i : catalogo.listaIndicacoesNovosFilmes()) {
			System.out.println(aux + " - " + i);
			aux++;
		}
		
		// Assistindo filme:
		System.out.println("---------------------------");
		//System.out.println(usuario1.assistirFilme(catalogo, filme1));
		System.out.println(usuario2.assistirFilme(catalogo, filme1));
		System.out.println(usuario3.assistirFilme(catalogo, filme1));
		System.out.println(usuario1.assistirFilme(catalogo, filme2));
		System.out.println(usuario2.assistirFilme(catalogo, filme2));
		System.out.println(usuario3.assistirFilme(catalogo, filme2));
		
		System.out.println("---------------------------");
		System.out.println("GENEROS MAIS ASSISTIDO DO CATÁLOGO DE FILMES");
		System.out.println(catalogo.getGeneroMaisAssistidoCatalogo());
		
	}
}
