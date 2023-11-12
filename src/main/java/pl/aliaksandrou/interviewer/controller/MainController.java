package pl.aliaksandrou.interviewer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import pl.aliaksandrou.interviewer.enums.AIModel;
import pl.aliaksandrou.interviewer.enums.InterviewTopic;
import pl.aliaksandrou.interviewer.enums.Language;
import pl.aliaksandrou.interviewer.enums.SpeechToTextModel;
import pl.aliaksandrou.interviewer.service.StartAction;
import pl.aliaksandrou.interviewer.service.impl.StartActionIml;

public class MainController {
    @FXML
    public ComboBox<AIModel> aiModelComboBox;
    @FXML
    public ComboBox<SpeechToTextModel> speechToTextComboBox;
    @FXML
    public ComboBox<InterviewTopic> interviewTopicComboBox;
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

    @FXML
    public String startButtonClicked(ActionEvent actionEvent) {
        return startAction.start(actionEvent);
    }

    @FXML
    public void stopButtonClicked(ActionEvent actionEvent) {

    }
}
