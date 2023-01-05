package it.unipv.ingsfw.ispafd.atl.view.form;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;

public class PostaNewsView extends AbstractFormView{

	private final String cardposition = "5";
	
	public PostaNewsView() {
		
		super();
		
		l1.setText("Posta News");
		
		addInput(0,50,"titolo");
		addInput(1,50,"testo");
		
	}
	
	public void resetLabel(ATLModel m) {
		
		errorlabel.setVisible(false);
		getInput("titolo").setText("");
		getInput("testo").setText("");	
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}
	
	
}
