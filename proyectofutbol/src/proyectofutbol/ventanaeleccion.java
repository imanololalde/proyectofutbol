package proyectofutbol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaeleccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaeleccion frame = new ventanaeleccion();
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
	public ventanaeleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_2 = new JButton("Entrenamientos");
		btnNewButton_2.setBounds(10, 11, 167, 539);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ventanaentrenamientos().setVisible(true);
				ventanaeleccion.this.setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Partidos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ventanapartidos().setVisible(true);
				ventanaeleccion.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(200, 11, 167, 539);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Registrar Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ventanaregistro().setVisible(true);
				ventanaeleccion.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(399, 11, 167, 539);
		contentPane.add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ventanalogin().setVisible(true);
				ventanaeleccion.this.setVisible(false);
			}
		});
		btnAtras.setBounds(585, 527, 89, 23);
		contentPane.add(btnAtras);
	}
}
