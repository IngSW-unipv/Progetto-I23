package it.unipv.ingsfw.ispafd.atl.view.form;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;

public class RegistrationDipendentiView extends AbstractFormView{

	private final String cardposition = "4";
	
	public RegistrationDipendentiView() {
		
		super();
		
		l1.setText("Registrazione Dipendenti");
		
		addInput(0,20,"nome");
		addInput(1,20,"cognome");
		addInput(2,20,"username");
		addInput(3,20,"password");
		addInput(4,20,"cf");
		
	}
	
	public void resetLabel(ATLModel m) {
		
		errorlabel.setVisible(false);
		getInput("nome").setText("");
		getInput("cognome").setText("");
		getInput("username").setText("");
		getInput("password").setText("");
		getInput("cf").setText("");
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
}
