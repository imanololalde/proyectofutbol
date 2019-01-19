package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import base_de_datos.BaseDeDatos;
import datos.Entrenador;
import datos.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel panelLabels;
	private JPanel botones;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField dorsalTextField;
	private JTextField fecha_nacimientoTextField;
	public static String[] posiciones = {"Delantero", "Centrocampista", "Defensa", "Portero"};
	public static JComboBox<Object> comboBox;
	public static String posicion;
	public static int dorsal;
	
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
		setTitle("Ventana de Registro");
		setLocationRelativeTo(null);
		//Paneles
		panelPrincipal = new JPanel(new GridLayout(6, 1));
		panelLabels = new JPanel(new GridLayout(6, 1));
		botones = new JPanel(new BorderLayout());
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
		JButton bregistrar = new JButton("Registrar");
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
		botones.add(bregistrar, BorderLayout.CENTER);
		botones.add(batras, BorderLayout.EAST);
		getContentPane().add( panelLabels, BorderLayout.WEST );
		getContentPane().add( panelPrincipal, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
				dorsal = Integer.parseInt(dorsalTextField.getText());
				Jugador registrado = new Jugador(nombreTextField.getText(), apellidoTextField.getText(), posicion, dorsal, fecha_nacimientoTextField.getText(), entrenador);
				BaseDeDatos.conectarBD();
				BaseDeDatos.insertarJugador(registrado, entrenador);
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaRegistro.this.setVisible(false);
			}
		});
	}
}
