package it.unipv.ingsfw.ispafd.atl;

import javax.swing.JFrame;

import it.unipv.ingsfw.ispafd.atl.controller.MVCController;
import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Ospite;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Responsabile;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class ATLStarter {

	public ATLStarter() {
		//nothing
	}
	
	public static void main(String[] args) {
		
		MainFrame v = new MainFrame();
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setVisible(true);
		
		ATLModel m = ATLModel.getIstance();
		
		MVCController c = new MVCController(v,m);
		
		Ospite o = Ospite.getIstance();
		
		m.setOspite(o);
		
		//testing
		
		Responsabile r = new Responsabile("fede","spat","fedespat","aaa","hkdfjghd");
		Utente u = new Utente("prova","abc","a","a");
		Impiegato i = new Impiegato("paolo","luc","lucche","aaa","fsgr");
		
		m.addUtente(r);
		m.addUtente(u);
		m.addUtente(i);
		
		m.setLoggedUser(i);
		
		m.addNews(new News("Cambio fermate Stazione di Rogoredo","Abbiamo cambiato le fermate alla stazione di rogoredo: da Alessandria a Sestri Levante e da Milano a Pavia",i));
		
		m.addNews(new News("Aumento Costo Biglietti","Dal 9 novembre sarà aumentato il costo di tutti i biglietti e abbonamenti della linea Milano-Pavia perchè siamo molto cattivi sssssssssssssssdddddddd",i));
		
		m.addNews(new News("News di Test 1","Questa è una news solo per testing dello scrollpane",i));
		
		m.addNews(new News("News di Test 2","Questa è una news solo per testing dello scrollpane",i));
		
		m.addNews(new News("News di Test 3","Questa è una news solo per testing dello scrollpane",i));
		
		//fine testing
		
		
		v.changeView(v.getMainview(), m);
		
	}
	
}
