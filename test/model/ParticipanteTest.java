package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParticipanteTest {

	private Participante p;
	
	private void setUpEscenario1() {
		p = new Participante("69-8798650", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
	}
	
	private void setUpEscenario2() {
		p = new Participante("%&#$#!", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
	}
	
	@Test
	public void testInsert1() {
		
		setUpEscenario1();
		
		Participante x = new Participante("39-8798650", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
		p.insert(x);
		
		if(p.getNext() != x) {
			fail();
		}
		
	}
	
	@Test
	public void testInsert2() {
		
		setUpEscenario2();
		
		Participante x = new Participante("#$#%34", "Enid","Simoncello","esimoncello6@apache.org","Female","Martinique","https://robohash.org/excepturitotamin.bmp?size=50x50&set=set1","1/30/2014");
		p.insert(x);
		
		if(p.getNext() != x) {
			fail();
		}
		
	}
	
	@Test
	public void testInsert3() {
		
		setUpEscenario2();
		
		Participante x = null;
		p.insert(x);
		
		if(p.getNext() != null) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscar1() {
		
		setUpEscenario2();
		
		Participante x = p.buscar("%&#$#!");
		
		if(x == null) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscar2() {
		
		setUpEscenario2();
		
		Participante x = p.buscar("%&$#!");
		
		if(x != null) {
			fail();
		}
		
	}

}
