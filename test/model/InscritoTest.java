package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InscritoTest {

	private Inscrito i;
	
	private void setUpEscenario1() {
		i = new Inscrito("69-8798650", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
	}
	
	private void setUpEscenario2() {
		i = new Inscrito("%&#$#!", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
	}
	
	@Test
	public void testInsert1() {
		
		setUpEscenario1();
		
		Inscrito x = new Inscrito("39-8798650", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
		i.insert(x);
		
		if(i.getL() != x) {
			fail();
		}
		
	}
	
	@Test
	public void testInsert2() {
		
		setUpEscenario2();
		
		Inscrito x = new Inscrito("#$#%34", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
		i.insert(x);
		
		if(i.getL() != x || i.getR() != x) {
			fail();
		}
		
	}
	
	@Test
	public void testInsert3() {
		
		setUpEscenario2();
		
		Inscrito x = null;
		i.insert(x);
		
		if(i.getL() != null || i.getL() != null) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscar1() {
		
		setUpEscenario2();
		
		Inscrito x = i.buscar("%&#$#!");
		
		if(x == null) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscar2() {
		
		setUpEscenario2();
		
		Inscrito x = i.buscar("%&$#!");
		
		if(x != null) {
			fail();
		}
		
	}

}
