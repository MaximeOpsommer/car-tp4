package car.tp4.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PanierTest {
	
	private Panier panier;
	
	@Before
	public void init() {
		panier = new Panier();
	}

	@Test
	public void testPanier() {
		assertEquals(new ArrayList<Book>(), panier.getPanier());
	}

}
