package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField num1TextField;
    private TextField num2TextField;
    private Label resultLabel;

    @Override
    public void start(Stage stage) {

        // Create the text fields for input
        num1TextField = new TextField();
        num2TextField = new TextField();

        // Create the label for displaying the result
        resultLabel = new Label();

        // Create the buttons for the calculator
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Set the action for the buttons
        addButton.setOnAction(this::add);
        subtractButton.setOnAction(this::subtract);
        multiplyButton.setOnAction(this::multiply);
        divideButton.setOnAction(this::divide);

        // Create the grid pane layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(new Label("Number 1:"), 0, 0);
        gridPane.add(num1TextField, 1, 0);
        gridPane.add(new Label("Number 2:"), 0, 1);
        gridPane.add(num2TextField, 1, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 0, 3);
        gridPane.add(divideButton, 1, 3);
        gridPane.add(new Label("Result:"), 0, 4);
        gridPane.add(resultLabel, 1, 4);

        // Create the scene and show the stage
        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    // Handle the addition operation
    private void add(ActionEvent event) {
        double num1 = Double.parseDouble(num1TextField.getText());
        double num2 = Double.parseDouble(num2TextField.getText());
        double result = num1 + num2;
        resultLabel.setText(Double.toString(result));
    }

    // Handle the subtraction operation
    private void subtract(ActionEvent event) {
        double num1 = Double.parseDouble(num1TextField.getText());
        double num2 = Double.parseDouble(num2TextField.getText());
        double result = num1 - num2;
        resultLabel.setText(Double.toString(result));
    }

    // Handle the multiplication operation
    private void multiply(ActionEvent event) {
        double num1 = Double.parseDouble(num1TextField.getText());
        double num2 = Double.parseDouble(num2TextField.getText());
        double result = num1 * num2;
        resultLabel.setText(Double.toString(result));
    }

    // Handle the division operation
    private void divide(ActionEvent event) {
        double num1 = Double.parseDouble(num1TextField.getText());
        double num2 = Double.parseDouble(num2TextField.getText());
        double result = num1 / num2;
        resultLabel.setText(Double.toString(result));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
