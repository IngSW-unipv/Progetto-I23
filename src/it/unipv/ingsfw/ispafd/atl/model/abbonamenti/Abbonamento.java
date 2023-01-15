package it.unipv.ingsfw.ispafd.atl.model.abbonamenti;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class Abbonamento {
	
	private Utente utenteProprietario;
	protected TipoAbbonamento tipoabbonamento;
	private long data_acquisto;
	private String id;
	
	public Abbonamento(Utente utenteProprietario, TipoAbbonamento tipoabbonamento) {
		this.utenteProprietario = utenteProprietario;
		this.tipoabbonamento = tipoabbonamento;
		this.data_acquisto = System.currentTimeMillis();
		this.id = createId();
	}
	
	private String createId() {
		return data_acquisto+utenteProprietario.getUsername();
	}
	
	public String getId() {
		return id;
	}
	
	public TipoAbbonamento getTipoAbbonamento() {
		return tipoabbonamento;
	}
	
	public Utente getUtenteProprietario() {
		return utenteProprietario;
	}
	
	public long getDataAcquisto() {
		return data_acquisto;
	}
	
	public long getDataScadenza() {
		return data_acquisto+tipoabbonamento.getDurataInSecondi()*1000;
	}
	
	public boolean isExpired() {
		if(System.currentTimeMillis()>getDataScadenza()) {
			return true;
		}
		
		return false;
	}
	
	public void timbra() {
		//nothing
	}
	
	public long getDataTimbratura() {
		return -1;
	}
}
