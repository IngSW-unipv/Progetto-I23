package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.view.form.LoginView;
import it.unipv.ingsfw.ispafd.atl.view.form.PostaNewsView;
import it.unipv.ingsfw.ispafd.atl.view.form.RegistrationDipendentiView;
import it.unipv.ingsfw.ispafd.atl.view.form.RegistrationView;

public class MainFrame extends JFrame{
	//Pattern Facade (?)
	public static final int WIDTH = 750;
	public static final int HEIGHT= 500;
	
	private CardLayout c1;
	private JPanel cardPanel;
	
	private RegistrationView registrationview;
	private MainView mainview;
	private LoginView loginview;
	private RegistrationDipendentiView registrationdipendentiview;
	private PostaNewsView postanewsview;
	private NewsListView newslistview;
	
	public MainFrame() {
		
		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("ATL");
		
		this.initComponents();
		
	}

	private void initComponents() {
		
		c1 = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(c1);
		
		
		mainview = new MainView();
		registrationview = new RegistrationView();
		loginview = new LoginView();
		registrationdipendentiview = new RegistrationDipendentiView();
		postanewsview = new PostaNewsView();
		newslistview = new NewsListView();
		
		
		cardPanel.add(mainview, mainview.getCardPosition());
		cardPanel.add(registrationview, registrationview.getCardPosition());
		cardPanel.add(loginview, loginview.getCardPosition());
		cardPanel.add(registrationdipendentiview,registrationdipendentiview.getCardPosition());
		cardPanel.add(postanewsview,postanewsview.getCardPosition());
		cardPanel.add(newslistview, newslistview.getCardPosition());
		
		c1.show(cardPanel, mainview.getCardPosition());
		//mainpanel.setVisible(true);
		this.add(cardPanel);
		
		
	}
	
	public void changeView(AbstractView p, ATLModel m) {
		p.resetLabel(m);
		c1.show(cardPanel, p.getCardPosition());
		p.setVisible(true);
	}
	
	public CardLayout getCardLayout() {
		return c1;
	}
	
	public JPanel getCardPanel() {
		return cardPanel;
	}
	
	public RegistrationView getRegistrationview() {
		return registrationview;
	}
	
	public LoginView getLoginview() {
		return loginview;
	}
	
	public MainView getMainview() {
		return mainview;
	}
	
	public RegistrationDipendentiView getRegistrationDipendentiView() {
		return registrationdipendentiview;
	}
	
	public PostaNewsView getPostaNewsView() {
		return postanewsview;
	}
	
	public NewsListView getNewsListView() {
		return newslistview;
	}
	
}
