package filmes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import interfaces.IndicacoesCatalogo;
import plataforma.Plataforma;

public class IndicacoesMelhorCatalogoPlus implements IndicacoesCatalogo {

	/*
	 * Usuários estão indicando muitos filmes para a plataforma e a mesma não possui
	 * recursos para adquirir tanto filmes, então foi definido que temporariamente
	 * será possível indicar apenas um filme por mês. Sendo assim foi criada uma
	 * interface que possibilita mudar a regra de negócio sem gerar muito impacto
	 * devido a interface possibilitar baixo acoplamento e flexibilidade.
	 */

	private LocalDate dataUltimaIndicacao;
	private LocalDate dataIndicacao;
	private int qtdIndicacaoUsuario = 0;

	@Override
	public String addIndicacoesNovosFilme(String nomeNovoFilme, String usuarioIndicou, Plataforma plataforma) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Classe para formatar o LocalDate

		this.dataIndicacao = LocalDate.now();// A data da indicação sempre será a data atual

		if (dataUltimaIndicacao == null) { // Lógica criada para tratar casos onde o usuário ainda não sugeriu um filme
			this.dataUltimaIndicacao = LocalDate.now();
		}

		// Tirando a diferença em dias entre a data da indicao e a data da última
		// indicação
		Duration diferencaDuracao = Duration.between(dataUltimaIndicacao.atStartOfDay(), dataIndicacao.atStartOfDay());
		long qtdDiferencaDias = diferencaDuracao.toDays();

		// Se a diferença for menor que 31 dias e o usuário já tiver feito uma
		// indicação, então não permite a indicação.
		if (qtdDiferencaDias < 31 && this.qtdIndicacaoUsuario >= 1) {
			return "Não foi possível realizar a indicação do filme " + nomeNovoFilme.toUpperCase() + "!"
					+ " Motivo: Você já indicou um filme neste mês." + " Falta(m) " + (31 - qtdDiferencaDias)
					+ " dia(s) para você poder fazer uma nova indicação.\n" + "Data atual: "
					+ dtf.format(dataIndicacao.atStartOfDay()) + " - " + "Data da última indicação: "
					+ dtf.format(dataUltimaIndicacao.atStartOfDay());
		} else if (qtdDiferencaDias > 31) {
			this.qtdIndicacaoUsuario = 0;
		}

		this.dataUltimaIndicacao = this.dataIndicacao;
		this.qtdIndicacaoUsuario++;

		plataforma.getIndicacoesNovosFilmes().add("Filme indicado: " + nomeNovoFilme.toUpperCase()
				+ " - Usuário que indicou: " + usuarioIndicou.toUpperCase());

		return "Indicação do filme " + nomeNovoFilme.toUpperCase()
				+ " realizada com sucesso! Muito obrigado por nos ajudar a tornar"
				+ " a DevInFlix na melhor plataforma de filmes que existe!";

	}

}
