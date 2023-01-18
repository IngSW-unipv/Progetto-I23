package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;

public class SingoloReclamoView extends AbstractView{
	
	private final String cardposition = "11";
	
	private JButton indietrobutton, inviarispostabutton;
	
	private JPanel rispostapanel, rispondipanel;
	
	private JLabel l1;
	
	private JTextArea testo, testorisposta;
	
	private JTextField inputrisposta;
	
	public SingoloReclamoView() {
		
		this.setLayout(new BorderLayout());
		
		l1 = new JLabel("--", SwingConstants.CENTER);
		l1.setFont(new Font("", Font.PLAIN, 25));
		
		JPanel centerpanel = new JPanel(new BorderLayout());
		
		JPanel testopanel = new JPanel(new BorderLayout());
		
		centerpanel.setAutoscrolls(true);
		testo = new JTextArea("-");
		testo.setLineWrap(true);
        testo.setWrapStyleWord(true);
        testo.setColumns(10);
        testo.setRows(3);
        testo.setEditable(false);
		testopanel.add(testo, BorderLayout.CENTER);
		
		centerpanel.add(testopanel, BorderLayout.NORTH);
		
		rispostapanel = new JPanel(new BorderLayout());
		testorisposta = new JTextArea("-");
		testorisposta.setLineWrap(true);
        testorisposta.setWrapStyleWord(true);
        testorisposta.setColumns(10);
        testorisposta.setRows(3);
        testorisposta.setEditable(false);
		JLabel lr = new JLabel("Risposta:");
		rispostapanel.add(lr, BorderLayout.NORTH);
		rispostapanel.add(testorisposta, BorderLayout.CENTER);
		
		centerpanel.add(rispostapanel, BorderLayout.CENTER);
		
		rispondipanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		c.gridx = 0;
		c.gridy = 0;
		JLabel rlabel = new JLabel("Risposta");
		rispondipanel.add(rlabel,c);
		inputrisposta = new JTextField(50);
		c.gridx = 1;
		rispondipanel.add(inputrisposta,c);
		inviarispostabutton = new JButton("Invia");
		c.gridx = 1;
		c.gridy = 1;
		rispondipanel.add(inviarispostabutton,c);
		
		centerpanel.add(rispondipanel, BorderLayout.SOUTH);
		
		indietrobutton = new JButton("← Indietro");
		JPanel downpanel = new JPanel(new BorderLayout());
		downpanel.add(indietrobutton, BorderLayout.WEST);
		
		this.add(l1, BorderLayout.NORTH);
		this.add(centerpanel, BorderLayout.CENTER);
		this.add(downpanel, BorderLayout.SOUTH);
		
		rispostapanel.setVisible(false);
		rispondipanel.setVisible(false);
		
	}
	
	
	
	public void resetLabel(ATLModel m) {
		
		inputrisposta.setText("");
		
		Reclamo rtemp = m.getReclamoById(m.getIdActualReclamo());
		
		l1.setText("Reclamo: "+rtemp.getTitolo());
		testo.setText(rtemp.getTesto());
		
		if(rtemp.getTestoRisposta()!=null) {
			rispostapanel.setVisible(true);
			rispondipanel.setVisible(false);
			
			testorisposta.setText(rtemp.getTestoRisposta());
		} else {
			if(m.getLoggedUser().isDipendente()) {
				rispondipanel.setVisible(true);
				inviarispostabutton.putClientProperty("id",rtemp.getId());
			} else {
				rispondipanel.setVisible(false);
			}
			rispostapanel.setVisible(false);
		}
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	public JButton getIndietroButton() {
		return indietrobutton;
	}
	
	public JTextField getInputRisposta() {
		return inputrisposta;
	}
	
	public JButton getInviaRispostaButton() {
		return inviarispostabutton;
	}

}
