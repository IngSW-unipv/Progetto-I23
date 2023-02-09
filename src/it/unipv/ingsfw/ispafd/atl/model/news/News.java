package it.unipv.ingsfw.ispafd.atl.model.news;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;

public class News {

	 private String titolo, testo, id;
	 private Impiegato autore;
	 
	 public News(String titolo, String testo, Impiegato autore) {
		 
		 this.titolo=titolo;
		 this.testo=testo;
		 this.autore=autore;
		 this.id=createId();	//id: username+timestamp

	 }
	 
	 public News(String titolo, String testo, Impiegato autore, String id) {
		 
		 this.titolo=titolo;
		 this.testo=testo;
		 this.autore=autore;
		 this.id=id;

	 }
	 
	 private String createId() {
		 return this.autore.getUsername()+System.currentTimeMillis();
	 }
	 
	 public String getTitolo() {
		 return titolo;
	 }
	 
	 public String getTesto() {
		 return testo;
	 }
	 
	 public Impiegato getAutore() {
		 return autore;
	 }
	
}
