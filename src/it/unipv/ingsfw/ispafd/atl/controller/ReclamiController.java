package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class ReclamiController {
	
	private static MainFrame view;
	
	public ReclamiController() {
		//nothing
	}
	
	public static void addListeners(ATLModelSingleton m, MainFrame v) {
		
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
				
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(titolo); parameters.add(testo);
				
				try {
					m.getLoggedUser().postaReclamo(parameters, m);
					
					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Reclamo postato con successo!");
				} catch(Exception e) {
					view.getPostaReclamiView().setErrorText(e.getMessage());
				}
				
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
				m.setRisposta(rtemp, testor, m.getLoggedUser());
				view.changeView(view.getListaReclamiView(), m);
				view.getListaReclamiView().setSuccessText("Risposta inviata correttamente!");
			}
	    	  
	    };
	    
	    view.getSingoloReclamoView().getInviaRispostaButton().addActionListener(inviarispostaaction);
	    
		
	}
	
	public static void updateApriListeners(ATLModelSingleton m, ArrayList<JButton> listapulsanti) {
		
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
