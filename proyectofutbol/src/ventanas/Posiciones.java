package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Posiciones extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ImageIcon> imgPosicion = new ArrayList<ImageIcon>();
	public Object jugador;
	
	public Posiciones(String nombre, int a) {
		setName(nombre);
		setHorizontalAlignment(a);
		setForeground(Color.WHITE);
		setFont(new Font("SpaceClaim ASME CB", Font.BOLD, 11));
		setBackground(new Color(255, 0, 0));
		setOpaque(true);
		
		JLabel imagen = new JLabel("");
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugador = JOptionPane.showInputDialog( null,
						   "Seleccione Centrocampista",
						   "Selector de Centrocampista",
						   JOptionPane.QUESTION_MESSAGE,
						   null,
						   new Object[] { "Aritz", "Iker", "Javier" }, 
						   "Centrocampista");
				 
				 setText((String) jugador);
				 setVisible(true);
			}
		});
	}
	
	public ImageIcon definirPosicion(int posicion) {
		imgPosicion.add(new ImageIcon(Posiciones.class.getResource("/imagenes/POR.png")));
		imgPosicion.add(new ImageIcon(Posiciones.class.getResource("/imagenes/DEF.png")));
		imgPosicion.add(new ImageIcon(Posiciones.class.getResource("/imagenes/MED.png")));
		imgPosicion.add(new ImageIcon(Posiciones.class.getResource("/imagenes/DEL.png")));
	
		return imgPosicion.get(posicion);
	}
}
