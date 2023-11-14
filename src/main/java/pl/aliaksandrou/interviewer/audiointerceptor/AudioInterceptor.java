package pl.aliaksandrou.interviewer.audiointerceptor;

import javax.sound.sampled.*;
import java.util.Arrays;

public class AudioInterceptor {

    private static final AudioFormat FORMAT = new AudioFormat(44100, 16, 2, true, false);

    public void processAudioData() {
        try {
            var mixerInfos = AudioSystem.getMixerInfo();

            var blackHole = Arrays.stream(mixerInfos)
                    .filter(info -> info.getName().equals("BlackHole 2ch"))
                    .findFirst()
                    .orElse(null);

            if (blackHole == null) {
                System.err.println("BlackHole 2ch Device not found.");
                System.exit(1);
            }

            var mixer = AudioSystem.getMixer(blackHole);

            var dataLineInfo = new DataLine.Info(TargetDataLine.class, FORMAT);
            var targetDataLine = (TargetDataLine) mixer.getLine(dataLineInfo);

            targetDataLine.open(FORMAT);
            targetDataLine.start();

            var buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = targetDataLine.read(buffer, 0, buffer.length)) != -1) {
                // Process the audio data here.

                // For example, you could save the audio data to a file:
                // FileOutputStream fos = new FileOutputStream("audio.wav");
                // fos.write(buffer, 0, bytesRead);
                // fos.close();

                // Or, you could use a speech-to-text recognition engine to generate captions for the audio:
                // SpeechToTextRecognitionEngine engine = new GoogleCloudSpeechToTextRecognitionEngine();
                // String transcript = engine.transcribe(buffer);
                // ...
                checkAmplitude(buffer, bytesRead);
            }

            targetDataLine.close();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void checkAmplitude(byte[] buffer, int bytesRead) {
        // Example: Print the amplitude of each sample
        for (int i = 0; i < bytesRead; i += 2) {
            var sample = ((buffer[i + 1] << 8) | (buffer[i] & 0xFF));
            System.out.println("Amplitude: " + sample);
        }
    }
}
