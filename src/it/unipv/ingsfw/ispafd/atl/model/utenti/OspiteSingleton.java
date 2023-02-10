package it.unipv.ingsfw.ispafd.atl.model.utenti;

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
	
	public void createUtente(String nome, String cognome, String username, String password, ATLModelSingleton m) {
		
		Utente utemp = new Utente(nome,cognome,username,password);
		
		m.addUtente(utemp);
		
		//Pattern Creator: B registra A
		
	}
	
	public void login(Utente u, ATLModelSingleton m) {
		m.setLoggedUser(u);
	}
	
}
