package pl.aliaksandrou.interviewer.audiointerceptor;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class AudioInterceptor {

    public void getAudioData() {
        try {
            // Задаем формат аудиоданных для записи и воспроизведения
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    44100, 16, 2, 4, 44100, false);

            // Создаем линию для перехвата аудио данных из микшера
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, format);
            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
            Mixer mixer = null;

            for (Mixer.Info info : mixerInfo) {
                Mixer currentMixer = AudioSystem.getMixer(info);
                if (currentMixer.isLineSupported(dataLineInfo)) {
                    mixer = currentMixer;
                    break;
                }
            }

            if (mixer == null) {
                // Не удалось найти подходящий микшер, обработайте эту ситуацию
                System.out.println("Не удалось найти подходящий микшер.");
                return;
            }

            TargetDataLine targetDataLine = (TargetDataLine) mixer.getLine(dataLineInfo);
            targetDataLine.open(format);
            targetDataLine.start();

            // Создаем буфер для считывания аудио данных
            byte[] buffer = new byte[1024];

            // Создаем линию для воспроизведения перехваченных аудио данных
            DataLine.Info sourceDataLineInfo = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(sourceDataLineInfo);
            sourceDataLine.open(format);
            sourceDataLine.start();

            // Читаем аудио данные из TargetDataLine и отправляем их в сервис распознавания речи
            while (true) {
                int bytesRead = targetDataLine.read(buffer, 0, buffer.length);
                if (bytesRead >= 0) {
                    System.out.println(bytesRead);
                    // Здесь вам нужно вызвать API для отправки аудио данных в сервис распознавания речи
                    // Например:
                    // SpeechToTextAPI.sendAudioData(buffer, bytesRead);
                    // В этом примере buffer содержит считанные аудио данные, bytesRead - количество байт, считанных из TargetDataLine
                    sourceDataLine.write(buffer, 0, bytesRead);
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
