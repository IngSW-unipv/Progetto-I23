package it.unipv.ingsfw.ispafd.atl.view.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.view.AbstractView;

public class LoginView extends AbstractFormView{
	
	private final String cardposition = "3";

	public LoginView() {
		
		super();
		
		l1.setText("Login");
		
		addInput(0,20,"username");
		addInput(1,20,"password");
		
	}
	
	public void resetLabel(ATLModelSingleton m) {
		
		errorlabel.setVisible(false);
		getInput("username").setText("");
		getInput("password").setText("");	
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
}
