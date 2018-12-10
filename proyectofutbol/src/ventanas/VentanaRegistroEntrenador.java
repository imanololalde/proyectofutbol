package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import base_de_datos.BaseDeDatos;
import datos.Entrenador;

import javax.swing.SwingConstants;

public class VentanaRegistroEntrenador extends JFrame {

private static final long serialVersionUID = 1L;
	
	private JPanel panelLabels;
	private JPanel panelPrincipal;
	private JPanel botones;
	private JTextField dniTextField;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JPasswordField contraseinaTextField;
	private JPasswordField contraseinaTextField2;
	private JTextField fecha_naciTextField;
	private JButton bregistrar;
	private JButton batras;

	/**
	 * Launch the application.
	 */
	public VentanaRegistroEntrenador() {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar();
	}

	/**
	 * Create the frame.
	 */
	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Registro");
		setLocationRelativeTo(null);
		//Paneles
		panelLabels = new JPanel(new GridLayout(6, 1));
		panelPrincipal = new JPanel(new GridLayout(6, 1));
		botones = new JPanel(new BorderLayout());
		//Componentes
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblContraseina = new JLabel("Contraseña");
		lblContraseina.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblContraseina2 = new JLabel("Repita contraseña");
		lblContraseina2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		dniTextField = new JTextField();
		nombreTextField = new JTextField();
		apellidoTextField = new JTextField();
		contraseinaTextField = new JPasswordField();
		contraseinaTextField2 = new JPasswordField();
		fecha_naciTextField = new JTextField();
		fecha_naciTextField.setText("yyyy/mm/dd");
		fecha_naciTextField.setHorizontalAlignment(SwingConstants.CENTER);
		bregistrar = new JButton("Registrar");
		batras = new JButton("Atras");
		//Asignacion
		panelLabels.add(lblDni, new GridLayout(1, 1));
		panelLabels.add(lblNombre, new GridLayout(2, 1));
		panelLabels.add(lblApellido, new GridLayout(3, 1));
		panelLabels.add(lblContraseina, new GridLayout(4, 1));
		panelLabels.add(lblContraseina2, new GridLayout(5, 1));
		panelLabels.add(lblFechaDeNacimiento, new GridLayout(6, 1));
		panelPrincipal.add(dniTextField, new GridLayout(1, 1));
		panelPrincipal.add(nombreTextField, new GridLayout(2, 1));
		panelPrincipal.add(apellidoTextField, new GridLayout(3, 1));
		panelPrincipal.add(contraseinaTextField, new GridLayout(4, 1));
		panelPrincipal.add(contraseinaTextField2, new GridLayout(5, 1));
		panelPrincipal.add(fecha_naciTextField, new GridLayout(6, 1));
		botones.add(bregistrar, BorderLayout.CENTER);
		botones.add(batras, BorderLayout.EAST);
		getContentPane().add( panelLabels, BorderLayout.WEST );
		getContentPane().add( panelPrincipal, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		batras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaLogin().setVisible(true);
				VentanaRegistroEntrenador.this.setVisible(false);
			}
		});
		
		bregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String contraseina1 = BaseDeDatos.convertir(contraseinaTextField.getPassword());
				String contraseina2 = BaseDeDatos.convertir(contraseinaTextField2.getPassword());
				
				Calendar fecha = Calendar.getInstance();
				int mes = fecha.get(Calendar.MONTH) + 1;	//empieza en el mes 0
				String fecha_inscripcion =""+fecha.get(Calendar.DATE)+"/"+mes+"/"+fecha.get(Calendar.YEAR);
				
				if(contraseina1.equals(contraseina2)) {
					BaseDeDatos.conectarBD();
					Entrenador entrenador = new Entrenador(dniTextField.getText(), nombreTextField.getText(), 
							apellidoTextField.getText(), contraseina2, fecha_naciTextField.getText(), fecha_inscripcion);
					boolean correcto = true;
					if(correcto == BaseDeDatos.insertarEntrenador(entrenador)) {
						BaseDeDatos.cerrarConexion();
						new VentanaEleccion(entrenador).setVisible(true);
						VentanaRegistroEntrenador.this.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Entrenador no registrado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					contraseinaTextField.setText(null);
					contraseinaTextField2.setText(null);
					JOptionPane.showMessageDialog(null, "Contraseñas diferentes", "Precaucion", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
