package base_de_datos;

import java.sql.Connection;

import datos.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {

	private static ResultSet rs;
	private static Statement statement;
	private static Connection connection = null;
	
	/**
	 * El servidor se conecta a la base de datos
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public static void conectarBD() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql:Futbol");
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS entrenador (dni VARCHAR(9) NOT NULL PRIMARY KEY, nombre CHAR(20) NOT NULL, apellido CHAR(20) NOT NULL, contraseña VARCHAR(30),"
					+ " fecha_nacimiento DATE, fecha_inscripcion DATE)");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS jugador (nombre CHAR(20) NOT NULL PRIMARY KEY, apellido CHAR(30) NOT NULL UNIQUE, posicion CHAR(20) NOT NULL, dorsal INT,"
					+ " fecha_nacimiento DATE, entrenador CHAR(20) REFERENCES entrenador(nombre))");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS plantilla (nombre CHAR(30), nombre_entrenador CHAR(20) REFERENCES entrenador(nombre),"
					+ " numero_jugadores INT, formacion VARCHAR(5), figura_formacion CHAR(20), PRIMARY KEY(nombre, nombre_entrenador))");
			
			log(Level.INFO, "Base de datos conectada", null);
		} catch(ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "Error en conexión de base de datos", e);
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
		log(Level.INFO, "Base de datos cerrada", null);
	}
	
	/**
	 * Para poder ver la información que hay en la tabla de jugador
	 * @param Jugador
	 * @return Nombre, Apellido, Dorsal y Posicion 
	 * @throws SQLException
	 */
	public static String verJugador(Jugador jugador) {
		try {
			rs = statement.executeQuery("SELECT "+jugador.getNombre()+" FROM jugador");
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
			log(Level.INFO, "Seleccionado el jugador " + jugador.getNombre(), null);
			return rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getDate(5)+rs.getString(6);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de seleccionar jugador", e);
			return null;
		}
	}

	/**
	 * Visualiza los nombres y apellidos de los entrenadores
	 * @param Entrenador
	 * @return Nombres y apellidos
	 * @throws SQLException
	 */
	public static String verEntrenador(Entrenador entrenador) {
		try {
			rs = statement.executeQuery("SELECT "+entrenador.getNombre()+" FROM entrenador");
			while(rs.next()) {
				System.out.println("DNI ="+rs.getString(1));
				System.out.println("Nombre ="+rs.getString(2));
				System.out.println("Apellido ="+rs.getString(3));
				System.out.println("Fecha de nacimiento ="+rs.getDate(5));
				System.out.println("Fecha de inscripcion ="+rs.getDate(6));
			}
			rs.close();
			log(Level.INFO, "Seleccionado el entrenador " + entrenador.getNombre(), null);
			return rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getDate(5)+rs.getDate(6);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de seleccionar entrenador", e);
			return null;
		}
	}

	public static void eliminarJugador(Jugador jugador) {	
		try {
			statement = connection.createStatement();
			String sql ="DELETE FROM jugador WHERE nombre = '"+jugador.getNombre()+"' AND apellido = '"
					+jugador.getApellido()+"' AND"
					+ " posicion = '"+jugador.getPosicion()+"' AND dorsal = '"+jugador.getDorsal()+"';";
			rs = statement.executeQuery(sql);
			rs.close();
			log(Level.INFO, jugador + "eliminado de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de eliminar jugador", e);
		}
	}

	public static void insertarJugador(Jugador jugador, Entrenador entrenador) {
		try {
			String sentenciaSQL = new String();
			statement = connection.createStatement();
			sentenciaSQL = "INSERT INTO jugador (nombre, apellido, posicion, dorsal, fecha_nacimiento, entrenador)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"
					+jugador.getNombre()+ "','" +jugador.getApellido()+ "','" +jugador.getPosicion()
					+ "','"+jugador.getDorsal()+"','"+jugador.getFecha_Naci()+"','"+entrenador.getNombre()+"');"; 

			statement.setQueryTimeout(30);
			statement.executeUpdate(sentenciaSQL);
			log(Level.INFO, jugador + "añadido a la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de insertar al jugador " + jugador.getNombre(), e);
		}
	}
	
	public static void insertarEntrenador(Entrenador entrenador) {
		try {
			statement = connection.createStatement();
			Calendar fecha = Calendar.getInstance();
			int mes = fecha.get(Calendar.MONTH) + 1;	//empieza en el mes 0
			String fecha_inscripcion =""+fecha.get(Calendar.DATE)+"/"+mes+"/"+fecha.get(Calendar.YEAR);
			String sentenciaSQL = new String();
			sentenciaSQL = "INSERT INTO entrenador (dni, nombre, apellido, contraseña, fecha_nacimiento, fecha_inscripcion)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"
					+entrenador.getNombre()+"','"+entrenador.getApellido()+"','"+entrenador.getContraseña()+"','"+entrenador.getFecha_naci()+
					"','"+fecha_inscripcion+"')";
			
			statement.setQueryTimeout(30);
			statement.executeUpdate(sentenciaSQL);
			log(Level.INFO, entrenador + "añadido a la base de datos", null);
		}catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de insertar al entrenador " + entrenador.getNombre(), e);
		}		
	}

	/**
	 * Comprueba si existe el entrenador en la base de datos
	 * @return Devuelve el objeto entrenador
	 * @throws SQLException
	 */
	public static Entrenador comprobarLogin(Entrenador entrenador) {
		try {
			statement = connection.createStatement();
			String sql ="SELECT nombre, contraseña FROM entrenador WHERE nombre = '"
					+entrenador.getNombre()+"' AND contraseña = '"+entrenador.getContraseña()+"'";
			rs = statement.executeQuery(sql);
			Entrenador registrado = new Entrenador(entrenador.getNombre(), entrenador.getContraseña());
			rs.close();
			log(Level.INFO, "Usuario y contraseña correctos " + entrenador, null);
			return registrado;
		}catch (SQLException e) {
			log(Level.SEVERE, "Error en usuario y contraseña " + entrenador.getNombre(), e);
			return null;
		}
	}
	
	public static String convertir(char[] password) {
		String contra = "";
		for(int i = 0; i < password.length; i++){
			contra+=password[i];
		}
		return contra;
	}
	
	private static Logger logger = null;
	
	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger==null) {  
			logger = Logger.getLogger(BaseDeDatos.class.getName());  
			logger.setLevel(Level.ALL);  
		}
		if (excepcion==null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}
}
