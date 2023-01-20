module com.example.proiecttelefoane {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.proiecttelefoane to javafx.fxml;
    exports com.example.proiecttelefoane;
}