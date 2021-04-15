package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.shipsForms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import urjc.grupoo.data.shipsData.ShipFactory;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.complementForms.DefenceCreationScreen;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.crationHandlers.OfferCreationHandler;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.crationHandlers.ShipCreationHandler;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.ShipCreationScreen;
import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class StationCreationScreen extends javax.swing.JPanel {

    private final SystemSession session;
    private final ShipCreationHandler handler;
    private final OfferCreationHandler offerhandler;

    /**
     * Creates new form StationCreationScreen
     *
     * @param session
     * @param handler
     * @param offerhandler
     */
    public StationCreationScreen(SystemSession session, ShipCreationHandler handler, OfferCreationHandler offerhandler) {
        this.session = session;
        this.handler = handler;
        this.offerhandler = offerhandler;
        initComponents();
    }
    
    

    /**
     *
     * @return TRUE if all parameters are of the correct type.
     */
    private boolean checkParameters() {
        if (handler.getDefenceList().isEmpty()) {
            incorrectLabel.setText("Introduzca al menos un sistema de defensa.");
            return false;
        }
        incorrectLabel.setText("");
        return true;
    }
    
    private void addDefences() {
        JPanel defencesList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        defencesPanel.setViewportView(defencesList);

        handler.getDefenceList().forEach((defence) -> {
            addEntry(defence.getDefenceType(), defencesList);
        });
    }
    
    private void addEntry(String text, JPanel displayList) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayList.add(panel, gbc, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doneButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        pasangerAmountField = new javax.swing.JTextField();
        registerLabel2 = new javax.swing.JLabel();
        addShipButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addDefenceButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        incorrectLabel = new javax.swing.JLabel();
        defencesPanel = new javax.swing.JScrollPane();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        doneButton.setText("Siguiente");
        doneButton.setToolTipText("");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nameLabel.setText("Estación espacial");

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        registerLabel2.setText("Número máximo de pasajeros:");

        addShipButton.setText("Añadir nave");
        addShipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addShipButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Naves en su interior:");

        addDefenceButton.setText("Añadir sistema de defensa");
        addDefenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDefenceButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Sistemas de defensa:");

        incorrectLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(registerLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pasangerAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(262, 262, 262)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(addDefenceButton)
                                    .addGap(116, 116, 116)
                                    .addComponent(addShipButton))
                                .addComponent(defencesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(72, 72, 72)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(incorrectLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doneButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerLabel2)
                            .addComponent(pasangerAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defencesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addShipButton)
                    .addComponent(addDefenceButton))
                .addGap(62, 62, 62)
                .addComponent(incorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneButton)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        if (checkParameters()) {
            handler.removeStationCounter();
            handler.setPassangerNumber(Integer.parseInt(pasangerAmountField.getText()));
            Spaceship newShip = new ShipFactory().CreateSpaceship(
                    handler.getType(), handler.getCrewNumber(), handler.getPropulsion1(), handler.getSpeed(),
                    handler.getPropulsion2(), handler.getSpeed(), handler.getRegNumber(),
                    handler.getPassangerNumber(), handler.getDefenceList(), handler.getShipList());
            if (handler.getStationCounter() == 0) {
                offerhandler.addShipToOffer(newShip);
                System.out.println("Naves dentro: " + newShip.getSpaceshipList().size());
            } else {
                handler.addShip(newShip);
                System.out.println("Naves en el handler: " + handler.getShipList().size());
            }
            session.getController().goBack();
            session.getController().goBackToCheckPoint();
        }
    }//GEN-LAST:event_doneButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        session.getController().goBack();
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addShipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addShipButtonActionPerformed
        session.getController().checkPoint();
        session.getController().addNewPanel(new ShipCreationScreen(
                session, new ShipCreationHandler(), offerhandler));
    }//GEN-LAST:event_addShipButtonActionPerformed

    private void addDefenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDefenceButtonActionPerformed
        if (handler.getDefenceList().size() < 3) {
            session.getController().addNewPanel(new DefenceCreationScreen(session, handler));
            incorrectLabel.setText("");
        } else {
            incorrectLabel.setText("Las estaciones espaciales solo pueden 3 sistemas de defensa.");
        }
    }//GEN-LAST:event_addDefenceButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        addDefences();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDefenceButton;
    private javax.swing.JButton addShipButton;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane defencesPanel;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel incorrectLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pasangerAmountField;
    private javax.swing.JLabel registerLabel2;
    // End of variables declaration//GEN-END:variables

}