package it.unipv.ingsfw.ispafd.atl.controller;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleTone;
import it.unipv.ingsfw.ispafd.atl.view.*;

public class MVCController {

	private static MainFrame view;
	private static ATLModelSingleTone m;
	
	public MVCController(MainFrame view, ATLModelSingleTone m) {
		
		this.view = view;
		this.m = m;
		this.addListeners();
	}
	
	private void addListeners() {
		
		AutenticationController.addListeners(m, view);
		NewsController.addListeners(m, view);
		BigliettiController.addListeners(m, view);
		ReclamiController.addListeners(m, view);
		
	}
	
}
