package programa;

import java.util.ArrayList;
import java.util.List;

import enums.GeneroFilme;
import filmes.CatalogoFilmes;
import filmes.Filme;
import usuarios.Usuario;

public class UnindoTodosPontos1 {

	public static void main(String[] args) {
		
		// Instanciando 6 filmes e adicionando no cat�logo de filmes.
		List<Filme> filmes = new ArrayList<>();
		
		Filme filme1 = new Filme("O Rei Le�o", "Simba, um le�o herdeiro do trono, "
				+ "precisar� enfrentar seu tio Scar e escapar de suas artimanhas "
				+ "para evitar perder seu posto como futuro rei.", GeneroFilme.ANIMACAO, 
				"https://devinflix.com.br/oreileao");
		
		filmes.add(filme1);
		
		Filme filme2 = new Filme("Forrest Gump - O Contador de Hist�rias", "Quarenta anos "
				+ "da hist�ria dos Estados Unidos, vistos pelos olhos de Forrest Gump "
				+ "(Tom Hanks), um rapaz com QI abaixo da m�dia e boas inten��es. "
				+ "Por obra do acaso, ele consegue participar de momentos cruciais, "
				+ "como a Guerra do Vietn� e Watergate, mas continua pensando no seu amor "
				+ "de inf�ncia, Jenny Curran.", GeneroFilme.DRAMA, 
				"https://devinflix.com.br/forrestgump");
		
		filmes.add(filme2);
		
		Filme filme3 = new Filme("Vingadores: Ultimato", "Os Vingadores unem for�as para "
				+ "lutar contra Thanos, ap�s o vil�o eliminar metade dos seres vivos da "
				+ "gal�xia.", GeneroFilme.FANTASIA, 
				"https://devinflix.com.br/vingadoresultimato");
		
		filmes.add(filme3);
		
		Filme filme4 = new Filme("� Espera de um Milagre", "1935, no corredor da morte de "
				+ "uma pris�o sulista. Paul Edgecomb (Tom Hanks) � o chefe de guarda da "
				+ "pris�o, que temJohn Coffey (Michael Clarke Duncan) como um de seus "
				+ "prisioneiros. Aos poucos, desenvolve-se entre eles uma rela��o incomum,"
				+ " baseada na descoberta de que o prisioneiro possui um dom m�gico que �,"
				+ " ao mesmo tempo, misterioso e milagroso.", GeneroFilme.DRAMA, 
				"https://devinflix.com.br/aesperadeummilagre");
		
		filmes.add(filme4);
		
		Filme filme5 = new Filme("Star Wars: O Imp�rio Contra-ataca", "As for�as imperais "
				+ "comandadas por Darth Vader lan�am um ataque contra os membros da "
				+ "resist�ncia. Luke Skywalker tenta encontrar o Mestre Yoda, que poder� "
				+ "ensin�-lo a se tornar um Jedi. No entanto, Vader planeja lev�-lo para "
				+ "o Lado Negro da \"For�a\".", GeneroFilme.FICCAO_CIENTIFICA, 
				"https://devinflix.com.br/starwarsoimperiocontraataca");
		
		filmes.add(filme5);
		
		Filme filme6 = new Filme("De Volta para o Futuro", "Um jovem (Michael J. Fox) "
				+ "aciona acidentalmente uma m�quina do tempo constru�da por um "
				+ "cientista (Christopher Lloyd) em um Delorean, retornando aos anos 50. "
				+ "L� conhece sua m�e (Lea Thompson), antes ainda do casamento com seu pai,"
				+ " que fica apaixonada por ele. Tal paix�o p�e em risco sua pr�pria "
				+ "exist�ncia, pois alteraria todo o futuro.", GeneroFilme.FICCAO_CIENTIFICA, 
				"https://devinflix.com.br/devoltaparaofuturo");
		
		filmes.add(filme6);
				
		CatalogoFilmes catalogo = new CatalogoFilmes(filmes);
		
		// Instanciando 3 usu�rios
		Usuario usuario1 = new Usuario("Jo�o Silva", "Rua X", "05/02/1995");
		Usuario usuario2 = new Usuario("Pedro Lacerda", "Rua XY", "15/07/1990");
		Usuario usuario3 = new Usuario("Antonio Marques", "Rua XYZ", "14/02/2000");
		
		// Recomendando filmes para outros usu�rios
		usuario1.recomendarFilme(filme6, "Filme sensacional pra quem gosta de fic��o "
				+ "cient�fica. Super recomendo!", 
				usuario1, usuario2);
		
		usuario1.recomendarFilme(filme5, "Filme incr�vel! Voc� precisa assistir", 
				usuario1, usuario2);

		// Curtindo/Descurtindo filmes
		if(!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " j� curtiu esse filme!");
		}
		
		if(!usuario2.curtirFilme(filme2, usuario2)) {
			System.out.println(usuario2.getNome() + " j� curtiu esse filme!");
		}
		
		if(!usuario3.curtirFilme(filme3, usuario3)) {
			System.out.println(usuario3.getNome() + " j� curtiu esse filme!");
		}
		
		if(!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " j� curtiu esse filme!");
		}
		
		if(usuario1.descurtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " ainda n�o curtiu esse filme!");
		}
		
		if(!usuario1.curtirFilme(filme1, usuario1)) {
			System.out.println(usuario1.getNome() + " j� curtiu esse filme!");
		}	

		// Indicando filmes novos para o cat�logo da platagorma de filmes
		usuario1.indicarFilmeCatalogo(catalogo, "Harry Potter e a Pedra Filosofal");
		usuario2.indicarFilmeCatalogo(catalogo, "T� Dando Onda");
		usuario3.indicarFilmeCatalogo(catalogo, "Viva - A vida � uma festa");
		
		//Listando quantidade de curtidas de cada filme da plataforma
		System.out.println("---------------------------");	
		System.out.println("Quantidade de curtidas de cada filme");
		for(Filme i : catalogo.getFilmes()) {
			System.out.println("Filme " + i.getNome() + ": " + i.getQtdCurtidas() + " curtida(s)");
		}
		System.out.println("---------------------------");
		
		//Listando recomendacoes de filmes que o usu�rio recebeu
		System.out.println("Recomenda��es de filmes do usu�rio " + usuario2.getNome() + ":\n");
		for(String[] i : usuario2.listarRecomendacoes(usuario2)) {
			for(int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}
			System.out.println("\n");
		}
		System.out.println("---------------------------");
		//Listando filmes que foram indicados para a plataforma
		System.out.println("Recomenda��es de filmes para o cat�logo da plataforma: ");
		for(String i : catalogo.getIndicacoesNovosFilmes()) {
			System.out.println(i);
		}
}
}
