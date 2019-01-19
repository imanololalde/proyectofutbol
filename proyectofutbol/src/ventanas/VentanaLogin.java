package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import base_de_datos.*;
import datos.Entrenador;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panelText;
	private JPanel botones;
	public static JTextField textField;
	public static JPasswordField passwordField;
	private JButton registrar;
	private JButton iniciar_sesion;
	private JButton salir;

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
		setTitle("Ventana Login");
		setLocationRelativeTo(null);
		//Paneles
		contentPane = new JPanel(new GridLayout(2, 1));
		panelText = new JPanel(new GridLayout(2, 1));
		botones = new JPanel();
		//Componentes
		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		textField = new JTextField();
		passwordField = new JPasswordField();
		registrar = new JButton("Registrar");
		iniciar_sesion = new JButton("Iniciar Sesion");
		salir = new JButton("Salir");
		//Asignacion
		contentPane.add(lblUsuario);
		contentPane.add(lblContrasea);
		panelText.add(textField);
		panelText.add(passwordField);
		botones.add(registrar);
		botones.add(iniciar_sesion);
		botones.add(salir);
		getContentPane().add( contentPane, BorderLayout.WEST );
		getContentPane().add( panelText, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaRegistroEntrenador().setVisible(true);
				VentanaLogin.this.setVisible(false);
			}
		});
		
		iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comprobar que el entrenador esta en la base de datos
				BaseDeDatos.conectarBD();

				String contraseina = BaseDeDatos.convertir(passwordField.getPassword());
				Entrenador entrenador = new Entrenador(textField.getText(),contraseina);

				Entrenador nuevoEntrenador = BaseDeDatos.comprobarLogin(entrenador);
				if(nuevoEntrenador == null) {
					JOptionPane.showConfirmDialog(null, "Entrenador no encontrado", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					BaseDeDatos.cerrarConexion();
					new VentanaEleccion(nuevoEntrenador).setVisible(true);
					VentanaLogin.this.setVisible(false);
				}
			}
		});
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose(); 
			}
		});
	}

}
