package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base_de_datos.BaseDeDatos;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class VentanaRegistroEntrenador extends JFrame {

private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField nombreTextField;
	public static JTextField apellidoTextField;
	public static JPasswordField contraseinaTextField;
	public static JPasswordField contraseinaTextField2;
	public static JButton registrar;
	private JButton btnAtras;
	private JLabel lblDni;
	private JTextField textField;
	private JLabel lblFechaDeNacimiento;
	private JTextField fecha_naciTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroEntrenador frame = new VentanaRegistroEntrenador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistroEntrenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Ventana de Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][6px][45px,grow][6px][65px][6px][103px][6px][85px][][][][][][][]", "[25px][][][][][][][][][][][][][][][][][][][][]"));
		
		lblDni = new JLabel("DNI");
		contentPane.add(lblDni, "cell 1 2");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 5 2 3 1,alignx center");
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre, "cell 1 4,alignx left,aligny center");
		
		nombreTextField = new JTextField();
		contentPane.add(nombreTextField, "cell 5 4 3 1,alignx center,aligny center");
		nombreTextField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		contentPane.add(lblApellido, "cell 1 6,alignx left,aligny center");
		
		apellidoTextField = new JTextField();
		contentPane.add(apellidoTextField, "cell 5 6 3 1,alignx center,aligny center");
		apellidoTextField.setColumns(10);
		
		JLabel lblContraseina = new JLabel("Contrase�a");
		contentPane.add(lblContraseina, "cell 1 8,alignx left,aligny center");
		
		contraseinaTextField = new JPasswordField();
		contentPane.add(contraseinaTextField, "cell 5 8 3 1,alignx center,aligny center");
		contraseinaTextField.setColumns(10);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaLogin().setVisible(true);
				VentanaRegistroEntrenador.this.setVisible(false);
			}
		});
		
		JLabel lblContraseina2 = new JLabel("Repita contrase�a");
		contentPane.add(lblContraseina2, "cell 1 10,alignx left,aligny center");
		
		contraseinaTextField2 = new JPasswordField();
		contentPane.add(contraseinaTextField2, "cell 5 10 3 1,alignx center,aligny center");
		contraseinaTextField2.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		contentPane.add(lblFechaDeNacimiento, "cell 1 12");
		
		fecha_naciTextField = new JTextField();
		contentPane.add(fecha_naciTextField, "cell 5 12 3 1,alignx center");
		fecha_naciTextField.setText("dd/mm/yyyy");
		fecha_naciTextField.setColumns(10);
		contentPane.add(btnAtras, "cell 0 20,alignx center,aligny center");
		
		registrar = new JButton("Registrar");
		contentPane.add(registrar, "cell 16 20,alignx left,aligny center");
		registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(contraseinaTextField == contraseinaTextField2) {
					try {
						BaseDeDatos.insertarEntrenador();
						new VentanaLogin().setVisible(true);
						VentanaRegistroEntrenador.this.setVisible(false);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showInternalMessageDialog(null, "Entrenador no registrado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					contraseinaTextField.setText(null);
					contraseinaTextField2.setText(null);
					JOptionPane.showInternalMessageDialog(null, "Contrase�as diferentes", "Precaucion", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
}
