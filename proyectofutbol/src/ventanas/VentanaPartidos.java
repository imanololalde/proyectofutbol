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
import java.awt.Color;
import java.awt.Font;

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
		
		getContentPane().add(botones, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		layeredPane.add(getContentPane(), 1);
		layeredPane.add(panelFormacion1, 2);
		layeredPane.add(panelFormacion2, 3);
		layeredPane.add(panelFormacion3, 4);
		layeredPane.add(panelFormacion4, 5);
		
		//Componentes		
		JLabel campo = new JLabel();
		campo.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/campo bueno.jpg")));
		campo.setMaximumSize(panelPrincipal.getSize());
		panelPrincipal.add(campo);
		
		JButton btnAtras = new JButton("Atras");
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		
		botones.add(btnGuardarCambios, BorderLayout.WEST);
		botones.add(btnAtras, BorderLayout.EAST);
		
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
		
		JComboBox formaciones = new JComboBox(formacion);
		botones.add(formaciones, BorderLayout.CENTER);
		
		if(formaciones.getSelectedIndex() == 1) {
			layeredPane.setLayer(panelFormacion1, 2);
		} else if (formaciones.getSelectedIndex() == 2) {
			layeredPane.setLayer(panelFormacion2, 3);
		} else if (formaciones.getSelectedIndex() == 3) {
			layeredPane.setLayer(panelFormacion3, 4);
		} else if (formaciones.getSelectedIndex() == 4) {
			layeredPane.setLayer(panelFormacion4, 5);
		}

        }
	}