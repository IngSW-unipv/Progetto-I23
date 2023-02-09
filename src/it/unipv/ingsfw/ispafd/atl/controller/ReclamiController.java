package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class ReclamiController {
	
	private static MainFrame view;
	
	public ReclamiController() {
		//nothing
	}
	
	public static void addListeners(ATLModel m, MainFrame v) {
		
		view = v;
		
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
	    view.getListaReclamiView().getIndietroButton().addActionListener(indietropageswitch);
	    
	    ActionListener postreclamoenter = new ActionListener() {
	    	private String titolo, testo;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				titolo=view.getPostaReclamiView().getInput("titolo").getText();
				testo=view.getPostaReclamiView().getInput("testo").getText();

				manageAction();
				
			}
			
			private void manageAction() {
				
				if(!checkForErrors()) {
					m.getLoggedUser().postaReclamo(titolo, testo, m);

					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Reclamo postato con successo!");
					
					
				}
				
			}
			
			private boolean checkForErrors() {
				
				if(checkEmptyInput()) {
					view.getPostaReclamiView().setErrorText("Errore, tutti i campi devono essere riempiti");
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
	    
	    view.getPostaReclamiView().getInviabutton().addActionListener(postreclamoenter);
	    
	    ActionListener listareclamipageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getListaReclamiView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getListaReclamiButton().addActionListener(listareclamipageswitch);
	    view.getSingoloReclamoView().getIndietroButton().addActionListener(listareclamipageswitch);
	    
	    ActionListener inviarispostaaction = new ActionListener() {

	    	private String id,testor;
	    	private Reclamo rtemp;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				this.id = (String) ((JComponent) e.getSource()).getClientProperty("id");
				this.rtemp = m.getReclamoById(id);
				this.testor = view.getSingoloReclamoView().getInputRisposta().getText();
				manageAction();
				
			}
			
			private void manageAction() {
			
				rtemp.setRisposta(testor,((Impiegato)m.getLoggedUser()));
				view.changeView(view.getListaReclamiView(), m);
				view.getListaReclamiView().setSuccessText("Risposta inviata correttamente!");
				
			}
	    	  
	    };
	    
	    view.getSingoloReclamoView().getInviaRispostaButton().addActionListener(inviarispostaaction);
	    
		
	}
	
	public static void updateApriListeners(ATLModel m, ArrayList<JButton> listapulsanti) {
		
		ActionListener singoloreclamopageswitch = new ActionListener() {
			
			private String id;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				this.id = (String) ((JComponent) e.getSource()).getClientProperty("id");
				manageAction();
				
			}
			
			private void manageAction() {
				m.setIdActualReclamo(id);
				view.changeView(view.getSingoloReclamoView(),m);
				
			}
	    	  
	    };
	    
	    for(JButton btemp: listapulsanti) {
	    	btemp.addActionListener(singoloreclamopageswitch);
	    }
		
	}

}
