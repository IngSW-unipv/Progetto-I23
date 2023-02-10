package it.unipv.ingsfw.ispafd.atl.test;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import it.unipv.ingsfw.ispafd.atl.exception.AlreadyExistingUsernameException;
import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.utenti.OspiteSingleton;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class MethodsReturnTests {

	@Test
	void NoDuplicatedUsernames() {
		
		ATLModelSingleton m = ATLModelSingleton.getIstance();
		
		Long timestamp = System.currentTimeMillis();
		
		String username= timestamp.toString();
		
		m.addUtente(new Utente("test","test",username,"test")); //forcing a new user withouth passing from Ospite
		
		OspiteSingleton o = OspiteSingleton.getIstance();
		
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add("test2"); parameters.add("test2"); parameters.add(username); parameters.add("test2");
		
		assertThrows(AlreadyExistingUsernameException.class,
				() -> {
					o.creaUtente(parameters, m);
				}
				
		);
		
		//Grazie a questo test mi sono effettivamente accorto di un errore: stavo passando un parametro errato
		//per la verifica dell'username già esistente in OspiteSingleton.
		//Ora l'errore è corretto
		
	}
	
}
