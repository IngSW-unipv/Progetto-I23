package it.unipv.ingsfw.ispafd.atl.model.utenti;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;

public class Ospite {

	private static Ospite jOspite;
	
	private Ospite() {
		
	}
	
	public static Ospite getIstance() {
		
		if(jOspite==null) {
			jOspite = new Ospite();
		}
		
		return jOspite;
		
	}
	
	public void createUtente(String nome, String cognome, String username, String password, ATLModel m) {
		
		Utente utemp = new Utente(nome,cognome,username,password);
		
		m.addUtente(utemp);
		
		//Pattern Creator: B registra A
		
	}
	
	public void login(Utente u, ATLModel m) {
		m.setLoggedUser(u);
	}
	
}
