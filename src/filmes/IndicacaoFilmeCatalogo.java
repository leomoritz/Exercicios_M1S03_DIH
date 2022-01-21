package filmes;

import java.time.LocalDate;
import java.util.Objects;

import usuarios.Usuario;

public class IndicacaoFilmeCatalogo implements Comparable<IndicacaoFilmeCatalogo> {

	private final String filme;
	private final Usuario usuarioIndicou;
	private final LocalDate dataIndicacao = LocalDate.now();

	private LocalDate dataUltimaIndicacao;
	private Integer qtdIndicacaoUsuario;

	public IndicacaoFilmeCatalogo(String nomeFilme, Usuario usuarioOrigem) {
		this.filme = nomeFilme;
		this.usuarioIndicou = usuarioOrigem;
		this.qtdIndicacaoUsuario = 0;
		this.dataUltimaIndicacao = LocalDate.now();
	}

	public LocalDate getDataUltimaIndicacao() {
		return dataUltimaIndicacao;
	}

	public void setDataUltimaIndicacao(LocalDate dataUltimaIndicacao) {
		this.dataUltimaIndicacao = dataUltimaIndicacao;
	}

	public int getQtdIndicacaoUsuario() {
		return qtdIndicacaoUsuario;
	}

	public void setQtdIndicacaoUsuario(int qtdIndicacaoUsuario) {
		this.qtdIndicacaoUsuario = qtdIndicacaoUsuario;
	}

	public String getFilme() {
		return filme;
	}

	public Usuario getUsuarioIndicou() {
		return usuarioIndicou;
	}

	public LocalDate getDataIndicacao() {
		return dataIndicacao;
	}

	public void incrementaQtdIndicacao(int qtdIndicacaoUsuario) {
		this.qtdIndicacaoUsuario += qtdIndicacaoUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filme, qtdIndicacaoUsuario, usuarioIndicou);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndicacaoFilmeCatalogo other = (IndicacaoFilmeCatalogo) obj;
		return Objects.equals(filme, other.filme) && qtdIndicacaoUsuario == other.qtdIndicacaoUsuario
				&& Objects.equals(usuarioIndicou, other.usuarioIndicou);
	}

	@Override
	public int compareTo(IndicacaoFilmeCatalogo o) {
		return filme.compareTo(o.getFilme()) + usuarioIndicou.compareTo(o.usuarioIndicou)
				+ qtdIndicacaoUsuario.compareTo(o.getQtdIndicacaoUsuario());
	}

}
