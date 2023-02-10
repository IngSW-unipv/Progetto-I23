package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.controller.ReclamiController;
import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;

public class ListaReclamiView extends AbstractView{
	
	private final String cardposition = "10";
	
	private JButton indietrobutton;
	
	private ArrayList<JButton> listapulsanti;
	
	private JLabel successlabel;
	
	private JPanel centerpanel;
	
	public ListaReclamiView() {
		
		this.setLayout(new BorderLayout());
		
		listapulsanti = new ArrayList<JButton>();
		
		JLabel l1 = new JLabel("Lista Reclami", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		
		
		indietrobutton = new JButton("← Indietro");
		JPanel downpanel = new JPanel(new BorderLayout());
		downpanel.add(indietrobutton, BorderLayout.WEST);
		
		centerpanel = new JPanel(new GridBagLayout());
		JScrollPane scrollFrame = new JScrollPane(centerpanel);
		centerpanel.setAutoscrolls(true);
		
		successlabel = new JLabel("", SwingConstants.CENTER);
		successlabel.setForeground(Color.GREEN);
		successlabel.setFont(new Font("", Font.PLAIN, 25));
		successlabel.setVisible(false);
		downpanel.add(successlabel, BorderLayout.NORTH);
		
		this.add(l1, BorderLayout.NORTH);
		this.add(scrollFrame, BorderLayout.CENTER);
		this.add(downpanel, BorderLayout.SOUTH);
		
		
	}
	
	
	public void resetLabel(ATLModelSingleton m) {
		
		successlabel.setVisible(false);
		
		ArrayList<Reclamo> reclami = m.getReclamiArray();
		listapulsanti.clear();
		
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c1 = new GridBagConstraints();
		c.insets = new Insets(6, 6, 6, 6);
		c1.insets = new Insets(1, 1, 1, 1);
		
		centerpanel.removeAll();
		
		c.gridx = 0;
		c.gridy = 0;
		
		for(Reclamo r: reclami) {
			
			if((r.getUtente()==m.getLoggedUser())||(m.getLoggedUser().isDipendente())) {
				
				JPanel ptemp = new JPanel(new GridBagLayout());
				ptemp.setBackground(Color.WHITE);
				JLabel l1 = new JLabel(r.getTitolo());
				
				String s=r.getTesto();
				if(s.length() > 36)
				    s = r.getTesto().substring(0,36) + "...";
				
				JTextArea l2 = new JTextArea(s);
				
				
				l2.setLineWrap(true);
	            l2.setWrapStyleWord(true);
	            l2.setColumns(20);
	            l2.setRows(3);
	            l2.setEditable(false);
				
				c1.gridx = 0;
				c1.gridy = 0;
				ptemp.add(l1,c1);
				c1.gridy = 2;
				ptemp.add(l2,c1);
				
				JButton btemp = new JButton("Apri");
				btemp.putClientProperty("id",r.getId());
				listapulsanti.add(btemp);
				c1.gridx = 3;
				c1.gridy = 3;
				ptemp.add(btemp,c1);
				
				centerpanel.add(ptemp,c);
				
				c.gridy += 3;
				
			}
			
		}
		
		ReclamiController.updateApriListeners(m, listapulsanti);
			
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietroButton() {
		return indietrobutton;
	}
	
	public void setSuccessText(String s) {
		successlabel.setVisible(true);
		successlabel.setText(s);
	}

}
