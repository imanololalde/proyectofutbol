package datos;

public class Entrenador {

	private String Nombre;
	private String Apellido;
	private int Plantilla;
	
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

	public int getPlantilla() {
		return Plantilla;
	}

	public void setPlantilla(int plantilla) {
		Plantilla = plantilla;
	}

	public Entrenador(String Nombre, String Apellido) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	
	public Entrenador(String Nombre, String Apellido, int Plantilla) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Plantilla = Plantilla;
	}
}
