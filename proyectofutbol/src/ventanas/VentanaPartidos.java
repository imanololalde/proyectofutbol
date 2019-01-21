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
		
<<<<<<< HEAD
=======
		JLabel nombre_por = new JLabel("", SwingConstants.CENTER);
		nombre_por.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_por.setForeground(Color.WHITE);
		panelPrincipal.add(nombre_por, new GridLayout(2, 2));
		nombre_por.setBackground(new Color(255, 0, 0));
		nombre_por.setOpaque(true);
		nombre_por.setVisible(false);
		
		JLabel nombre_def1 = new JLabel("", SwingConstants.CENTER);
		nombre_def1.setForeground(Color.WHITE);
		nombre_def1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_def1, new GridLayout(4, 1));
		nombre_def1.setBackground(new Color(255, 0, 0));
		nombre_def1.setOpaque(true);
		nombre_def1.setVisible(false);
		
		JLabel nombre_def2 = new JLabel("", SwingConstants.CENTER);
		nombre_def2.setForeground(Color.WHITE);
		nombre_def2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_def2, new GridLayout(4, 3));
		nombre_def2.setBackground(new Color(255, 0, 0));
		nombre_def2.setOpaque(true);
		nombre_def2.setVisible(false);
		

		JLabel nomcen1 = new JLabel("", SwingConstants.CENTER);
		nomcen1.setForeground(Color.WHITE);
		nomcen1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomcen1.setBounds(299, 323, 89, 29);
		panelPrincipal.add(nomcen1);
		nomcen1.setBackground(new Color(255, 0, 0));
		nomcen1.setOpaque(true);
		nomcen1.setVisible(false);

		JLabel nombre_cen1 = new JLabel("", SwingConstants.CENTER);
		nombre_cen1.setForeground(Color.WHITE);
		nombre_cen1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_cen1, new GridLayout(6, 1));
		nombre_cen1.setBackground(new Color(255, 0, 0));
		nombre_cen1.setOpaque(true);
		nombre_cen1.setVisible(false);
		
		JLabel nombre_cen2 = new JLabel("", SwingConstants.CENTER);
		nombre_cen2.setForeground(Color.WHITE);
		nombre_cen2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_cen2, new GridLayout(6, 2));
		nombre_cen2.setBackground(new Color(255, 0, 0));
		nombre_cen2.setOpaque(true);
		nombre_cen2.setVisible(false);

		
		JLabel nombre_cen3 = new JLabel("",  SwingConstants.CENTER);
		nombre_cen3.setForeground(Color.WHITE);
		nombre_cen3.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_cen3, new GridLayout(6, 3));
		nombre_cen3.setBackground(new Color(255, 0, 0));
		nombre_cen3.setOpaque(true);
		nombre_cen3.setVisible(false);
		
		JLabel nombre_del1 = new JLabel("",  SwingConstants.CENTER);
		nombre_del1.setForeground(Color.WHITE);
		nombre_del1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		panelPrincipal.add(nombre_del1, new GridLayout(8, 2));
		nombre_del1.setBackground(new Color(255, 0, 0));
		nombre_del1.setOpaque(true);
		
>>>>>>> branch 'master' of https://github.com/imanololalde/proyectofutbol.git
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