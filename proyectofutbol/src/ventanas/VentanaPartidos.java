package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import datos.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.BorderLayout;


public class VentanaPartidos extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel botones;
	public String[] formacion={"2-3-1", "2-2-2", "3-2-1", "3-1-2"};
	public Object seleccionPor, seleccionDef1, seleccionDef2, seleccionCen1, seleccionCen2, seleccionCen3,seleccionDel;

	/**
	 * Launch the application.
	 *  
	 */
	public VentanaPartidos(Entrenador entrenador) {
		this.setSize(670,500);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Partidos");
		setLocationRelativeTo(null);
		setResizable(false);
		//Paneles
		JLayeredPane layeredPane = new JLayeredPane();
		
		panelPrincipal = new JPanel(new BorderLayout());
		botones = new JPanel(new BorderLayout());
		JPanel panelFormacion1 = new JPanel();
		JPanel panelFormacion2 = new JPanel();
		JPanel panelFormacion3 = new JPanel();
		JPanel panelFormacion4 = new JPanel();
		
		layeredPane.add(panelPrincipal, 1);
		layeredPane.add(panelFormacion1, 2);
		layeredPane.add(panelFormacion2, 3);
		layeredPane.add(panelFormacion3, 4);
		layeredPane.add(panelFormacion4, 5);
		
		//Componentes		
		JLabel campo = new JLabel();
		campo.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/campo bueno.jpg")));
		campo.setMaximumSize(panelPrincipal.getSize());
		panelPrincipal.add(campo);
		
		JComboBox formaciones = new JComboBox(formacion);
		JButton btnAtras = new JButton("Atras");
		JButton btnGuardarCambios = new JButton("Guardar cambios");

		botones.add(btnGuardarCambios, BorderLayout.WEST);
		botones.add(btnAtras, BorderLayout.EAST);
		botones.add(formaciones, BorderLayout.CENTER);
		
		getContentPane().add(layeredPane);
		getContentPane().add(botones, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaPartidos.this.setVisible(false);
			}
		});
		
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("img_por: "+nombre_por.getText()+
//						"; Defensas: "+nombre_def1.getText()+" y "+nombre_def2.getText()+
//						"; Centrocampitas: "+nombre_cen1.getText()+", "+nombre_cen2.getText()+" y "+nombre_cen3.getText()+
//						"; Delantero: "+nombre_del1.getText());
			}
		});
		
		if(formaciones.getSelectedIndex() == 1) {
			layeredPane.setLayer(panelFormacion1, 2);
			panelPrincipal.setOpaque(true);
			panelPrincipal.setVisible(false);
			Posiciones portero = new Posiciones("", SwingConstants.CENTER);
			Posiciones defensa = new Posiciones("", SwingConstants.CENTER);
			Posiciones centro = new Posiciones("", SwingConstants.CENTER);
			Posiciones delantero = new Posiciones("", SwingConstants.CENTER);
			//imagenes
			portero.definirPosicion(1);
			defensa.definirPosicion(2);
			centro.definirPosicion(3);
			delantero.definirPosicion(4);
			//nombres
			portero.elegirJugador();
			defensa.elegirJugador();
			centro.elegirJugador();
			delantero.elegirJugador();
			//colocacion
			portero.setLocation(panelFormacion1.getHeight()/2, panelFormacion1.getWidth()/4);
			
			panelFormacion1.add(portero);
		} else if (formaciones.getSelectedIndex() == 2) {
			layeredPane.setLayer(panelFormacion2, 3);
			
		} else if (formaciones.getSelectedIndex() == 3) {
			layeredPane.setLayer(panelFormacion3, 4);
			
		} else if (formaciones.getSelectedIndex() == 4) {
			layeredPane.setLayer(panelFormacion4, 5);
			
		}

        }
	}