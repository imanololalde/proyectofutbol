package datos;

import javax.swing.JOptionPane;

public class Entrenador {

	private String dni;
	private String nombre;
	private String apellido;
	private String contraseina;
	private String fecha_naci;
	private String fecha_inscri;
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni.length()!=9){
			setDni(dni);
		} else {
			String secuenciaLetrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE"; 
			dni = dni.toUpperCase();
			String numeroNIF = dni.substring(0, dni.length()-1);
			//Si es un NIE reemplazamos letra inicial por su valor num�rico.
			numeroNIF = numeroNIF.replace("X", "0").replace("Y", "1").replace("Z", "2");
			char letraNIF = dni.charAt(8);
			int i = Integer.parseInt(numeroNIF) % 23;
			if (letraNIF == secuenciaLetrasNIF.charAt(i)) {
				this.dni = dni;
			} else {
				setDni(dni);
			}
		}
	}

	public String getFecha_naci() {
		return fecha_naci;
	}

	public void setFecha_naci(String fecha_naci) {
		this.fecha_naci = fecha_naci;
	}
	
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

	public String getContrase�a() {
		return contraseina;
	}

	public void setContraseina(String contraseina) {
		if (contraseina == null) {
			JOptionPane.showMessageDialog(null,"Debe tener una contrase�a");
			setContraseina(contraseina);
		} else {
			this.contraseina = contraseina;
		}
	}
	
	public String getFecha_inscri() {
		return fecha_inscri;
	}

	public void setFecha_inscri(String fecha_inscri) {
		this.fecha_inscri = fecha_inscri;
	}

	public Entrenador(String nombre, String contraseina) {
		this.nombre = nombre;
		this.contraseina = contraseina;
	}
	
	public Entrenador(String dni, String nombre, String apellido, String contraseina, String fecha_naci, String fecha_inscri) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseina = contraseina;
		this.fecha_naci = fecha_naci;
		this.fecha_inscri = fecha_inscri;
	}
}
