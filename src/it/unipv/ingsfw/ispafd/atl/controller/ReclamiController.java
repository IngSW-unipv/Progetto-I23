package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class ReclamiController {
	
	public ReclamiController() {
		//nothing
	}
	
	public static void addListeners(ATLModel m, MainFrame view) {
		
		ActionListener postareclamipageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getPostaReclamiView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getReclamiButton().addActionListener(postareclamipageswitch);
	    
	    ActionListener indietropageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getMainview(),m);
				
			}
	    	  
	    };
	    
	    view.getPostaReclamiView().getIndietrobutton().addActionListener(indietropageswitch);
		
	}

}
