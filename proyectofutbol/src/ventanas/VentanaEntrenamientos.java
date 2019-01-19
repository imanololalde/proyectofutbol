package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Ejercicios;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEntrenamientos extends JFrame {

	private JPanel contentPane;
	public int numIni;
	public int numPP;
	public int numF;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEntrenamientos frame = new VentanaEntrenamientos();
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
	public VentanaEntrenamientos() {
		Ejercicios[] todos= {
				//parte inicial
				new Ejercicios("Derribar Cono",10,"Parte Inicial"),
				new Ejercicios("Pescadilla",15,"Parte Inicial"),
				new Ejercicios("Las Colas",15,"Parte Inicial"),
				new Ejercicios("Pilla-Pilla",15,"Parte Inicial"),
				new Ejercicios("Circulo con Balon",10,"Parte Inicial"),
				new Ejercicios("Habilidad motriz y balon",10,"Parte Inicial"),
				new Ejercicios("Jugador y balon",10,"Parte Inicial"),
				new Ejercicios("Accion Combinativa",10,"Parte Inicial"),
				//parte principal
				new Ejercicios("Posesion Amplitud",15,"Parte Principal"),
				new Ejercicios("Posesion y profundidad",15,"Parte Principal"),
				new Ejercicios("Posesion con amplitud y profundidad",25,"Parte Principal"),
				new Ejercicios("Finalizacion con oposicion",15,"Parte Principal"),
				new Ejercicios("Finalizacion sin oposicion",15,"Parte Principal"),
				new Ejercicios("Conduccion y tiro tras estimulo",15,"Parte Principal"),
				new Ejercicios("2x1-3x2",15,"Parte Principal"),
				new Ejercicios("Juego en equipo",20,"Parte Principal"),
				new Ejercicios("Basculaciones",15,"Parte Principal"),
				//parte final
				new Ejercicios("Partido 3pp",15,"Parte Final"),
				new Ejercicios("Partido reducido amplitud",15,"Parte Final"),
				new Ejercicios("Partido reducido profundidad",15,"Parte Final"),
				};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PI = new JLabel(numIni+" de 30 minutos");
		PI.setBounds(621, 142, 110, 14);
		contentPane.add(PI);
		
		JLabel PP = new JLabel("0 de 40 minutos");
		PP.setBounds(621, 274, 110, 14);
		contentPane.add(PP);
		
		JLabel PF = new JLabel("0 de 15 minutos");
		PF.setBounds(621, 433, 110, 14);
		contentPane.add(PF);
		
		JProgressBar progressBarPI = new JProgressBar();
		progressBarPI.setBounds(535, 83, 219, 48);
		contentPane.add(progressBarPI);
		progressBarPI.setMaximum(30);
		
		JProgressBar progressBarPP = new JProgressBar();
		progressBarPP.setBounds(535, 215, 219, 48);
		contentPane.add(progressBarPP);
		progressBarPP.setMaximum(40);
		
		JProgressBar progressBarPF = new JProgressBar();
		progressBarPF.setBounds(535, 374, 219, 48);
		contentPane.add(progressBarPF);
		progressBarPF.setMaximum(15);
		
		JLabel lblEntrenamientos = new JLabel("Entrenamientos");
		lblEntrenamientos.setBounds(297, 11, 132, 14);
		contentPane.add(lblEntrenamientos);
		
		JLabel lblParteInicial = new JLabel("Parte Inicial");
		lblParteInicial.setBounds(10, 39, 84, 14);
		contentPane.add(lblParteInicial);
		
		int i;
		int xpp=0;
		int x=todos.length;
		String ejpi[]=new String[8];
		for( i=0;i<x;i++) {
			if(todos[i].getParte().equals("Parte Inicial")) {
			ejpi[i]=todos[i].getNombre();
			}
		};
		i=0;
		
		String ejpp[]=new String[9];
		for( i=0;i<x;i++) {
			if(todos[i].getParte().equals("Parte Principal")) {
			
				ejpp[xpp]=todos[i].getNombre();
				xpp++;
			}
		};
		i=0;
		xpp=0;
		String ejpf[]=new String[3];
		for( i=0;i<x;i++) {
			if(todos[i].getParte().equals("Parte Final")) {
			ejpf[xpp]=todos[i].getNombre();
			xpp++;
			}
		};
		System.out.println(x);
		
		JComboBox comboBoxPI = new JComboBox(ejpi);
		comboBoxPI.setBounds(10, 83, 315, 20);
		contentPane.add(comboBoxPI);
		
		JComboBox comboBoxPP = new JComboBox(ejpp);
		comboBoxPP.setBounds(10, 230, 315, 20);
		contentPane.add(comboBoxPP);
		
		JComboBox comboBoxPF = new JComboBox(ejpf);
		comboBoxPF.setBounds(10, 384, 315, 20);
		contentPane.add(comboBoxPF);
		
		JLabel lblParteFinalDuracion = new JLabel("Parte Final");
		lblParteFinalDuracion.setBounds(10, 359, 150, 14);
		contentPane.add(lblParteFinalDuracion);
		
		JLabel lblPartePrincipal = new JLabel("Parte Principal");
		lblPartePrincipal.setBounds(10, 205, 150, 14);
		contentPane.add(lblPartePrincipal);
		
		
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			
				for(int i=0;i<ejpi.length;i++) {
				if(comboBoxPI.getSelectedItem().toString().equals(todos[i].getNombre())&& numIni<30) {
					
					numIni = numIni+todos[i].getDuracion();
					progressBarPI.setValue(numIni);
					
					PI.setText(Integer.toString(numIni)+" de 30 minutos");
					
					System.out.println(	comboBoxPI.getSelectedItem().toString());
				};
				
			}}
		});
		btnAnadir.setBounds(10, 114, 89, 23);
		contentPane.add(btnAnadir);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setBounds(236, 114, 89, 23);
		contentPane.add(btnInfo);
		
		JButton btnAnadir_1 = new JButton("Anadir");
		btnAnadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())&& numPP<40) {
						
						numPP = numPP+todos[i].getDuracion();
						progressBarPP.setValue(numPP);
						
						PP.setText(Integer.toString(numPP)+" de 40 minutos");
						
						System.out.println(	comboBoxPP.getSelectedItem().toString());
					};
					
				}
			}
		});
		btnAnadir_1.setBounds(10, 261, 89, 23);
		contentPane.add(btnAnadir_1);
		
		JButton btnInfo_1 = new JButton("Info");
		btnInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())) {
						Icon eleder;
						
					};
					
				}
			}
		});
		btnInfo_1.setBounds(236, 261, 89, 23);
		contentPane.add(btnInfo_1);
		
		JButton btnAnadir_2 = new JButton("Anadir");
		btnAnadir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPF.getSelectedItem().toString().equals(todos[i].getNombre())&& numF<15) {
						
						numF = numF+todos[i].getDuracion();
						progressBarPF.setValue(numF);
						
						PF.setText(Integer.toString(numF)+" de 15 minutos");
						
						System.out.println(	comboBoxPF.getSelectedItem().toString());
					};
					
				}
			}
		});
		btnAnadir_2.setBounds(10, 415, 89, 23);
		contentPane.add(btnAnadir_2);
		
		JButton btnInfo_2 = new JButton("Info");
		btnInfo_2.setBounds(236, 415, 89, 23);
		contentPane.add(btnInfo_2);
		
		JLabel lblParteInicial_1 = new JLabel("Parte Inicial");
		lblParteInicial_1.setBounds(621, 58, 69, 14);
		contentPane.add(lblParteInicial_1);
		
		JLabel lblPartePrincipal_1 = new JLabel("Parte Principal");
		lblPartePrincipal_1.setBounds(621, 190, 94, 14);
		contentPane.add(lblPartePrincipal_1);
		
		JLabel lblParteFinal = new JLabel("Parte Final");
		lblParteFinal.setBounds(621, 349, 69, 14);
		contentPane.add(lblParteFinal);
		
		
	}
}
