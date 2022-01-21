package interfaces;

import plataforma.Plataforma;
import usuarios.Usuario;

public interface IndicacoesCatalogo {

	public Boolean addIndicacoesNovosFilme(String nomeNovoFilme, Usuario usuarioIndicou,
			Plataforma plataforma) throws Exception;

}
