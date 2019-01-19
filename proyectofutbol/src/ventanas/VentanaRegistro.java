package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import base_de_datos.BaseDeDatos;
import datos.Entrenador;
import datos.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel panelLabels;
	private JPanel botones;
	private JPanel panelMenu;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField dorsalTextField;
	private JTextField fecha_nacimientoTextField;
	public static String[] posiciones = {"Delantero", "Centrocampista", "Defensa", "Portero"};
	public static JComboBox<Object> comboBox;
	public static String posicion;
	public static int dorsal;
	private JButton ainadirJugador;
	private JButton eliminarJugador;
	private JButton editarJugador;
	
	/**
	 * Launch the application.
	 */
	public VentanaRegistro(Entrenador entrenador) {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Registro "+entrenador.getNombre());
		setLocationRelativeTo(null);
		//Paneles
		panelPrincipal = new JPanel(new GridLayout(6, 1));
		panelLabels = new JPanel(new GridLayout(6, 1));
		botones = new JPanel(new GridLayout(1, 4));
		panelMenu = new JPanel();
		//Componentes
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblFecha_Nacimiento = new JLabel("Fecha de nacimiento");
		lblFecha_Nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTextField = new JTextField();
		apellidoTextField = new JTextField();
		dorsalTextField = new JTextField();
		fecha_nacimientoTextField = new JTextField();
		fecha_nacimientoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		fecha_nacimientoTextField.setText("yyyy/mm/dd");
		comboBox = new JComboBox<Object>(posiciones);
		comboBox.setMaximumRowCount(4);
		JButton batras = new JButton("Atras");
		JButton bborrar = new JButton("Borrar");
		JButton bregistrar = new JButton("Registrar");
		JButton bguardar = new JButton("Guardar");
		ainadirJugador = new JButton("Añadir Jugador");
		eliminarJugador = new JButton("Eliminar Jugador");
		editarJugador = new JButton("Editar Jugador");
		//Asignacion
		panelLabels.add(lblNombre, new GridLayout(1, 1));
		panelLabels.add(lblApellido, new GridLayout(2, 1));
		panelLabels.add(lblPosicion, new GridLayout(3, 1));
		panelLabels.add(lblDorsal, new GridLayout(4, 1));
		panelLabels.add(lblFecha_Nacimiento, new GridLayout(5, 1));
		panelPrincipal.add(nombreTextField, new GridLayout(1, 1));
		panelPrincipal.add(apellidoTextField, new GridLayout(2, 1));
		panelPrincipal.add(comboBox, new GridLayout(3, 1));
		panelPrincipal.add(dorsalTextField, new GridLayout(4, 1));
		panelPrincipal.add(fecha_nacimientoTextField, new GridLayout(5, 1));
		botones.add(bregistrar, new GridLayout(1, 1));
		botones.add(bborrar, new GridLayout(1, 2));
		botones.add(bguardar, new GridLayout(1, 3));
		botones.add(batras, new GridLayout(1, 4));
		panelMenu.add(ainadirJugador);
		panelMenu.add(eliminarJugador);
		panelMenu.add(editarJugador);
		
		getContentPane().add( panelMenu, BorderLayout.NORTH );
		getContentPane().add( panelLabels, BorderLayout.WEST );
		getContentPane().add( panelPrincipal, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		ainadirJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelLabels.setVisible(true);
			}
		});
		
		eliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(false);
				panelLabels.setVisible(false);
				JPanel pEliminar = new JPanel();
				getContentPane().add(pEliminar, BorderLayout.CENTER);
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.setColumnIdentifiers(new Object[]{"nombre","apellido","posicion"});
				try {
					while(BaseDeDatos.rs.next()) {
						modelo.addRow(new Object[]{BaseDeDatos.rs.getString("nombre"), BaseDeDatos.rs.getString(2)});
					}
				} catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		editarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(false);
				panelLabels.setVisible(false);
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicion = comboBox.getSelectedItem().toString();
			}
		});
		
		batras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaRegistro.this.setVisible(false);
			}
		});
		
		bregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(nombreTextField.equals(null) || apellidoTextField == null || 
						dorsalTextField == null || fecha_nacimientoTextField == null) {
					JOptionPane.showMessageDialog(null, "Debe rellenar los datos", "Atención", JOptionPane.WARNING_MESSAGE);
				} else {
					dorsal = Integer.parseInt(dorsalTextField.getText());
					BaseDeDatos.conectarBD();
					Entrenador entrenadorCompleto = BaseDeDatos.verEntrenador(entrenador);
					Jugador registrado = new Jugador(nombreTextField.getText(), apellidoTextField.getText(), posicion, dorsal, fecha_nacimientoTextField.getText(), entrenadorCompleto);
					if(BaseDeDatos.insertarJugador(registrado, entrenadorCompleto)) {
						new VentanaEleccion(entrenador).setVisible(true);
						VentanaRegistro.this.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Error a la hora de registrar jugador", "Registro", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}
