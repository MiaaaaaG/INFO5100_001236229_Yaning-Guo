/*
This class implements the ImageConverter interface
and provides the functionality to convert an image file to PNG format.
 */

package com.example.finalproject;

import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PngConverter implements ImageConverter {
    @Override
    public void convert(File file) {
        try {
            String fileName = file.getName();
            String[] parts = fileName.split("\\.");
            String newFileName = parts[0] + ".png";

            BufferedImage image = ImageIO.read(file);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose the output directory");
            fileChooser.setInitialFileName(newFileName);
            File location = fileChooser.showSaveDialog(null);

            ImageIO.write(image, "png", location);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
