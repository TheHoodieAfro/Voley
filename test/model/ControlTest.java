package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControlTest {

	private Control c;
	
	private void setUpEscenario1() {
		c = new Control();
	}
	
	private void setUpEscenario2() {
		c = new Control();
		c.cargarDatos("C:/Users/Usuario/Documents/JavaProyects/Voley/ruta/1000.csv");
	}
	
	@Test
	public void testCargarDatos1() {
		
		setUpEscenario1();
		
		c.cargarDatos("C:/Users/Usuario/Documents/JavaProyects/Voley/ruta/1000.csv");
		
		if(c.getFirst() == null || c.getRaiz() == null) {
			fail();
		}
		
	}
	
	public void testCargarDatos2() {
		
		setUpEscenario1();
		
		c.cargarDatos("");
		
		fail();
	
	}
	
	@Test
	public void testBuscarEspectador() {
		
		setUpEscenario2();
		
		String[] x = c.buscarEspectador("69-8798650");
		
		if(!x[0].equals("69-8798650")) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscarParticipante() {
		
		setUpEscenario2();
		
		String[] x = c.buscarParticipante("69-8798650");
		String[] z = c.buscarParticipante("66-8421067");
		
		if(x == null || z == null) {
			fail();
		}
		
	}
	
	@Test
	public void testDibujarParticipantes() {
		
	}
	
	@Test
	public void testDibujarEspectadores() {
		
	}

}
