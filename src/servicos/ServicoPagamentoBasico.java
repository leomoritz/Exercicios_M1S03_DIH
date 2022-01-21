package servicos;

import interfaces.ServicoPagamento;
import usuarios.UsuarioAssinaturaPlano;

public class ServicoPagamentoBasico implements ServicoPagamento {

	@Override
	public Boolean gerarParcelaPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario) {

		Double precoPlano = assinaturaUsuario.getPlanoContratado().getPreco();

		if (assinaturaUsuario.getMensalidade() == null || assinaturaUsuario.getMensalidade() == 0.0) {
			assinaturaUsuario.setMensalidade(precoPlano);
			return true;
		}

		return false;
	}

	@Override
	public Boolean processaPagamentoPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario) {

		Double valorPagamento = assinaturaUsuario.getPlanoContratado().getPreco();

		if (assinaturaUsuario.getMensalidade() == 0.0) {
			return false;
		}

		if (assinaturaUsuario.getMensalidade() != valorPagamento) {
			return false;
		}

		assinaturaUsuario.setMensalidade(0.0);
		verificaPendenciaFinanceira(assinaturaUsuario);
		return true;

	}

	@Override
	public Boolean verificaPendenciaFinanceira(UsuarioAssinaturaPlano assinaturaUsuario) {

		if (assinaturaUsuario.getMensalidade() != 0.0) {
			assinaturaUsuario.setIsInadimplente(true);
		} else {
			assinaturaUsuario.setIsInadimplente(false);
		}

		return assinaturaUsuario.getIsInadimplente();

	}

}
