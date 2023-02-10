package it.unipv.ingsfw.ispafd.atl.exception;

public class EmptyParametersException extends Exception{

	private static String errorMessage = "Errore! Devi riempire tutti i campi";
	
	public EmptyParametersException() {
		
		super(errorMessage);
		
	}
	
}
