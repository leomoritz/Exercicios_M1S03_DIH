package enums;

public enum GeneroFilme {
	
	ACAO(1),
	ANIMACAO(2),
	AVENTURA(3),
	COMEDIA(4),
	DANCA(5),
	DOCUMENTARIO(6),
	DRAMA(7),
	FAROESTE(8),
	FANTASIA(9),
	FICCAO_CIENTIFICA(10),
	GUERRA(11),
	MUSICAL(12),
	POLICIAL(13),
	ROMANCE(14),
	SUSPENSE(15),
	TERROR(16);
	
	private int id;
	private int coutplus = 0;
	
	GeneroFilme(int id){
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getCountPlus() {
		return this.coutplus;
	}
	
	public void setCountPlus(int countplus) {
		this.coutplus = countplus;
	}
}
