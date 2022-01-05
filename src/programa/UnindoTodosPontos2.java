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

		// Cadastrando 15 usuários conforme solicitado no exercício 10

		for (int i = 0; i < 3; i++) {

			System.out.println("### CADASTRO DO " + (i + 1) + "º USUÁRIO ###");

			System.out.print("Informe o seu nome: ");
			String nomeUsuario = sc.nextLine();

			System.out.print("Informe o seu endereço: ");
			String enderecoUsuario = sc.nextLine();

			System.out.print("Informe a sua data de nascimento: ");
			String dataNascimentoUsuario = sc.nextLine();

			System.out.print("Deseja assinar um plano agora e começar a assistir filmes? (1 - Sim / 2 - Não): ");
			int escolhaAssinatura = sc.nextInt();

			if (escolhaAssinatura == 1) {

				System.out.print("Planos Disponíveis: \n 1 - " + PlanosPlataforma.BASICO.detalhesPlano() + "\n 2 - "
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
					System.out.println("Não foi possível assinar o plano. Motivo: Plano não encontrado!");
				}
			}

			Usuario usuario = new Usuario(nomeUsuario, enderecoUsuario, dataNascimentoUsuario, contrato);
			usuarios.add(usuario); // adiciona em uma lista para depois poder percorrer e fazer as ações desejadas

			// seta contrato para nulo após instanciar o usuário para ser reaproveitado nos
			// próximos cadastros.
			if (contrato != null) {
				contrato = null;
				System.out.println("Usuário criado com sucesso! :)" + "\nPlano assinado: "
						+ usuario.getContrato().getPlanoContratado().name() + "\nSeja bem-vindo à DevInFlix!\n");
			} else {
				System.out.println(
						"Usuário criado com sucesso! Você ainda não escolheu um plano para assistir filmes, mas não tem"
								+ " problema, você poderá voltar mais tarde e escolher um plano que lhe interessar. "
								+ "Até logo :)\n");
			}

			sc.nextLine(); // Consumir uma linha devido aos pulos do println
		}

		// Cadastrando quantidade de filmes desejada
		for (int i = 0; i < 3; i++) {

			System.out.println("### CADASTRO DO " + (i + 1) + "º FILME ###");

			System.out.print("Informe o nome do filme: ");
			String nomeFilme = sc.nextLine();

			System.out.print("Informe a sinopse do filme: ");
			String sinopseFilme = sc.nextLine();

			System.out.print("Gêneros Disponíveis: " + "\n1-Ação" + "\n" + "2-Animação" + "\n" + "3-Aventura" + "\n"
					+ "4-Comédia" + "\n" + "5-Dança" + "\n" + "6-Documentário" + "\n" + "7-Drama" + "\n" + "8-Faroeste"
					+ "\n" + "9-Fantasia" + "\n" + "10-Ficção Científica" + "\n" + "11-Guerra" + "\n" + "12-Musical"
					+ "\n" + "13-Policial" + "\n" + "14-Romance" + "\n" + "15-Suspense" + "\n" + "16-Terror"
					+ "\nInforme o gênero do filme: ");
			int generoFilme = sc.nextInt();

			System.out.print("Informe o link do filme: ");
			String urlFilme = sc.next();

			Filme filme = new Filme(nomeFilme, sinopseFilme, generoFilme, urlFilme);
			filmes.add(filme);
			System.out.println("Filme cadastrado com sucesso!");

			sc.nextLine(); // Consumir uma linha devido aos pulos do println

		}

		// Testando métodos com três usuários e três filmes para testes
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
		
		// Listando gênero de filmes assistidos pelos usuários
		System.out.println("---------------------------");
		for (Usuario usuario : usuarios) {
			System.out.println("\nGENEROS ASSISTIDOS PELO USUÁRIO " + usuario.getNome().toUpperCase());
			for (GeneroAssistido i : usuario.listaGenerosAssistidosUsuario()) {
				System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
			}
			System.out.println("\nGENEROS MAIS ASSISTIDO DO USUÁRIO " + usuario.getNome().toUpperCase());
			System.out.println(usuario.getGeneroMaisAssistido());

		}
		
		// Listando gênero dos filmes assistidos do catálogo
		System.out.println("---------------------------");
		System.out.println("GENEROS ASSISTIDOS DO CATÁLOGO DE FILMES");
		for (GeneroAssistido i : catalogo.listaGenerosAssistidosCatalogo()) {
			System.out.println(i.getGeneroAssistido().name() + " - " + i.getQtdAssistido());
		}

		System.out.println("---------------------------");
		System.out.println("GENEROS MAIS ASSISTIDO DO CATÁLOGO DE FILMES");
		System.out.println(catalogo.getGeneroMaisAssistido());

		sc.close();

	}
}
