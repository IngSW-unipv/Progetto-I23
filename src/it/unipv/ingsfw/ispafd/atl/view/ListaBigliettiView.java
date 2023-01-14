package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;

public class ListaBigliettiView extends AbstractView{

	private final String cardposition = "7";
	
	private JButton indietrobutton;
	private JButton acquistabutton;
	
	private JPanel centerpanel;
	
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
		
		centerpanel = new JPanel(new GridBagLayout());
		JScrollPane scrollFrame = new JScrollPane(centerpanel);
		centerpanel.setAutoscrolls(true);
		
		
		successlabel = new JLabel("", SwingConstants.CENTER);
		successlabel.setForeground(Color.GREEN);
		successlabel.setFont(new Font("", Font.PLAIN, 25));
		successlabel.setVisible(false);
		
		downbuttonpanel.add(successlabel, BorderLayout.NORTH);
		
		this.add(scrollFrame, BorderLayout.CENTER);
		this.add(downbuttonpanel, BorderLayout.SOUTH);
		this.add(pl1, BorderLayout.NORTH);
		
	}
	
	
	public void resetLabel(ATLModel m) {
		successlabel.setVisible(false);
		
		ArrayList<Abbonamento> abbonamenti = m.getAbbonamentiArray();
		
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c1 = new GridBagConstraints();
		c.insets = new Insets(6, 6, 6, 6);
		c1.insets = new Insets(1, 1, 1, 1);
		
		centerpanel.removeAll();
		
		c.gridx = 0;
		c.gridy = 0;
		
		for(Abbonamento a: abbonamenti) {
			if(a.getUtenteProprietario()==m.getLoggedUser()) {
				JPanel ptemp = new JPanel(new GridBagLayout());
				JPanel containerpanel = new JPanel(new BorderLayout());
				ptemp.setBackground(Color.WHITE);
				containerpanel.setBackground(Color.WHITE);
				
				
				JLabel l1 = new JLabel(a.getTipoAbbonamento().getNome(),SwingConstants.CENTER);
				containerpanel.add(l1, BorderLayout.NORTH);
					
				SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");    
				Date dataacq = new Date(a.getDataAcquisto());
				Date datascad = new Date(a.getDataScadenza());
				
				JTextArea l2 = new JTextArea("Data Acquisto: ");
				c1.gridy = 0;
				c1.gridx = 0;
				ptemp.add(l2,c1);
				JTextArea l2data = new JTextArea(sdf.format(dataacq));
				c1.gridx = 1;
				ptemp.add(l2data,c1);
				
				if(!a.getTipoAbbonamento().getIsAbbonamento()) {
					c1.gridy = 1;
					c1.gridx = 0;
					JTextArea lt = new JTextArea("Data Timbratura: ");
					ptemp.add(lt,c1);
					JTextArea ltdata = new JTextArea("...da mettere");
					c1.gridx = 1;
					ptemp.add(ltdata,c1);
				}
				
				JTextArea l3 = new JTextArea("Scadenza: ");
				c1.gridy = 2;
				c1.gridx = 0;
				ptemp.add(l3,c1);
				JTextArea l3data = new JTextArea(sdf.format(datascad));
				c1.gridx = 1;
				ptemp.add(l3data,c1);
				
				if(a.isExpired()) {
					JLabel l = new JLabel("Scaduto",SwingConstants.CENTER);
					l.setForeground(Color.RED);
					containerpanel.add(l, BorderLayout.SOUTH);
				}else {
					JLabel l = new JLabel("In Corso di Validità",SwingConstants.CENTER);
					l.setForeground(Color.GREEN);
					containerpanel.add(l, BorderLayout.SOUTH);
				}
				
				containerpanel.add(ptemp, BorderLayout.CENTER);
				centerpanel.add(containerpanel,c);
				c.gridy += 3;
			}
			
		}
		
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
