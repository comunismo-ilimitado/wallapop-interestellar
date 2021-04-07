package urjc.grupoo.system.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import urjc.grupoo.system.ui.Forms.NewJPanel;

/**
 * Ventana en la que se mostrará al usuario el programa y se interactuará con este.
 */

public class ProgramWindow implements ActionListener {

    private JFrame f = new JFrame("Walapop Interestelar");
    private JPanel panel = new NewJPanel();
    private JLabel headerText = new JLabel();
    private JLabel mainText = new JLabel();
    private JTextField textField = new JTextField();
    private JButton button = new JButton("Ok");
    private String text;

    /**
     * El constructor pinta la ventana
     */
    public ProgramWindow(){
//        // Se establece el panel de fondo.
        panel.setBounds(0, 0, 700, 400);
//        panel.setBackground(new Color(50, 50, 50));
//
//        // Se crea la cabecera.
//        headerText.setForeground(Color.white);
//        mainText.setVerticalAlignment(JLabel.TOP);
//        headerText.setFont(headerText.getFont().deriveFont(20.0f));
//        headerText.setBounds(50,50, 700,30);
//
//        // Se crea el testo principal.
//        mainText.setForeground(Color.white);
//        mainText.setVerticalAlignment(JLabel.TOP);
//        mainText.setBounds(50,80, 700,300);
//
//        // Se crea el campo de texto.
//        textField.setForeground(Color.white);
//        textField.setCaretColor(Color.white);
//        textField.setBackground(new Color(50, 50, 50));
//        textField.setBounds(50, 300, 500, 30);
//
//        // Se crea el boton.
//        button.setForeground(Color.white);
//        button.setBackground(new Color(50, 50, 50));
//        button.setBounds(600, 300, 50, 30);
//        button.addActionListener(this);
//
//        // Se añade tdo al Jframe.
//        f.add(mainText);
//        f.add(headerText);
//        f.add(textField);
//        f.add(button);
        f.add(panel);

        

        // Se establecen los parametros de la ventana.

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

    // El semaforo espera a que se ejecute la accion del boton
    // No se si hay alguna forma mejor de hacer esto...
    private Semaphore semaphore = new Semaphore(0);

    /**
     * @return El texto escrito en la caja.
     */
    public String readText() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Cuando se pulsa el boton almacena el texto escrito.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            text = textField.getText();
            textField.setText("  ");
            semaphore.release();
        }
    }
}
