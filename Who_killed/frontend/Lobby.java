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

import Who_killed.Investigacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;

public class Lobby {
    private JPanel panel1;
    private JLabel label1;
    public JButton start;

    public Lobby() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Button clicked");
            }
        });
    }
    public static void main(String[] args) {
        JFrame panel1 = new JFrame("MyForm");
        panel1.setContentPane(new Lobby().panel1);
        panel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.pack();
        panel1.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
