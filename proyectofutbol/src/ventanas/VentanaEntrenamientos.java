package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import datos.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class VentanaEntrenamientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel botones;

	/**
	 * Launch the application.
	 */
	public VentanaEntrenamientos(Entrenador entrenador) {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Entrenamientos");
		setLocationRelativeTo(null);
		//Paneles
		panelPrincipal = new JPanel();
		botones = new JPanel(new BorderLayout());
		//Componentes
		JButton bAtras = new JButton("Atras");
		//Asignacion
		botones.add(bAtras, BorderLayout.EAST);
		getContentPane().add( panelPrincipal, BorderLayout.EAST );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaEntrenamientos.this.setVisible(false);
			}
		});
	}
}
