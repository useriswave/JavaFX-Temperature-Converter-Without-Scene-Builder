package org.example.temperatureconverter.erroralert;

import javafx.scene.control.Alert;

public class ErrorAlert extends Alert {

    public ErrorAlert() {
        super(AlertType.ERROR);
    }

    public void customizeAlert(String title, String headerText, String contentText) {
        this.setTitle(title);
        this.setHeaderText(headerText);
        this.setContentText(contentText);
        this.showAndWait();
    }
}
