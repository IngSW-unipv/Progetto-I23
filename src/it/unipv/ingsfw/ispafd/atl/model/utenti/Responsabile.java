package it.unipv.ingsfw.ispafd.atl.model.utenti;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.exception.*;
import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;

public class Responsabile extends Impiegato{

	public Responsabile(String nome, String cognome, String username, String password, String cf) {
		super(nome, cognome, username, password, cf);
	}
	
	public void creaImpiegato(ArrayList<String> parameters, ATLModelSingleton m) throws Exception {
		
		for(String s: parameters) {
			if(s.length()==0) {
				throw new EmptyParametersException();
			}
		}
		
		if(m.checkUsernameAlreadyExist(parameters.get(2))) {
			throw new AlreadyExistingUsernameException();
		}
		
		Utente utemp = new Impiegato(parameters.get(0),parameters.get(1),parameters.get(2),parameters.get(3),parameters.get(4));
		m.addUtente(utemp);
		
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
