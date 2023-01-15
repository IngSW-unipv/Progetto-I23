package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento{

	private long datatimbratura;
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		super(utenteProprietario, tipoabbonamento);
		this.datatimbratura = 0;
	}
	
	@Override
	public long getDataTimbratura() {
		return datatimbratura;
	}
	
	@Override
	public void timbra() {
		datatimbratura = System.currentTimeMillis();
	}
	
	public long getDataScadenza() {
		return datatimbratura+tipoabbonamento.getDurataInSecondi()*1000;
	}

}
