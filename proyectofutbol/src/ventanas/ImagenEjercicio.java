package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.NumeroImagen;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ImagenEjercicio extends  JFrame {

	private JPanel contentPane;
	public VentanaEntrenamientos  e;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagenEjercicio frame = new ImagenEjercicio();
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
	public ImagenEjercicio() {
		setResizable(false);
		
		int i=VentanaEntrenamientos.getEleccion();
		System.out.println(i);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1166, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		if(i<=7) {
		lblNewLabel.setIcon(new ImageIcon(ImagenEjercicio.class.getResource("/imagenes/ejercicios/parteInicial/ejercicio"+i+".JPG")));
		}else if(8<=i && i<17) {
			lblNewLabel.setIcon(new ImageIcon(ImagenEjercicio.class.getResource("/imagenes/ejercicios/partePrincipal/ejercicio"+i+".JPG")));
		}else if(17<=i && i<20) {
			lblNewLabel.setIcon(new ImageIcon(ImagenEjercicio.class.getResource("/imagenes/ejercicios/parteFinal/ejercicio"+i+".JPG")));
		}
		lblNewLabel.setBounds(0, 11, 1155, 649);
		contentPane.add(lblNewLabel);
	}
}
