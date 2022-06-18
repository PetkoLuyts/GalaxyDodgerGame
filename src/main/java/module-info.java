module com.example.galaxydodger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.galaxydodger to javafx.fxml;
    exports com.example.galaxydodger;
}