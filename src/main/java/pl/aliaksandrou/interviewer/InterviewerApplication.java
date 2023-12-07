package pl.aliaksandrou.interviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InterviewerApplication extends Application {
    @Override
    public void start(final Stage stage) throws IOException {
        final var fxmlLoader = new FXMLLoader(InterviewerApplication.class.getResource("main-view.fxml"));
        final var scene = new Scene(fxmlLoader.load(), 1200, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        stage.setTitle("Interviewer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
