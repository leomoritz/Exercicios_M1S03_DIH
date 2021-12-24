package filmes;

import java.util.ArrayList;
import java.util.List;

import interfaces.IndicacoesCatalogo;

public class IndicacoesMelhorCatalogo implements IndicacoesCatalogo {
	
	private List<String[]> indicacoesNovosFilmes = new ArrayList<>();
	
	@Override
	public void addIndicacoesNovosFilme(String indicacaoFilme, String usuario) {
		indicacoesNovosFilmes.add(new String[]{"Filme Indicado: " + indicacaoFilme + " - Usuário que indicou: " + usuario});
	}
	
	@Override
	public void removeIndicacoesNovosFilme(String indicacaoFilme) {
		indicacoesNovosFilmes.remove(indicacaoFilme);
	}
	
	@Override
	public List<String[]> listaIndicacoesNovosFilmes(){
		return indicacoesNovosFilmes;
	}
	
}
