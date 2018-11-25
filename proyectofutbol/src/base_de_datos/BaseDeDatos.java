package base_de_datos;

import java.sql.Connection;

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
	
	/**
	 * El servidor se conecta a la base de datos
	 * @throws ClassNotFoundException
	 */
	public static void conectarBD() throws ClassNotFoundException {

		String username = "jsxigzifksfofs";
		String password = "837a4cd59231a62c30fd00d7aa39bb2f1fe6a33465b3fb30682bb9758c629809";
		String urldB = "jdbc:postgresql://ec2-54-221-204-161.compute-1.amazonaws.com:5432/d7k4h8c5tjnkec";
		String dbUrl = urldB + "?sslmode=require";

		Class.forName("org.postgresql.Driver");

		try {
			connection = DriverManager.getConnection( dbUrl, username, password );
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS entrenador (dni VARCHAR(9) NOT NULL PRIMARY KEY, nombre CHAR(20) NOT NULL, apellido CHAR(20) NOT NULL, contraseña VARCHAR(30),"
					+ " fecha_nacimiento DATE, fecha_inscripcion DATE)");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS jugador (nombre CHAR(20) NOT NULL PRIMARY KEY, apellido CHAR(30) NOT NULL UNIQUE, posicion CHAR(20) NOT NULL, dorsal INT,"
					+ " fecha_nacimiento DATE, entrenador CHAR(20) REFERENCES entrenador(nombre))");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS plantilla (nombre CHAR(30), nombre_entrenador CHAR(20) REFERENCES entrenador(nombre),"
					+ " numero_jugadores INT, formacion VARCHAR(5), figura_formacion CHAR(20), PRIMARY KEY(nombre, nombre_entrenador))");
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		} 
	}

	public static void cerrarConexion() {

		if (rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			}catch(Exception e) {
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
			System.out.println("Fecha de Nacimiento = " + rs.getDate("fecha_nacimiento"));
			System.out.println("Entrenador = " + rs.getString("entrenador"));
		}
		rs.close();
		return rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getDate(5)+rs.getString(6);
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
			System.out.println("DNI ="+rs.getString(1));
			System.out.println("Nombre ="+rs.getString(2));
			System.out.println("Apellido ="+rs.getString(3));
			System.out.println("Fecha de nacimiento ="+rs.getDate(5));
			System.out.println("Fecha de inscripcion ="+rs.getDate(6));
		}
		rs.close();
		return rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getDate(5)+rs.getDate(6);
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

	public static void insertarJugador(Jugador a, Entrenador entrenador) {

		try {
			String sentenciaSQL = new String();
			sentenciaSQL = "INSERT INTO jugador (nombre, apellido, posicion, dorsal, fecha_nacimiento, entrenador)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"
					+a.getNombre()+ "','" +a.getApellido()+ "','" +a.getPosicion()+ "','"+a.getDorsal()+"','"+a.getFecha_Naci()+"','"+entrenador.getNombre()+"');"; 

			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(sentenciaSQL);
			JOptionPane.showMessageDialog(null, "Guardado exitosamente");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, ex, "ERROR a la hora de crear jugador", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void insertarEntrenador(Entrenador entrenador) throws SQLException {
		
		Calendar fecha = Calendar.getInstance();
		int mes = fecha.get(Calendar.MONTH) + 1;
		String fecha_inscripcion =""+fecha.get(Calendar.DATE)+"/"+mes+"/"+fecha.get(Calendar.YEAR);
		
		String sentenciaSQL = new String();
		sentenciaSQL = "INSERT INTO entrenador (dni, nombre, apellido, contraseña, fecha_nacimiento, fecha_inscripcion)";
		sentenciaSQL = sentenciaSQL + " VALUES ('"
				+entrenador.getNombre()+"','"+entrenador.getApellido()+"','"+entrenador.getContraseña()+"','"+entrenador.getFecha_naci()+
				"','"+fecha_inscripcion+"')";
		
		statement = connection.createStatement();
		statement.setQueryTimeout(30);
		statement.executeUpdate(sentenciaSQL);
		JOptionPane.showMessageDialog(null, "Entrenador registrado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Comprueba si existe el entrenador en la base de datos
	 * @return Devuelve el objeto entrenador
	 * @throws SQLException
	 */
	public static Entrenador comprobarLogin(Entrenador entrenador) throws SQLException {

		statement = connection.createStatement();
		String sql ="SELECT nombre, contraseña FROM entrenador WHERE nombre = '"+entrenador.getNombre()+"' AND contraseña = '"+entrenador.getContraseña()+"'";
		rs = statement.executeQuery(sql);

		Entrenador registrado = new Entrenador(entrenador.getNombre(), entrenador.getContraseña());

		rs.close();

		return registrado;
	}
	
	public static String convertir(char[] password) {
		String contra = "";
		for(int i = 0; i < password.length; i++){
			contra+=password[i];
		}
		return contra;
	}
}
