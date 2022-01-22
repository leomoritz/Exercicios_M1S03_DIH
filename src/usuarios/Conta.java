package usuarios;

import java.util.HashMap;
import java.util.Map;

public class Conta {

	private final String email;
	private final Map<Integer, Usuario> perfisDoUsuario;
	private String senha;
	private boolean isAdimplente;

	public Conta(String email, String senha) {
		this.email = email;
		this.senha = senha;
		this.isAdimplente = true;
		this.perfisDoUsuario = new HashMap<Integer, Usuario>();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdimplente() {
		return isAdimplente;
	}

	public void setAdimplente(boolean isAdimplente) {
		this.isAdimplente = isAdimplente;
	}

	public String getEmail() {
		return email;
	}

	public Map<Integer, Usuario> getPerfisDoUsuario() {
		return perfisDoUsuario;
	}

	public Boolean addPerfilConta(Integer idPerfil, Usuario usuario) throws Exception {

		if (getPerfisDoUsuario().size() > 3) {
			throw new UnsupportedOperationException("A conta atual já possui o limite máximo de perfis."
					+ " Só é possível possuir 3 perfis por conta.");
		}

		getPerfisDoUsuario().put(idPerfil, usuario);

		return true;
	}

}
