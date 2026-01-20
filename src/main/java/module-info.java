module org.example.temperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.temperatureconverter to javafx.fxml;

    exports org.example.temperatureconverter.main;
    opens org.example.temperatureconverter.main to javafx.fxml;
    exports org.example.temperatureconverter.panes;
    opens org.example.temperatureconverter.panes to javafx.fxml;
    exports org.example.temperatureconverter.erroralert;
    opens org.example.temperatureconverter.erroralert to javafx.fxml;
}