package datos;

import java.util.ArrayList;

public class Plantilla {

	private String nombre;
	private String formacion;
	private Entrenador entrenador;
	private ArrayList<Jugador> plantilla;
	
	public Plantilla(Entrenador entrenador){
		this.entrenador = entrenador;
		this.plantilla = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public ArrayList<Jugador> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(ArrayList<Jugador> plantilla) {
		this.plantilla = plantilla;
	}
	
	public void addPlantilla(ArrayList<Jugador> plantilla) {
		this.plantilla.addAll(plantilla);
	}
}
