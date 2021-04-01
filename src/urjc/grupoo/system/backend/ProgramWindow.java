package urjc.grupoo.system.backend;

import java.awt.*;
import javax.swing.*;

/**
 * Ventana en la que se mostrará al usuario el programa y se interactuará con este.
 */

public class ProgramWindow {

    private JLabel headerText = new JLabel();
    private JLabel mainText = new JLabel();

    public ProgramWindow() {
        JFrame f = new JFrame("Walapop Interestelar");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 700, 400);
        panel.setBackground(new Color(50, 50, 50));

        headerText.setForeground(Color.white);
        headerText.setBounds(50,50, 700,30);

        mainText.setForeground(Color.white);
        mainText.setBounds(50,100, 700,30);

        f.add(mainText);
        f.add(headerText);
        f.add(panel);
        f.setSize(700, 400);

        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setMainText(String text) {
        mainText.setText(text);
    }

    public void setHeaderText(String text) {
        headerText.setText(text);
    }
}
