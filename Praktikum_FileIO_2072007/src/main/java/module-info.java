module com.example.praktikum_fileio_2072007 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.praktikum_fileio_2072007 to javafx.fxml;
    exports com.example.praktikum_fileio_2072007;
}