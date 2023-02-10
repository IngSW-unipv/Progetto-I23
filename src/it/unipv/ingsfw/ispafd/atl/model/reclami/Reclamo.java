package it.unipv.ingsfw.ispafd.atl.model.reclami;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Reclamo implements IReplicabile{

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
	
	public Reclamo(String titolo, String testo, Utente utente, String id, String testorisposta, Impiegato impiegato) {
		this.titolo = titolo;
		this.testo = testo;
		this.utente = utente;
		this.id = id;
		this.testorisposta = testorisposta;
		this.impiegato = impiegato;
	}
	
	private String creaId() {
		return utente.getUsername()+System.currentTimeMillis();
	}
	
	public String getId() {
		return id;
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String getTesto() {
		return testo;
	}
	
	public Impiegato getImpiegato() {
		return impiegato;
	}
	
	public String getTestoRisposta() {
		return testorisposta;
	}
	
	public void setRisposta(String risposta, Impiegato impiegato) {
		this.testorisposta = risposta;
		this.impiegato = impiegato;
	}
	
	
}
