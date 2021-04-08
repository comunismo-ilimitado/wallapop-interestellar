package urjc.grupoo.system.ui.Forms.clientForms;

import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class ClientMenu extends javax.swing.JPanel {
    
    private final SystemSession session;

    /** Creates new form ClientMenu */
    public ClientMenu(SystemSession session) {
        this.session = session;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clientProfile = new javax.swing.JButton();
        uploadShip = new javax.swing.JButton();
        searchShips = new javax.swing.JButton();
        notifications = new javax.swing.JButton();
        comments = new javax.swing.JButton();
        soldShips = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Menu Cliente");

        clientProfile.setText("Mi perfil");
        clientProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientProfileActionPerformed(evt);
            }
        });

        uploadShip.setText("Subir nave");

        searchShips.setText("Explorar ofertas");
        searchShips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchShipsActionPerformed(evt);
            }
        });

        notifications.setText("Notificaciones");
        notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationsActionPerformed(evt);
            }
        });

        comments.setText("Mis valoraciones");

        soldShips.setText("Naves vendidas");
        soldShips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldShipsActionPerformed(evt);
            }
        });

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uploadShip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchShips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notifications, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soldShips, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(256, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientProfile)
                        .addGap(18, 18, 18)
                        .addComponent(uploadShip)
                        .addGap(18, 18, 18)
                        .addComponent(searchShips))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(notifications)
                        .addGap(18, 18, 18)
                        .addComponent(comments)
                        .addGap(18, 18, 18)
                        .addComponent(soldShips)))
                .addContainerGap(304, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clientProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientProfileActionPerformed
        setVisible(false);
        session.getController().addLastPanel(this);
        session.getController().showClientProfile(session.getClient());

    }//GEN-LAST:event_clientProfileActionPerformed

    private void searchShipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchShipsActionPerformed

    }//GEN-LAST:event_searchShipsActionPerformed

    private void notificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notificationsActionPerformed

    private void soldShipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldShipsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soldShipsActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        session.getController().goBack();
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton clientProfile;
    private javax.swing.JButton comments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton notifications;
    private javax.swing.JButton searchShips;
    private javax.swing.JButton soldShips;
    private javax.swing.JButton uploadShip;
    // End of variables declaration//GEN-END:variables

}