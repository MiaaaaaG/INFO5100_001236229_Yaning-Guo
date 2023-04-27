package com.example.finalproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


// use of encapsulation: protect the member variables of the MyImage class from being accessed directly by external code
public class MyImage {
    // member variables
    private String imageName;
    private String width;
    private String height;
    private long fileSize;

    public MyImage(File file) throws IOException {
        try {
            // read the image file using the ImageIO
            BufferedImage image = ImageIO.read(file);

            // set the member variables based on the image properties
            imageName = file.getName();
            fileSize = file.length();
            width = String.valueOf(image.getWidth());
            height = String.valueOf(image.getHeight());

        } catch (IOException e) {
            // handle the exception
            e.printStackTrace();
        }
    }

    public String getImageName() {
        return imageName;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    // method to calculate and return the size of the image file in MB
    public String getFileSizeMB() {
        double fileSizeMB = (double)fileSize / (1024 * 1024);
        return String.format("%.2fMB", fileSizeMB);
    }

    // method to determine and return the image format based on the file extension
    public String getImageFormat() {
        // get the file extension by finding the last occurrence of "." in the image name
        String extension = imageName.substring(imageName.lastIndexOf(".") + 1);
        String format = "";

        // determine the image format based on the file extension using a switch statement
        switch (extension.toLowerCase()) {
            case "jpg":
            case "jpeg":
                format = "JPEG";
                break;
            case "png":
                format = "PNG";
                break;
            case "gif":
                format = "GIF";
                break;
            default:
                format = ""; // if the file extension is not recognized, return an empty string
        }

        return format;
    }
}
