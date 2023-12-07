package pl.aliaksandrou.interviewer.enums;

public enum SpeechToTextModel {
    SPEECH_TO_TEXT_MODEL_1("speech_to_text_model_1"),
    SPEECH_TO_TEXT_MODEL_2("speech_to_text_model_2");

    public final String label;

    SpeechToTextModel(final String label) {
        this.label = label;
    }
}
