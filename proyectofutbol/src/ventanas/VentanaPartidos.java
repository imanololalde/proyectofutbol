package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import datos.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Component;

public class VentanaPartidos extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel botones;
	public String[] formacion={"2-3-1", "2-2-2", "3-2-1", "3-1-2"};
	public Object seleccionPor, seleccionDef1, seleccionDef2, seleccionCen1, seleccionCen2, seleccionCen3,seleccionDel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public VentanaPartidos(Entrenador entrenador) {
		this.setSize(670,500);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Partidos");
		setLocationRelativeTo(null);
		setResizable(false);
		//Paneles
		panelPrincipal = new JPanel(new BorderLayout());
		botones = new JPanel(new BorderLayout());
		
		getContentPane().add(botones, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		//Componentes
//		lblNewLabel = new JLabel("New label");
//		lblNewLabel.setAutoscrolls(true);
//		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		lblNewLabel.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/campo bueno.jpg")));
//		panelPrincipal.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanelConFondo fondo = new JPanelConFondo("/imagenes/campo bueno.jpg");
		fondo.setImagen("/imagenes/campo bueno.jpg");
		panelPrincipal.add(fondo, BorderLayout.CENTER);
		
		JButton btnAtras = new JButton("Atras");
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		
		JLabel nombre_por = new JLabel("", SwingConstants.CENTER);
		nombre_por.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_por.setForeground(Color.WHITE);
		nombre_por.setBackground(new Color(255, 0, 0));
		nombre_por.setOpaque(true);
		nombre_por.setVisible(false);
		
		JLabel nombre_def1 = new JLabel("", SwingConstants.CENTER);
		nombre_def1.setForeground(Color.WHITE);
		nombre_def1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_def1.setBackground(new Color(255, 0, 0));
		nombre_def1.setOpaque(true);
		nombre_def1.setVisible(false);
		
		JLabel nombre_def2 = new JLabel("", SwingConstants.CENTER);
		nombre_def2.setForeground(Color.WHITE);
		nombre_def2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_def2.setBackground(new Color(255, 0, 0));
		nombre_def2.setOpaque(true);
		nombre_def2.setVisible(false);
		
		JLabel nombre_cen1 = new JLabel("", SwingConstants.CENTER);
		nombre_cen1.setForeground(Color.WHITE);
		nombre_cen1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_cen1.setBackground(new Color(255, 0, 0));
		nombre_cen1.setOpaque(true);
		nombre_cen1.setVisible(false);
		
		JLabel nombre_cen2 = new JLabel("", SwingConstants.CENTER);
		nombre_cen2.setForeground(Color.WHITE);
		nombre_cen2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_cen2.setBackground(new Color(255, 0, 0));
		nombre_cen2.setOpaque(true);
		nombre_cen2.setVisible(false);
		
		JLabel nombre_cen3 = new JLabel("",  SwingConstants.CENTER);
		nombre_cen3.setForeground(Color.WHITE);
		nombre_cen3.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_cen3.setBackground(new Color(255, 0, 0));
		nombre_cen3.setOpaque(true);
		nombre_cen3.setVisible(false);
		
		JLabel nombre_del1 = new JLabel("",  SwingConstants.CENTER);
		nombre_del1.setForeground(Color.WHITE);
		nombre_del1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombre_del1.setBackground(new Color(255, 0, 0));
		nombre_del1.setOpaque(true);
		
		botones.add(btnGuardarCambios, BorderLayout.WEST);
		botones.add(btnAtras, BorderLayout.EAST);
		
		JLabel img_cen3 = new JLabel("");
		img_cen3.setHorizontalAlignment(SwingConstants.CENTER);
		img_cen3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen3 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Aritz", "Iker", "Javier" }, 
						   "Centrocampista");
				 
				 nombre_cen3.setText((String) seleccionCen3);
				 nombre_cen3.setVisible(true);
			}
		});
		
		JLabel img_por = new JLabel("");
		img_por.setHorizontalAlignment(SwingConstants.CENTER);
		img_por.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 seleccionPor = JOptionPane.showInputDialog( null,
						   "Seleccione Portero",
						   "Selector de Porteros",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Javi", "Carlos", "Eleder" }, 
						   "img_por");
				 
				 nombre_por.setText((String) seleccionPor);
				 nombre_por.setVisible(true);
				 
			}
		});
		
		JLabel img_def1 = new JLabel("");
		img_def1.setHorizontalAlignment(SwingConstants.CENTER);
		img_def1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionDef1 = JOptionPane.showInputDialog( null,
						   "Seleccione Defensa Central",
						   "Selector de Defensa Central",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Xabi", "Aitor 'EL COCHES'", "Lucas" }, 
						   "Defensa Central");
				 
				 nombre_def1.setText((String) seleccionDef1);
				 nombre_def1.setVisible(true);
			}
		});
		
		JLabel img_def2 = new JLabel("");
		img_def2.setHorizontalAlignment(SwingConstants.CENTER);
		img_def2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionDef2 = JOptionPane.showInputDialog( null,
						   "Seleccione Defensa Central",
						   "Selector de Defensa Central",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Alejandro", "Joel", "Erik" }, 
						   "Defensa Central");
				 
				 nombre_def2.setText((String) seleccionDef2);
				 nombre_def2.setVisible(true);
			}
		});
		
		JLabel img_cen1 = new JLabel("");
		img_cen1.setHorizontalAlignment(SwingConstants.CENTER);
		img_cen1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen1 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Tomas", "Jon N", "Martin" }, 
						   "Centrocampista");
				 
				 nombre_cen1.setText((String) seleccionCen1);
				 nombre_cen1.setVisible(true);
			}
		});
		
		JLabel img_cen2 = new JLabel("");
		img_cen2.setHorizontalAlignment(SwingConstants.CENTER);
		img_cen2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen2 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Hugo", "Adrian", "Luis" }, 
						   "Centrocampista");
				 
				 nombre_cen2.setText((String) seleccionCen2);
				 nombre_cen2.setVisible(true);
			}
		});

		JLabel img_del1 = new JLabel("");
		img_del1.setHorizontalAlignment(SwingConstants.CENTER);
		img_del1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionDel = JOptionPane.showInputDialog( null,
						   "Seleccione Delantero Centro",
						   "Selector de Delantero Centro",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Imanol" }, 
						   "Delantero Centro");
				 
				 nombre_del1.setText((String) seleccionDel);
				 nombre_del1.setVisible(true);
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaPartidos.this.setVisible(false);
			}
		});
		
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("img_por: "+nombre_por.getText()+
						"; Defensas: "+nombre_def1.getText()+" y "+nombre_def2.getText()+
						"; Centrocampitas: "+nombre_cen1.getText()+", "+nombre_cen2.getText()+" y "+nombre_cen3.getText()+
						"; Delantero: "+nombre_del1.getText());
			}
		});
		
		img_por.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/POR.png")));
		
		img_def1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEF.png")));
		
		img_def2.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEF.png")));
		
		img_cen1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		
		img_cen2.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		
		img_cen3.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		
		img_del1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEL.png")));
		
		JComboBox formaciones = new JComboBox(formacion);
		botones.add(formaciones, BorderLayout.CENTER);
		
		formaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(formaciones.getSelectedItem().toString().equals("2-3-1")) {
					img_por.setLocation(panelPrincipal.getWidth()/2, panelPrincipal.getHeight()/4);
					img_def1.setLocation(panelPrincipal.getWidth()/4, panelPrincipal.getHeight()/3);
					img_def2.setLocation(panelPrincipal.getWidth()/4, panelPrincipal.getHeight()/3);
					img_cen1.setLocation(panelPrincipal.getWidth()/3, panelPrincipal.getHeight()/2);
					img_cen2.setLocation(panelPrincipal.getWidth()/2, panelPrincipal.getHeight()/2);
					img_cen3.setLocation(panelPrincipal.getWidth(), panelPrincipal.getHeight()/2);
					img_del1.setLocation(panelPrincipal.getWidth()/2, panelPrincipal.getHeight());
				} else if(formaciones.getSelectedItem().toString().equals("2-2-2")) {
					
				} else if(formaciones.getSelectedItem().toString().equals("3-2-1")) {
					
				} else if(formaciones.getSelectedItem().toString().equals("3-1-2")) {
					
				}
			}
		});

        }
	}