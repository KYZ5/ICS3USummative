/*
 * Stella Castura
 * 6/7/2022
 * InventoryGameGUI.java
 * The inventory form of my ICS3U summtive
 */

/**
 *
 * @author jumpi
 */
public class InventoryGUI extends javax.swing.JFrame {

    /**
     * Creates new form InventoryGUI
     */
    public InventoryGUI() {
        initComponents();
            //initialize/reset variables in accordance with what we already did in the main game
            boolean water = MainGameGUI.water;
            boolean map = MainGameGUI.map;
            boolean thirsty = MainGameGUI.thirsty;
            boolean food = MainGameGUI.food;
            boolean fork = MainGameGUI.fork;
            boolean rubbing = MainGameGUI.rubbing;
            
            //all of these if statments basically set the text blocks to the item you have if you have it 
            
            //water code
            //the only way you would have a waterskein lost is if you also lost your map
            //so I can check to see if you have an empty water bottle or no water bottle using the map variable.
            if (water)
            {
                txtWater.setText("Full waterskin");
            }
            else if (map)
            {
                txtWater.setText("Empty waterskin");
            }
            else
            {
                txtWater.setText("Item lost");
            }
            //map code
            if (map)
            {
                txtMap.setText("Map");
            }
            else
            {
                txtMap.setText("Item lost");
            }
            //food code
            if (food)
            {
                txtFood.setText("Food");
            }
            //fork code
            if (fork)
            {
                txtFork.setText("Strange objects found in the mesas");
            }
            //rubbing code
            if (rubbing)
            {
                txtRubbing.setText("A rubbing of a spell sigil");
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtGoggles = new javax.swing.JTextField();
        txtWater = new javax.swing.JTextField();
        txtMap = new javax.swing.JTextField();
        txtFood = new javax.swing.JTextField();
        txtFork = new javax.swing.JTextField();
        txtRubbing = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Inventory");

        txtGoggles.setText("Aviators's goggles");
        txtGoggles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGogglesActionPerformed(evt);
            }
        });

        txtWater.setText("Item not yet found");
        txtWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaterActionPerformed(evt);
            }
        });

        txtMap.setText("Item not yet found");
        txtMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMapActionPerformed(evt);
            }
        });

        txtFood.setText("Item not yet found");
        txtFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoodActionPerformed(evt);
            }
        });

        txtFork.setText("Item not yet found");
        txtFork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtForkActionPerformed(evt);
            }
        });

        txtRubbing.setText("Item not yet found");
        txtRubbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRubbingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtWater, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGoggles, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMap, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(txtFood)
                                .addComponent(txtFork)
                                .addComponent(txtRubbing))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblTitle)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGoggles, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWater, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFork, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRubbing, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGogglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGogglesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGogglesActionPerformed

    private void txtWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaterActionPerformed

    private void txtMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMapActionPerformed

    private void txtFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoodActionPerformed

    private void txtForkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtForkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtForkActionPerformed

    private void txtRubbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRubbingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRubbingActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
         
    }
    /*
    public void waterText(boolean water, boolean map)
    {
        if (water)
        {
          txtWater.setText("Full waterskein");  
        }
        else if (map)
        {
          txtWater.setText("Empty waterskein");
        }
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtFood;
    private javax.swing.JTextField txtFork;
    private javax.swing.JTextField txtGoggles;
    private javax.swing.JTextField txtMap;
    private javax.swing.JTextField txtRubbing;
    private javax.swing.JTextField txtWater;
    // End of variables declaration//GEN-END:variables
}
