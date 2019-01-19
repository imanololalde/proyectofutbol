package datos;

public class Ejercicios {
	String nombre;
	int duracion;
	String parte;
	public Ejercicios(String nombre, int duracion, String parte) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.parte = parte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getParte() {
		return parte;
	}
	public void setParte(String parte) {
		this.parte = parte;
	}

}
