package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class Controller {
    // create an instance variable to hold a reference to the ScrollPane in fxml
    @FXML
    private ScrollPane scrollPane;

    // create a list of file to hold the selected images for view
    List<File> selectedFile;

    // method of add images when user click the button "Add Images"
    public void addImage() {

        try {
            // create a new FileChooser object
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose one or more images");
            // add filters to only allow image files with images extensions
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Images Files", "*.png", "*.jpg", "*.gif"));
            // show the file chooser dialog and wait for the user to select one or more files
            selectedFile = fileChooser.showOpenMultipleDialog(null);

            // create a GridPane(gallery) to hold the image cards
            GridPane gallery = new GridPane();
            // Initialize row and column counters for the grid
            int row = 0;
            int col = 0;

            // if the user selects files, create an image card for each file
            if (selectedFile != null) {
                for (int i = 0; i < selectedFile.size(); i++) {
                    File file = selectedFile.get(i);

                    // create a new MyImage object for the file to get the properties
                    MyImage image = new MyImage(file);

                    // get the thumbnail 100*100
                    ImageView imageView = new ImageView();
                    imageView.setImage(new Image(new FileInputStream(file.getPath())));
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    imageView.setPreserveRatio(true);

                    // create a thumbnail container
                    VBox thumbnail = new VBox();
                    thumbnail.setPrefSize(100, 100);
                    thumbnail.getChildren().add(imageView);

                    // get the label and create a label container
                    Label labelHeight = new Label("Height: " + image.getHeight());
                    Label labelWidth = new Label("Width: " + image.getWidth());
                    Label labelSize = new Label("File Size: " + image.getFileSizeMB());
                    Label labelType = new Label("Type: " + image.getImageFormat());
                    VBox labelContainer = new VBox(labelHeight, labelWidth, labelSize, labelType);
                    labelContainer.setSpacing(5);

                    // add thumbnail and labels to ImageCard container
                    VBox imageCard = new VBox(thumbnail, labelContainer);
                    imageCard.setSpacing(10);

                    // add ImageCard to GridPane(gallery)
                    gallery.add(imageCard, col, row);
                    gallery.setHgap(40);
                    gallery.setVgap(30);

                    col++; // move right

                    // move down, so there 5 image cards each row
                    if (col == 5) {
                        col = 0;
                        row++;
                    }
                }

                // show gallery in the Scroll Pane
                scrollPane.setContent(gallery);
            }

        } catch (IOException e) {
            // handle the exception by displaying an error message
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred while adding images.");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

    // create instances variable to hold a reference to the CheckBox in fxml
    @FXML
    private CheckBox jpg;
    @FXML
    private CheckBox png;
    @FXML
    private CheckBox gif;

    // create a variable to hold the image converter
    ImageConverter imageConverter;

    // method of convert images when user click the button "Convert & Save"
    public void convertImage() throws IOException, NoFileSelectedException{
        // check if at least one image format checkbox is selected, if not, show an error dialog
        if (!jpg.isSelected() && !png.isSelected() && !gif.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one image format checkbox.");
            alert.showAndWait();
            return;
        }

        // check if any file is selected
        if (selectedFile == null || selectedFile.isEmpty()) {
            // throw an exception if no file is selected
            throw new NoFileSelectedException("No file selected");
        }

        // new a converter based on the selected image format checkbox
        if (jpg.isSelected()){
            imageConverter = new JpgConverter();
        }else if (png.isSelected()){
            imageConverter = new PngConverter();
        }else if (gif.isSelected()){
            imageConverter = new GifConverter();
        }

        // iterate over the selected files and convert them to the selected format
        if (selectedFile != null) {
            for (int i = 0; i < selectedFile.size(); i++) {
                File file = selectedFile.get(i);
                imageConverter.convert(file);
            }
        }
    }
}