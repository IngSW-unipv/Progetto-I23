package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Abbonamento {
	
	private Utente utenteProprietario;
	private double costo;
	private Tipologia tipologia;
	private Timestamp orarioDiAttivazione;
	
	public Abbonamento(Utente utenteProprietario, Tipologia tipologia) {
		this.utenteProprietario = utenteProprietario;
		
		switch(tipologia) {
			
		case ABBONAMENTO_SETTIMANALE:
			this.costo = 20;
			break;
		case ABBONAMENTO_MENSILE:
			this.costo = 68;
			break;
		case BIGLIETTO_ORDINARIO:
			this.costo = 1.20;
			break;
		}
		this.orarioDiAttivazione = Timestamp.valueOf(LocalDateTime.now());    //prende l'orario del computer
	}
	
	
}
