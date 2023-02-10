package it.unipv.ingsfw.ispafd.atl.model.utenti;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;

public class Responsabile extends Impiegato{

	public Responsabile(String nome, String cognome, String username, String password, String cf) {
		super(nome, cognome, username, password, cf);
	}
	
	public void createImpiegato(String nome, String cognome, String username, String password, String cf, ATLModelSingleton m) {
		Impiegato itemp = new Impiegato(nome,cognome,username,password,cf);
		
		m.addUtente(itemp);

	}
	
	@Override
	public boolean isResponsabile() {
		return true;
	}
	
	@Override
	public boolean isDipendente() {
		return true;
	}
	
}
