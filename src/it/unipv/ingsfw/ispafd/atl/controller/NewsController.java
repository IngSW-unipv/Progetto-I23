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
				
				if(!checkForErrors()) {
					((Impiegato) m.getLoggedUser()).postaNews(titolo, testo, m);

					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("News postata con successo!");
					
					
				}
				
			}
			
			private boolean checkForErrors() {
				
				if(checkEmptyInput()) {
					view.getPostaNewsView().setErrorText("Errore, tutti i campi devono essere riempiti");
					return true;
				}
				
				return false;
				
			}
			
			private boolean checkEmptyInput() {
				
				if(!((isNotEmpty(titolo))&&(isNotEmpty(testo)))) {
					return true;
				}
				
				
				return false; //every input has at least 1 character
				
			}
			
			private boolean isNotEmpty(String s) {
				if(s.length()>0) {
					return true;	//return true if string is not empty
				}
				return false;
			}
			
	    	  
	    };
	    
	    view.getPostaNewsView().getInviabutton().addActionListener(postnewsenter);
		
	}
	
}
