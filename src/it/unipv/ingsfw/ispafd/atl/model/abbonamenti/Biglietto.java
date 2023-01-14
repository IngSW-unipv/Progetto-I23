package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento{

	private long datatimbratura;
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		super(utenteProprietario, tipoabbonamento);
	}
	
	public long getDataTimbratura() {
		return datatimbratura;
	}

}
