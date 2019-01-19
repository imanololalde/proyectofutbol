package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datos.Entrenador;
import datos.Jugador;
import datos.Plantilla;

public class TestBaseDeDatos {

	private Jugador j1, j2, j3;
	private Jugador[] jugadores;
	private ArrayList<Jugador> lJugadores;
	private Entrenador e1, e2, e3;
	private Plantilla p1;
	
	@Before
	public void setUp() throws Exception {
		e1 = new Entrenador("Carlos","123");
		e2 = new Entrenador("Fernando","asd");
		e3 = new Entrenador("Rodrigo","qwe");
		j1 = new Jugador( "Roberto", "Rodriguez", "Delantero", 10, "03/08/1995", e3);
		j2 = new Jugador( "Juan", "Monte", "Centrocampista", 7, "08/02/1990", e2);
		j3 = new Jugador( "Pedro", "Hernandez", "Defensa", 5, "10/11/1993", e1);
		jugadores = new Jugador[] { j1, j2, j3 };
		lJugadores = (ArrayList<Jugador>) Arrays.asList(jugadores);
		p1 = new Plantilla(e1);
		
		p1.addPlantilla(lJugadores);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void CrearCerrarTest() {
		
	}

}
