package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import datos.Ejercicios;
import datos.Entrenador;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

public class VentanaEntrenamientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel botones;
	public int numIni;
	public int numPP;
	public int numF;
	
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

	/**
	 * Launch the application.
	 */
	public VentanaEntrenamientos(Entrenador entrenador) {
		this.setSize(580,400);
		this.setVisible(true);
		inicializar(entrenador);
	}

	/**
	 * Create the frame.
	 */
	private void inicializar(Entrenador entrenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 800, 513);
		setResizable(false);
		setTitle("Entrenamientos");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		botones = new JPanel(new BorderLayout());

		getContentPane().add(contentPane);
		getContentPane().add(botones, BorderLayout.SOUTH);

		JButton batras = new JButton("Atras");
		botones.add(batras, BorderLayout.EAST);
		batras.addActionListener(
				(e)->{new VentanaEleccion(entrenador).setVisible(true);
					VentanaEntrenamientos.this.setVisible(false);}
				);

		JButton bGuardar = new JButton("Guardar");
		botones.add(bGuardar, BorderLayout.WEST);
		
		bGuardar.addActionListener(
				(e) -> {}
				);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));

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

		JLabel lblParteInicial = new JLabel("Parte Inicial");
		lblParteInicial.setHorizontalTextPosition(SwingConstants.LEFT);
		lblParteInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblParteInicial);

		JLabel label = new JLabel("");
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);

		JLabel lblParteInicial_1 = new JLabel("Parte Inicial");
		contentPane.add(lblParteInicial_1);

		JComboBox comboBoxPI = new JComboBox(ejpi);
		contentPane.add(comboBoxPI);

		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);

		JProgressBar progressBarPI = new JProgressBar();
		contentPane.add(progressBarPI);
		progressBarPI.setMaximum(30);

		JLabel PI = new JLabel(numIni+" de 30 minutos");
		
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<ejpi.length;i++) {
					if(comboBoxPI.getSelectedItem().toString().equals(todos[i].getNombre())&& numIni<30) {

						numIni = numIni+todos[i].getDuracion();
						progressBarPI.setValue(numIni);

						PI.setText(Integer.toString(numIni)+" de 30 minutos");

						System.out.println(	comboBoxPI.getSelectedItem().toString());
					}
				}}
		});
		contentPane.add(btnAnadir);

		JButton btnInfo_2 = new JButton("Info");
		contentPane.add(btnInfo_2);

		JLabel label_16 = new JLabel("");
		contentPane.add(label_16);

		contentPane.add(PI);

		JLabel lblPartePrincipal_1 = new JLabel("Parte Principal");
		contentPane.add(lblPartePrincipal_1);

		JLabel label_18 = new JLabel("");
		contentPane.add(label_18);

		JLabel label_19 = new JLabel("");
		contentPane.add(label_19);

		JLabel lblPartePrincipal = new JLabel("Parte Principal");
		contentPane.add(lblPartePrincipal);

		JComboBox comboBoxPP = new JComboBox(ejpp);
		contentPane.add(comboBoxPP);

		JLabel label_17 = new JLabel("");
		contentPane.add(label_17);

		JLabel label_20 = new JLabel("");
		contentPane.add(label_20);

		JProgressBar progressBarPP = new JProgressBar();
		contentPane.add(progressBarPP);
		progressBarPP.setMaximum(40);

		JLabel PP = new JLabel("0 de 40 minutos");
		
		JButton btnAnadir_1 = new JButton("Anadir");
		btnAnadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())&& numPP<40) {

						numPP = numPP+todos[i].getDuracion();
						progressBarPP.setValue(numPP);

						PP.setText(Integer.toString(numPP)+" de 40 minutos");

						System.out.println(	comboBoxPP.getSelectedItem().toString());
					}

				}
			}
		});

		contentPane.add(btnAnadir_1);

		JButton btnInfo = new JButton("Info");
		contentPane.add(btnInfo);

		JLabel label_5 = new JLabel("");
		contentPane.add(label_5);

		contentPane.add(PP);

		JLabel lblParteFinal = new JLabel("Parte Final");
		contentPane.add(lblParteFinal);

		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);

		JLabel label_4 = new JLabel("");
		contentPane.add(label_4);

		JLabel lblParteFinalDuracion = new JLabel("Parte Final");
		contentPane.add(lblParteFinalDuracion);

		JComboBox comboBoxPF = new JComboBox(ejpf);
		contentPane.add(comboBoxPF);

		JLabel label_7 = new JLabel("");
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("");
		contentPane.add(label_8);

		JProgressBar progressBarPF = new JProgressBar();
		contentPane.add(progressBarPF);
		progressBarPF.setMaximum(15);

		JLabel PF = new JLabel("0 de 15 minutos");
		
		JButton btnAnadir_2 = new JButton("Anadir");
		btnAnadir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPF.getSelectedItem().toString().equals(todos[i].getNombre())&& numF<15) {

						numF = numF+todos[i].getDuracion();
						progressBarPF.setValue(numF);

						PF.setText(Integer.toString(numF)+" de 15 minutos");

						System.out.println(	comboBoxPF.getSelectedItem().toString());
					}
				}
			}
		});

		contentPane.add(btnAnadir_2);

		JButton btnInfo_1 = new JButton("Info");
		btnInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())) {
						Icon eleder;

					}
				}
			}
		});
		contentPane.add(btnInfo_1);

		JLabel label_9 = new JLabel("");
		contentPane.add(label_9);

		contentPane.add(PF);

		JLabel label_10 = new JLabel("");
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("");
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("");
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("");
		contentPane.add(label_13);

	}
	
}
