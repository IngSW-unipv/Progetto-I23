package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Responsabile;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class AutenticationController {

	public AutenticationController() {
		//nothing
	}
	
	public static void addListeners(ATLModelSingleton m, MainFrame view) {
		
		ActionListener registrationdipendentipageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getRegistrationDipendentiView(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getRegistraDipendentiButton().addActionListener(registrationdipendentipageswitch);
		
		ActionListener registrationpageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getRegistrationview(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getRegistrationButton().addActionListener(registrationpageswitch);
	    
	    ActionListener loginpageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				view.changeView(view.getLoginview(),m);
				
			}
	    	  
	    };
	    
	    view.getMainview().getLoginButton().addActionListener(loginpageswitch);
	    
	    ActionListener indietropageswitch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				view.changeView(view.getMainview(),m);
				
			}
	    	  
	    };

	    view.getRegistrationview().getIndietrobutton().addActionListener(indietropageswitch);
	    view.getLoginview().getIndietrobutton().addActionListener(indietropageswitch);
	    view.getRegistrationDipendentiView().getIndietrobutton().addActionListener(indietropageswitch);
	    
	    ActionListener logout = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				m.setLoggedUser(null);
				view.changeView(view.getMainview(),m);
				view.getMainview().setSuccessText("Logout effettuato correttamente!");
				
			}
	    	  
	    };
	    
	    view.getMainview().getLogoutButton().addActionListener(logout);
	    
	    ActionListener registrationenter = new ActionListener() {
	    	private String nome,cognome,username,password;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nome=view.getRegistrationview().getInput("nome").getText();
				cognome=view.getRegistrationview().getInput("cognome").getText();
				username=view.getRegistrationview().getInput("username").getText();
				password=view.getRegistrationview().getInput("password").getText();

				manageAction();
				
			}
			
			private void manageAction() {
				
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(nome); parameters.add(cognome); parameters.add(username); parameters.add(password);
				
				try {
					m.getOspite().creaUtente(parameters, m);
					
					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Registrazione effettuata con successo!");
				} catch(Exception e) {
					view.getRegistrationview().setErrorText(e.getMessage());
				}
				
			}
	    	  
	    };
	    
	    view.getRegistrationview().getInviabutton().addActionListener(registrationenter);
	    
	    ActionListener loginenter = new ActionListener() {
	    	private String username,password;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				username=view.getLoginview().getInput("username").getText();
				password=view.getLoginview().getInput("password").getText();

				manageAction();
				
			}
			
			private void manageAction() {
				
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(username); parameters.add(password);
				
				try {
					m.getOspite().login(parameters, m);
					
					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Login effettuato correttamente!");
				} catch(Exception e) {
					view.getLoginview().setErrorText(e.getMessage());
				}
				
			}
	    	  
	    };
	    
	    view.getLoginview().getInviabutton().addActionListener(loginenter);
	    
	    ActionListener registrationdipendentienter = new ActionListener() {
	    	private String nome,cognome,username,password,cf;
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nome=view.getRegistrationDipendentiView().getInput("nome").getText();
				cognome=view.getRegistrationDipendentiView().getInput("cognome").getText();
				username=view.getRegistrationDipendentiView().getInput("username").getText();
				password=view.getRegistrationDipendentiView().getInput("password").getText();
				cf=view.getRegistrationDipendentiView().getInput("cf").getText();
				
				manageAction();
				
			}
			
			private void manageAction() {
				
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(nome); parameters.add(cognome); parameters.add(username); parameters.add(password); parameters.add(cf);
				
				try {
					((Responsabile) m.getLoggedUser()).creaImpiegato(parameters, m);
					
					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Registrazione effettuata con successo!");
				} catch(Exception e) {
					view.getRegistrationview().setErrorText(e.getMessage());
				}
				
			}
	    	  
	    };
	    
	    view.getRegistrationDipendentiView().getInviabutton().addActionListener(registrationdipendentienter);
		
	}
	
}
