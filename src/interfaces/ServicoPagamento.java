package interfaces;

import usuarios.UsuarioAssinaturaPlano;

public interface ServicoPagamento {
	
	public Boolean gerarParcelaPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario);
	public Boolean processaPagamentoPlanoContrato(UsuarioAssinaturaPlano assinaturaUsuario);
	public Boolean verificaPendenciaFinanceira(UsuarioAssinaturaPlano assinaturaUsuario);

}
