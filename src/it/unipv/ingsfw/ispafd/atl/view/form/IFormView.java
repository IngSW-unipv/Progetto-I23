package it.unipv.ingsfw.ispafd.atl.view.form;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface IFormView {

	public JButton getInviabutton();
	
	public JButton getIndietrobutton();
	
	public void setErrorText(String s);
	
	//public JTextField getInput(); //map che da gli input ...
	
}
