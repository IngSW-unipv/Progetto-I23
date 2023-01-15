package it.unipv.ingsfw.ispafd.atl.model;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.*;

public class ATLModel {

		private static ATLModel jATLModel;
		
		private Utente loggeduser;
		private ArrayList<Utente> utenti;
		private ArrayList<News> news;
		private Ospite ospite;
		private ArrayList<TipoAbbonamento> tipoabbonamento;
		private ArrayList<Abbonamento> abbonamenti;
		
		private ATLModel() {
			this.loggeduser = null;
			this.utenti = new ArrayList<Utente>();
			this.news = new ArrayList<News>();
			this.tipoabbonamento = new ArrayList<TipoAbbonamento>();
			this.abbonamenti = new ArrayList<Abbonamento>();
		}
		
		public static ATLModel getIstance() {
			
			if(jATLModel==null) {
				jATLModel = new ATLModel();
			}
			
			return jATLModel;
			
		}
		
		public void addUtente(Utente u) {
			utenti.add(u);
		}
		
		public ArrayList<Utente> getUtentiArray(){
			return utenti;
		}
		
		public void setLoggedUser(Utente u) {
			this.loggeduser=u;
		}
		
		public Utente getLoggedUser() {
			return loggeduser;
		}
		
		public Ospite getOspite() {
			return ospite;
		}
		
		public void setOspite(Ospite o) {
			this.ospite=o;
		}
		
		public boolean checkUsernameAlreadyExist(String username) {
			
			boolean result=false;
			
			for(Utente u: utenti) {
				if(u.getUsername().equals(username)) {
					result = true; //username already exist
					break;
				}
			}
			
			return result;
			
		}
		
		public void addNews(News n) {
			news.add(n);
		}
		
		public ArrayList<News> getNewsArray(){
			return news;
		}
		
		public ArrayList<TipoAbbonamento> getTipoAbbonamentoArray() {
			return tipoabbonamento;
		}
		
		public void addTipoAbbonamento(TipoAbbonamento t) {
			tipoabbonamento.add(t);
		}
		
		public TipoAbbonamento getTipoAbbonamentoByNome(String nome) {
			
			TipoAbbonamento ret = null;
			
			for(TipoAbbonamento t: tipoabbonamento) {
				if(t.getNome().equals(nome)) {
					ret = t;
				}
			}
			
			return ret;
		}
		
		public ArrayList<Abbonamento> getAbbonamentiArray(){
			return abbonamenti;
		}
		
		public void addAbbonamento(Abbonamento a) {
			abbonamenti.add(a);
		}
		
		public Abbonamento getAbbonamentoById(String s) {
			
			Abbonamento atemp=null;
			
			for(Abbonamento a: abbonamenti) {
				if(a.getId().equals(s)) {
					atemp=a;
				}
			}
			
			return atemp;
			
		}
	
}
