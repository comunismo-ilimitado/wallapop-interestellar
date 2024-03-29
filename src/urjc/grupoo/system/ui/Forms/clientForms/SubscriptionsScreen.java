package urjc.grupoo.system.ui.Forms.clientForms;

import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class SubscriptionsScreen extends javax.swing.JPanel {

    private final SystemSession session;
    private Client client;

    /**
     * Creates new form SubsciptionsScreen
     */
    public SubscriptionsScreen(SystemSession session, Client client) {
        this.session = session;
        this.client = client;
        initComponents();
        showSubscriptions();
    }

    public void showSubscriptions() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        stationsSubCheck = new javax.swing.JCheckBox();
        destructorSubCheck = new javax.swing.JCheckBox();
        cargoSubCheck = new javax.swing.JCheckBox();
        fighterSubCheck = new javax.swing.JCheckBox();
        saveSubcriptionsButtons = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Subscripciones");

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        stationsSubCheck.setText("Estaciones espaciales");

        destructorSubCheck.setText("Destructores");
        destructorSubCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destructorSubCheckActionPerformed(evt);
            }
        });

        cargoSubCheck.setText("Cargueros");

        fighterSubCheck.setText("Cazas");

        saveSubcriptionsButtons.setText("Guardar");
        saveSubcriptionsButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubcriptionsButtonsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stationsSubCheck)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fighterSubCheck)
                            .addComponent(cargoSubCheck)
                            .addComponent(destructorSubCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveSubcriptionsButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(stationsSubCheck)
                .addGap(18, 18, 18)
                .addComponent(destructorSubCheck)
                .addGap(18, 18, 18)
                .addComponent(cargoSubCheck)
                .addGap(18, 18, 18)
                .addComponent(fighterSubCheck)
                .addGap(18, 18, 18)
                .addComponent(saveSubcriptionsButtons)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        session.getController().goBack();
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void destructorSubCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destructorSubCheckActionPerformed

    }//GEN-LAST:event_destructorSubCheckActionPerformed

    private void saveSubcriptionsButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubcriptionsButtonsActionPerformed
        if (cargoSubCheck.isSelected()) {
            session.getClientFacade().suscribeClientTo(client.getIdNumber(), Spaceship.cargo);
        } else {
            session.getClientFacade().unsuscribeClientTo(client.getIdNumber(), Spaceship.cargo);
        }

        if (destructorSubCheck.isSelected()) {
            session.getClientFacade().suscribeClientTo(client.getIdNumber(), Spaceship.destructor);
        } else {
            session.getClientFacade().unsuscribeClientTo(client.getIdNumber(), Spaceship.destructor);
        }

        if (fighterSubCheck.isSelected()) {
            session.getClientFacade().suscribeClientTo(client.getIdNumber(), Spaceship.fighter);
        } else {
            session.getClientFacade().unsuscribeClientTo(client.getIdNumber(), Spaceship.fighter);
        }

        if (stationsSubCheck.isSelected()) {
            session.getClientFacade().suscribeClientTo(client.getIdNumber(), Spaceship.station);
        } else {
            session.getClientFacade().unsuscribeClientTo(client.getIdNumber(), Spaceship.station);
        }

    }//GEN-LAST:event_saveSubcriptionsButtonsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JCheckBox cargoSubCheck;
    private javax.swing.JCheckBox destructorSubCheck;
    private javax.swing.JCheckBox fighterSubCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton saveSubcriptionsButtons;
    private javax.swing.JCheckBox stationsSubCheck;
    // End of variables declaration//GEN-END:variables

}
