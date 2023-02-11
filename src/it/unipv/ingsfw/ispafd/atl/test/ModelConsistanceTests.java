package it.unipv.ingsfw.ispafd.atl.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;

public class ModelConsistanceTests {

	@Test
	void AuthorOfNewsShouldBeImpiegato() {
		
		ATLModelSingleton m = ATLModelSingleton.getIstance();
		
		ArrayList<News> newslist = m.getNewsArray();
		
		for(News n: newslist) {
			assertTrue(n.getAutore().isDipendente());
		}
		
	}
	
	@Test
	void AuthorOfRispostaReclamoShouldBeImpiegato() {
		
		ATLModelSingleton m = ATLModelSingleton.getIstance();
		
		ArrayList<Reclamo> reclamilist = m.getReclamiArray();
		
		for(Reclamo r: reclamilist) {
			if(r.getImpiegato()!=null) {
				assertTrue(r.getImpiegato().isDipendente());
			}
		}
		
	}
	
}
