package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Abbonamento {
	
	private Utente utenteProprietario;
	private double costo;
	private Validità validita;
	private Timestamp orarioDiAttivazione;
	
	public Abbonamento(Utente utenteProprietario, Validità validita) {
		this.utenteProprietario = utenteProprietario;
		
		switch(validita) {
			
		case SETTIMANALE:
			this.costo = 20;
			break;
		case MENSILE:
			this.costo = 68;
			break;
		case NOVANTA_MINUTI:
			this.costo = 1.20;
			break;
		}
		this.orarioDiAttivazione = Timestamp.valueOf(LocalDateTime.now());    //prende l'orario del computer
	}
	
	
}
