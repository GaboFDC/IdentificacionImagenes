/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificacionimagenes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author USUARIO
 */
public class Ventana extends JFrame {

	private char[][] letters;

	public Ventana(int MyHEIGHT, int MyWIDTH, char[][] letters) {
		this.letters = letters;
		setSize(MyWIDTH / 2, MyHEIGHT / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		int margenX = 15;
		int margenY = 50;
		int espacioX = 7;
		int espacioY = 8;

		final JPanel panel = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setFont(new Font("Times New Roman", Font.PLAIN, 9));
				for (int i = 0; i < MyHEIGHT / 3; i++) {
					for (int j = 0; j < MyWIDTH / 3; j++) {
						g.drawString(letters[i][j] + "", margenX + (j * espacioX), margenY + (i * espacioY));
					}
				}
			}
		};
		panel.setPreferredSize(new Dimension((MyWIDTH / 3) * espacioX, (MyHEIGHT / 3) * espacioY));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		add(new JScrollPane(panel));
	}
	/*
	 public void paint(Graphics g) {
		

	 }*/
}
