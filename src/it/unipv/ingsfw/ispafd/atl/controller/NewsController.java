package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class NewsController {

	public NewsController() {
		//nothing
	}
	
	public static void addListeners(ATLModelSingleton m, MainFrame view) {
		
		ActionListener postanewspageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getPostaNewsView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getPostaNewsButton().addActionListener(postanewspageswitch);
	    
	    ActionListener indietropageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				view.changeView(view.getMainview(),m);
				
			}
	    	  
	    };
	    
	    view.getPostaNewsView().getIndietrobutton().addActionListener(indietropageswitch);
	    view.getNewsListView().getIndietrobutton().addActionListener(indietropageswitch);
	    
	    ActionListener listanewspageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getNewsListView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getNewsButton().addActionListener(listanewspageswitch);
	    
	    ActionListener postnewsenter = new ActionListener() {
	    	private String titolo, testo;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				titolo=view.getPostaNewsView().getInput("titolo").getText();
				testo=view.getPostaNewsView().getInput("testo").getText();

				manageAction();
				
			}
			
			private void manageAction() {
				
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(titolo); parameters.add(testo);
				
				try {
					((Impiegato) m.getLoggedUser()).postaNews(parameters, m);
					
					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("News postata con successo!");
				} catch(Exception e) {
					view.getPostaNewsView().setErrorText(e.getMessage());
				}
				
			}			
	    	  
	    };
	    
	    view.getPostaNewsView().getInviabutton().addActionListener(postnewsenter);
		
	}
	
}
