package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
import java.awt.Color;
import java.awt.Font;

public class VentanaPartidos extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public String[] formacion={"2-3-1", "2-2-2", "3-2-1", "3-1-2"};
	public Object seleccionPor, seleccionDef1, seleccionDef2, seleccionCen1, seleccionCen2, seleccionCen3,seleccionDel;

	/**
	 * Launch the application.
	 */
	public VentanaPartidos(Entrenador entrenador) {
		
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Partidos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion(entrenador).setVisible(true);
				VentanaPartidos.this.setVisible(false);
			}
		});
		
		JLabel nomdef2 = new JLabel("", SwingConstants.CENTER);
		nomdef2.setForeground(Color.WHITE);
		nomdef2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomdef2.setBounds(412, 222, 89, 29);
		contentPane.add(nomdef2);
		nomdef2.setBackground(new Color(255, 0, 0));
		nomdef2.setOpaque(true);
		nomdef2.setVisible(false);
		
		JLabel nombreportero = new JLabel("", SwingConstants.CENTER);
		nombreportero.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nombreportero.setForeground(Color.WHITE);
		nombreportero.setBounds(299, 109, 89, 29);
		contentPane.add(nombreportero);
		nombreportero.setBackground(new Color(255, 0, 0));
		nombreportero.setOpaque(true);
		nombreportero.setVisible(false);
		
		JLabel nomdef1 = new JLabel("", SwingConstants.CENTER);
		nomdef1.setForeground(Color.WHITE);
		nomdef1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomdef1.setBounds(150, 220, 89, 29);
		contentPane.add(nomdef1);
		nomdef1.setBackground(new Color(255, 0, 0));
		nomdef1.setOpaque(true);
		nomdef1.setVisible(false);
		
		 
		JLabel nomcen1 = new JLabel("", SwingConstants.CENTER);
		nomcen1.setForeground(Color.WHITE);
		nomcen1.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomcen1.setBounds(299, 323, 89, 29);
		contentPane.add(nomcen1);
		nomcen1.setBackground(new Color(255, 0, 0));
		nomcen1.setOpaque(true);
		nomcen1.setVisible(false);
		
		JLabel nomcen2 = new JLabel("", SwingConstants.CENTER);
		nomcen2.setForeground(Color.WHITE);
		nomcen2.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomcen2.setBounds(88, 406, 89, 29);
		contentPane.add(nomcen2);
		nomcen2.setBackground(new Color(255, 0, 0));
		nomcen2.setOpaque(true);
		nomcen2.setVisible(false);
		
		JLabel nomcen3 = new JLabel("",  SwingConstants.CENTER);
		nomcen3.setForeground(Color.WHITE);
		nomcen3.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomcen3.setBounds(496, 406, 89, 29);
		contentPane.add(nomcen3);
		nomcen3.setBackground(new Color(255, 0, 0));
		nomcen3.setOpaque(true);
		nomcen3.setVisible(false);
		
		JLabel nomdel = new JLabel("",  SwingConstants.CENTER);
		nomdel.setForeground(Color.WHITE);
		nomdel.setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		nomdel.setBounds(299, 453, 89, 29);
		contentPane.add(nomdel);
		nomdel.setBackground(new Color(255, 0, 0));
		nomdel.setOpaque(true);
		nomdel.setVisible(false);
		
		JLabel Centro3 = new JLabel("");
		Centro3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen3 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Aritz", "Iker", "Javier" }, 
						   "Centrocampista");
				 
				 nomcen3.setText((String) seleccionCen3);
				 nomcen3.setVisible(true);
			}
		});
		Centro3.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		Centro3.setBounds(509, 330, 65, 65);
		contentPane.add(Centro3);
		
		JLabel Defensa2 = new JLabel("");
		Defensa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionDef2 = JOptionPane.showInputDialog( null,
						   "Seleccione Defensa Central",
						   "Selector de Defensa Central",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Alejandro", "Joel", "Erik" }, 
						   "Defensa Central");
				 
				 nomdef2.setText((String) seleccionDef2);
				 nomdef2.setVisible(true);
			}
		});
		Defensa2.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEF.png")));
		Defensa2.setBounds(424, 146, 65, 65);
		contentPane.add(Defensa2);
		
		JLabel Portero = new JLabel("");
		Portero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 seleccionPor = JOptionPane.showInputDialog( null,
						   "Seleccione Portero",
						   "Selector de portero",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Javi", "Carlos", "Eleder" }, 
						   "Portero");
				 
				 nombreportero.setText((String) seleccionPor);
				 nombreportero.setVisible(true);
				 
			}
		});
		Portero.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/POR.png")));
		Portero.setBounds(307, 36, 65, 65);
		contentPane.add(Portero);
		
		JLabel Defensa1 = new JLabel("");
		Defensa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionDef1 = JOptionPane.showInputDialog( null,
						   "Seleccione Defensa Central",
						   "Selector de Defensa Central",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Xabi", "Aitor 'EL COCHES'", "Lucas" }, 
						   "Defensa Central");
				 
				 nomdef1.setText((String) seleccionDef1);
				 nomdef1.setVisible(true);
			}
		});
		Defensa1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEF.png")));
		Defensa1.setBounds(164, 146, 65, 65);
		contentPane.add(Defensa1);
		
		JLabel Centro2 = new JLabel("");
		Centro2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen2 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Hugo", "Adrian", "Luis" }, 
						   "Centrocampista");
				 
				 nomcen2.setText((String) seleccionCen2);
				 nomcen2.setVisible(true);
			}
		});
		Centro2.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		Centro2.setBounds(100, 330, 65, 65);
		contentPane.add(Centro2);
		
		JLabel Centro1 = new JLabel("");
		Centro1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionCen1 = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Tomas", "Jon N", "Martin" }, 
						   "Centrocampista");
				 
				 nomcen1.setText((String) seleccionCen1);
				 nomcen1.setVisible(true);
			}
		});

		JLabel Delantero1 = new JLabel("");
		Delantero1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionDel = JOptionPane.showInputDialog( null,
						   "Seleccione Delantero Centro",
						   "Selector de Delantero Centro",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Imanol" }, 
						   "Delantero Centro");
				 
				 nomdel.setText((String) seleccionDel);
				 nomdel.setVisible(true);
			}
		});
		Delantero1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/DEL.png")));
		Delantero1.setBounds(307, 377, 65, 65);
		contentPane.add(Delantero1);
		Centro1.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/MED.png")));
		Centro1.setBounds(307, 247, 65, 65);
		contentPane.add(Centro1);
		btnAtras.setBounds(585, 527, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Portero: "+nombreportero.getText()+
						"; Defensas: "+nomdef1.getText()+" y "+nomdef2.getText()+
						"; Centrocampitas: "+nomcen1.getText()+", "+nomcen2.getText()+" y "+nomcen3.getText()+
						"; Delantero: "+nomdel.getText());
			}
		});
		btnGuardarCambios.setBounds(10, 527, 136, 23);
		contentPane.add(btnGuardarCambios);
		
		JComboBox<String> formaciones = new JComboBox<String>(formacion);
		formaciones.setBounds(299, 528, 73, 20);
		contentPane.add(formaciones);
		
		JLabel Campo = new JLabel("");
		Campo.setIcon(new ImageIcon(VentanaPartidos.class.getResource("/imagenes/campo bueno.jpg")));
		Campo.setBounds(10, 0, 664, 505);
		contentPane.add(Campo);
		
		//Object eleccion= formaciones.getSelectedItem();		

        }
	}