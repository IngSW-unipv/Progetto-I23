package it.unipv.ingsfw.ispafd.atl.model.utenti;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;

public class OspiteSingleton {

	private static OspiteSingleton jOspite;
	
	private OspiteSingleton() {
		
	}
	
	public static OspiteSingleton getIstance() {
		
		if(jOspite==null) {
			jOspite = new OspiteSingleton();
		}
		
		return jOspite;
		
	}
	
	public void creaUtente(ArrayList<String> parameters, ATLModelSingleton m) throws Exception {
		
		for(String s: parameters) {
			if(s.length()==0) {
				throw new Exception("Errore! Devi riempire tutti i campi");
			}
		}
		
		if(m.checkUsernameAlreadyExist(parameters.get(3))) {
			throw new Exception("Errore! Username già in uso");
		}
		
		Utente utemp = new Utente(parameters.get(0),parameters.get(1),parameters.get(2),parameters.get(3));
		m.addUtente(utemp);
		
	}
	
	public void login(ArrayList<String> parameters, ATLModelSingleton m) throws Exception {
		
		for(String s: parameters) {
			if(s.length()==0) {
				throw new Exception("Errore! Devi riempire tutti i campi");
			}
		}
		
		Utente u = m.checkCredentials(parameters.get(0),parameters.get(1));
		
		if(u==null) {
			throw new Exception("Errore! Credenziali Errate");
		}
		
		m.setLoggedUser(u);
	}
	
}
