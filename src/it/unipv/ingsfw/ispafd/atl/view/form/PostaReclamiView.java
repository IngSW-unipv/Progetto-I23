package it.unipv.ingsfw.ispafd.atl.view.form;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleTone;

public class PostaReclamiView extends AbstractFormView{
	
	private final String cardposition = "9";
	
	public PostaReclamiView() {
		
		super();
		
		l1.setText("Posta Reclamo");
		
		addInput(0,50,"titolo");
		addInput(1,50,"testo");
		
	}
	
	public void resetLabel(ATLModelSingleTone m) {
		
		errorlabel.setVisible(false);
		getInput("titolo").setText("");
		getInput("testo").setText("");	
		
	}
	
	public String getCardPosition() {
		return cardposition;
	}

}
