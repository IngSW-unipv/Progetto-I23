package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;

public class AcquistaBigliettiView extends AbstractView{
	
	private final String cardposition = "8";
	
	private JButton indietrobutton;
	private JButton inviabutton;
	
	private JLabel labeldurata, labelcosto, errorlabel;
	
	private JPanel centerpanel;
	
	private JTextField inputcarta;
	
	private JComboBox<String> combo;
	
	private GridBagConstraints c;
	
	public AcquistaBigliettiView() {
		
		super();
		
		this.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("Acquista Biglietto/Abbonamento", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		JPanel pl1 = new JPanel(new BorderLayout());
		pl1.add(l1,BorderLayout.CENTER);

		
		c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		centerpanel = new JPanel(new GridBagLayout());
		JLabel l2 = new JLabel("Oggetto");
		
	    c.gridx = 0;
		c.gridy = 0;
		centerpanel.add(l2,c);
		
		
		
		combo = new JComboBox<String>();
		c.gridx = 1;
		centerpanel.add(combo,c);
		
		c.gridx = 0;
		c.gridy = 1;
		JLabel l3 = new JLabel("Durata: ");
		centerpanel.add(l3,c);
		labeldurata = new JLabel("");
		c.gridx = 1;
		centerpanel.add(labeldurata,c);
		
		c.gridx = 0;
		c.gridy = 2;
		JLabel l4 = new JLabel("Costo: ");
		centerpanel.add(l4,c);
		labelcosto = new JLabel("");
		c.gridx = 1;
		centerpanel.add(labelcosto,c);
		
		
		c.gridx = 0;
		c.gridy = 5;
		inputcarta = new JTextField(20);
		JLabel l5 = new JLabel("Numero Carta");
		centerpanel.add(l5,c);
		c.gridx = 1;
		centerpanel.add(inputcarta,c);
		
		
		errorlabel = new JLabel("Error Message", SwingConstants.CENTER);
		errorlabel.setForeground(Color.RED);
		errorlabel.setFont(new Font("", Font.PLAIN, 25));
		errorlabel.setVisible(false);
		
		indietrobutton = new JButton("← Indietro");
		JPanel downbuttonpanel = new JPanel(new BorderLayout());
		downbuttonpanel.add(indietrobutton, BorderLayout.WEST);
		inviabutton = new JButton("Acquista");
		downbuttonpanel.add(inviabutton, BorderLayout.CENTER);
		downbuttonpanel.add(errorlabel, BorderLayout.NORTH);
		
		this.add(centerpanel, BorderLayout.CENTER);
		this.add(downbuttonpanel, BorderLayout.SOUTH);
		this.add(pl1, BorderLayout.NORTH);
		
		
	}
	
	public void resetLabel(ATLModel m) {
		inputcarta.setText("");
		
		errorlabel.setVisible(false);
		
		if(combo.getItemCount()==0) {
		
			ArrayList<TipoAbbonamento> tarray = m.getTipoAbbonamentoArray();
			
			combo.addItem("");
			
			for(TipoAbbonamento t: tarray) {
				combo.addItem(t.getNome());
			}
		
		}else {
			combo.setSelectedItem("");
		}
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietrobutton() {
		return indietrobutton;
	}
	
	public JLabel getLabelCosto() {
		return labelcosto;
	}
	
	public JLabel getLabelDurata() {
		return labeldurata;
	}
	
	public JTextField getInputCarta() {
		return inputcarta;
	}
	
	public JButton getInviaButton() {
		return inviabutton;
	}
	
	public JComboBox<String> getCombo(){
		return combo;
	}
	
	public void setErrorText(String s) {
		errorlabel.setVisible(true);
		errorlabel.setText(s);
	}

}
