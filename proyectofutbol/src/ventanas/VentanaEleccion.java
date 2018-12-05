package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEleccion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public VentanaEleccion(Entrenador entrenador) {

		
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Ventana de Eleccion");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_2 = new JButton("Entrenamientos");
		btnNewButton_2.setBounds(10, 11, 167, 539);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEntrenamientos(entrenador).setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Partidos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaPartidos(entrenador).setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(200, 11, 167, 539);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Registrar Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(entrenador).setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(399, 11, 167, 539);
		contentPane.add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin().setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		btnAtras.setBounds(585, 527, 89, 23);
		contentPane.add(btnAtras);
		
	}
}
