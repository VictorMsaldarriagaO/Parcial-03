module com.example.parcial {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.parcial3 to javafx.fxml;

    opens com.example.parcial3.Controller to javafx.fxml;

    opens com.example.parcial3.App to javafx.fxml;

    exports com.example.parcial3.Controller;
    exports com.example.parcial3.App;
}