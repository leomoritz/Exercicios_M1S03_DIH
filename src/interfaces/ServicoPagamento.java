package interfaces;

import usuarios.ContratoCliente;

public interface ServicoPagamento {
	
	public void gerarParcelaPlanoContrato(ContratoCliente contrato);
	public Boolean validaPagamentoPlanoContrato(ContratoCliente contrato);
	public Boolean processaPagamentoPlanoContrato(ContratoCliente contrato, Double pagamento);

}
