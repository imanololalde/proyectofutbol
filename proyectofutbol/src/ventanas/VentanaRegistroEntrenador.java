package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base_de_datos.BaseDeDatos;

public class VentanaRegistroEntrenador extends JFrame {

private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField nombreTextField;
	public static JTextField apellidoTextField;
	public static JPasswordField contraseinaTextField;
	public static JPasswordField contraseinaTextField2;
	public static JButton registrar;

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
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(62, 68, 201, 14);
		contentPane.add(lblNombre);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(62, 93, 162, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(62, 161, 46, 14);
		contentPane.add(lblApellido);
		
		apellidoTextField = new JTextField();
		apellidoTextField.setBounds(62, 206, 86, 20);
		contentPane.add(apellidoTextField);
		apellidoTextField.setColumns(10);
		
		JLabel lblContraseina = new JLabel("Contraseña");
		lblContraseina.setBounds(62, 256, 60, 14);
		contentPane.add(lblContraseina);
		
		contraseinaTextField = new JPasswordField();
		contraseinaTextField.setBounds(62, 306, 86, 20);
		contentPane.add(contraseinaTextField);
		contraseinaTextField.setColumns(10);
		
		JLabel lblContraseina2 = new JLabel("Repita contraseña");
		lblContraseina2.setBounds(62, 356, 100, 14);
		contentPane.add(lblContraseina2);
		
		contraseinaTextField2 = new JPasswordField();
		contraseinaTextField2.setBounds(62, 406, 86, 20);
		contentPane.add(contraseinaTextField2);
		contraseinaTextField2.setColumns(10);
		
		registrar = new JButton("Registrar");
		contentPane.add(registrar);
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
					JOptionPane.showInternalMessageDialog(null, "Contraseñas diferentes", "Precaucion", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
}
