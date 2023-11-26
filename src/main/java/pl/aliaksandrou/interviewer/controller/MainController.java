package pl.aliaksandrou.interviewer.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import pl.aliaksandrou.interviewer.enums.AIModel;
import pl.aliaksandrou.interviewer.enums.Language;
import pl.aliaksandrou.interviewer.enums.SpeechToTextModel;
import pl.aliaksandrou.interviewer.service.StartAction;
import pl.aliaksandrou.interviewer.service.StopAction;
import pl.aliaksandrou.interviewer.service.impl.StartActionIml;
import pl.aliaksandrou.interviewer.service.impl.StopActionImpl;

import java.util.List;

public class MainController {
    @FXML
    public ComboBox<AIModel> aiModelComboBox;
    @FXML
    public ComboBox<SpeechToTextModel> speechToTextComboBox;
    @FXML
    private ComboBox<Language> interviewLanguageComboBox;
    @FXML
    private ComboBox<Language> secondLanguageComboBox;
    @FXML
    private Text incomingQuestion;
    @FXML
    private Text incomingAnswer;
    @FXML
    private Text incomingTranslatedQuestion;
    @FXML
    private Text incomingTranslatedAnswerLabel;

    private final StartAction startAction = new StartActionIml();
    private final StopAction stopAction = new StopActionImpl();

    @FXML
    public String startButtonClicked(final ActionEvent actionEvent) {
        return startAction.start(actionEvent);
    }

    @FXML
    public void stopButtonClicked(final ActionEvent actionEvent) {
        stopAction.stop(actionEvent);
    }

    public void initialize() {
        final var aiModels = FXCollections.observableArrayList(List.of(AIModel.values()));
        aiModelComboBox.getItems().clear();
        aiModelComboBox.setItems(aiModels);

        final var speechToTextModels = FXCollections.observableArrayList(List.of(SpeechToTextModel.values()));
        speechToTextComboBox.getItems().clear();
        speechToTextComboBox.setItems(speechToTextModels);

        final var languages = FXCollections.observableArrayList(List.of(Language.values()));
        interviewLanguageComboBox.getItems().clear();
        interviewLanguageComboBox.setItems(languages);

        final var secondLanguages = FXCollections.observableArrayList(List.of(Language.values()));
        secondLanguageComboBox.getItems().clear();
        secondLanguageComboBox.setItems(secondLanguages);
    }
}
