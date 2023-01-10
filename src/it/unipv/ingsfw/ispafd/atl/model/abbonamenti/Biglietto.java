package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento{

	private long timbratura;
	
	public Biglietto(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		super(utenteProprietario, tipoabbonamento);
		this.timbratura = 0;
	}

}
