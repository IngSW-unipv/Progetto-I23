package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento{

	private long datatimbratura;
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		super(utenteProprietario, tipoabbonamento);
		this.datatimbratura = 0;
	}
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento, long data_acquisto) {
		super(utenteProprietario, tipoabbonamento, data_acquisto);
		this.datatimbratura = 0;
	}
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento, long data_acquisto, long datatimbratura) {
		super(utenteProprietario, tipoabbonamento, data_acquisto);
		this.datatimbratura = datatimbratura;
	}
	
	@Override
	public long getDataTimbratura() {
		return datatimbratura;
	}
	
	@Override
	public void timbra() {
		datatimbratura = System.currentTimeMillis();
	}
	
	public void setDataTimbratura(Long d) {
		datatimbratura = d;
	}
	
	public long getDataScadenza() {
		return datatimbratura+tipoabbonamento.getDurataInSecondi()*1000;
	}

}
