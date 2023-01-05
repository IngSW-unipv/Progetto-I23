package it.unipv.ingsfw.ispafd.atl.model;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.*;

public class ATLModel {

		private static ATLModel jATLModel;
		
		private Utente loggeduser;
		private ArrayList<Utente> utenti;
		private ArrayList<News> news;
		private Ospite ospite;
		
		
		private ATLModel() {
			this.loggeduser = null;
			this.utenti = new ArrayList<Utente>();
			this.news = new ArrayList<News>();
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
	
}
