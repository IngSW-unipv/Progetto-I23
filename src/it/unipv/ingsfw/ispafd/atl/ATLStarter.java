package it.unipv.ingsfw.ispafd.atl;

import javax.swing.JFrame;

import it.unipv.ingsfw.ispafd.atl.controller.MVCControllerFacade;
import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Biglietto;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.OspiteSingleton;
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
		
		ATLModelSingleton m = ATLModelSingleton.getIstance();
		
		MVCControllerFacade c = new MVCControllerFacade(v,m);
		
		OspiteSingleton o = OspiteSingleton.getIstance();
		
		m.setOspite(o);
		
		v.changeView(v.getMainview(), m);
		
	}
	
}
