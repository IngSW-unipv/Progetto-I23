package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;

public class ListaReclamiView extends AbstractView{
	
	private final String cardposition = "10";
	
	private JButton indietrobutton;
	
	private JPanel centerpanel;
	
	public ListaReclamiView() {
		
		this.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("Lista Reclami", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		
		
		indietrobutton = new JButton("← Indietro");
		JPanel downpanel = new JPanel(new BorderLayout());
		downpanel.add(indietrobutton, BorderLayout.WEST);
		
		centerpanel = new JPanel(new GridBagLayout());
		JScrollPane scrollFrame = new JScrollPane(centerpanel);
		centerpanel.setAutoscrolls(true);
		
		this.add(l1, BorderLayout.NORTH);
		this.add(centerpanel, BorderLayout.CENTER);
		this.add(downpanel, BorderLayout.SOUTH);
		
		
	}
	
	
	public void resetLabel(ATLModel m) {
		
		ArrayList<Reclamo> reclami = m.getListaReclami();
		
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c1 = new GridBagConstraints();
		c.insets = new Insets(6, 6, 6, 6);
		c1.insets = new Insets(1, 1, 1, 1);
		
		centerpanel.removeAll();
		
		c.gridx = 0;
		c.gridy = 0;
		
		for(Reclamo r: reclami) {
			
		}
			
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietroButton() {
		return indietrobutton;
	}

}
