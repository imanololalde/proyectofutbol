package datos;

public class Jugador {

	private String nombre;
	private String apellido;
	private int dorsal;
	private String posicion;
	private String fecha_naci;
	
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

	public String getFecha_Naci() {
		return fecha_naci;
	}

	public void setFecha_Naci(String fecha_naci) {
		this.fecha_naci = fecha_naci;
	}
	
	public Jugador(String nombre, String apellido, String posicion, int dorsal, String fecha_naci, Entrenador entrenador) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.fecha_naci = fecha_naci;
	}

}
