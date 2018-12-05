package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base_de_datos.BaseDeDatos;
import datos.Entrenador;
import datos.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField nombreTextField;
	public static JTextField apellidoTextField;
	public static JTextField dorsalTextField;
	public static JComboBox<String> comboBox;
	public String[] posiciones={"Delantero", "Centrocampista", "Defensa", "Portero"};
	public static String posicion;
	public static int dorsal;
	public static JButton registrar;
	public static JTextField fecha_nacimientoTextField;
	private JTextField posicionTextField;

	/**
	 * Launch the application.
	 */
	public VentanaRegistro(Entrenador entrenador) {
		VentanaRegistro frame = new VentanaRegistro(entrenador);
		frame.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Ventana de Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{90, 28, 201, 322, 90, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 14, 20, 14, 20, 14, 20, 17, 17, 17, 0, 20, 17, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		nombreTextField = new JTextField();
		GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
		gbc_nombreTextField.fill = GridBagConstraints.BOTH;
		gbc_nombreTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTextField.gridx = 2;
		gbc_nombreTextField.gridy = 3;
		contentPane.add(nombreTextField, gbc_nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 2;
		gbc_lblApellido.gridy = 4;
		contentPane.add(lblApellido, gbc_lblApellido);
		
		apellidoTextField = new JTextField();
		GridBagConstraints gbc_apellidoTextField = new GridBagConstraints();
		gbc_apellidoTextField.fill = GridBagConstraints.BOTH;
		gbc_apellidoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_apellidoTextField.gridx = 2;
		gbc_apellidoTextField.gridy = 5;
		contentPane.add(apellidoTextField, gbc_apellidoTextField);
		apellidoTextField.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		GridBagConstraints gbc_lblDorsal = new GridBagConstraints();
		gbc_lblDorsal.anchor = GridBagConstraints.WEST;
		gbc_lblDorsal.fill = GridBagConstraints.VERTICAL;
		gbc_lblDorsal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDorsal.gridx = 2;
		gbc_lblDorsal.gridy = 6;
		contentPane.add(lblDorsal, gbc_lblDorsal);
		
		dorsalTextField = new JTextField();
		GridBagConstraints gbc_dorsalTextField = new GridBagConstraints();
		gbc_dorsalTextField.fill = GridBagConstraints.BOTH;
		gbc_dorsalTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dorsalTextField.gridx = 2;
		gbc_dorsalTextField.gridy = 7;
		contentPane.add(dorsalTextField, gbc_dorsalTextField);
		dorsalTextField.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion");
		GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.anchor = GridBagConstraints.WEST;
		gbc_lblPosicion.fill = GridBagConstraints.VERTICAL;
		gbc_lblPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicion.gridx = 2;
		gbc_lblPosicion.gridy = 8;
		contentPane.add(lblPosicion, gbc_lblPosicion);
		
		posicionTextField = new JTextField();
		GridBagConstraints gbc_posicionTextField = new GridBagConstraints();
		gbc_posicionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_posicionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_posicionTextField.gridx = 2;
		gbc_posicionTextField.gridy = 9;
		contentPane.add(posicionTextField, gbc_posicionTextField);
		posicionTextField.setColumns(10);
		
		JLabel lblFecha_Nacimiento = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblFecha_Nacimiento = new GridBagConstraints();
		gbc_lblFecha_Nacimiento.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha_Nacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFecha_Nacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha_Nacimiento.gridx = 2;
		gbc_lblFecha_Nacimiento.gridy = 10;
		contentPane.add(lblFecha_Nacimiento, gbc_lblFecha_Nacimiento);
		
		fecha_nacimientoTextField = new JTextField();
		GridBagConstraints gbc_fecha_nacimientoTextField = new GridBagConstraints();
		gbc_fecha_nacimientoTextField.fill = GridBagConstraints.BOTH;
		gbc_fecha_nacimientoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_fecha_nacimientoTextField.gridx = 2;
		gbc_fecha_nacimientoTextField.gridy = 11;
		contentPane.add(fecha_nacimientoTextField, gbc_fecha_nacimientoTextField);
		fecha_nacimientoTextField.setColumns(10);
		fecha_nacimientoTextField.setText("YYYY-MM-DD");
		
		comboBox = new JComboBox<String>(posiciones);
		comboBox.setMaximumRowCount(4);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.fill = GridBagConstraints.VERTICAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 13;
		contentPane.add(comboBox, gbc_comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				posicion = comboBox.getSelectedItem().toString();
			}
		});
		
		JButton bAtras = new JButton("Atras");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaRegistro.this.setVisible(false);
			}
		});
		GridBagConstraints gbc_bAtras = new GridBagConstraints();
		gbc_bAtras.insets = new Insets(0, 0, 0, 5);
		gbc_bAtras.fill = GridBagConstraints.BOTH;
		gbc_bAtras.gridx = 0;
		gbc_bAtras.gridy = 14;
		contentPane.add(bAtras, gbc_bAtras);
		
		registrar = new JButton("Registrar");
		GridBagConstraints gbc_registrar = new GridBagConstraints();
		gbc_registrar.fill = GridBagConstraints.BOTH;
		gbc_registrar.gridx = 4;
		gbc_registrar.gridy = 14;
		contentPane.add(registrar, gbc_registrar);
		
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				dorsal = Integer.parseInt(dorsalTextField.getText());
				Jugador registrado = new Jugador(nombreTextField.getText(), apellidoTextField.getText(), posicion, dorsal, fecha_nacimientoTextField.getText(), entrenador);
				BaseDeDatos.insertarJugador(registrado, entrenador);
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaRegistro.this.setVisible(false);
			}
		});
		
	}
}
