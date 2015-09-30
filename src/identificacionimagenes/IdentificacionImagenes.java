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
        String basePath = "/home/gabo/Pictures/";
        String imageSource = "IA.jpg";

        BufferedImage bufferedImage = null;
        System.out.println("Se lee la imagen...");
        try {
            bufferedImage = ImageIO.read(Files.newInputStream(Paths.get(basePath + imageSource)));
        } catch (IOException ex) {
            Logger.getLogger(IdentificacionImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Raster data = bufferedImage.getData();
        final int WITH=data.getWidth(), HEIGHT=data.getHeight();

        System.out.println("Se inicializa la matriz");
        int[][] image = new int[HEIGHT+1][WITH+1];

        System.out.println("Se carga la matriz con lo valores en escala de grises");
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WITH; j++) {
                image[i][j] = (data.getSample(j, i, 0));
            }
        }
        
        System.out.println("Aplicamos filtro horizontal, obtenemos bordes verticales");
        int[][] bordesV= new int[HEIGHT][WITH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WITH; j++) {
                bordesV[i][j]=image[i][j]+image[i][j+1];
            }
        }
        
        System.out.println("Finalizo");
    }

}
