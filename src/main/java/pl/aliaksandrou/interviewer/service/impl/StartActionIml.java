package pl.aliaksandrou.interviewer.service.impl;

import javafx.event.ActionEvent;
import pl.aliaksandrou.interviewer.audiointerceptor.AudioInterceptor;
import pl.aliaksandrou.interviewer.service.StartAction;

public class StartActionIml implements StartAction {

    AudioInterceptor audioInterceptor = new AudioInterceptor();
    @Override
    public String start(ActionEvent actionEvent) {
        audioInterceptor.getAudioData();
        return null;
    }
}
