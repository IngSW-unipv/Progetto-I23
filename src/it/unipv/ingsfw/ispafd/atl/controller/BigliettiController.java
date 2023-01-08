package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
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
		
		
	}

}
