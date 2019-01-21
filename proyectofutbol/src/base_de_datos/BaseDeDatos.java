package base_de_datos;

import java.sql.Connection;

import datos.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class BaseDeDatos {

	public static ResultSet rs;
	private static Statement statement;
	private static Connection connection = null;
	
	/**
	 * El servidor se conecta a la base de datos
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public static boolean conectarBD() {
		String user = "postgres";
		String password = "proyectoProgramacion";
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Futbol", user, password);
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS entrenador (dni VARCHAR(9) NOT NULL PRIMARY KEY, nombre CHAR(20) NOT NULL, apellido CHAR(20) NOT NULL, contraseña VARCHAR(30),"
					+ " fecha_nacimiento DATE, fecha_inscripcion DATE)");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS jugador (nombre CHAR(20) NOT NULL, apellido CHAR(30) NOT NULL, posicion CHAR(20) NOT NULL, dorsal INT,"
					+ " fecha_nacimiento DATE, dni_ent VARCHAR(9), FOREIGN KEY (dni_ent) REFERENCES entrenador (dni), PRIMARY KEY (nombre, apellido))");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS plantilla (nombre CHAR(30) NOT NULL, dni_ent CHAR(20), FOREIGN KEY (dni_ent) REFERENCES entrenador (dni),"
					+ " numero_jugadores INT, formacion VARCHAR(5), PRIMARY KEY(nombre, dni_ent))");
			
			log(Level.INFO, "Base de datos conectada", null);
			return true;
		} catch(ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "Error en conexión de base de datos", e);
			return false;
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
			statement = connection.createStatement();
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
	 * Visualiza todos los jugadores que hay en la base de datos para crear una tabla
	 * @return Nombre y apellido de los jugadores guardados
	 */
	public static JTable creadorTabla() {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM jugador");
			ResultSetMetaData metaDatos = rs.getMetaData();
			
			int numeroColumnas = metaDatos.getColumnCount();
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = new JTable(modelo);
			Object[] etiquetas = new Object[numeroColumnas];
			//Crea las cabeceras del JTable
			for (int i = 0; i < numeroColumnas; i++) {
				etiquetas[i] = metaDatos.getColumnLabel(i + 1);
				modelo.setColumnIdentifiers(etiquetas);
			}
			//Crea las filas para el JTable
			while(rs.next()) {
				Object[] fila = new Object[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					fila[i]=rs.getObject(i+1);
				}
				modelo.addRow(fila);
			}
			rs.close();
			log(Level.INFO, "Lista de jugadores", null);
			return tabla;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error, no se han podidio visualizar los jugadores", e);
			return null;
		}
	}
	
	public static void borrarFilaDeTabla(JTable tabla) {
		DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
		if(tabla.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(null, "Debe elegir una fila", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			dtm.removeRow(tabla.getSelectedRow());
		}
	}

	public static void datosDesdeTabla(JTable tabla) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		int filas = modelo.getRowCount();
		
		for(int i = 0; i < filas; i++) {
			
		}
		modelo.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE){
					int columna = e.getColumn();
					int fila = e.getFirstRow();
					if(columna == 0){
						String sql = "UPDATE jugador SET nombre = '"+ tabla.getValueAt(fila, columna) +"' WHERE id_usuario = 2;";
						try {
							statement = connection.createStatement();
							rs = statement.executeQuery(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	/**
	 * Visualiza toda la información guardada que hay del entrenador
	 * @param Entrenador
	 * @return Entrenador
	 * @throws SQLException
	 */
	public static Entrenador verEntrenador(Entrenador entrenador) {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM entrenador WHERE nombre = '"+entrenador.getNombre()+"' AND contraseña = '"+entrenador.getContraseña()+"';");
			Entrenador entrenadorCompleto = null;
			while (rs.next()){
				System.out.println("DNI = "+rs.getString(1));
				System.out.println("Nombre = "+rs.getString(2));
				System.out.println("Apellido = "+rs.getString(3));
				System.out.println("Contraseña = "+rs.getString(4));
				System.out.println("Fecha de nacimiento = "+rs.getDate(5));
				System.out.println("Fecha de inscripcion = "+rs.getDate(6));
				entrenadorCompleto = new Entrenador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toString(), rs.getDate(6).toString());
			}
			rs.close();
			log(Level.INFO, "Seleccionado el entrenador " + entrenador.getNombre(), null);
			return entrenadorCompleto;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de seleccionar entrenador", e);
			return null;
		}
	}

	/**
	 * Elimina un jugador de la base de datos
	 * @param jugador
	 * @return True si se ha eliminado y false si no se ha conseguido borrar
	 * @throws SQLException
	 */
	public static boolean eliminarJugador(Jugador jugador) {	
		try {
			statement = connection.createStatement();
			String sql ="DELETE FROM jugador WHERE nombre = '"+jugador.getNombre()+"' AND apellido = '"
					+jugador.getApellido()+"' AND"
					+ " posicion = '"+jugador.getPosicion()+"' AND dorsal = '"+jugador.getDorsal()+"';";
			rs = statement.executeQuery(sql);
			rs.close();
			log(Level.INFO, jugador + "eliminado de la base de datos", null);
			return true;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de eliminar jugador", e);
			return false;
		}
	}

	/**
	 * Inserta un jugador en la base de datos. Se necesita un entrenador para saber de quien es el jugador.
	 * @param jugador, entrenador
	 * @return True si ha sido insertado y false si no se ha conseguido.
	 * @throws SQLException
	 */
	public static boolean insertarJugador(Jugador jugador, Entrenador entrenador) {
		try {
			String sentenciaSQL = new String();
			statement = connection.createStatement();
			sentenciaSQL = "INSERT INTO jugador (nombre, apellido, posicion, dorsal, fecha_nacimiento, dni_ent)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"
					+jugador.getNombre()+ "','" +jugador.getApellido()+ "','" +jugador.getPosicion()
					+ "','"+jugador.getDorsal()+"','"+jugador.getFecha_Naci()+"','"+entrenador.getDni()+"');"; 

			statement.executeUpdate(sentenciaSQL);
			log(Level.INFO, jugador + "añadido a la base de datos", null);
			return true;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de insertar al jugador " + jugador.getNombre(), e);
			return false;
		}
	}
	
	/**
	 * Inserta un entrenador en la base de datos
	 * @param entrenador
	 * @return True si ha sido insertado y false si no se ha conseguido
	 * @throws SQLException
	 */
	public static boolean insertarEntrenador(Entrenador entrenador) {
		try {
			statement = connection.createStatement();
			Calendar fecha = Calendar.getInstance();
			int mes = fecha.get(Calendar.MONTH) + 1;	//empieza en el mes 0
			String fecha_inscripcion =""+fecha.get(Calendar.DATE)+"/"+mes+"/"+fecha.get(Calendar.YEAR);
			
			String sentenciaSQL = new String();
			sentenciaSQL = "INSERT INTO entrenador (dni, nombre, apellido, contraseña, fecha_nacimiento, fecha_inscripcion)";
			sentenciaSQL = sentenciaSQL + " VALUES ('"+entrenador.getDni()+"','"
					+entrenador.getNombre()+"','"+entrenador.getApellido()+"','"+entrenador.getContraseña()+"','"+entrenador.getFecha_naci()+
					"','"+fecha_inscripcion+"')";
			
			statement.setQueryTimeout(30);
			statement.executeUpdate(sentenciaSQL);
			log(Level.INFO, entrenador + "añadido a la base de datos", null);
			return true;
		}catch (SQLException e) {
			log(Level.SEVERE, "Error a la hora de insertar al entrenador " + entrenador.getNombre(), e);
			return false;
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
			String sql ="SELECT * FROM entrenador WHERE nombre = '"
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
