package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento implements ITimbrabile{

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
	
	public void timbra() {
		datatimbratura = System.currentTimeMillis();
	}
	
	public long getDataScadenza() {
		return datatimbratura+tipoabbonamento.getDurataInSecondi()*1000;
	}

}
