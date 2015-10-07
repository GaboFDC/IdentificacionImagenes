/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificacionimagenes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author gabo
 */
public class IdentificacionImagenes {

private static ArrayList<Letter> init() {
	ArrayList<Letter> myLetters = new ArrayList<>();
	
	final int[][] lNada = {{-1, -1, -1},
					    {-1, -1, -1},
					    {-1, -1, -1}};
	Letter Nada = new Letter(' ', lNada);
	
	final int[][] lA = {{-1,  1, -1},
					   { 1,  1,  1},
					   { 1, -1,  1}};
	Letter A = new Letter('A', lA);
	
	final int[][] lB = {{ 1,  1, -1},
					   { 1,  1,  1},
					   { 1,  1,  1}};
	Letter B = new Letter('B', lB);

	final int[][] lC = {{ 1,  1,  1},
					   { 1, -1, -1},
					   { 1,  1,  1}};
	Letter C = new Letter('C', lC);

	final int[][] lD = {{ 1,  1, -1},
					   { 1, -1,  1},
					   { 1,  1, -1}};
	Letter D = new Letter('D', lD);

	final int[][] lE = {{ 1,  1,  1},
					   { 1,  1, -1},
					   { 1,  1,  1}};
	Letter E = new Letter('E', lE);

	final int[][] lF = {{ 1,  1,  1},
					   { 1,  1, -1},
					   { 1, -1, -1}};
	Letter F = new Letter('F', lF);

	final int[][] lG = {{ 1,  1, -1},
					   { 1, -1,  1},
					   { 1,  1,  1}};
	Letter G = new Letter('G', lG);

	final int[][] lH = {{ 1, -1,  1},
					   { 1,  1,  1},
					   { 1, -1,  1}};
	Letter H = new Letter('H', lH);

	final int[][] lI = {{ 1,  1,  1},
					   {-1,  1, -1},
					   { 1,  1,  1}};
	Letter I = new Letter('I', lI);

	final int[][] lJ = {{-1, -1,  1},
					   { 1, -1,  1},
					   { 1,  1,  1}};
	Letter J = new Letter('J', lJ);
	
	final int[][] lK = {{ 1, -1,  1},
					   { 1,  1, -1},
					   { 1, -1,  1}};
	Letter K = new Letter('K', lK);
	
	final int[][] lL = {{ 1, -1, -1},
					   { 1, -1, -1},
					   { 1,  1, -1}};
	Letter L = new Letter('L', lL);

	final int[][] lM = {{ 1,  1,  1},
					   { 1,  1,  1},
					   { 1, -1,  1}};
	Letter M = new Letter('M', lM);

	final int[][] lN = {{ 1,  1,  1},
					   { 1, -1,  1},
					   { 1, -1,  1}};
	Letter N = new Letter('N', lN);

	final int[][] lO = {{ 1,  1,  1},
					   { 1, -1,  1},
					   { 1,  1,  1}};
	Letter O = new Letter('O', lO);

	final int[][] lP = {{ 1,  1,  1},
					   { 1,  1,  1},
					   { 1, -1, -1}};
	Letter P = new Letter('P', lP);

	final int[][] lQ = {{ 1,  1,  1},
					   { 1,  1,  1},
					   {-1, -1,  1}};
	Letter Q = new Letter('Q', lQ);

	final int[][] lR = {{ 1,  1,  1},
					   { 1, -1, -1},
					   { 1, -1, -1}};
	Letter R = new Letter('R', lR);

	final int[][] lS = {{-1,  1,  1},
					   {-1,  1, -1},
					   { 1,  1, -1}};
	Letter S = new Letter('S', lS);

	final int[][] lT = {{ 1,  1,  1},
					   {-1,  1, -1},
					   {-1,  1, -1}};
	Letter T = new Letter('T', lT);

	final int[][] lU = {{ 1, -1,  1},
					   { 1, -1,  1},
					   { 1,  1,  1}};
	Letter U = new Letter('U', lU);

	final int[][] lV = {{ 1, -1,  1},
					   { 1, -1,  1},
					   {-1,  1, -1}};
	Letter V = new Letter('V', lV);

	final int[][] lW = {{ 1, -1,  1},
					   { 1,  1,  1},
					   { 1,  1,  1}};
	Letter W = new Letter('W', lW);

	final int[][] lX = {{ 1, -1,  1},
					   {-1,  1, -1},
					   { 1, -1,  1}};
	Letter X = new Letter('X', lX);

	final int[][] lY = {{ 1, -1,  1},
					   {-1,  1, -1},
					   {-1,  1, -1}};
	Letter Y = new Letter('Y', lY);

	final int[][] lZ = {{ 1,  1, -1},
					   {-1,  1, -1},
					   {-1,  1,  1}};
	Letter Z = new Letter('Z', lZ);

	final int[][] lN1 = {{ 1,  1, -1},
					    {-1,  1, -1},
					    { 1,  1,  1}};
	Letter N1 = new Letter('1', lN1);

	final int[][] lN3 = {{ 1,  1,  1},
					    {-1,  1,  1},
					    { 1,  1,  1}};
	Letter N3 = new Letter('3', lN3);

	final int[][] lN4 = {{ 1, -1,  1},
					    { 1,  1,  1},
					    {-1, -1,  1}};
	Letter N4 = new Letter('4', lN4);

	final int[][] lN6 = {{ 1, -1, -1},
				 	    { 1,  1,  1},
				 	    { 1,  1,  1}};
	Letter N6 = new Letter('6', lN6);

	final int[][] lN7 = {{ 1,  1,  1},
				 	    {-1, -1,  1},
				 	    {-1, -1,  1}};
	Letter N7 = new Letter('7', lN7);

	final int[][] lN8 = {{-1,  1,  1},
				 	    { 1,  1,  1},
 					    { 1,  1,  1}};
	Letter N8 = new Letter('8', lN8);
	myLetters.add(Nada);
	myLetters.add(A);
	myLetters.add(B);
	myLetters.add(C);
	myLetters.add(D);
	myLetters.add(E);
	myLetters.add(F);
	myLetters.add(G);
	myLetters.add(H);
	myLetters.add(I);
	myLetters.add(J);
	myLetters.add(K);
	myLetters.add(L);
	myLetters.add(M);
	myLetters.add(N);
	myLetters.add(O);
	myLetters.add(P);
	myLetters.add(Q);
	myLetters.add(R);
	myLetters.add(S);
	myLetters.add(T);
	myLetters.add(U);
	myLetters.add(V);
	myLetters.add(W);
	myLetters.add(X);
	myLetters.add(Y);
	myLetters.add(Z);
	myLetters.add(N1);
	myLetters.add(N3);
	myLetters.add(N4);
	myLetters.add(N6);
	myLetters.add(N7);
	myLetters.add(N8);
	
	return myLetters;
}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Letter> myLetters = init();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor intriduza la ruta de la imagen (con slash al final)");
		final String basePath = scanner.nextLine();

