package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Ejercicios;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

public class VentanaEntrenamientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public int numIni;
	public int numPP;
	public int numF;
	public static int eleccion;
	public int z=0;
	public int q=0;
	public int er=0;
	
	public VentanaEntrenamientos(int eleccion) throws HeadlessException {
		super();
		VentanaEntrenamientos.eleccion = eleccion;
	}

	public static int getEleccion() {
		return eleccion;
	}

	public void setEleccion(int eleccion) {
		VentanaEntrenamientos.eleccion = eleccion;
	}

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
		setLocationByPlatform(true);
		setTitle("Entrenamientos");
		String[] ultimoPI= new String[3];
		String[] ultimoPP=new String[12];
		String[] ultimoPF=new String[2];
		
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
		setBounds(100, 100, 800, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PI = new JLabel(numIni+" de 30 minutos");
		PI.setBounds(621, 123, 110, 14);
		contentPane.add(PI);
		
		JLabel PP = new JLabel("0 de 40 minutos");
		PP.setBounds(621, 274, 110, 14);
		contentPane.add(PP);
		
		JLabel PF = new JLabel("0 de 15 minutos");
		PF.setBounds(621, 419, 110, 14);
		contentPane.add(PF);
		
		JProgressBar progressBarPI = new JProgressBar();
		progressBarPI.setBounds(535, 64, 219, 48);
		contentPane.add(progressBarPI);
		progressBarPI.setMaximum(30);
		progressBarPI.doLayout();
		
		JProgressBar progressBarPP = new JProgressBar();
		progressBarPP.setBounds(535, 215, 219, 48);
		contentPane.add(progressBarPP);
		progressBarPP.setMaximum(40);
		
		System.out.println(this.getHeight());
		
		JProgressBar progressBarPF = new JProgressBar();
		progressBarPF.setBounds(535, 360, 219, 48);
		contentPane.add(progressBarPF);
		progressBarPF.setMaximum(15);
		
		JLabel lblEntrenamientos = new JLabel("Entrenamientos");
		lblEntrenamientos.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEntrenamientos.setBounds(317, 11, 111, 19);
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
		
		
		JComboBox comboBoxPI = new JComboBox(ejpi);
		comboBoxPI.setBounds(10, 83, 315, 20);
		contentPane.add(comboBoxPI);
		
		JComboBox comboBoxPP = new JComboBox(ejpp);
		comboBoxPP.setBounds(10, 231, 315, 20);
		contentPane.add(comboBoxPP);
		
		JComboBox comboBoxPF = new JComboBox(ejpf);
		comboBoxPF.setBounds(10, 374, 315, 20);
		contentPane.add(comboBoxPF);
		
		JLabel lblParteFinalDuracion = new JLabel("Parte Final");
		lblParteFinalDuracion.setBounds(10, 335, 150, 14);
		contentPane.add(lblParteFinalDuracion);
		
		JLabel lblPartePrincipal = new JLabel("Parte Principal");
		lblPartePrincipal.setBounds(10, 184, 150, 14);
		contentPane.add(lblPartePrincipal);
		
		
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			
				for(int i=0;i<ejpi.length;i++) {
				if(comboBoxPI.getSelectedItem().toString().equals(todos[i].getNombre())&& numIni<30) {
					
					numIni = numIni+todos[i].getDuracion();
					if(numIni<=30) {
						
					progressBarPI.setValue(numIni);
					
					
					PI.setText(Integer.toString(numIni)+" de 30 minutos");
					ultimoPI[z]=todos[i].getNombre();
					z++;
					}else { 
						JOptionPane.showMessageDialog(null, "Sobrepasas el tiempo de entrenamiento.", "Error", JOptionPane.WARNING_MESSAGE );
						numIni = numIni-todos[i].getDuracion();
						z--;
					}
					System.out.println(	comboBoxPI.getSelectedItem().toString());
				};
				
			}}
		});
		btnAnadir.setBounds(10, 114, 89, 23);
		contentPane.add(btnAnadir);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int seleccionadoI;
				for(int i=0;i<ejpi.length;i++) {
			if(comboBoxPI.getSelectedItem().toString().equals(todos[i].getNombre())) {
				seleccionadoI=i;
		VentanaEntrenamientos eleccion = new VentanaEntrenamientos();
		eleccion.setEleccion(seleccionadoI);
			
			new ImagenEjercicio().setVisible(true);
			}
		}}});
		btnInfo.setBounds(236, 114, 89, 23);
		contentPane.add(btnInfo);
		
		JButton btnAnadir_1 = new JButton("Anadir");
		btnAnadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())&& numPP<40) {
						System.out.println();
						numPP = numPP+todos[i].getDuracion();
						if(numPP<=40) {
						progressBarPP.setValue(numPP);
						
						PP.setText(Integer.toString(numPP)+" de 40 minutos");
						ultimoPI[q]=comboBoxPP.getSelectedItem().toString();
						q++;
						}else { 
							JOptionPane.showMessageDialog(null, "Sobrepasas el tiempo de entrenamiento.", "Error", JOptionPane.WARNING_MESSAGE );
							numPP=numPP-todos[i].getDuracion();
							q--;
						}
						System.out.println(	comboBoxPP.getSelectedItem().toString());
					};
					
				}
			}
		});
		btnAnadir_1.setBounds(10, 270, 89, 23);
		contentPane.add(btnAnadir_1);
		
		JButton btnInfo_1 = new JButton("Info");
		btnInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionadosP;
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPP.getSelectedItem().toString().equals(todos[i].getNombre())) {
						seleccionadosP=i;
						VentanaEntrenamientos eleccion = new VentanaEntrenamientos();
						eleccion.setEleccion(seleccionadosP);
							
							new ImagenEjercicio().setVisible(true);
					};
					
				}
			}
		});
		btnInfo_1.setBounds(236, 270, 89, 23);
		contentPane.add(btnInfo_1);
		
		JButton btnAnadir_2 = new JButton("Anadir");
		btnAnadir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPF.getSelectedItem().toString().equals(todos[i].getNombre())&& numF<15) {
						
						numF = numF+todos[i].getDuracion();
						if(numF<=15) {
						progressBarPF.setValue(numF);
						
						PF.setText(Integer.toString(numF)+" de 15 minutos");
						ultimoPF[er]=todos[i].getNombre();
						er++;
						}else { 
							JOptionPane.showMessageDialog(null, "Sobrepasas el tiempo de entrenamiento.", "Error", JOptionPane.WARNING_MESSAGE );
							numF=numF-todos[i].getDuracion();
						er--;
						}
						System.out.println(	comboBoxPF.getSelectedItem().toString());
					};
					
				}
			}
		});
		btnAnadir_2.setBounds(10, 405, 89, 23);
		contentPane.add(btnAnadir_2);
		
		JButton btnInfo_2 = new JButton("Info");
		btnInfo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionadosF;
				for(int i=0;i<todos.length;i++) {
					if(comboBoxPF.getSelectedItem().toString().equals(todos[i].getNombre())) {
						seleccionadosF=i;
						VentanaEntrenamientos eleccion = new VentanaEntrenamientos();
						eleccion.setEleccion(seleccionadosF);
							
							new ImagenEjercicio().setVisible(true);
					};
					
				}
			}
		});
		btnInfo_2.setBounds(236, 405, 89, 23);
		contentPane.add(btnInfo_2);
		
		JLabel lblParteInicial_1 = new JLabel("Parte Inicial");
		lblParteInicial_1.setBounds(621, 39, 69, 14);
		contentPane.add(lblParteInicial_1);
		
		JLabel lblPartePrincipal_1 = new JLabel("Parte Principal");
		lblPartePrincipal_1.setBounds(621, 184, 94, 14);
		contentPane.add(lblPartePrincipal_1);
		
		JLabel lblParteFinal = new JLabel("Parte Final");
		lblParteFinal.setBounds(621, 335, 69, 14);
		contentPane.add(lblParteFinal);
		
		JButton eliminarPI = new JButton("Eliminar");
		eliminarPI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				progressBarPI.setValue(0);
				numIni=0;
				PI.setText(Integer.toString(numIni)+" de 30 minutos");
				for (int i =0; i< ultimoPI.length; i++)
					   ultimoPI[i] = null;
				z=0;
			}
		});
		eliminarPI.setBounds(126, 114, 89, 23);
		contentPane.add(eliminarPI);
		
		JButton eliminarPP = new JButton("Eliminar");
		eliminarPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBarPP.setValue(0);
				numPP=0;
				PP.setText(Integer.toString(numPP)+" de 40 minutos");
				for (int i =0; i< ultimoPP.length; i++)
					   ultimoPP[i] = null;
				q=0;
				
			}
		});
		eliminarPP.setBounds(126, 270, 89, 23);
		contentPane.add(eliminarPP);
		
		JButton eliminarPF = new JButton("Eliminar");
		eliminarPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBarPF.setValue(0);
				numF=0;
				PF.setText(Integer.toString(numF)+" de 15 minutos");
				for (int i =0; i< ultimoPF.length; i++)
					   ultimoPF[i] = null;
				er=0;
			}
		});
		eliminarPF.setBounds(126, 405, 89, 23);
		contentPane.add(eliminarPF);
		
		JButton Atras = new JButton("Atras");
		Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
			}
		});
		Atras.setBounds(665, 464, 89, 23);
		contentPane.add(Atras);
		
		JButton cambios = new JButton("Guardar cambios");
		cambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Parte inicial: "+ultimoPI[0]+", "+ultimoPI[1]+" y "+ultimoPI[2]
						+"; "+"Parte Principal: "+ultimoPP[0]+", "+ultimoPP[1]+" y "+ultimoPP[2]+
						"; "+"Parte Final: "+ultimoPF[0]);
				
			}
		});
		cambios.setBounds(10, 464, 132, 23);
		contentPane.add(cambios);
		
		contentPane.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		        // do stuff
		    	System.out.println(contentPane.getX());
		    	if(contentPane.getWidth()<=1000) {
		    	//parte inicial
		    		progressBarPI.setBounds(535, 64, 219, 48);
		    	lblParteInicial_1.setBounds(621, 39, 69, 14);
		    	PI.setBounds(621, 123, 110, 14);
		    	//parte PRINCIAPL
	    		progressBarPP.setBounds(535,  215, 219, 48);
	    	lblPartePrincipal_1.setBounds(621,184, 94, 14);
	    	PP.setBounds(621, 274, 110, 14);
	    	// parte Final
	    	progressBarPF.setBounds(535, 360, 219, 48);
	    	PF.setBounds(621, 419, 110, 14);
	    	lblParteFinal.setBounds(621, 335, 69, 14);
	    	//botones
	    	Atras.setBounds(665, 464, 89, 23);
	    	cambios.setBounds(10, 464, 132, 23);
	    	//partescomboIni
	    	eliminarPI.setBounds(126, 114, 89, 23);
	    	btnInfo.setBounds(236, 114, 89, 23);
			btnAnadir.setBounds(10, 114, 89, 23);
			comboBoxPI.setBounds(10, 73, 315, 20);
			lblParteInicial.setBounds(10, 29, 84, 14);
			//partescomboPP
			eliminarPP.setBounds(126, 270, 89, 23);
			btnInfo_1.setBounds(236, 270, 89, 23);
			btnAnadir_1.setBounds(10, 270, 89, 23);
			comboBoxPP.setBounds(10, 231, 315, 20);
			lblPartePrincipal.setBounds(10, 184, 150, 14);
			//parte final combo
			eliminarPF.setBounds(126, 400, 89, 23);
			btnInfo_2.setBounds(236, 400, 89, 23);
			btnAnadir_2.setBounds(10, 400, 89, 23);
			comboBoxPF.setBounds(10, 364, 315, 20);
			lblParteFinalDuracion.setBounds(10, 335, 150, 14);
			//LABEL
			lblEntrenamientos.setBounds(317, 11, 111, 19);
			}else {
		    	//parte inicial
		    	lblParteInicial_1.setBounds(1200, 39, 69*2, 14*2);
		    	PI.setBounds(1200, 153, 110*2, 14*2);
		    	progressBarPI.setBounds(1100, 64, 300, 48*2);
		    	//parte PRINCIAPL
	    		progressBarPP.setBounds(1100, 308, 300, 48*2);
	    	lblPartePrincipal_1.setBounds(1200,289, 94, 14);
	    	PP.setBounds(1200, 419, 110, 14);
	       	// parte Final
	    	progressBarPF.setBounds(1100, 520, 300, 48*2);
	    	PF.setBounds(1200, 624, 110, 14);
	    	lblParteFinal.setBounds(1200, 495, 69, 14);
	    	//botones
	    	Atras.setBounds(1400, 700, 89, 23);
	    	cambios.setBounds(10, 700, 132, 23);
	    	//partescomboIni
	    	eliminarPI.setBounds(126, 134, 89, 23);
	    	btnInfo.setBounds(236, 134, 89, 23);
			btnAnadir.setBounds(10, 134, 89, 23);
			comboBoxPI.setBounds(10, 83, 315, 20);
			lblParteInicial.setBounds(10, 39, 84, 14);
			//partescomboPP
			eliminarPP.setBounds(126, 390, 89, 23);
			btnInfo_1.setBounds(236, 390, 89, 23);
			btnAnadir_1.setBounds(10, 390, 89, 23);
			comboBoxPP.setBounds(10, 341, 315, 20);
			lblPartePrincipal.setBounds(10, 294, 150, 14);
			//parte final combo
			eliminarPF.setBounds(126, 602, 89, 23);
			btnInfo_2.setBounds(236, 602, 89, 23);
			btnAnadir_2.setBounds(10, 602, 89, 23);
			comboBoxPF.setBounds(10, 566, 315, 20);
			lblParteFinalDuracion.setBounds(10, 527, 150, 14);
			//LABEL
			lblEntrenamientos.setBounds(700, 11, 111, 19);
			} }
		});
		
		
	}
}