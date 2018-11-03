package base_de_datos;

import java.sql.Connection;

import ventanas.*;
import datos.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class BaseDeDatos {

	private static ResultSet rs;
	private static Statement statement;
	private static Connection connection = null;
	private static Jugador jugador;
	
	/**
	 * El servidor se conecta a la base de datos
	 * @throws ClassNotFoundException
	 */
	public static void conectarBD() throws ClassNotFoundException {

		String username = "jsxigzifksfofs";
		String password = "837a4cd59231a62c30fd00d7aa39bb2f1fe6a33465b3fb30682bb9758c629809";
		String urldB = "jdbc:postgresql://ec2-54-221-204-161.compute-1.amazonaws.com:5432/d7k4h8c5tjnkec";
		String dbUrl = urldB + "?sslmode=require";

		//String urldB = "postgres://jsxigzifksfofs:837a4cd59231a62c30fd00d7aa39bb2f1fe6a33465b3fb30682bb9758c629809@ec2-54-221-204-161.compute-1.amazonaws.com:5432/d7k4h8c5tjnkec";
		//"jdbc:postgresql://hostname:port/dbname","username", "password"

		Class.forName("org.postgresql.Driver");

		try {
			//connection = DriverManager.getConnection("jdbc:sqlite:5432/AlquilerdePistas");
			connection = DriverManager.getConnection( dbUrl, username, password );
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS jugador (nombre CHAR(20) NOT NULL, apellido CHAR(30) NOT NULL, posicion CHAR(20) NOT NULL, dorsal INT);");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS entrenador (nombre CHAR(20) PRIMARY KEY, apellido CHAR(20) NOT NULL, contraseña);");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS plantilla (cod_plantilla CHAR(20) PRIMARY KEY, nombre CHAR(20);");
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "No se puede conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}

	public static void cerrarConexion() {

		if (rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				JOptionPane.showInputDialog(e);
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			}catch(Exception e) {
				JOptionPane.showInputDialog(e);
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			}catch(Exception e) {
				JOptionPane.showInputDialog(e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Para poder ver la información que hay en la tabla de jugador
	 * @param Jugador
	 * @return Nombre, Apellido, Dorsal y Posicion 
	 * @throws SQLException
	 */
	public static String verJugador(Jugador a) throws SQLException {
		
		rs = statement.executeQuery("SELECT "+a.getNombre()+" FROM jugador");
		while(rs.next()) {
			// Se saca por consola info de la tabla
			System.out.println("Nombre = " + rs.getString("nombre"));
			System.out.println("Apellido = " + rs.getString("apellido"));
			System.out.println("Posición = " + rs.getString("posicion"));
			System.out.println("Dorsal = " + rs.getInt("dorsal"));
		}
		rs.close();

		return rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4);
	}

	/**
	 * Visualiza los nombres y apellidos de los entrenadores
	 * @param Entrenador
	 * @return Nombres y apellidos
	 * @throws SQLException
	 */
	public static String verEntrenador(Entrenador e) throws SQLException {
		
		rs = statement.executeQuery("SELECT "+e.getNombre()+" FROM entrenador");
		while(rs.next()) {
			System.out.println("Nombre ="+rs.getString(1));
			System.out.println("Apellido ="+rs.getString(2));
		}
		rs.close();
		return rs.getString(1)+rs.getString(2);
	}

	public static void eliminarJugador(Jugador a) {	

		try {
			statement = connection.createStatement();
			String sql ="DELETE FROM jugador WHERE nombre = '"+a.getNombre()+"' AND apellido = '"+a.getApellido()+"' AND"
					+ " posicion = '"+a.getPosicion()+"' AND dorsal = '"+a.getDorsal()+"';";
			ResultSet resultado = statement.executeQuery(sql);
			JOptionPane.showMessageDialog(null, "El jugador ha sido eliminado exitosamente", 
					"Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
			resultado.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Alert", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void insertarJugador() {

		try {
//			char[] arrayContra = VentanaLogin.passwordField.getPassword();
//			String pass = new String(arrayContra);
//
//			Calendar cal1 = Calendar.getInstance();
//			int mes = cal1.get(Calendar.MONTH) + 1;
//			String fechalta =""+cal1.get(Calendar.DATE)+"/"+mes
//					+"/"+cal1.get(Calendar.YEAR);
			
			jugador = new Jugador(VentanaRegistro.nombreTextField.getText(), VentanaRegistro.apellidoTextField.getText(), VentanaRegistro.dorsal, VentanaRegistro.posicion);

			String sentenciaSQL = new String();
			sentenciaSQL = "INSERT INTO jugador (nombre, apellido, dorsal, posicion)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"
					+jugador.getNombre()+ "','" +jugador.getApellido()+ "','" +jugador.getDorsal()+ "','"+jugador.getPosicion()+"');"; 
					//+ "', TO_DATE('" + jugador.fecha_alta +"', 'DD/MM/YYYY'),'"
					//+ jugador.poblacion	+ "','" + jugador.descripcion + "');";

			statement = connection.createStatement();
			statement.executeUpdate(sentenciaSQL);
			JOptionPane.showMessageDialog(null, "Guardado exitosamente");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, ex, "ERROR a la hora de crear jugador", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void insertarEntrenador() throws SQLException {
		
		char[] arrayContra = VentanaRegistroEntrenador.contraseinaTextField.getPassword();
		String pass = new String(arrayContra);
		
		Entrenador entrenadorNuevo = new Entrenador(VentanaRegistroEntrenador.nombreTextField.getText(), VentanaRegistroEntrenador.apellidoTextField.getText(), pass);
		
		String sentenciaSQL = new String();
		sentenciaSQL = "INSERT INTO entrenador (nombre, apellido, contraseña)";
		sentenciaSQL = sentenciaSQL + " VALUES ('"
				+entrenadorNuevo.getNombre()+ "','" +entrenadorNuevo.getApellido()+ "','" +entrenadorNuevo.getContraseña()+"');";
		
		statement = connection.createStatement();
		statement.executeUpdate(sentenciaSQL);
		JOptionPane.showInternalMessageDialog(null, "Entrenador registrado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Comprueba si existe el entrenador en la base de datos
	 * @return Devuelve el objeto entrenador
	 * @throws SQLException
	 */
	public static Entrenador comprobarLogin() throws SQLException {

		String entrenador = VentanaRegistroEntrenador.nombreTextField.getText();
		char[] arrayContra = VentanaRegistroEntrenador.contraseinaTextField.getPassword();
		String pass = new String(arrayContra); 

		statement = connection.createStatement();
		String sql ="SELECT nombre, contraseña FROM entrenador WHERE nombre = '"+entrenador+"' AND contraseña = '"+pass+"'";
		rs = statement.executeQuery(sql);

		Entrenador registrado = new Entrenador(entrenador, pass);

		rs.close();

		return registrado;
	}
}
