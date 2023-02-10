package it.unipv.ingsfw.ispafd.atl.view.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.view.AbstractView;

public abstract class AbstractFormView extends AbstractView implements IFormView{
	
	protected JButton inviabutton;
	protected JButton indietrobutton;
	
	protected JLabel errorlabel;
	
	protected GridBagConstraints c;
	protected JPanel inputpanel;
	protected JLabel l1;
	protected JPanel centerpanel;
	
	protected Map<String,JTextField> inputs;
	
	public AbstractFormView() {
		
		inputs = new HashMap<String,JTextField>();
		
		this.setLayout(new BorderLayout());
		
		l1 = new JLabel("", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		JPanel pl1 = new JPanel(new BorderLayout());
		pl1.add(l1,BorderLayout.CENTER);
		
		centerpanel = new JPanel(new BorderLayout());
		
		inputpanel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		
		errorlabel = new JLabel("Error Message", SwingConstants.CENTER);
		errorlabel.setForeground(Color.RED);
		errorlabel.setFont(new Font("", Font.PLAIN, 25));
		errorlabel.setVisible(false);
		
		
		centerpanel.add(errorlabel,BorderLayout.SOUTH);
		centerpanel.add(inputpanel,BorderLayout.CENTER);
		
		this.add(centerpanel,BorderLayout.CENTER);
		
		
		JPanel inviabuttonpanel = new JPanel(new BorderLayout());
		inviabutton = new JButton("Invia");
		inviabuttonpanel.add(inviabutton,BorderLayout.CENTER);

		indietrobutton = new JButton("← Indietro");
		inviabuttonpanel.add(indietrobutton,BorderLayout.WEST);
		
		this.add(pl1,BorderLayout.NORTH);
		this.add(inviabuttonpanel,BorderLayout.SOUTH);
		
	}
	
	public void setErrorText(String s) {
		errorlabel.setVisible(true);
		errorlabel.setText(s);
	}
	
	public JButton getInviabutton() {
		return inviabutton;
	}
	
	
	public JButton getIndietrobutton() {
		return indietrobutton;
	}
	
	protected void addInput(int y, int size, String nome) {
		
		JTextField temptext=null;
		
		if(nome.equals("password")) {
			temptext = new JPasswordField(size);
		} else {
			temptext = new JTextField(size);
		}
		
		c.gridx = 0;
		c.gridy = y;
		JLabel l = new JLabel(nome.substring(0, 1).toUpperCase() + nome.substring(1));
		inputpanel.add(l,c);
		
		c.gridx = 1;
		inputpanel.add(temptext,c);
		
		inputs.put(nome, temptext);
		
	}
	
	public JTextField getInput(String s) {
		
		return inputs.get(s);
		
	}

}
