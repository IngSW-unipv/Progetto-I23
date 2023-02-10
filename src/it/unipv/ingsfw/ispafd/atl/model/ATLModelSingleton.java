package it.unipv.ingsfw.ispafd.atl.model;

import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.database.*;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Biglietto;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.*;

public class ATLModelSingleton {

		private static ATLModelSingleton jATLModel;
		
		private Utente loggeduser;
		private ArrayList<Utente> utenti;
		private ArrayList<News> news;
		private OspiteSingleton ospite;
		private String idactualreclamo;
		private ArrayList<TipoAbbonamento> tipoabbonamento;
		private ArrayList<Abbonamento> abbonamenti;
		private ArrayList<Reclamo> reclami;
		
		private UtentiDAO utentidao;
		private TipoAbbonamentiDAO tipoabbonamentidao;
		private AbbonamentiDAO abbonamentidao;
		private NewsDAO newsdao;
		private ReclamiDAO reclamidao;
		
		private ATLModelSingleton() {
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
			newsdao = new NewsDAO();
			reclamidao = new ReclamiDAO();
			
			popolaUtenti();
			popolaTipoAbbonamenti();
			popolaAbbonamenti();
			popolaNews();
			popolaReclami();
		}
		
		public static ATLModelSingleton getIstance() {
			
			if(jATLModel==null) {
				jATLModel = new ATLModelSingleton();
			}
			
			return jATLModel;
			
		}
		
		public void addUtente(Utente u) {
			utenti.add(u);
			utentidao.insertUtente(u);
		}
		
		public void popolaUtenti() {
			ArrayList<Utente> temp=utentidao.selectUtenti();
			
			for(Utente u: temp) {
				utenti.add(u);
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
				abbonamenti.add(u);
			}
			
		}
		
		public void popolaNews() {
			ArrayList<News> temp=newsdao.selectNews(this);
			
			for(News u: temp) {
				news.add(u);
			}
			
		}
		
		public void popolaReclami() {
			ArrayList<Reclamo> temp=reclamidao.selectReclami(this);
			
			for(Reclamo u: temp) {
				reclami.add(u);
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
		
		public Utente checkCredentials(String username, String password) {
			
			Utente ureturn = null;
			
			for(Utente u: utenti) {
				if((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
					ureturn=u;
					break;
				}
			}
			
			return ureturn;
			
		}
		
		public void setLoggedUser(Utente u) {
			this.loggeduser=u;
		}
		
		public Utente getLoggedUser() {
			return loggeduser;
		}
		
		public OspiteSingleton getOspite() {
			return ospite;
		}
		
		public void setOspite(OspiteSingleton o) {
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
			newsdao.insertNews(n);
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
			abbonamentidao.insertAbbonamento(a);
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
		
		public void timbraBiglietto(Biglietto b) {
			b.timbra();
			abbonamentidao.updateTimbratura(b.getId(), b.getDataTimbratura());
		}
		
		public ArrayList<Reclamo> getReclamiArray(){
			return reclami;
		}
		
		public void addReclamo(Reclamo r) {
			reclami.add(r);
			reclamidao.insertReclamo(r);
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
		
		public void setRisposta(Reclamo r, String testo, Utente u) {
			r.setRisposta(testo, (Impiegato)u);
			reclamidao.updateRisposta(r.getId(), testo, u.getUsername());
		}
	
}
