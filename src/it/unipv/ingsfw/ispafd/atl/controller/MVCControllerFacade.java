package it.unipv.ingsfw.ispafd.atl.controller;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.view.*;

public class MVCControllerFacade {

	private static MainFrame view;
	private static ATLModelSingleton m;
	
	public MVCControllerFacade(MainFrame view, ATLModelSingleton m) {
		
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
