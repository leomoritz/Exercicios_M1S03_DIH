package programa;

import enums.GeneroFilme;
import enums.PlanosPlataforma;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import filmes.IndicacaoFilmeCatalogo;
import plataforma.Plataforma;
import usuarios.IndicacaoFilmeUsuario;
import usuarios.Usuario;
import usuarios.UsuarioAssinaturaPlano;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		// Instanciando 6 filmes
		Filme filme1 = new Filme("O Rei Le�o",
				"Simba, um le�o herdeiro do trono, " + "precisar� enfrentar seu tio Scar e escapar de suas artimanhas "
						+ "para evitar perder seu posto como futuro rei.",
				GeneroFilme.ANIMACAO, "https://devinflix.com.br/oreileao");

		Filme filme2 = new Filme("Forrest Gump - O Contador de Hist�rias",
				"Quarenta anos " + "da hist�ria dos Estados Unidos, vistos pelos olhos de Forrest Gump "
						+ "(Tom Hanks), um rapaz com QI abaixo da m�dia e boas inten��es. "
						+ "Por obra do acaso, ele consegue participar de momentos cruciais, "
						+ "como a Guerra do Vietn� e Watergate, mas continua pensando no seu amor "
						+ "de inf�ncia, Jenny Curran.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/forrestgump");

		Filme filme3 = new Filme("Vingadores: Ultimato",
				"Os Vingadores unem for�as para "
						+ "lutar contra Thanos, ap�s o vil�o eliminar metade dos seres vivos da " + "gal�xia.",
				GeneroFilme.FANTASIA, "https://devinflix.com.br/vingadoresultimato");

		Filme filme4 = new Filme("� Espera de um Milagre",
				"1935, no corredor da morte de "
						+ "uma pris�o sulista. Paul Edgecomb (Tom Hanks) � o chefe de guarda da "
						+ "pris�o, que temJohn Coffey (Michael Clarke Duncan) como um de seus "
						+ "prisioneiros. Aos poucos, desenvolve-se entre eles uma rela��o incomum,"
						+ " baseada na descoberta de que o prisioneiro possui um dom m�gico que �,"
						+ " ao mesmo tempo, misterioso e milagroso.",
				GeneroFilme.DRAMA, "https://devinflix.com.br/aesperadeummilagre");

		Filme filme5 = new Filme("Star Wars: O Imp�rio Contra-ataca",
				"As for�as imperais " + "comandadas por Darth Vader lan�am um ataque contra os membros da "
						+ "resist�ncia. Luke Skywalker tenta encontrar o Mestre Yoda, que poder� "
						+ "ensin�-lo a se tornar um Jedi. No entanto, Vader planeja lev�-lo para "
						+ "o Lado Negro da \"For�a\".",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/starwarsoimperiocontraataca");

		Filme filme6 = new Filme("De Volta para o Futuro",
				"Um jovem (Michael J. Fox) " + "aciona acidentalmente uma m�quina do tempo constru�da por um "
						+ "cientista (Christopher Lloyd) em um Delorean, retornando aos anos 50. "
						+ "L� conhece sua m�e (Lea Thompson), antes ainda do casamento com seu pai,"
						+ " que fica apaixonada por ele. Tal paix�o p�e em risco sua pr�pria "
						+ "exist�ncia, pois alteraria todo o futuro.",
				GeneroFilme.FICCAO_CIENTIFICA, "https://devinflix.com.br/devoltaparaofuturo");

		// Instanciando 5 usu�rios sem assinatura
		Usuario usuario1 = new Usuario("Jo�o Silva", "joao.silva@gmail.com", "Rua A", "05/02/1995");
		Usuario usuario2 = new Usuario("Pedro Lacerda", "pedro.lacerda@gmail.com", "Rua B", "15/07/1990");
		Usuario usuario3 = new Usuario("Antonio Marques", "antonio.marques@gmail.com", "Rua C", "14/03/2000");
		Usuario usuario4 = new Usuario("Bruno Guedes", "bruno.guedes@gmail.com", "Rua D", "01/04/2005");
		Usuario usuario5 = new Usuario("Valdir Nunes", "valdir.nunes@gmail.com", "Rua E", "02/05/1974");

		// Instanciando 10 usu�rios com assinatura
		Usuario usuario6 = new Usuario("Pedro Costa", "pedro.costa@gmail.com", "Rua F", "03/06/1981",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PADRAO));
		Usuario usuario7 = new Usuario("Bruna Rosa", "bruna.rosa@gmail.com", "Rua G", "01/02/1995",
				new UsuarioAssinaturaPlano(PlanosPlataforma.BASICO));
		Usuario usuario8 = new Usuario("Le�nidas Rosa", "leonidas.rosa@gmail.com", "Rua G", "17/02/1995",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PREMIUM));
		Usuario usuario9 = new Usuario("Bianca Rodrigues", "bianca.rodrigues@gmail.com", "Rua I", "06/09/2000",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PADRAO));
		Usuario usuario10 = new Usuario("Julio Cesar", "julio.cesar@gmail.com", "Rua J", "07/10/2001",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PADRAO));
		Usuario usuario11 = new Usuario("Ricardo Augusto", "ricardo.augusto@gmail.com", "Rua K", "08/11/2002",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PREMIUM));
		Usuario usuario12 = new Usuario("Vinicius Guedes", "vinicius.guedes@gmail.com", "Rua L", "09/12/2003",
				new UsuarioAssinaturaPlano(PlanosPlataforma.BASICO));
		Usuario usuario13 = new Usuario("Anderson Costa", "anderson.costa@gmail.com", "Rua M", "10/02/1994",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PADRAO));
		Usuario usuario14 = new Usuario("Roberta Marinho", "roberto.marinho@gmail.com", "Rua N", "11/01/1993",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PREMIUM));
		Usuario usuario15 = new Usuario("Kiara Suzane", "kiara.suzane@gmail.com", "Rua O", "12/03/1997",
				new UsuarioAssinaturaPlano(PlanosPlataforma.PADRAO));

		// Intanciando um cat�logo de filmes para adicionar os filmes
		CatalogoFilmes catalogo = new CatalogoFilmes();

		catalogo.addFilmeCatalogo(filme1);
		catalogo.addFilmeCatalogo(filme2);
		catalogo.addFilmeCatalogo(filme3);
		catalogo.addFilmeCatalogo(filme4);
		catalogo.addFilmeCatalogo(filme5);
		catalogo.addFilmeCatalogo(filme6);

		// Instanciando a plataforma com o seu cat�logo de filmes
		Plataforma plataforma = new Plataforma(catalogo);

		// Cadastrando os 15 usu�rios na plataforma

		try {
			plataforma.cadastrarUsuario(usuario1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario11);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario13);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario14);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			plataforma.cadastrarUsuario(usuario15);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// Assistindo filme sem assinatura
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE ASSISTIR FILME SEM ASSINATURA");

		try {
			plataforma.assistirFilme(usuario1, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		// Assisitindo filme com assinatura por�m sem pagar a mensalidade
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE ASSISTIR FILME COM ASSINATURA MAS SEM PAGAR MENSALIDADE");

		try {
			plataforma.assinarPlano(usuario1, new UsuarioAssinaturaPlano(PlanosPlataforma.PREMIUM));
			plataforma.assistirFilme(usuario1, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		// Pagando primeira mensalidade para poder assistir filmes
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE ASSISTIR FILME COM ASSINATURA E ADIMPLENTE");

		plataforma.pagarParcelaPlano(usuario1);
		plataforma.pagarParcelaPlano(usuario6);
		plataforma.pagarParcelaPlano(usuario7);
		plataforma.pagarParcelaPlano(usuario8);
		plataforma.pagarParcelaPlano(usuario9);
		plataforma.pagarParcelaPlano(usuario10);
		plataforma.pagarParcelaPlano(usuario11);
		plataforma.pagarParcelaPlano(usuario12);
		plataforma.pagarParcelaPlano(usuario13);
		plataforma.pagarParcelaPlano(usuario14);
		plataforma.pagarParcelaPlano(usuario15);

		try {
			plataforma.assistirFilme(usuario1, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario1, filme3);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario1, filme4);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario6, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario6, filme6);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario6, filme4);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario6, filme5);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario8, filme6);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario9, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario10, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario11, filme4);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario12, filme3);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario13, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario14, filme1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			plataforma.assistirFilme(usuario15, filme6);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		// Recomendando filmes para outros usu�rios
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE RECOMENDANDO FILMES PARA OUTROS USU�RIOS");

		plataforma.indicarFilmeOutroUsuario(filme1, "Filme sensacional. Voc� precisa assistir!", usuario1, usuario2);
		plataforma.indicarFilmeOutroUsuario(filme2, "Filme Top. Recomendo voc� assistir!", usuario2, usuario2);
		plataforma.indicarFilmeOutroUsuario(filme3, "Filme Incr�vel. Tenho certeza que voc� vai curtir!", usuario10,
				usuario2);

		System.out.println("\nLista de recomenda��es que o usu�rio " + usuario2.getNome().toUpperCase() + " recebeu: ");

		for (IndicacaoFilmeUsuario i : usuario2.getIndicacoesRecebidas()) {
			System.out.println("Filme Indicado: " + i.getFilme().getNome() + "\nUsuario que Indicou: "
					+ i.getUsuarioIndicou().getNome() + "\nRecomenda��o: " + i.getTextoRecomendacao() + "\n");
		}

		// Curtindo/Descurtindo filmes
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE CURTIDAS/DESCURTIDAS DOS FILMES\n");

		try {
			plataforma.curtirFilme(usuario1, filme1);
			plataforma.curtirFilme(usuario1, filme2);
			plataforma.curtirFilme(usuario1, filme1); // N�o ser� contabilizado, pois usu�rio j� curtiu esse filme
			plataforma.descurtirFilme(usuario1, filme2); //

			plataforma.curtirFilme(usuario6, filme1);

			plataforma.curtirFilme(usuario7, filme2);

			plataforma.curtirFilme(usuario8, filme3);

			plataforma.curtirFilme(usuario9, filme3);

			plataforma.curtirFilme(usuario10, filme4);

			plataforma.curtirFilme(usuario11, filme4);

			plataforma.curtirFilme(usuario12, filme4);

			plataforma.curtirFilme(usuario13, filme5);

			plataforma.curtirFilme(usuario14, filme5);

			plataforma.curtirFilme(usuario15, filme6);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		for (Filme i : plataforma.getCatalogo().getFilmes()) {
			System.out.println(i.getNome().toUpperCase() + ": " + i.getQtdCurtidas() + " curtida(s)");
		}

		// Indicando filmes novos para o cat�logo da platagorma de filmes
		System.out.println("-----------------------------------------------------------");
		System.out.println("TESTE SUGEST�O DE FILMES PARA O CATALOGO DE FILMES\n");

		try {
			plataforma.indicarFilmeCatalogo("Harry Potter e a Pedra Filosofal", usuario1);
			plataforma.indicarFilmeCatalogo("T� Dando Onda", usuario2);
			plataforma.indicarFilmeCatalogo("Viva - A vida � uma festa", usuario1);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		for (IndicacaoFilmeCatalogo i : plataforma.getCatalogo().getIndicacoesNovosFilmesUsuario()) {
			System.out.println("Filme Indicado: " + i.getFilme() + "\nUsuario Indicou: "
					+ i.getUsuarioIndicou().getNome() + "\nData Indicacao: " + i.getDataIndicacao()
					+ "\nData �ltima Indica��o: " + i.getDataUltimaIndicacao() + "\nQuantidade de Indica��es: "
					+ i.getQtdIndicacaoUsuario() + "\n");
		}

		// Lista g�neros assistidos da plataforma e g�neros assistidos pelo usu�rio
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("TESTE LISTANDO GENEROS ASSISTIDO DO CAT�LOGO DE FILMES\n");
		for (GeneroAssistido i : plataforma.getGenerosAssistidosPlataforma()) {
			System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
		}

		System.out.println("\nTESTE LISTANDO GENEROS ASSISTIDOS PELO USU�RIO " + usuario1.getNome().toUpperCase() + "\n");
		for (GeneroAssistido i : usuario1.getGenerosAssistidosUsuario()) {
			System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
		}

		System.out.println("\nTESTE LISTANDO GENEROS ASSISTIDOS PELO USU�RIO " + usuario6.getNome().toUpperCase() + "\n");
		for (GeneroAssistido i : usuario6.getGenerosAssistidosUsuario()) {
			System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
		}

		// Imprime g�nero mais assitido da plataforma e do usu�rio
		System.out.println("\n-----------------------------------------------------------");
		System.out.print("G�nero mais assistido do cat�logo de filmes: ");
		System.out.print(plataforma.getGeneroMaisAssistido());

		System.out.print("\n\nG�nero mais assistido do usu�rio  " + usuario1.getNome().toUpperCase() + ": ");
		System.out.print(usuario1.getGeneroMaisAssistido());

		System.out.print("\n\nG�nero mais assistido do usu�rio  " + usuario6.getNome().toUpperCase() + ": ");
		System.out.print(usuario6.getGeneroMaisAssistido());

	}

}