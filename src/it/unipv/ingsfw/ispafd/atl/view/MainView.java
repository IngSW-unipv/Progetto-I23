package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;

public class MainView extends AbstractView{
	
	private final String cardposition = "1";
	
	private JButton loginbutton;
	private JButton registrationbutton;
	private JButton logoutbutton;
	private JButton newsbutton;
	private JButton reclamibutton;
	private JButton bigliettibutton;
	private JButton registradipendentibutton;
	private JButton postanewsbutton;
	
	private JLabel successlabel;
	
	public MainView() {
		
		super();
		
		this.setLayout(new BorderLayout());
		
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(new BorderLayout());
		loginpanel.setSize(1, 1);
		loginbutton = new JButton("Login");
		loginpanel.add(loginbutton, BorderLayout.NORTH);
		
		JPanel registrationpanel = new JPanel();
		registrationpanel.setLayout(new BorderLayout());
		registrationpanel.setSize(1, 1);
		registrationbutton = new JButton("Registrati");
		registrationpanel.add(registrationbutton, BorderLayout.NORTH);
		
		successlabel = new JLabel("Success Label", SwingConstants.CENTER);
		successlabel.setForeground(Color.GREEN);
		successlabel.setFont(new Font("", Font.PLAIN, 25));
		successlabel.setVisible(false);
		
		this.add(loginpanel, BorderLayout.EAST);
		this.add(registrationpanel, BorderLayout.WEST);
		this.add(successlabel, BorderLayout.SOUTH);
		
		
		JPanel centerpanel = new JPanel(new BorderLayout());
		
		try {
			BufferedImage img = ImageIO.read(new File("resources/disegno_cropped_png.png"));
			Image dimg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			JLabel picLabel = new JLabel(imageIcon);
			centerpanel.add(picLabel,BorderLayout.NORTH);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JPanel buttonspanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		
		c.gridx = 0;
		c.gridy = 0;
		newsbutton = new JButton("Visualizza News");
		buttonspanel.add(newsbutton,c);
		
		c.gridx = 1;
		reclamibutton = new JButton("Posta un Reclamo");
		buttonspanel.add(reclamibutton,c);
		
		c.gridx = 2;
		bigliettibutton = new JButton("Biglietti e Abbonamenti");
		buttonspanel.add(bigliettibutton,c);
		
		c.gridy = 1;
		c.gridx = 0;
		registradipendentibutton = new JButton("Registra Dipendenti");
		buttonspanel.add(registradipendentibutton,c);
		
		c.gridx = 1;
		postanewsbutton = new JButton("Posta News");
		buttonspanel.add(postanewsbutton,c);
		
		c.gridx = 2;
		c.gridy = 3;
		logoutbutton = new JButton("Logout");
		buttonspanel.add(logoutbutton,c);
		
		centerpanel.add(buttonspanel,BorderLayout.CENTER);
		
		this.add(centerpanel, BorderLayout.CENTER);
		
		reclamibutton.setVisible(false);
		bigliettibutton.setVisible(false);
		logoutbutton.setVisible(false);
		registradipendentibutton.setVisible(false);
		postanewsbutton.setVisible(false);
		
		
	}
	
	public void resetLabel(ATLModel m) {
		successlabel.setVisible(false);
		
		if(m.getLoggedUser()!=null) {
			reclamibutton.setVisible(true);
			bigliettibutton.setVisible(true);
			logoutbutton.setVisible(true);
			
			if(m.getLoggedUser().isResponsabile()) {
				registradipendentibutton.setVisible(true);
			}
			
			if(m.getLoggedUser().isDipendente()) {
				postanewsbutton.setVisible(true);
			}
			
			registrationbutton.setVisible(false);
			loginbutton.setVisible(false);
		} else {
			reclamibutton.setVisible(false);
			bigliettibutton.setVisible(false);
			logoutbutton.setVisible(false);
			registradipendentibutton.setVisible(false);
			postanewsbutton.setVisible(false);
			
			registrationbutton.setVisible(true);
			loginbutton.setVisible(true);
		}
		//to do
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public void setSuccessText(String s) {
		successlabel.setVisible(true);
		successlabel.setText(s);
	}
	
	public JButton getLoginButton() {
		return loginbutton;
	}
	
	public JButton getRegistrationButton() {
		return registrationbutton;
	}
	
	public JLabel getSuccesslabel() {
		return successlabel;
	}
	
	public JButton getLogoutButton() {
		return logoutbutton;
	}
	
	public JButton getPostaNewsButton() {
		return postanewsbutton;
	}
	
	public JButton getNewsButton() {
		return newsbutton;
	}
	
	public JButton getRegistraDipendentiButton() {
		return registradipendentibutton;
	}
	
	public JButton getBigliettiButton() {
		return bigliettibutton;
	}

}
