/*
This class implements the ImageConverter interface
and provides the functionality to convert an image file to JPG format.
 */


package com.example.finalproject;

import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JpgConverter implements ImageConverter {

    @Override
    public void convert(File file) {
        try {
            // get the name of the input file and create a new name for the output file
            String fileName = file.getName();
            String[] parts = fileName.split("\\.");
            String newFileName = parts[0] + ".jpg";

            // read the input image file into a BufferedImage object
            BufferedImage image = ImageIO.read(file);

            // show a file chooser dialog to select the output directory and name the output file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose the output directory");
            fileChooser.setInitialFileName(newFileName);
            File location = fileChooser.showSaveDialog(null);

            // write the output file in JPG format to the selected location
            ImageIO.write(image, "jpg", location);
        } catch (IOException e) {
            // handle the exception
            e.printStackTrace();
        }
    }
}