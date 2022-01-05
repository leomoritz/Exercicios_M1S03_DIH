package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.PlanosPlataforma;
import filmes.CatalogoFilmes;
import filmes.Filme;
import filmes.GeneroAssistido;
import usuarios.ContratoCliente;
import usuarios.Usuario;

public class UnindoTodosPontos2 {

	public static void main(String[] args) {

		ContratoCliente contrato = null;
		Scanner sc = new Scanner(System.in);
		List<Usuario> usuarios = new ArrayList<>();
		List<Filme> filmes = new ArrayList<>();
		CatalogoFilmes catalogo = new CatalogoFilmes(filmes);

		// Cadastrando 15 usu�rios conforme solicitado no exerc�cio 10

		for (int i = 0; i < 3; i++) {

			System.out.println("### CADASTRO DO " + (i + 1) + "� USU�RIO ###");

			System.out.print("Informe o seu nome: ");
			String nomeUsuario = sc.nextLine();

			System.out.print("Informe o seu endere�o: ");
			String enderecoUsuario = sc.nextLine();

			System.out.print("Informe a sua data de nascimento: ");
			String dataNascimentoUsuario = sc.nextLine();

			System.out.print("Deseja assinar um plano agora e come�ar a assistir filmes? (1 - Sim / 2 - N�o): ");
			int escolhaAssinatura = sc.nextInt();

			if (escolhaAssinatura == 1) {

				System.out.print("Planos Dispon�veis: \n 1 - " + PlanosPlataforma.BASICO.detalhesPlano() + "\n 2 - "
						+ PlanosPlataforma.PADRAO.detalhesPlano() + "\n 3 - " + PlanosPlataforma.PREMIUM.detalhesPlano()
						+ "\nInforme o plano desejado (1 / 2 / 3): ");

				int escolhaPlano = sc.nextInt();

				switch (escolhaPlano) {
				case 1:
					contrato = new ContratoCliente(PlanosPlataforma.BASICO);
					break;
				case 2:
					contrato = new ContratoCliente(PlanosPlataforma.PADRAO);
					break;
				case 3:
					contrato = new ContratoCliente(PlanosPlataforma.PREMIUM);
					break;
				default:
					System.out.println("N�o foi poss�vel assinar o plano. Motivo: Plano n�o encontrado!");
				}
			}

			Usuario usuario = new Usuario(nomeUsuario, enderecoUsuario, dataNascimentoUsuario, contrato);
			usuarios.add(usuario); // adiciona em uma lista para depois poder percorrer e fazer as a��es desejadas

			// seta contrato para nulo ap�s instanciar o usu�rio para ser reaproveitado nos
			// pr�ximos cadastros.
			if (contrato != null) {
				contrato = null;
				System.out.println("Usu�rio criado com sucesso! :)" + "\nPlano assinado: "
						+ usuario.getContrato().getPlanoContratado().name() + "\nSeja bem-vindo � DevInFlix!\n");
			} else {
				System.out.println(
						"Usu�rio criado com sucesso! Voc� ainda n�o escolheu um plano para assistir filmes, mas n�o tem"
								+ " problema, voc� poder� voltar mais tarde e escolher um plano que lhe interessar. "
								+ "At� logo :)\n");
			}

			sc.nextLine(); // Consumir uma linha devido aos pulos do println
		}

		// Cadastrando quantidade de filmes desejada
		for (int i = 0; i < 3; i++) {

			System.out.println("### CADASTRO DO " + (i + 1) + "� FILME ###");

			System.out.print("Informe o nome do filme: ");
			String nomeFilme = sc.nextLine();

			System.out.print("Informe a sinopse do filme: ");
			String sinopseFilme = sc.nextLine();

			System.out.print("G�neros Dispon�veis: " + "\n1-A��o" + "\n" + "2-Anima��o" + "\n" + "3-Aventura" + "\n"
					+ "4-Com�dia" + "\n" + "5-Dan�a" + "\n" + "6-Document�rio" + "\n" + "7-Drama" + "\n" + "8-Faroeste"
					+ "\n" + "9-Fantasia" + "\n" + "10-Fic��o Cient�fica" + "\n" + "11-Guerra" + "\n" + "12-Musical"
					+ "\n" + "13-Policial" + "\n" + "14-Romance" + "\n" + "15-Suspense" + "\n" + "16-Terror"
					+ "\nInforme o g�nero do filme: ");
			int generoFilme = sc.nextInt();

			System.out.print("Informe o link do filme: ");
			String urlFilme = sc.next();

			Filme filme = new Filme(nomeFilme, sinopseFilme, generoFilme, urlFilme);
			filmes.add(filme);
			System.out.println("Filme cadastrado com sucesso!");

			sc.nextLine(); // Consumir uma linha devido aos pulos do println

		}

		// Testando m�todos com tr�s usu�rios e tr�s filmes para testes
		System.out.println("---------------------------");
		Usuario usuario1 = usuarios.get(0);
		Usuario usuario2 = usuarios.get(1);
		Usuario usuario3 = usuarios.get(2);

		Filme filme1 = filmes.get(0);
		Filme filme2 = filmes.get(1);
		Filme filme3 = filmes.get(2);

		usuario1.pagarParcelaPlano();
		usuario2.setContrato(new ContratoCliente(PlanosPlataforma.PADRAO));
		usuario2.pagarParcelaPlano();

		System.out.println(usuario1.assistirFilme(catalogo, filme1));
		System.out.println(usuario2.assistirFilme(catalogo, filme2));
		System.out.println(usuario3.assistirFilme(catalogo, filme3));
		
		// Listando g�nero de filmes assistidos pelos usu�rios
		System.out.println("---------------------------");
		for (Usuario usuario : usuarios) {
			System.out.println("\nGENEROS ASSISTIDOS PELO USU�RIO " + usuario.getNome().toUpperCase());
			for (GeneroAssistido i : usuario.listaGenerosAssistidosUsuario()) {
				System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
			}
			System.out.println("\nGENEROS MAIS ASSISTIDO DO USU�RIO " + usuario.getNome().toUpperCase());
			System.out.println(usuario.getGeneroMaisAssistido());

		}
		
		// Listando g�nero dos filmes assistidos do cat�logo
		System.out.println("---------------------------");
		System.out.println("GENEROS ASSISTIDOS DO CAT�LOGO DE FILMES");
		for (GeneroAssistido i : catalogo.listaGenerosAssistidosCatalogo()) {
			System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
		}

		System.out.println("---------------------------");
		System.out.println("GENEROS MAIS ASSISTIDO DO CAT�LOGO DE FILMES");
		System.out.println(catalogo.getGeneroMaisAssistido());

		sc.close();

	}
}
