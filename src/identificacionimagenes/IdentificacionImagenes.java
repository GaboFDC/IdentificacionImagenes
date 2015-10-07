/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificacionimagenes;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gabo
 */
public class IdentificacionImagenes {

private final int[][] A = {{-1,  1, -1},
						   { 1,  1,  1},
						   { 1, -1,  1}};

private final int[][] B = {{ 1,  1, -1},
						   { 1,  1,  1},
						   { 1,  1,  1}};

private final int[][] C = {{ 1,  1,  1},
						   { 1, -1, -1},
						   { 1,  1,  1}};

private final int[][] D = {{ 1,  1, -1},
						   { 1, -1,  1},
						   { 1,  1, -1}};

private final int[][] E = {{ 1,  1,  1},
						   { 1,  1, -1},
						   { 1,  1,  1}};

private final int[][] F = {{ 1,  1,  1},
						   { 1,  1, -1},
						   { 1, -1, -1}};

private final int[][] G = {{ 1,  1, -1},
						   { 1, -1,  1},
						   { 1,  1,  1}};

private final int[][] H = {{ 1, -1,  1},
						   { 1,  1,  1},
						   { 1, -1,  1}};

private final int[][] I = {{ 1,  1,  1},
						   {-1,  1, -1},
						   { 1,  1,  1}};

private final int[][] J = {{-1, -1,  1},
						   { 1, -1,  1},
						   { 1,  1,  1}};

private final int[][] K = {{ 1, -1,  1},
						   { 1,  1, -1},
						   { 1, -1,  1}};

private final int[][] L = {{ 1, -1, -1},
						   { 1, -1, -1},
						   { 1,  1, -1}};

private final int[][] M = {{ 1,  1,  1},
						   { 1,  1,  1},
						   { 1, -1,  1}};

private final int[][] N = {{ 1,  1,  1},
						   { 1, -1,  1},
						   { 1, -1,  1}};

private final int[][] O = {{ 1,  1,  1},
						   { 1, -1,  1},
						   { 1,  1,  1}};

private final int[][] P = {{ 1,  1,  1},
						   { 1,  1,  1},
						   { 1, -1, -1}};

private final int[][] Q = {{ 1,  1,  1},
						   { 1,  1,  1},
						   {-1, -1,  1}};

private final int[][] R = {{ 1,  1,  1},
						   { 1, -1, -1},
						   { 1, -1, -1}};

private final int[][] S = {{-1,  1,  1},
						   {-1,  1, -1},
						   { 1,  1, -1}};

private final int[][] T = {{ 1,  1,  1},
						   {-1,  1, -1},
						   {-1,  1, -1}};

private final int[][] U = {{ 1, -1,  1},
						   { 1, -1,  1},
						   { 1,  1,  1}};

private final int[][] V = {{ 1, -1,  1},
						   { 1, -1,  1},
						   {-1,  1, -1}};

private final int[][] W = {{ 1, -1,  1},
						   { 1,  1,  1},
						   { 1,  1,  1}};

private final int[][] X = {{ 1, -1,  1},
						   {-1,  1, -1},
						   { 1, -1,  1}};

private final int[][] Y = {{ 1, -1,  1},
						   {-1,  1, -1},
						   {-1,  1, -1}};

private final int[][] Z = {{ 1,  1, -1},
						   {-1,  1, -1},
						   {-1,  1,  1}};

private final int[][] N1 = {{ 1,  1, -1},
						    {-1,  1, -1},
						    { 1,  1,  1}};

private final int[][] N3 = {{ 1,  1,  1},
						    {-1,  1,  1},
						    { 1,  1,  1}};

private final int[][] N4 = {{ 1, -1,  1},
						    { 1,  1,  1},
						    {-1, -1,  1}};

private final int[][] N6 = {{ 1, -1, -1},
					 	    { 1,  1,  1},
					 	    { 1,  1,  1}};

private final int[][] N7 = {{ 1,  1,  1},
					 	    {-1, -1,  1},
					 	    {-1, -1,  1}};

private final int[][] N8 = {{-1,  1,  1},
					 	    { 1,  1,  1},
 						    { 1,  1,  1}};

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

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
		final int WITH = data.getWidth(), HEIGHT = data.getHeight();

		System.out.println("Se inicializa la matriz");
		int[][] image = new int[HEIGHT + margen][WITH + margen];

		System.out.println("Se carga la matriz con lo valores en escala de grises");
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				image[i][j] = (data.getSample(j, i, 0));
			}
		}

		saveImage(image, HEIGHT, WITH, FORMATO, new File(basePath + "G-" + imageSource));

		System.out.println("Aplicamos filtro horizontal, obtenemos bordes verticales");
		int[][] imagenH = filtro(image, "H", margen, HEIGHT, WITH);
		saveImage(imagenH, HEIGHT, WITH, FORMATO, new File(basePath + "H-" + imageSource));

		System.out.println("Aplicamos filtro vertical, obtenemos bordes horizontales");
		int[][] imagenV = filtro(image, "V", margen, HEIGHT, WITH);
		saveImage(imagenV, HEIGHT, WITH, FORMATO, new File(basePath + "V-" + imageSource));

		System.out.println("combinamos las imagenes");
		int[][] borders = combine(imagenH, imagenV, HEIGHT, WITH);
		saveImage(borders, HEIGHT, WITH, FORMATO, new File(basePath + "B-" + imageSource));

		int[][] bordersBN = GrayscaleToBN(borders, HEIGHT, WITH);
		saveImage(bordersBN, HEIGHT, WITH, FORMATO, new File(basePath + "BN-" + imageSource));

		System.out.println("Pasamos a letras");
		int[][] letters = imageToLetters(bordersBN, HEIGHT, WITH);

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

	private static int[][] imageToLetters(int[][] image, int HEIGHT, int WITH) {
		int[][] combined = new int[HEIGHT][WITH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				
			}
		}
		return combined;
	}
}
