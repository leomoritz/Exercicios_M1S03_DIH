package filmes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IndicacoesCatalogo;

public class IndicacoesMelhorCatalogoPlus implements IndicacoesCatalogo{
	
	/*
	 * Usu�rios est�o indicando muitos filmes para a plataforma e a mesma n�o possui
	 * recursos para adquirir tanto filmes, ent�o foi definido que temporariamente 
	 * ser� poss�vel indicar apenas um filme por m�s. Sendo assim foi criada uma 
	 * interface que possibilita mudar a regra de neg�cio sem gerar muito impacto 
	 * devido a interface possibilitar baixo acoplamento e flexibilidade.
	 */
	
	private List<String[]> indicacoesNovosFilmes = new ArrayList<>();
	private LocalDate data = LocalDate.now();
	
	@Override
	public void addIndicacoesNovosFilme(String indicacaoFilme, String usuario) {
				
	}
	
	@Override

	public void removeIndicacoesNovosFilme(String indicacaoFilme) {
		
	}

	@Override
	public List<String[]> listaIndicacoesNovosFilmes() {
		// TODO Auto-generated method stub
		return null;
	}

}
