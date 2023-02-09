package it.unipv.ingsfw.ispafd.atl.model;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.database.*;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.*;

public class ATLModel {

		private static ATLModel jATLModel;
		
		private Utente loggeduser;
		private ArrayList<Utente> utenti;
		private ArrayList<News> news;
		private Ospite ospite;
		private String idactualreclamo;
		private ArrayList<TipoAbbonamento> tipoabbonamento;
		private ArrayList<Abbonamento> abbonamenti;
		private ArrayList<Reclamo> reclami;
		
		private UtentiDAO utentidao;
		private TipoAbbonamentiDAO tipoabbonamentidao;
		private AbbonamentiDAO abbonamentidao;
		
		private ATLModel() {
			this.idactualreclamo = null;
			this.loggeduser = null;
			this.utenti = new ArrayList<Utente>();
			this.news = new ArrayList<News>();
			this.tipoabbonamento = new ArrayList<TipoAbbonamento>();
			this.abbonamenti = new ArrayList<Abbonamento>();
			this.reclami = new ArrayList<Reclamo>();
			
			utentidao = new UtentiDAO();
			tipoabbonamentidao = new TipoAbbonamentiDAO();
			abbonamentidao = new AbbonamentiDAO();
			
			popolaUtenti();
			popolaTipoAbbonamenti();
			popolaAbbonamenti();
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
		
		public void popolaUtenti() {
			ArrayList<Utente> temp=utentidao.selectUtenti();
			
			for(Utente u: temp) {
				addUtente(u);
			}
			
		}
		
		public void popolaTipoAbbonamenti() {
			ArrayList<TipoAbbonamento> temp=tipoabbonamentidao.selectTipoAbbonamenti();
			
			for(TipoAbbonamento u: temp) {
				addTipoAbbonamento(u);
			}
			
		}
		
		public void popolaAbbonamenti() {
			ArrayList<Abbonamento> temp=abbonamentidao.selectAbbonamenti(this);
			
			for(Abbonamento u: temp) {
				addAbbonamento(u);
			}
			
		}
		
		public ArrayList<Utente> getUtentiArray(){
			return utenti;
		}
		
		public Utente getUtenteByUsername(String s) {
			
			Utente uret=null;
			
			for(Utente u: utenti) {
				if(u.getUsername().equals(s)) {
					uret=u;
				}
			}
			
			return uret;
			
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
		
		public ArrayList<Reclamo> getListaReclami(){
			return reclami;
		}
		
		public void addReclamo(Reclamo r) {
			reclami.add(r);
		}
		
		public String getIdActualReclamo() {
			return idactualreclamo;
		}
		
		public void setIdActualReclamo(String s) {
			this.idactualreclamo = s;
		}
		
		public Reclamo getReclamoById(String s) {
			
			Reclamo rtemp=null;
			
			for(Reclamo r: reclami) {
				if(r.getId().equals(s)) {
					rtemp=r;
				}
			}
			
			return rtemp;
			
		}
	
}
