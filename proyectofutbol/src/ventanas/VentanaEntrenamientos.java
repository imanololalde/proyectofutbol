package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datos.Entrenador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class VentanaEntrenamientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel panelSecundario;
	private JPanel botones;
	private JList list;

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
		panelPrincipal = new JPanel(new GridLayout(2, 5));
		panelSecundario = new JPanel();
		botones = new JPanel(new BorderLayout());
		//Componentes
		JButton bAtras = new JButton("Atras");
		JLabel entrenamientos = new JLabel("Entrenamientos");
		//Asignacion
		botones.add(bAtras, BorderLayout.EAST);
		panelPrincipal.add(entrenamientos, new GridLayout(1, 1));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		list = new JList();
		panelSecundario.add(list);
		
		JLabel entrena = new JLabel("");
		entrena.setIcon(new ImageIcon(VentanaEntrenamientos.class.getResource("/imagenes/ejercicio1.jpg")));
		
		list.add("Entrenamientos", entrena);
		
		getContentPane().add( panelPrincipal, BorderLayout.EAST );
		getContentPane().add( panelSecundario, BorderLayout.CENTER );
		getContentPane().add( botones, BorderLayout.SOUTH );
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaEntrenamientos.this.setVisible(false);
			}
		});
	}
}
