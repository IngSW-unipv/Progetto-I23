package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Tipologia;

public class AcquistaBigliettiView extends AbstractView{
	
	private final String cardposition = "8";
	
	private JButton indietrobutton;
	private JButton inviabutton;
	
	private JLabel labeldurata, labelcosto;
	
	private JTextField inputcarta;
	
	public AcquistaBigliettiView() {
		
		super();
		
		this.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("Acquista Biglietto/Abbonamento", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		JPanel pl1 = new JPanel(new BorderLayout());
		pl1.add(l1,BorderLayout.CENTER);

		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		JPanel centerpanel = new JPanel(new GridBagLayout());
		JLabel l2 = new JLabel("Oggetto");
		
		Tipologia[] choices = {null,Tipologia.BIGLIETTO_ORDINARIO, Tipologia.ABBONAMENTO_SETTIMANALE,Tipologia.ABBONAMENTO_MENSILE};
		
	    JComboBox<Tipologia> combo = new JComboBox<Tipologia>(choices);
	    c.gridx = 0;
		c.gridy = 0;
		centerpanel.add(l2,c);
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
		
		
		indietrobutton = new JButton("← Indietro");
		JPanel downbuttonpanel = new JPanel(new BorderLayout());
		downbuttonpanel.add(indietrobutton, BorderLayout.WEST);
		inviabutton = new JButton("Acquista");
		downbuttonpanel.add(inviabutton, BorderLayout.CENTER);
		
		this.add(centerpanel, BorderLayout.CENTER);
		this.add(downbuttonpanel, BorderLayout.SOUTH);
		this.add(pl1, BorderLayout.NORTH);
		
		
	}
	
	public void resetLabel(ATLModel m) {
		
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

}
