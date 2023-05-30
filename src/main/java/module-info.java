module com.example.psabschlussprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;


    opens com.example.psabschlussprojekt to javafx.fxml;
    exports com.example.psabschlussprojekt;
    exports com.example.psabschlussprojekt.gui;
    opens com.example.psabschlussprojekt.gui to javafx.fxml;
}