package interfaces;

import enums.GeneroFilme;

public interface GeneroMaisAssistido {
	
	public Boolean addGeneroAssistido(GeneroFilme genero);
	public GeneroFilme getGeneroMaisAssistido();

}
