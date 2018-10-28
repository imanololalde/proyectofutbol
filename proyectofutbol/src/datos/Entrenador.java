package datos;

import datos.Jugador;

public class Entrenador {

	private String Nombre;
	private String Apellido;
	private Jugador[] Plantilla;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Entrenador(String Nombre, String Apellido) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}

	public Jugador[] getPlantilla() {
		return Plantilla;
	}

	public void setPlantilla(Jugador[] plantilla) {
		Plantilla = plantilla;
	}
	
}
