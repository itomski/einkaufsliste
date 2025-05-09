module de.lubowiecki.einkaufsliste {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lubowiecki.einkaufsliste to javafx.fxml;
    exports de.lubowiecki.einkaufsliste;
}