package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;

public class ListaBigliettiView extends AbstractView{

	private final String cardposition = "7";
	
	private JButton indietrobutton;
	private JButton acquistabutton;
	
	private JLabel successlabel;
	
	public ListaBigliettiView() {
		
		super();
		
		this.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("Lista Biglietti/Abbonamenti", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		JPanel pl1 = new JPanel(new BorderLayout());
		pl1.add(l1,BorderLayout.CENTER);
		acquistabutton = new JButton("Acquista");
		pl1.add(acquistabutton, BorderLayout.EAST);
		
		indietrobutton = new JButton("← Indietro");
		JPanel downbuttonpanel = new JPanel(new BorderLayout());
		downbuttonpanel.add(indietrobutton, BorderLayout.WEST);
		
		successlabel = new JLabel("", SwingConstants.CENTER);
		successlabel.setForeground(Color.GREEN);
		successlabel.setFont(new Font("", Font.PLAIN, 25));
		successlabel.setVisible(false);
		
		downbuttonpanel.add(successlabel, BorderLayout.NORTH);
		
		this.add(downbuttonpanel, BorderLayout.SOUTH);
		this.add(pl1, BorderLayout.NORTH);
		
	}
	
	
	public void resetLabel(ATLModel m) {
		successlabel.setVisible(false);
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietrobutton() {
		return indietrobutton;
	}
	
	public JButton getAcquistaButton() {
		return acquistabutton;
	}
	
	public void setSuccessText(String s) {
		successlabel.setVisible(true);
		successlabel.setText(s);
	}
	
}
