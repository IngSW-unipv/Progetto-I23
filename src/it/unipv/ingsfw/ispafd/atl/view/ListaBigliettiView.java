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

import it.unipv.ingsfw.ispafd.atl.controller.BigliettiController;
import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;

public class ListaBigliettiView extends AbstractView{

	private final String cardposition = "7";
	
	private JButton indietrobutton;
	private JButton acquistabutton;
	
	private JPanel centerpanel;
	
	private JLabel successlabel;
	
	private ArrayList<JButton> listapulsanti;
	private ArrayList<JLabel> listaconvalide;
	private ArrayList<JTextArea> listatimbrature;
	private ArrayList<JTextArea> listascadenze;
	
	public ListaBigliettiView() {
		
		super();
		
		listapulsanti = new ArrayList<JButton>();
		listaconvalide = new ArrayList<JLabel>();
		listatimbrature = new ArrayList<JTextArea>();
		listascadenze = new ArrayList<JTextArea>();
		
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
		
		updateInterface(m);
		
		BigliettiController.updateTimbraListeners(m, listapulsanti, this);
		
	}
	
	public void updateInterface(ATLModel m) {
		listapulsanti.clear();
		listaconvalide.clear();
		listatimbrature.clear();
		listascadenze.clear();
		
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
				JPanel downpanel = new JPanel(new BorderLayout());
				ptemp.setBackground(Color.WHITE);
				containerpanel.setBackground(Color.WHITE);
				downpanel.setBackground(Color.WHITE);
				
				
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
					JTextArea ltdata = new JTextArea("-");
					ltdata.putClientProperty("id",a.getId());
					listatimbrature.add(ltdata);
					c1.gridx = 1;
					ptemp.add(ltdata,c1);
					
					JButton btemp = new JButton("TImbra");
					btemp.putClientProperty("id",a.getId());
					listapulsanti.add(btemp);
					
					downpanel.add(btemp, BorderLayout.SOUTH);
				}
				
				JTextArea l3 = new JTextArea("Scadenza: ");
				c1.gridy = 2;
				c1.gridx = 0;
				ptemp.add(l3,c1);
				
				c1.gridx = 1;
				if(!a.getTipoAbbonamento().getIsAbbonamento()) {
					JTextArea l3data = new JTextArea("-");
					l3data.putClientProperty("id",a.getId());
					listascadenze.add(l3data);
					ptemp.add(l3data,c1);
				} else {
					JTextArea l3data = new JTextArea(sdf.format(datascad));
					ptemp.add(l3data,c1);
				}
				
				if(!a.getTipoAbbonamento().getIsAbbonamento()) {
					JLabel l = new JLabel("Da Timbrare",SwingConstants.CENTER);
					l.setForeground(Color.ORANGE);
					downpanel.add(l, BorderLayout.NORTH);
					l.putClientProperty("id",a.getId());
					listaconvalide.add(l);
				} else {
					if(a.isExpired()) {
						JLabel l = new JLabel("Scaduto",SwingConstants.CENTER);
						l.setForeground(Color.RED);
						downpanel.add(l, BorderLayout.NORTH);
					}else {
						JLabel l = new JLabel("In Corso di Validità",SwingConstants.CENTER);
						l.setForeground(Color.GREEN);
						downpanel.add(l, BorderLayout.NORTH);
					}
				}
				
				containerpanel.add(downpanel, BorderLayout.SOUTH);
				containerpanel.add(ptemp, BorderLayout.CENTER);
				centerpanel.add(containerpanel,c);
				c.gridy += 3;
			}
			
		}
		
		updateBigliettiStatus(m);
	}
	
	public void updateBigliettiStatus(ATLModel m) {
		
		for(JButton b: listapulsanti) {
			String stemp = (String) b.getClientProperty("id");
			Abbonamento atemp = m.getAbbonamentoById(stemp);
			
			if(atemp.getDataTimbratura()>0) {
				b.setVisible(false);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");    
				Date data1 = new Date(atemp.getDataTimbratura());
				Date data2 = new Date(atemp.getDataScadenza());
				
				this.getTimbraturaById(stemp).setText(sdf.format(data1));
				this.getScadenzaById(stemp).setText(sdf.format(data2));
				
				if(atemp.isExpired()) {
					this.getConvalidaById(stemp).setText("Scaduto");
					this.getConvalidaById(stemp).setForeground(Color.RED);
				} else {
					this.getConvalidaById(stemp).setText("In Corso di Validità");
					this.getConvalidaById(stemp).setForeground(Color.GREEN);
				}
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
	
	public ArrayList<JButton> getListaPulsanti(){
		return listapulsanti;
	}
	
	public JTextArea getTimbraturaById(String s) {
		JTextArea ttemp = null;
		
		for(JTextArea l: listatimbrature) {
			if(l.getClientProperty("id").equals(s)) {
				ttemp = l;
			}
		}
		
		return ttemp;
		
	}
	
	public JLabel getConvalidaById(String s) {
		JLabel ttemp = null;
		
		for(JLabel l: listaconvalide) {
			if(l.getClientProperty("id").equals(s)) {
				ttemp = l;
			}
		}
		
		return ttemp;
		
	}
	
	public JTextArea getScadenzaById(String s) {
		JTextArea ttemp = null;
		
		for(JTextArea l: listascadenze) {
			if(l.getClientProperty("id").equals(s)) {
				ttemp = l;
			}
		}
		
		return ttemp;
		
	}
	
}
