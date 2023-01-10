package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Abbonamento {
	
	private Utente utenteProprietario;
	private TipoAbbonamento tipoabbonamento;
	private long data_acquisto;
	
	public Abbonamento(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		this.utenteProprietario = utenteProprietario;
		this.tipoabbonamento = tipoabbonamento;
		this.data_acquisto = System.currentTimeMillis();
	}
	
	
}
