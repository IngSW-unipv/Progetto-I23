package it.unipv.ingsfw.ispafd.atl.model.utenti;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleTone;

public class OspiteSingleTone {

	private static OspiteSingleTone jOspite;
	
	private OspiteSingleTone() {
		
	}
	
	public static OspiteSingleTone getIstance() {
		
		if(jOspite==null) {
			jOspite = new OspiteSingleTone();
		}
		
		return jOspite;
		
	}
	
	public void createUtente(String nome, String cognome, String username, String password, ATLModelSingleTone m) {
		
		Utente utemp = new Utente(nome,cognome,username,password);
		
		m.addUtente(utemp);
		
		//Pattern Creator: B registra A
		
	}
	
	public void login(Utente u, ATLModelSingleTone m) {
		m.setLoggedUser(u);
	}
	
}
