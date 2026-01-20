package org.example.temperatureconverter.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.temperatureconverter.erroralert.ErrorAlert;

public class CenterPane extends VBox {
    public CenterPane() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
        Label header = new Label("Temperature Converter");
        header.setId("header");
        header.setAlignment(Pos.CENTER);

        Label from = new Label("From:");
        from.setId("from");

        ChoiceBox box = new ChoiceBox();
        box.setId("choice-box");
        box.getItems().addAll("Fahrenheit", "Celsius", "Kelvin");
        box.setPrefWidth(140);
        box.setValue("Celsius");

        Label to = new Label("To:");
        to.setId("to");

        ChoiceBox toScale = new ChoiceBox();
        toScale.setMaxWidth(140);
        toScale.getItems().addAll("Fahrenheit", "Celsius", "Kelvin");
        toScale.setValue("Fahrenheit");

        TextField fromScale = new TextField();
        fromScale.setId("text-field");
        fromScale.setMaxWidth(140);

        Button b = new Button("Convert");
        b.setMinWidth(100);
        b.setMinHeight(30);
        b.setSkin(new ConvertButtonSkin(b));
        b.setId("convert-button");

        Label resultLabel = new Label();
        resultLabel.setId("result-label");

        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(fromScale.getText().trim().isBlank()) {
                    ErrorAlert alert = new ErrorAlert();
                    alert.customizeAlert("Error", "Empty Field", "Text Field cannot be empty.");
                    resultLabel.setText("Text Field cannot be empty.");
                    return;
                }
                Logic logic = new Logic();
                String fromItem = box.getValue().toString();
                String toItem = toScale.getValue().toString();
                String requestedConversion = fromItem.toLowerCase() + "->" + toItem.toLowerCase();

                try {
                    double value = Double.parseDouble(fromScale.getText().replace(" ", "").trim());
                    double returnValue = logic.calculate(requestedConversion, value);
                    String formatted = String.format("%.2f", returnValue);



                    if(Double.isNaN(returnValue)) {
                        fromScale.setText(Double.toString(value));          // display cleaned value again just for aesthetic purposes
                        ErrorAlert alert = new ErrorAlert();
                        alert.customizeAlert("Error", "Same Scales", "Cannot convert the same type of scales.");
                        resultLabel.setText("Cannot convert the same type of scales.");
                    }
                    else {
                        fromScale.setText(Double.toString(value));
                        resultLabel.setText(formatted + logic.getScale());
                    }
                }

                catch(NumberFormatException nfe) {
                    ErrorAlert alert = new ErrorAlert();
                    alert.customizeAlert("Error", "Number Format Exception", "Please enter numbers.");
                    resultLabel.setText("Please enter numbers.");

                    System.out.println("Letters are not allowed");
                }

                catch(Exception e) {
                    ErrorAlert alert = new ErrorAlert();
                    alert.customizeAlert("Error", "Unknown Error", "Something went wrong");
                    System.out.println("Something went wrong.");
                }
            }
        });

        this.getChildren().addAll(header, from, box, to, toScale,  fromScale, b, resultLabel);
    }
}
