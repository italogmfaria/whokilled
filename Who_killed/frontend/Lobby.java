/*
echo "# whokilled" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/italogmfaria/whokilled.git
git push -u origin main
 */

package Who_killed.frontend;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class Lobby {
    private JPanel panel1;
    private JLabel label1;
    private JButton playButton;

    public Lobby() {
        panel1.addComponentListener(new ComponentAdapter() {
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
