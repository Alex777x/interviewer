module pl.aliaksandrou.interviewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens pl.aliaksandrou.interviewer to javafx.fxml;
    exports pl.aliaksandrou.interviewer;
    exports pl.aliaksandrou.interviewer.controller;
    exports pl.aliaksandrou.interviewer.enums;
    opens pl.aliaksandrou.interviewer.controller to javafx.fxml;
}
