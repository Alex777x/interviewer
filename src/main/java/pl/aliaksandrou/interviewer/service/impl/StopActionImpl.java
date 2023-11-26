package pl.aliaksandrou.interviewer.service.impl;

import javafx.event.ActionEvent;
import pl.aliaksandrou.interviewer.service.StopAction;

public class StopActionImpl implements StopAction {
    @Override
    public void stop(final ActionEvent actionEvent) {
//        save all data for future use
        System.exit(0); // for now, but needs to be stopped all threads and save data
    }
}
