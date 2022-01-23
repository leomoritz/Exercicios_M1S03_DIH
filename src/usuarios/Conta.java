package usuarios;

import java.util.HashSet;
import java.util.Set;

public class Conta {

	private final String email;
	private final Set<Usuario> perfisDoUsuario;
	private String senha;
	private UsuarioAssinaturaPlano plano;
	private boolean isAdimplente;

	public Conta(String email, String senha) {
		this.email = email;
		this.senha = senha;
		this.isAdimplente = true;
		this.perfisDoUsuario = new HashSet<>();
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

	public UsuarioAssinaturaPlano getPlano() {
		return plano;
	}

	public void setPlano(UsuarioAssinaturaPlano plano) {
		this.plano = plano;
	}

	public Set<Usuario> getPerfisDoUsuario() {
		return perfisDoUsuario;
	}

	public Boolean addPerfilConta(Usuario usuario) throws Exception {

		if (getPerfisDoUsuario().size() > 2) {
			throw new UnsupportedOperationException("A conta atual já possui o limite máximo de perfis."
					+ " Só é possível possuir 3 perfis por conta.");
		}

		getPerfisDoUsuario().add(usuario);

		return true;
	}

}
