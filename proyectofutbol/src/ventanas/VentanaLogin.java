package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import base_de_datos.*;
import datos.Entrenador;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField textField;
	public static JPasswordField passwordField;
	public static JButton registrar;
	public static JButton iniciar_sesion;

	/**
	 * Launch the application.
	 */
	public VentanaLogin() {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar();
	}

	/**
	 * Create the frame.
	 */
	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Ventana Login");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel lblUsuario = new JLabel("Usuario");
		contentPane.add(lblUsuario, "cell 1 2");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 3,growx");
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		contentPane.add(lblContrasea, "cell 1 4");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 1 5,growx");
		
		registrar = new JButton("registrar");
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaRegistroEntrenador().setVisible(true);
				VentanaLogin.this.setVisible(false);
			}
		});
		contentPane.add(registrar, "cell 0 9");
		
		iniciar_sesion = new JButton("Iniciar Sesion");
		
		iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comprobar que el entrenador esta en la base de datos
				BaseDeDatos.conectarBD();

				String contraseina = BaseDeDatos.convertir(passwordField.getPassword());
				Entrenador entrenador = new Entrenador(textField.getText(),contraseina);

				Entrenador nuevoEntrenador = BaseDeDatos.comprobarLogin(entrenador);
				BaseDeDatos.cerrarConexion();
				new VentanaEleccion(nuevoEntrenador).setVisible(true);
				VentanaLogin.this.setVisible(false);
				JOptionPane.showConfirmDialog(null, "Entrenador no registrado", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(iniciar_sesion, "cell 1 9");
		
	}

}
