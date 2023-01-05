package it.unipv.ingsfw.ispafd.atl.model.utenti;

import java.util.List;

import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Biglietto;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Validità;

public class Utente {

	private String nome, cognome, username, password;
	private List<Abbonamento> abbonamenti; //Dora
	

	public Utente(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isResponsabile() {
		return false;
	}
	
	public boolean isDipendente() {
		return false;
	}
	
	//Dora 
	
	public void acquistaAbbonamento(Validità validita) {
		
		Abbonamento ab= new Abbonamento(this, validita);
		abbonamenti.add(ab);
		
	}
	public void acquistaBiglietto() {
		Biglietto b = new Biglietto(this, Validità.NOVANTA_MINUTI);
		abbonamenti.add(b);
	}
	
	
}
