package repositorios;

import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;

public class CatalogoFilmeRepository {

	private static final CatalogoFilmes catalogo = new CatalogoFilmes();

	public CatalogoFilmeRepository() {

		catalogo.addFilmeCatalogo(new Filme("O Rei Le�o",
				"Simba, um le�o herdeiro do trono, " + "precisar� enfrentar seu tio Scar e escapar de suas artimanhas "
						+ "para evitar perder seu posto como futuro rei.",
				GeneroFilme.ANIMACAO, "https://devinflix.com.br/oreileao"));

		catalogo.addFilmeCatalogo(new Filme("Forrest Gump - O Contador de Hist�rias",
				"Quarenta anos " + "da hist�ria dos Estados Unidos, vistos pelos olhos de Forrest Gump "
						+ "(Tom Hanks), um rapaz com QI abaixo da m�dia e boas inten��es. "
						+ "Por obra do acaso, ele consegue participar de momentos cruciais, "
						+ "como a Guerra do Vietn� e Watergate, mas continua pensando no seu amor "
						+ "de inf�ncia, Jenny Curran.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/forrestgump"));

		catalogo.addFilmeCatalogo(new Filme("Vingadores: Ultimato",
				"Os Vingadores unem for�as para "
						+ "lutar contra Thanos, ap�s o vil�o eliminar metade dos seres vivos da " + "gal�xia.",
				GeneroFilme.FANTASIA, "https://devinflix.com.br/vingadoresultimato"));

		catalogo.addFilmeCatalogo(new Filme("� Espera de um Milagre",
				"1935, no corredor da morte de "
						+ "uma pris�o sulista. Paul Edgecomb (Tom Hanks) � o chefe de guarda da "
						+ "pris�o, que temJohn Coffey (Michael Clarke Duncan) como um de seus "
						+ "prisioneiros. Aos poucos, desenvolve-se entre eles uma rela��o incomum,"
						+ " baseada na descoberta de que o prisioneiro possui um dom m�gico que �,"
						+ " ao mesmo tempo, misterioso e milagroso.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/aesperadeummilagre"));

		catalogo.addFilmeCatalogo(new Filme("Star Wars: O Imp�rio Contra-ataca",
				"As for�as imperais " + "comandadas por Darth Vader lan�am um ataque contra os membros da "
						+ "resist�ncia. Luke Skywalker tenta encontrar o Mestre Yoda, que poder� "
						+ "ensin�-lo a se tornar um Jedi. No entanto, Vader planeja lev�-lo para "
						+ "o Lado Negro da \"For�a\".",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/starwarsoimperiocontraataca"));

		catalogo.addFilmeCatalogo(new Filme("De Volta para o Futuro",
				"Um jovem (Michael J. Fox) " + "aciona acidentalmente uma m�quina do tempo constru�da por um "
						+ "cientista (Christopher Lloyd) em um Delorean, retornando aos anos 50. "
						+ "L� conhece sua m�e (Lea Thompson), antes ainda do casamento com seu pai,"
						+ " que fica apaixonada por ele. Tal paix�o p�e em risco sua pr�pria "
						+ "exist�ncia, pois alteraria todo o futuro.",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/devoltaparaofuturo"));
	}

	public static CatalogoFilmes getCatalogo() {
		return catalogo;
	}

}
