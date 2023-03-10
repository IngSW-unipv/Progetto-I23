package it.unipv.ingsfw.ispafd.atl.model.utenti;

import java.util.ArrayList;
import java.util.List;

import it.unipv.ingsfw.ispafd.atl.exception.EmptyParametersException;
import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Biglietto;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;

public class Utente {

	private String nome, cognome, username, password;

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
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
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
	
	public void acquistaAbbonamento(Utente utenteProprietario, TipoAbbonamento tipoabbonamento, ATLModelSingleton m) {
		
		Abbonamento a;
		
		if(tipoabbonamento.getIsAbbonamento()==true) {
			a = new Abbonamento(utenteProprietario, tipoabbonamento);
		} else {
			a = new Biglietto(utenteProprietario, tipoabbonamento);
		}
		
		m.addAbbonamento(a);
		
	}
	
	public void postaReclamo(ArrayList<String> parameters, ATLModelSingleton m) throws Exception {
		
		for(String s: parameters) {
			if(s.length()==0) {
				throw new EmptyParametersException();
			}
		}
		
		Reclamo rtemp = new Reclamo(parameters.get(0),parameters.get(1),this);
		m.addReclamo(rtemp);
	}
	
	
}
