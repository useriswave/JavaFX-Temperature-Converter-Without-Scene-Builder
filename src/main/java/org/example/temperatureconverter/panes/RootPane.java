package org.example.temperatureconverter.panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;


public class RootPane extends BorderPane {

    public RootPane() {

        CenterPane cp = new CenterPane();
        this.setId("root-pane");
        this.setCenter(new CenterPane());
        this.setPadding(new Insets(20));
        BorderPane.setAlignment(cp, Pos.CENTER);
    }
}
