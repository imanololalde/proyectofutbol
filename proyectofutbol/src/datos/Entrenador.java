package datos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Jugador;

public class Entrenador {

	private String nombre;
	private String apellido;
	private String contraseina;
	private Jugador[] plantilla;
	private ArrayList<Jugador> plantilla1;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseina;
	}

	public void setContraseina(String contraseina) {
		if (contraseina == null) {
			JOptionPane.showMessageDialog(null,"Debe tener una contraseña");
			setContraseina(contraseina);
		} else {
			this.contraseina = contraseina;
		}
	}
	
	public Jugador[] getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Jugador[] plantilla) {
		this.plantilla = plantilla;
	}
	
	public void verPlantilla(Jugador[] plantilla) {
		while(plantilla != null) {
			System.out.println(plantilla);
		}
	}
	
	public Entrenador(String nombre, String contraseina) {
		this.nombre = nombre;
		this.contraseina = contraseina;
	}
	
	public Entrenador(String nombre, String apellido, String contraseina) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseina = contraseina;
		this.plantilla = null;
	}
	
}
