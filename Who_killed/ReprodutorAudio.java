package Who_killed;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class ReprodutorAudio {
    public static void main(String[] args) {

    }

    public static void leitura(String caminho,String texto,String titulo) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

            Clip oClip = null;
            String resource = caminho;// Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
            InputStream input = Investigacao.class.getResourceAsStream(resource);
            oClip = AudioSystem.getClip();
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
            oClip.open(audioInput);
            oClip.loop(0);
        JOptionPane.showMessageDialog(
                null,texto,
                titulo,
                JOptionPane.INFORMATION_MESSAGE
        );
            oClip.close();
            oClip.stop();

    }

}
