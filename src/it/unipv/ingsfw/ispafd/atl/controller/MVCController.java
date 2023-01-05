package it.unipv.ingsfw.ispafd.atl.controller;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.view.*;

public class MVCController {

	private static MainFrame view;
	private static ATLModel m;
	
	public MVCController(MainFrame view, ATLModel m) {
		
		this.view = view;
		this.m = m;
		this.addListeners();
	}
	
	private void addListeners() {
		
		AutenticationController.addListeners(m, view);
		NewsController.addListeners(m, view);
		
	}
	
}
