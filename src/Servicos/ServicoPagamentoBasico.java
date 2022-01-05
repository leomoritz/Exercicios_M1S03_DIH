package Servicos;

import interfaces.ServicoPagamento;
import usuarios.ContratoCliente;

public class ServicoPagamentoBasico implements ServicoPagamento {

	@Override
	public Boolean validaPagamentoPlanoContrato(ContratoCliente contrato) {
		if (contrato.getParcela() == 0.0) {
			contrato.setIsInadimplente(false);
			return true; // retorna true caso o pagamento do plano esteja OK
		}

		return false; // retorna false caso o contrato esteja inadimplente
	}

	@Override
	public Boolean processaPagamentoPlanoContrato(ContratoCliente contrato, Double valorPagamento) {

		Double valorParcela = contrato.getParcela();

		if (valorParcela == 0.0 || valorParcela == null) {
			gerarParcelaPlanoContrato(contrato);
		}

		/*
		 * Validação para nunca permitir quitar um plano se a diferença entre valor da
		 * parcela e valor pago for maior que zero ou se o valor pago for maior que o
		 * valor do plano
		 */
		if ((valorParcela - valorPagamento) > 0.0 || valorPagamento > contrato.getPlanoContratado().getPreco()) {
			return false;
		}

		contrato.setParcela(0.0); // quita o valor da parcela caso tenha passado pelas validações anteriores

		// devido a quitação da parcela, valida se o contrato está inadimplente:
		// se sim atualiza para adimplente
		if (contrato.getIsInadimplente()) {
			validaPagamentoPlanoContrato(contrato);
		}

		return true;

	}

	@Override
	public void gerarParcelaPlanoContrato(ContratoCliente contrato) {
		contrato.setParcela(contrato.getPlanoContratado().getPreco());
	}

}
