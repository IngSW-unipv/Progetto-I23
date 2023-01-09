package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Tipologia;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class BigliettiController {
	
	public BigliettiController() {
		//nothing
	}
	
	public static void addListeners(ATLModel m, MainFrame view) {
		
		
		ActionListener listabigliettiswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getListaBigliettiView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getBigliettiButton().addActionListener(listabigliettiswitch);
	    view.getAcquistaBigliettiView().getIndietrobutton().addActionListener(listabigliettiswitch);
	    
	    ActionListener indietropageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				view.changeView(view.getMainview(),m);
				
			}
	    	  
	    };
	    
	    view.getListaBigliettiView().getIndietrobutton().addActionListener(indietropageswitch);
	    
	    ActionListener acquistapageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				view.changeView(view.getAcquistaBigliettiView(),m);
				
			}
	    	  
	    };
	    
	    view.getListaBigliettiView().getAcquistaButton().addActionListener(acquistapageswitch);
	    
	    ActionListener combochange = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
				
			}
			
			private void manageAction() {
				String durata;
				Double costo;
				
				String selezionato;
				
				selezionato=(String) view.getAcquistaBigliettiView().getCombo().getSelectedItem();
				
				if((selezionato!=null)&&(selezionato!="")) {
					
					TipoAbbonamento temp = m.getTipoAbbonamentoByNome(selezionato);
					
					durata=temp.getDurataString();
					costo=temp.getCosto();
					
					view.getAcquistaBigliettiView().getLabelDurata().setText(durata);
					view.getAcquistaBigliettiView().getLabelCosto().setText(String.format("%.2f", costo)+"€");
					
				} else {
					view.getAcquistaBigliettiView().getLabelDurata().setText("");
					view.getAcquistaBigliettiView().getLabelCosto().setText("");
				}
				
			}
	    	  
	    };
	    
	    view.getAcquistaBigliettiView().getCombo().addActionListener(combochange);
		
	}

}
