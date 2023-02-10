package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.view.form.LoginView;
import it.unipv.ingsfw.ispafd.atl.view.form.PostaNewsView;
import it.unipv.ingsfw.ispafd.atl.view.form.PostaReclamiView;
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
	private ListaBigliettiView listabigliettiview;
	private AcquistaBigliettiView acquistabigliettiview;
	private PostaReclamiView postareclamiview;
	private ListaReclamiView listareclamiview;
	private SingoloReclamoView singoloreclamoview;
	
	public MainFrame() {
		
		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("ATL");
		
		ImageIcon img = new ImageIcon("resources/icon.png");
		this.setIconImage(img.getImage());
		setResizable(false);
		
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
		listabigliettiview = new ListaBigliettiView();
		acquistabigliettiview = new AcquistaBigliettiView();
		postareclamiview = new PostaReclamiView();
		listareclamiview = new ListaReclamiView();
		singoloreclamoview = new SingoloReclamoView();
		
		cardPanel.add(mainview, mainview.getCardPosition());
		cardPanel.add(registrationview, registrationview.getCardPosition());
		cardPanel.add(loginview, loginview.getCardPosition());
		cardPanel.add(registrationdipendentiview,registrationdipendentiview.getCardPosition());
		cardPanel.add(postanewsview,postanewsview.getCardPosition());
		cardPanel.add(newslistview, newslistview.getCardPosition());
		cardPanel.add(listabigliettiview, listabigliettiview.getCardPosition());
		cardPanel.add(acquistabigliettiview, acquistabigliettiview.getCardPosition());
		cardPanel.add(postareclamiview, postareclamiview.getCardPosition());
		cardPanel.add(listareclamiview, listareclamiview.getCardPosition());
		cardPanel.add(singoloreclamoview, singoloreclamoview.getCardPosition());
		
		c1.show(cardPanel, mainview.getCardPosition());
		//mainpanel.setVisible(true);
		this.add(cardPanel);
		
		
	}
	
	public void changeView(AbstractView p, ATLModelSingleton m) {
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
	
	public ListaBigliettiView getListaBigliettiView() {
		return listabigliettiview;
	}
	
	public AcquistaBigliettiView getAcquistaBigliettiView() {
		return acquistabigliettiview;
	}
	
	public PostaReclamiView getPostaReclamiView() {
		return postareclamiview;
	}
	
	public ListaReclamiView getListaReclamiView() {
		return listareclamiview;
	}
	
	public SingoloReclamoView getSingoloReclamoView() {
		return singoloreclamoview;
	}
	
}
