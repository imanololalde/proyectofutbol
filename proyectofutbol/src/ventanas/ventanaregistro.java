package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ventanaregistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String[] posiciones={"Delantero", "Centrocampista", "Defensa","Portero"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaregistro frame = new ventanaregistro();
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
	public ventanaregistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ventanaeleccion().setVisible(true);
				ventanaregistro.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(585, 527, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre y Apellido del Jugador");
		lblNombreDelJugador.setBounds(62, 68, 201, 14);
		contentPane.add(lblNombreDelJugador);
		
		textField = new JTextField();
		textField.setBounds(62, 93, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(62, 256, 46, 14);
		contentPane.add(lblDorsal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 306, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(62, 403, 46, 14);
		contentPane.add(lblPosicion);
		
		JComboBox comboBox = new JComboBox(posiciones);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(62, 447, 116, 20);
		contentPane.add(comboBox);
		
		JLabel lblApodo = new JLabel("Apodo");
		lblApodo.setBounds(62, 161, 46, 14);
		contentPane.add(lblApodo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 206, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
