package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.NumeroImagen;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ImagenEjercicio extends  VentanaEntrenamientos {

	private JPanel contentPane;

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
		VentanaEntrenamientos eleccion=new VentanaEntrenamientos();
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1166, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ImagenEjercicio.class.getResource("/imagenes/ejercicios/parteInicial/ejercicio"+eleccion.getNumero()+".JPG")));
		lblNewLabel.setBounds(0, 11, 1155, 649);
		contentPane.add(lblNewLabel);
	}
}
