package interfaces;

import java.util.List;

public interface IndicacoesCatalogo {
	
	public void addIndicacoesNovosFilme(String indicacaoFilme, String usuario);
	
	public void removeIndicacoesNovosFilme(String indicacaoFilme);
	
	public List<String[]> listaIndicacoesNovosFilmes();

}
