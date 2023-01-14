package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

public class TipoAbbonamento {

	private String nome;
	private boolean isAbbonamento;
	private long durataminuti;
	private String duratastring;
	private Double costo;
	
	public TipoAbbonamento(String nome, boolean isAbbonamento, long durataminuti, String duratastring, Double costo) {
		this.nome=nome;
		this.isAbbonamento=isAbbonamento;
		this.durataminuti=durataminuti;
		this.duratastring=duratastring;
		this.costo=costo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDurataString() {
		return duratastring;
	}
	
	public Double getCosto() {
		return costo;
	}
	
	public boolean getIsAbbonamento() {
		return isAbbonamento;
	}
	
	public long getDurataInSecondi() {
		return durataminuti;
	}
	
	
}
