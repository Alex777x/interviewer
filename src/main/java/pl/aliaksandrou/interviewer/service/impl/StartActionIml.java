package pl.aliaksandrou.interviewer.service.impl;

import javafx.event.ActionEvent;
import pl.aliaksandrou.interviewer.audiointerceptor.AudioProcessor;
import pl.aliaksandrou.interviewer.audiointerceptor.MacAudioProcessor;
import pl.aliaksandrou.interviewer.service.StartAction;

public class StartActionIml implements StartAction {

    private final AudioProcessor audioProcessor = new MacAudioProcessor();

    @Override
    public String start(final ActionEvent actionEvent) {
        audioProcessor.processAudio();
        return null;
    }
}
