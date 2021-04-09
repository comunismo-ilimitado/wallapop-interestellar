
package urjc.grupoo.system.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import urjc.grupoo.system.ui.Forms.StartMenu;

public class WindowController {

    private final SystemSession session;
    private final JFrame window;
    private final Stack<JPanel> panels = new Stack<>();
    private final Stack<Integer> checkpoints =  new Stack<>();
    
    public static final String WINDOW_NAME = "Wallapop Interestelar";
    
    public WindowController(SystemSession session) {
        
        this.session = session;
        
        window = new JFrame(WINDOW_NAME);
        
        JPanel startingPanel = new StartMenu(this.session);
        
        try {
            Image background = ImageIO.read(getClass().getResourceAsStream("/sky.png"));
            window.setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(background, 0, 0, null);
                }
            });
            window.pack();
        } catch (IOException ex) {
            Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Se establecen los parametros de la ventana.
        window.setSize(700, 400);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panels.add(startingPanel);
        internalShowPanel(startingPanel);
        
        checkpoints.add(panels.size());

    }
    
    private void internalShowPanel(JPanel panel){
        window.add(panel);
        panel.setBounds(0, 0, window.getSize().width, window.getSize().height);
        panel.setVisible(true);
        window.update(window.getGraphics());
    }
    
    public void addNewPanel(JPanel panel){
        panels.peek().setVisible(false);
        window.remove(panels.peek());
        panels.add(panel);
        internalShowPanel(panel);
    }
    
    public void goBack(){
        if(panels.size() > 1){
            window.remove(panels.pop());
            internalShowPanel(panels.peek());
            updateCheckPoints();
        }
    }
    
    private void updateCheckPoints(){
        while(checkpoints.peek() > panels.size()){
            checkpoints.pop();
        }
    }
    
    public void checkPoint(){
        checkpoints.add(panels.size());
    }
    
    public void goBackToCheckPoint(){
        if(panels.size() > 1){
            if(panels.size() > checkpoints.peek()){
                window.remove(panels.pop());
            }
            while(panels.size() > checkpoints.peek()){
                panels.pop();
            }
            internalShowPanel(panels.peek());
            updateCheckPoints();
        }
    }
    
}
