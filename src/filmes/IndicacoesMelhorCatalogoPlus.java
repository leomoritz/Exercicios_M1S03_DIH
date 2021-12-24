package filmes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IndicacoesCatalogo;

public class IndicacoesMelhorCatalogoPlus implements IndicacoesCatalogo{
	
	/*
	 * Usuários estão indicando muitos filmes para a plataforma e a mesma não possui
	 * recursos para adquirir tanto filmes, então foi definido que temporariamente 
	 * será possível indicar apenas um filme por mês. Sendo assim foi criada uma 
	 * interface que possibilita mudar a regra de negócio sem gerar muito impacto 
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
