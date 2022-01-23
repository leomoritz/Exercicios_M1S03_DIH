package repositorios;

import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;

public class CatalogoFilmeRepository {

	private static final CatalogoFilmes catalogo = new CatalogoFilmes();

	public CatalogoFilmeRepository() {

		catalogo.addFilmeCatalogo(new Filme("O Rei Leão",
				"Simba, um leão herdeiro do trono, " + "precisará enfrentar seu tio Scar e escapar de suas artimanhas "
						+ "para evitar perder seu posto como futuro rei.",
				GeneroFilme.ANIMACAO, "https://devinflix.com.br/oreileao"));

		catalogo.addFilmeCatalogo(new Filme("Forrest Gump - O Contador de Histórias",
				"Quarenta anos " + "da história dos Estados Unidos, vistos pelos olhos de Forrest Gump "
						+ "(Tom Hanks), um rapaz com QI abaixo da média e boas intenções. "
						+ "Por obra do acaso, ele consegue participar de momentos cruciais, "
						+ "como a Guerra do Vietnã e Watergate, mas continua pensando no seu amor "
						+ "de infância, Jenny Curran.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/forrestgump"));

		catalogo.addFilmeCatalogo(new Filme("Vingadores: Ultimato",
				"Os Vingadores unem forças para "
						+ "lutar contra Thanos, após o vilão eliminar metade dos seres vivos da " + "galáxia.",
				GeneroFilme.FANTASIA, "https://devinflix.com.br/vingadoresultimato"));

		catalogo.addFilmeCatalogo(new Filme("À Espera de um Milagre",
				"1935, no corredor da morte de "
						+ "uma prisão sulista. Paul Edgecomb (Tom Hanks) é o chefe de guarda da "
						+ "prisão, que temJohn Coffey (Michael Clarke Duncan) como um de seus "
						+ "prisioneiros. Aos poucos, desenvolve-se entre eles uma relação incomum,"
						+ " baseada na descoberta de que o prisioneiro possui um dom mágico que é,"
						+ " ao mesmo tempo, misterioso e milagroso.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/aesperadeummilagre"));

		catalogo.addFilmeCatalogo(new Filme("Star Wars: O Império Contra-ataca",
				"As forças imperais " + "comandadas por Darth Vader lançam um ataque contra os membros da "
						+ "resistência. Luke Skywalker tenta encontrar o Mestre Yoda, que poderá "
						+ "ensiná-lo a se tornar um Jedi. No entanto, Vader planeja levá-lo para "
						+ "o Lado Negro da \"Força\".",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/starwarsoimperiocontraataca"));

		catalogo.addFilmeCatalogo(new Filme("De Volta para o Futuro",
				"Um jovem (Michael J. Fox) " + "aciona acidentalmente uma máquina do tempo construída por um "
						+ "cientista (Christopher Lloyd) em um Delorean, retornando aos anos 50. "
						+ "Lá conhece sua mãe (Lea Thompson), antes ainda do casamento com seu pai,"
						+ " que fica apaixonada por ele. Tal paixão põe em risco sua própria "
						+ "existência, pois alteraria todo o futuro.",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/devoltaparaofuturo"));
	}

	public static CatalogoFilmes getCatalogo() {
		return catalogo;
	}

}
