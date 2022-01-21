package usuarios;

import java.time.LocalDate;
import java.util.Objects;

import filmes.Filme;

public class IndicacaoFilmeUsuario implements Comparable<IndicacaoFilmeUsuario> {

	private final Filme filme;
	private final Usuario usuarioIndicou;
	private final String textoRecomendacao;
	private final LocalDate dataIndicacao = LocalDate.now();

	public IndicacaoFilmeUsuario(Filme filme, Usuario usuarioIndicou, String textoRecomendacao) {
		this.filme = filme;
		this.usuarioIndicou = usuarioIndicou;
		this.textoRecomendacao = textoRecomendacao;
	}

	public LocalDate getDataindicacao() {
		return dataIndicacao;
	}

	public Filme getFilme() {
		return filme;
	}

	public Usuario getUsuarioIndicou() {
		return usuarioIndicou;
	}

	public String getTextoRecomendacao() {
		return textoRecomendacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataIndicacao, filme, textoRecomendacao, usuarioIndicou);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndicacaoFilmeUsuario other = (IndicacaoFilmeUsuario) obj;
		return Objects.equals(dataIndicacao, other.dataIndicacao) && Objects.equals(filme, other.filme)
				&& Objects.equals(textoRecomendacao, other.textoRecomendacao)
				&& Objects.equals(usuarioIndicou, other.usuarioIndicou);
	}

	@Override
	public int compareTo(IndicacaoFilmeUsuario o) {
		return filme.compareTo(o.getFilme()) 
				+ usuarioIndicou.compareTo(o.getUsuarioIndicou())
				+ textoRecomendacao.compareTo(o.getTextoRecomendacao())
				+ dataIndicacao.compareTo(o.getDataindicacao());
	}

}