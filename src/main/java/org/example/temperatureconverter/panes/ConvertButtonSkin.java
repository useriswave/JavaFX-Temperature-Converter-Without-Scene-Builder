package org.example.temperatureconverter.panes;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.util.Duration;

public class ConvertButtonSkin extends ButtonSkin {

    private final ScaleTransition hoverIn;
    private final ScaleTransition hoverOut;
    private final ScaleTransition pressIn;
    private final ScaleTransition pressOut;

    public ConvertButtonSkin(Button button) {
        super(button);


        hoverIn = new ScaleTransition(Duration.millis(120), button);
        hoverIn.setToX(1.08);
        hoverIn.setToY(1.08);

        hoverOut = new ScaleTransition(Duration.millis(120), button);
        hoverOut.setToX(1.0);
        hoverOut.setToY(1.0);

        pressIn = new ScaleTransition(Duration.millis(80), button);
        pressIn.setToX(0.95);
        pressIn.setToY(0.95);

        pressOut = new ScaleTransition(Duration.millis(80), button);
        pressOut.setToX(1.08);
        pressOut.setToY(1.08);

        button.setOnMouseEntered(e -> {
            hoverIn.playFromStart();
            button.setOpacity(1);
        });
        button.setOnMouseExited(e -> {
            hoverOut.playFromStart();
            button.setOpacity(1);
        });
//        button.setOnMousePressed(e -> pressIn.playFromStart());
        button.setOnMousePressed(e -> {
            pressIn.playFromStart();
            button.setOpacity(0.5);
        });
        button.setOnMouseReleased(e -> {
            pressOut.playFromStart();
            button.setOpacity(1);
        });
    }
}
