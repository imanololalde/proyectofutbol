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
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton_2 = new JButton("Entrenamientos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -76, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 177, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Partidos");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 73, SpringLayout.EAST, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 175, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 240, SpringLayout.EAST, btnNewButton_2);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Registrar Jugadores");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 62, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
	}

}
