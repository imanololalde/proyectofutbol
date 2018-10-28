package datos;

public class Jugador {

	private String Nombre;
	private String Apellido;
	private int dorsal;
	private String posicion;
	
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

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Jugador(String Nombre, String Apellido, int dorsal, String posicion) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

}
