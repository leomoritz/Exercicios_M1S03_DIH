package repositorios;

import java.util.HashSet;
import java.util.Set;

import usuarios.Conta;
import usuarios.Usuario;
import util.UtilConversorData;

public class ContaUsuarioRepository {

	private static final Set<Conta> contas = new HashSet<>();

	public ContaUsuarioRepository() throws Exception {

		getContas().add(new Conta("joao.silva@gmail.com", "123456"));

		getContaPorEmail("joao.silva@gmail.com").addPerfilConta(new Usuario("João Silva", null, UtilConversorData.converteStringParaData("05/02/1995")));
		getContaPorEmail("joao.silva@gmail.com").addPerfilConta(new Usuario("Bruno Guedes", null, UtilConversorData.converteStringParaData("01/04/2005")));
		getContaPorEmail("joao.silva@gmail.com").addPerfilConta(new Usuario("Antonio Marques", null, UtilConversorData.converteStringParaData("14/03/2000")));

		getContas().add(new Conta("pedro.lacerda@gmail.com", "78910"));

		getContaPorEmail("pedro.lacerda@gmail.com").addPerfilConta(new Usuario("Pedro Lacerda", null, UtilConversorData.converteStringParaData("15/07/1990")));
		getContaPorEmail("pedro.lacerda@gmail.com").addPerfilConta(new Usuario("Valdir Nunes", null, UtilConversorData.converteStringParaData("02/05/1974")));
		getContaPorEmail("pedro.lacerda@gmail.com").addPerfilConta(new Usuario("Pedro Costa", null, UtilConversorData.converteStringParaData("03/06/1981")));

		getContas().add(new Conta("bianca.figueiredo@yahoo.com", "111213"));

		getContaPorEmail("bianca.figueiredo@yahoo.com").addPerfilConta(new Usuario("Bianca Figueiredo", null, UtilConversorData.converteStringParaData("06/09/2000")));
		getContaPorEmail("bianca.figueiredo@yahoo.com").addPerfilConta(new Usuario("Julio Cesar", null, UtilConversorData.converteStringParaData("07/10/2001")));
		getContaPorEmail("bianca.figueiredo@yahoo.com").addPerfilConta(new Usuario("Ricardo Augusto", null, UtilConversorData.converteStringParaData("08/11/2002")));

		getContas().add(new Conta("pablo.augusto@hotmail.com", "141516"));

		getContaPorEmail("pablo.augusto@hotmail.com").addPerfilConta(new Usuario("Pablo Augusto", null, UtilConversorData.converteStringParaData("09/12/2003")));
		getContaPorEmail("pablo.augusto@hotmail.com").addPerfilConta(new Usuario("Julio Cesar", null, UtilConversorData.converteStringParaData("07/10/2001")));

		getContas().add(new Conta("lais.krueger@gmail.com", "171819"));
		getContaPorEmail("lais.krueger@gmail.com").addPerfilConta(new Usuario("Lais Krueger", null, UtilConversorData.converteStringParaData("09/12/2003")));

	}

	public static Set<Conta> getContas() {
		return contas;
	}

	public static Conta getConta(Conta conta) {
		return contas.stream().filter(contaAux -> contaAux.getEmail().equals(conta)).findFirst().get();
	}
	
	public static Conta getContaPorEmail(String email) {
		return contas.stream().filter(contaAux -> contaAux.getEmail().equals(email)).findFirst().get();
	}

	public static Conta getContaPorUsuario(Usuario usuario) {
		return contas.stream().filter(conta -> conta.getPerfisDoUsuario().contains(usuario)).findFirst().get();
	}

	public static Set<Usuario> getUsuariosPorConta(Conta conta, Usuario usuario) {
		return getContaPorUsuario(usuario).getPerfisDoUsuario();
	}

	public static Usuario getUsuarioConta(Conta conta, Usuario usuario) {
		return getUsuariosPorConta(conta, usuario)
				.stream()
				.filter(usuarioAux -> usuarioAux.equals(usuario))
				.findFirst()
				.get();
	}

}
