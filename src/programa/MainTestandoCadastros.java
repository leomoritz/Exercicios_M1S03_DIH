package programa;

import enums.ClassificacaoEtaria;
import enums.GeneroFilme;
import enums.PlanosPlataforma;
import filmes.Filme;
import plataforma.Plataforma;
import repositorios.CatalogoFilmeRepository;
import usuarios.Conta;
import usuarios.UsuarioAssinaturaPlano;

public class MainTestandoCadastros {

	public static void main(String[] args) {

		// Instanciando a plataforma com o seu catálogo de filmes
		Plataforma plataforma = null;

		try {

			plataforma = new Plataforma(CatalogoFilmeRepository.getCatalogo());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Cadastrando novo filmes
		plataforma.getCatalogo()
				.addFilmeCatalogo(new Filme("Homem Aranha: Sem volta para casa", "Sinopse filme homem aranha",
											GeneroFilme.FANTASIA, ClassificacaoEtaria.DOZE_ANOS, "https://devinflix.com.br/homemaranhasemvoltaparacasa"));

		// Cadastrando novas contas
		Conta conta = null;
		try {
			conta = plataforma.cadastrarConta("leogui.moritz@gmail.com", "12345678910");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cadastrar assinatura plano
		try {
			UsuarioAssinaturaPlano novoPlano = new UsuarioAssinaturaPlano(PlanosPlataforma.FAMILIA);
			plataforma.assinarPlano(conta, novoPlano);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cadastrando perfis de usuário na conta
		try {
			plataforma.cadastrarUsuarioConta(conta, "Leônidas" , "Rua Exemplo", "17/02/1995");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plataforma.cadastrarUsuarioConta(conta, "Bruna" , "Rua Exemplo", "01/02/1995");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plataforma.cadastrarUsuarioConta(conta, "Aylah" , "Rua Exemplo", "21/12/2021");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plataforma.cadastrarUsuarioConta(conta, "Enzo" , "Rua Outro Exemplo", "24/05/2010");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
