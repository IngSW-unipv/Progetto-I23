package it.unipv.ingsfw.ispafd.atl.view.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.view.AbstractView;

public class RegistrationView extends AbstractFormView{
	
	private final String cardposition = "2";

	public RegistrationView() {
		
		super();
		
		l1.setText("Registrazione");
		
		addInput(0,20,"nome");
		addInput(1,20,"cognome");
		addInput(2,20,"username");
		addInput(3,20,"password");
		
		
	}
	
	public void resetLabel(ATLModelSingleton m) {
		
		errorlabel.setVisible(false);
		getInput("nome").setText("");
		getInput("cognome").setText("");
		getInput("username").setText("");
		getInput("password").setText("");	
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}

	
	
}
