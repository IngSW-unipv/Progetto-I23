package it.unipv.ingsfw.ispafd.atl.model.utenti;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
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
	
	public void postaNews(String titolo, String testo, ATLModel m) {
		News ntemp = new News(titolo,testo,this);
		m.addNews(ntemp);
	}
	
	
	
	
}
