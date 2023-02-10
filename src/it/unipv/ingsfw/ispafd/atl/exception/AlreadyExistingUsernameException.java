package it.unipv.ingsfw.ispafd.atl.exception;

public class AlreadyExistingUsernameException extends Exception{
	
	private static String errorMessage = "Errore! Username già esistente";
	

	public AlreadyExistingUsernameException() {

		super(errorMessage);
		
	}
	
}
