package datos;

public class Jugador {

	private String nombre;
	private String apellido;
	private int dorsal;
	private String posicion;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			setNombre(nombre);
		} else {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if(apellido == null) {
			setApellido(apellido);
		} else {
			this.apellido = apellido;
		}
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		if(dorsal < 0) {
			setDorsal(dorsal);
		} else {
			this.dorsal = dorsal;
		}
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Jugador(String nombre, String apellido, int dorsal, String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

}
