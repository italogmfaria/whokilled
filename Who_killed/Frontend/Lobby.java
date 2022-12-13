/*
echo "# whokilled" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/italogmfaria/whokilled.git
git push -u origin main
 */

package Who_killed.Frontend;

import Who_killed.Investigacao;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Lobby {
    private JPanel panel1;
    private JLabel label1;
    public JButton start;

    public Lobby() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Investigacao investigacao = new Investigacao();

                try {
                    investigacao.main(new String[]{"a", "b"});
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame panel1 = new JFrame("WhoKilled");
        panel1.setContentPane(new Lobby().panel1);
        panel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.pack();
        panel1.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
