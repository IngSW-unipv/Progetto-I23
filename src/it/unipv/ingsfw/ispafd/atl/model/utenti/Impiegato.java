package it.unipv.ingsfw.ispafd.atl.model.utenti;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.news.News;

public class Impiegato extends Utente{

	private String cf;

	public Impiegato(String nome, String cognome, String username, String password, String cf) {
		super(nome, cognome, username, password);
		this.cf = cf;
	}
	
	@Override
	public boolean isDipendente() {
		return true;
	}
	
	@Override
	public boolean isResponsabile() {
		return false;
	}
	
	public String getCf() {
		return cf;
	}
	
	public void postaNews(ArrayList<String> parameters, ATLModelSingleton m) throws Exception {
		
		for(String s: parameters) {
			if(s.length()==0) {
				throw new Exception("Errore! Devi riempire tutti i campi");
			}
		}
		
		News ntemp = new News(parameters.get(0),parameters.get(1),this);
		m.addNews(ntemp);
	}
	
	
	
	
}
