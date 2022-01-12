package filmes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import interfaces.IndicacoesCatalogo;
import plataforma.Plataforma;

public class IndicacoesMelhorCatalogoPlus implements IndicacoesCatalogo {

	/*
	 * Usu�rios est�o indicando muitos filmes para a plataforma e a mesma n�o possui
	 * recursos para adquirir tanto filmes, ent�o foi definido que temporariamente
	 * ser� poss�vel indicar apenas um filme por m�s. Sendo assim foi criada uma
	 * interface que possibilita mudar a regra de neg�cio sem gerar muito impacto
	 * devido a interface possibilitar baixo acoplamento e flexibilidade.
	 */

	private LocalDate dataUltimaIndicacao;
	private LocalDate dataIndicacao;
	private int qtdIndicacaoUsuario = 0;

	@Override
	public String addIndicacoesNovosFilme(String nomeNovoFilme, String usuarioIndicou, Plataforma plataforma) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Classe para formatar o LocalDate

		this.dataIndicacao = LocalDate.now();// A data da indica��o sempre ser� a data atual

		if (dataUltimaIndicacao == null) { // L�gica criada para tratar casos onde o usu�rio ainda n�o sugeriu um filme
			this.dataUltimaIndicacao = LocalDate.now();
		}

		// Tirando a diferen�a em dias entre a data da indicao e a data da �ltima
		// indica��o
		Duration diferencaDuracao = Duration.between(dataUltimaIndicacao.atStartOfDay(), dataIndicacao.atStartOfDay());
		long qtdDiferencaDias = diferencaDuracao.toDays();

		// Se a diferen�a for menor que 31 dias e o usu�rio j� tiver feito uma
		// indica��o, ent�o n�o permite a indica��o.
		if (qtdDiferencaDias < 31 && this.qtdIndicacaoUsuario >= 1) {
			return "N�o foi poss�vel realizar a indica��o do filme " + nomeNovoFilme.toUpperCase() + "!"
					+ " Motivo: Voc� j� indicou um filme neste m�s." + " Falta(m) " + (31 - qtdDiferencaDias)
					+ " dia(s) para voc� poder fazer uma nova indica��o.\n" + "Data atual: "
					+ dtf.format(dataIndicacao.atStartOfDay()) + " - " + "Data da �ltima indica��o: "
					+ dtf.format(dataUltimaIndicacao.atStartOfDay());
		} else if (qtdDiferencaDias > 31) {
			this.qtdIndicacaoUsuario = 0;
		}

		this.dataUltimaIndicacao = this.dataIndicacao;
		this.qtdIndicacaoUsuario++;

		plataforma.getIndicacoesNovosFilmes().add("Filme indicado: " + nomeNovoFilme.toUpperCase()
				+ " - Usu�rio que indicou: " + usuarioIndicou.toUpperCase());

		return "Indica��o do filme " + nomeNovoFilme.toUpperCase()
				+ " realizada com sucesso! Muito obrigado por nos ajudar a tornar"
				+ " a DevInFlix na melhor plataforma de filmes que existe!";

	}

}
