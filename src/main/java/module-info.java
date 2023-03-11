module com.example.proj_ii_1210338_s6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.proj_ii_1210338_s6 to javafx.fxml;
    exports com.example.proj_ii_1210338_s6;
}