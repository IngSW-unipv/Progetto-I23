package it.unipv.ingsfw.ispafd.atl.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Responsabile;
import it.unipv.ingsfw.ispafd.atl.view.MainFrame;

public class AutenticationController {

	public AutenticationController() {
		//nothing
	}
	
	public static void addListeners(ATLModel m, MainFrame view) {
		
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
	    //da migliorare (stesso listener a tre non va bene)
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
				
				if(!checkForErrors()) {
					m.getOspite().createUtente(nome, cognome, username, password, m);

					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Registrazione effettuata con successo!");
					
					
				}
				
			}
			
			private boolean checkForErrors() {
				
				if(checkEmptyInput()) {
					view.getRegistrationview().setErrorText("Errore, tutti i campi devono essere riempiti");
					return true;
				}
				
				if(m.checkUsernameAlreadyExist(username)) {
					view.getRegistrationview().setErrorText("Errore, l'username scelto è già in uso");
					return true;
				}
				
				return false;
				
			}
			
			private boolean checkEmptyInput() {
				
				if(!((isNotEmpty(nome))&&(isNotEmpty(cognome))&&(isNotEmpty(username))&&(isNotEmpty(password)))) {
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
				
				if(!checkForErrors()) {
					
					Utente utemp=checkCredentials();
					
					if(utemp!=null) {
						m.getOspite().login(utemp, m);;
						
						view.changeView(view.getMainview(),m);
						view.getMainview().setSuccessText("Login effettuato correttamente!");
					} else {
						view.getLoginview().setErrorText("Credenziali errate");
					}
					
				}
				
			}
			
			private boolean checkForErrors() {
				
				if(checkEmptyInput()) {
					view.getLoginview().setErrorText("Errore, tutti i campi devono essere riempiti");
					return true;
				}
				
				return false;
				
			}
			
			private boolean checkEmptyInput() {
				
				if(!((isNotEmpty(username))&&(isNotEmpty(password)))) {
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
			
			private Utente checkCredentials() {
				
				ArrayList<Utente> utenti = m.getUtentiArray();
				Utente ureturn = null;
				
				for(Utente u: utenti) {
					if((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
						ureturn=u;
						break;
					}
				}
				
				return ureturn;
				
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
				
				if(!checkForErrors()) {
					
					((Responsabile) m.getLoggedUser()).createImpiegato(nome,cognome,username,password,cf,m);

					view.changeView(view.getMainview(),m);
					view.getMainview().setSuccessText("Registrazione effettuata con successo!");
					
					
				}
				
			}
			
			private boolean checkForErrors() {
				
				if(checkEmptyInput()) {
					view.getRegistrationDipendentiView().setErrorText("Errore, tutti i campi devono essere riempiti");
					return true;
				}
				
				if(m.checkUsernameAlreadyExist(username)) {
					view.getRegistrationDipendentiView().setErrorText("Errore, l'username scelto è già in uso");
					return true;
				}
				
				return false;
				
			}
			
			private boolean checkEmptyInput() {
				
				if(!((isNotEmpty(nome))&&(isNotEmpty(cognome))&&(isNotEmpty(username))&&(isNotEmpty(password))&&(isNotEmpty(cf)))) {
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
	    
	    view.getRegistrationDipendentiView().getInviabutton().addActionListener(registrationdipendentienter);
		
	}
	
}
