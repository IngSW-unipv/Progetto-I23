package it.unipv.ingsfw.ispafd.atl.model.reclami;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Reclamo {

	private String titolo, testo, testorisposta, id;
	private Utente utente;
	private Impiegato impiegato;
	
	public Reclamo(String titolo, String testo, Utente utente) {
		this.titolo = titolo;
		this.testo = testo;
		this.utente = utente;
		this.id = creaId();
		this.testorisposta = null;
		this.impiegato = null;
	}
	
	private String creaId() {
		return utente.getUsername()+System.currentTimeMillis();
	}
	
	private String getId() {
		return id;
	}
	
	
	
}
