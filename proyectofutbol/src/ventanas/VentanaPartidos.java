package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class VentanaPartidos extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public String[] formacion={"2-3-1", "2-2-2", "3-2-1", "3-1-2"};
	public JComboBox jugador1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPartidos frame = new VentanaPartidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPartidos() {
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
				new VentanaEleccion().setVisible(true);
				VentanaPartidos.this.setVisible(false);
			}
		});
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(301, 53, 71, 20);
		contentPane.add(comboBox_6);
		
		JComboBox jugador6 = new JComboBox();
		jugador6.setBounds(395, 159, 71, 20);
		contentPane.add(jugador6);
		
		JComboBox jugador5 = new JComboBox();
		jugador5.setBounds(177, 159, 71, 20);
		contentPane.add(jugador5);
		
		JComboBox jugador3 = new JComboBox();
		jugador3.setBounds(107, 349, 71, 20);
		contentPane.add(jugador3);
		
		JComboBox jugador2 = new JComboBox();
		jugador2.setBounds(472, 349, 71, 20);
		contentPane.add(jugador2);
		
		JComboBox jugador4 = new JComboBox();
		jugador4.setBounds(301, 269, 71, 20);
		contentPane.add(jugador4);
		btnAtras.setBounds(585, 527, 89, 23);
		contentPane.add(btnAtras);
		
		jugador1 = new JComboBox();
		jugador1.setBounds(301, 464, 71, 20);
		contentPane.add(jugador1);
		jugador1.addActionListener(jugador1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\imanololalde\\Desktop\\proyectofutbolgit\\fotillos\\campo bueno.jpg"));
		lblNewLabel.setBounds(10, 11, 664, 505);
		contentPane.add(lblNewLabel);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBounds(10, 527, 136, 23);
		contentPane.add(btnGuardarCambios);
		
		JComboBox formaciones = new JComboBox(formacion);
		formaciones.setBounds(299, 528, 73, 20);
		contentPane.add(formaciones);
		Object eleccion= formaciones.getSelectedItem();

        }
		  
	}