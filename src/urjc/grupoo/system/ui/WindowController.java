
package urjc.grupoo.system.ui;

import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import urjc.grupoo.system.ui.Forms.StartMenu;



public class WindowController {

    private final SystemSession session;
    private final JFrame window;
    private final Stack<JPanel> panels = new Stack<>();
    
    public static final String WINDOW_NAME = "Wallapop Interestelar";
    
    public WindowController(SystemSession session) {
        
        this.session = session;
        
        window = new JFrame(WINDOW_NAME);
        
        JPanel startingPanel = new StartMenu(this.session);
        
        // Se establecen los parametros de la ventana.
        window.setSize(700, 400);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panels.add(startingPanel);
        internalShowPanel(startingPanel);

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
        }
    }
    
    
    
}
