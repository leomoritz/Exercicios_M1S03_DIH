package servicos;

import java.time.LocalDate;

import interfaces.ServicoPagamento;
import usuarios.UsuarioAssinaturaPlano;

/**
 * Esta classe foi criada com uma implementação do exercício 9
 * 
 * @author Leônidas Moritz Rosa
 *
 */

public class ServicoPagamentoOld implements ServicoPagamento {

	@Override
	public Boolean processaPagamentoPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario) {

		Double valorPagamento = assinaturaUsuario.getPlanoContratado().getPreco();

		if (gerarParcelaPlanoContrato(assinaturaUsuario)) {

			if (assinaturaUsuario.getMensalidade() == valorPagamento) {
				assinaturaUsuario.setMensalidade(0.0);
				assinaturaUsuario.setIsInadimplente(false);
				return true;
			}

			assinaturaUsuario.setIsInadimplente(true);

		}

		return false;

	}

	@Override
	public Boolean gerarParcelaPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario) {

		
		Double precoPlano = assinaturaUsuario.getPlanoContratado().getPreco();
		LocalDate dataVencimentoMensalidade = assinaturaUsuario.getDataVencimentoMensalidade();
		LocalDate dataAtual = LocalDate.now();

		if (assinaturaUsuario.getMensalidade() == null || assinaturaUsuario.getMensalidade() == 0.0) {

			if (dataVencimentoMensalidade == null || dataAtual.isAfter(dataVencimentoMensalidade)) {
				assinaturaUsuario.setMensalidade(precoPlano);
				assinaturaUsuario.setDataVencimentoMensalidade(dataAtual.plusMonths(1));
				return true;
			}
		}
		return false;

	}

	@Override
	public Boolean verificaPendenciaFinanceira(UsuarioAssinaturaPlano assinaturaUsuario) {

		processaPagamentoPlanoContrato(assinaturaUsuario);

		if (assinaturaUsuario.getIsInadimplente()) {
			return true;
		}

		return false;
	}

}
