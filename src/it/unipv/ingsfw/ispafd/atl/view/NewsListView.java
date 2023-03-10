package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.news.News;

public class NewsListView extends AbstractView{

	private final String cardposition = "6";
	
	private JButton indietrobutton;
	
	private JPanel centerpanel;
	
	public NewsListView() {
		
		super();
		
		this.setLayout(new BorderLayout());
		
		JLabel l1 = new JLabel("News", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		JPanel pl1 = new JPanel(new BorderLayout());
		pl1.add(l1,BorderLayout.CENTER);
		
		indietrobutton = new JButton("← Indietro");
		JPanel downbuttonpanel = new JPanel(new BorderLayout());
		downbuttonpanel.add(indietrobutton, BorderLayout.WEST);
		
		centerpanel = new JPanel(new GridBagLayout());
		
		
		JScrollPane scrollFrame = new JScrollPane(centerpanel);
		centerpanel.setAutoscrolls(true);
		
		
		this.add(scrollFrame, BorderLayout.CENTER);
		this.add(downbuttonpanel, BorderLayout.SOUTH);
		this.add(pl1, BorderLayout.NORTH);
		
	}
	
	public void resetLabel(ATLModelSingleton m) {
		
		ArrayList<News> news = m.getNewsArray();
		
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c1 = new GridBagConstraints();
		c.insets = new Insets(6, 6, 6, 6);
		c1.insets = new Insets(1, 1, 1, 1);
		
		centerpanel.removeAll();
		
		c.gridx = 0;
		c.gridy = 0;
		
		for(News n: news) {
			
			JPanel ptemp = new JPanel(new GridBagLayout());
			ptemp.setBackground(Color.WHITE);
			JLabel l1 = new JLabel(n.getTitolo());
			JTextArea l2 = new JTextArea(n.getTesto());
            
            l2.setLineWrap(true);
            l2.setWrapStyleWord(true);
            l2.setColumns(40);
            l2.setRows(3);
            l2.setEditable(false);
			
			c1.gridx = 0;
			c1.gridy = 0;
			ptemp.add(l1,c1);
			c1.gridy = 2;
			ptemp.add(l2,c1);
			
			if(m.getLoggedUser()!=null) {
				if(m.getLoggedUser().isResponsabile()) {
					c1.gridy = 1;
					JLabel l3 = new JLabel("by "+n.getAutore().getUsername());
					ptemp.add(l3,c1);
				}
			}
			
			centerpanel.add(ptemp,c);
			
			c.gridy += 3;
			
		}
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietrobutton() {
		return indietrobutton;
	}
	
}
