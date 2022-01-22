package usuarios;

import java.util.HashMap;
import java.util.Map;

public class Conta {

	private final String email;
	private final Map<Integer, Usuario> perfisDoUsuario;
	private String senha;
	private Boolean statusPagamento;

	public Conta(String email, String senha, Boolean statusPagamento) {
		this.email = email;
		this.senha = senha;
		this.statusPagamento = statusPagamento;
		this.perfisDoUsuario = new HashMap<Integer, Usuario>(3);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(Boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getEmail() {
		return email;
	}

	public Map<Integer, Usuario> getPerfisDoUsuario() {
		return perfisDoUsuario;
	}

	public Boolean addPerfilConta(Integer idPerfil, Usuario usuario) throws Exception {

		if (idPerfil == null || nomePerfil == null) {
			throw new NullPointerException("O id ou o nome do perfil não foi informado.");
		}

		if(getPerfisDoUsuario().put(idPerfil, nomePerfil)) {
			
		}
		return true;
	}

}
