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
		int[][] image = new int[HEIGHT + 1][WITH + 1];

		System.out.println("Se carga la matriz con lo valores en escala de grises");
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WITH; j++) {
				image[i][j] = (data.getSample(j, i, 0));
			}
		}

		saveImage(image, HEIGHT, WITH, FORMATO, new File(basePath + "G-" + imageSource));

		int[][] imagenFiltrada = filtro(image, "H", HEIGHT, WITH);
		saveImage(imagenFiltrada, HEIGHT, WITH, FORMATO, new File(basePath + "H-" + imageSource));

		imagenFiltrada = filtro(image, "V", HEIGHT, WITH);
		saveImage(imagenFiltrada, HEIGHT, WITH, FORMATO, new File(basePath + "V-" + imageSource));

		System.out.println("Finalizo");
	}

	private static int[][] filtro(int[][] image, String tipo, int HEIGHT, int WITH) {
		int[][] filtro = new int[HEIGHT][WITH];
		switch (tipo) {
			case "H":
				System.out.println("Aplicamos filtro horizontal, obtenemos bordes verticales");
				for (int i = 0; i < HEIGHT; i++) {
					for (int j = 0; j < WITH; j++) {
						int value = image[i][j] - image[i][j + 1];
						if (value < 0) {
							value = 0;
						}
						filtro[i][j] = value;
					}
				}
				break;
			case "V":
				System.out.println("Aplicamos filtro vertical, obtenemos bordes horizontales");
				for (int i = 0; i < HEIGHT; i++) {
					for (int j = 0; j < WITH; j++) {
						int value = image[i][j] - image[i + 1][j];
						if (value < 0) {
							value = 0;
						}
						filtro[i][j] = value;
					}
				}
				break;
			default:
				System.out.println("Filtro invalido");
				break;
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

}
