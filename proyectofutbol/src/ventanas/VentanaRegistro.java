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

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField nombreTextField;
	public static JTextField apellidoTextField;
	public static JTextField dorsalTextField;
	public static JComboBox comboBox;
	public String[] posiciones={"Delantero", "Centrocampista", "Defensa", "Portero"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setTitle("Ventana de Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bAtras = new JButton("Atras");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaEleccion().setVisible(true);
				VentanaRegistro.this.setVisible(false);
			}
		});
		bAtras.setBounds(585, 527, 89, 23);
		contentPane.add(bAtras);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(62, 68, 201, 14);
		contentPane.add(lblNombre);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(62, 93, 162, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(62, 161, 46, 14);
		contentPane.add(lblApellido);
		
		apellidoTextField = new JTextField();
		apellidoTextField.setBounds(62, 206, 86, 20);
		contentPane.add(apellidoTextField);
		apellidoTextField.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(62, 256, 46, 14);
		contentPane.add(lblDorsal);
		
		dorsalTextField = new JTextField();
		dorsalTextField.setBounds(62, 306, 86, 20);
		contentPane.add(dorsalTextField);
		dorsalTextField.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(62, 403, 46, 17);
		contentPane.add(lblPosicion);
		
		comboBox = new JComboBox(posiciones);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(62, 447, 116, 20);
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
