package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Biglietto extends Abbonamento{

	public Biglietto(Utente utenteProprietario, Tipologia validita) {
		super(utenteProprietario, validita);
		
	}

}
