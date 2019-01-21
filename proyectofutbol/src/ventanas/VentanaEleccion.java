package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import datos.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class VentanaEleccion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel botones;

	/**
	 * Launch the application.
	 */
	public VentanaEleccion(Entrenador entrenador) {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Eleccion "+entrenador.getNombre());
		setLocationRelativeTo(null);
		//Paneles
		panelPrincipal = new JPanel(new GridLayout(1, 3));
		botones = new JPanel(new BorderLayout());
		//Componentes
		JButton bEntrena = new JButton("Entrenamientos");
		JButton bPartidos = new JButton("Partidos");
		JButton bRegistro = new JButton("Registrar Jugadores");
		JButton bAtras = new JButton("Atras");
		//Asigancion
		panelPrincipal.add(bEntrena, new GridLayout(1, 1));
		panelPrincipal.add(bPartidos, new GridLayout(1, 2));
		panelPrincipal.add(bRegistro, new GridLayout(1, 3));
		botones.add(bAtras, BorderLayout.EAST);
		getContentPane().add( panelPrincipal, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		bEntrena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEntrenamientos().setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		
		bPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaPartidos(entrenador).setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		
		bRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(entrenador).setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin().setVisible(true);
				VentanaEleccion.this.setVisible(false);
			}
		});
	}
}