		System.out.println("Por favor intriduza el nombre de la imagen (sin formato)");
		final String NAME = scanner.nextLine();

		System.out.println("Por favor intriduza el formato de la imagen (jpg, png, etc)");
		final String FORMATO = scanner.nextLine();

		System.out.println("Por favor intriduza el margen");
		final int margen = scanner.nextInt();

		String imageSource = NAME + "." + FORMATO;

		BufferedImage bufferedImage = null;
		System.out.println("Se lee la imagen...");
		try {
			bufferedImage = ImageIO.read(Files.newInputStream(Paths.get(basePath + imageSource)));
		} catch (IOException ex) {
			Logger.getLogger(IdentificacionImagenes.class.getName()).log(Level.SEVERE, null, ex);
		}
		Raster data = bufferedImage.getData();
		final int WIDTH = data.getWidth(), HEIGHT = data.getHeight();

		System.out.println("Se inicializa la matriz");
		int[][] image = new int[HEIGHT + margen][WIDTH + margen];

		System.out.println("Se carga la matriz con lo valores en escala de grises");
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				image[i][j] = (data.getSample(j, i, 0));
			}
		}

		saveImage(image, HEIGHT, WIDTH, FORMATO, new File(basePath + "G-" + imageSource));

		System.out.println("Aplicamos filtro horizontal, obtenemos bordes verticales");
		int[][] imagenH = filtro(image, "H", margen, HEIGHT, WIDTH);
		saveImage(imagenH, HEIGHT, WIDTH, FORMATO, new File(basePath + "H-" + imageSource));

		System.out.println("Aplicamos filtro vertical, obtenemos bordes horizontales");
		int[][] imagenV = filtro(image, "V", margen, HEIGHT, WIDTH);
		saveImage(imagenV, HEIGHT, WIDTH, FORMATO, new File(basePath + "V-" + imageSource));

		System.out.println("combinamos las imagenes");
		int[][] borders = combine(imagenH, imagenV, HEIGHT, WIDTH);
		saveImage(borders, HEIGHT, WIDTH, FORMATO, new File(basePath + "B-" + imageSource));

		int[][] bordersBN = GrayscaleToBN(borders, HEIGHT, WIDTH);
 		saveImage(bordersBN, HEIGHT, WIDTH, FORMATO, new File(basePath + "BN-" + imageSource));

		System.out.println("Pasamos a letras");
		char[][] letters = imageToLetters(bordersBN, myLetters, HEIGHT, WIDTH);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				new Ventana(HEIGHT, WIDTH, letters);
			}
		});
		
		System.out.println("Finalizo");
	}

	private static int[][] filtro(int[][] image, String tipo, int margen, int HEIGHT, int WITH) {
		int[][] filtro = new int[HEIGHT][WITH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				int value = 0;
				switch (tipo) {
					case "H":
						value = image[i][j] - image[i][j + margen];
						break;
					case "V":
						value = image[i][j] - image[i + margen][j];
						break;
					default:
						System.out.println("Filtro invalido");
						break;
				}
				if (value < 0) {
					value = value * -1;
				}
				filtro[i][j] = value;
			}
		}
		return filtro;
	}

	private static void saveImage(int[][] imagenFiltrada, int HEIGHT, int WITH, String FORMATO, File archivoSalida) {
		BufferedImage image = new BufferedImage(WITH, HEIGHT, BufferedImage.TYPE_BYTE_GRAY);
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WITH; x++) {
				int value = imagenFiltrada[y][x] << 16 | imagenFiltrada[y][x] << 8 | imagenFiltrada[y][x];
				image.setRGB(x, y, value);
			}
		}
		try {
			ImageIO.write(image, FORMATO, archivoSalida);
		} catch (IOException ex) {
			Logger.getLogger(IdentificacionImagenes.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static int[][] combine(int[][] imagenH, int[][] imagenV, int HEIGHT, int WITH) {
		int[][] combined = new int[HEIGHT][WITH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				combined[i][j] = imagenH[i][j] + imagenV[i][j];
			}
		}
		return combined;
	}

	private static int[][] GrayscaleToBN(int[][] image, int HEIGHT, int WITH) {
		int[][] blackandwhite = new int[HEIGHT][WITH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				if (image[i][j] < 50) {
					blackandwhite[i][j] = -1;
				} else {
					blackandwhite[i][j] = 1;
				}
			}
		}
		return blackandwhite;
	}

	private static char[][] imageToLetters(int[][] image, ArrayList<Letter> myLetters, int HEIGHT, int WITH) {
		char [][] letters = new char[HEIGHT/3][WITH/3];
		int[][] neighbors = new int[3][3];
		int k=0,l=0;
		for (int i = 0; i < HEIGHT-4; i+=3) {
			l=0;
			for (int j = 0; j < WITH-4; j+=3) {
				neighbors[0][0]=image[i][j];
				neighbors[0][1]=image[i][j+1];
				neighbors[0][2]=image[i][j+2];
				
				neighbors[1][0]=image[i+1][j];
				neighbors[1][1]=image[i+1][j+1];
				neighbors[1][2]=image[i+1][j+2];
				
				neighbors[2][0]=image[i+2][j];
				neighbors[2][1]=image[i+2][j+1];
				neighbors[2][2]=image[i+2][j+2];
				
				letters[k][l]=getLetter(neighbors,myLetters);
				//String test = getLetter(neighbors,myLetters);
				l++;
			}
			k++;
		}
		return letters;
	}
	
	private static char getLetter(int[][] neighbors,ArrayList<Letter> myLetters) {
		for (Letter letter : myLetters) {
			if(Arrays.deepEquals(neighbors, letter.form)){
				 return letter.name;
			}
		}
		return '-';
	}
}
