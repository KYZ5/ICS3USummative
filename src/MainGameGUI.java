
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Stella Castura
 * 6/7/2022
 * MainGameGUI.java
 * The main game form of my ICS3U summtive
 */

/**
 *
 * @author jumpi
 */

public class MainGameGUI extends javax.swing.JFrame {
    /**
     * Creates new form MainGameGUI
     */
    
    //Create needed variables
    int HP = 10;
    static boolean thirsty = false;
    static boolean hungry = false;
    static boolean tired = false;
    static boolean injured = false;
    static boolean shelter = false;
    
    
    //A method that updates the status effect bar
    private void updateEffect()
    {
        String x = "";
        if (hungry == true)
        {
            x += "Hungry ";
        }
        if (thirsty == true)
        {
            x += "Thirsty ";
        }
        if (tired == true)
        {
            x += "Tired ";
        }
        if (injured == true)
        {
            x += "Injured ";
        }
        lblStatusEffectsInfo.setText(x);
    }
    
    //Begins the story, gives the exposition and continues the plot. 
    private void begin()
    {
        btnChoice1.setText("---");
        btnChoice2.setText("---");
        lblHPNum.setText("" + HP);
        //main Text
        //THIS DOES NOT WORK FOR SOME GODFORSAKEN REASON, 
        //I'm leaving it for now because it might be my computer
        //But fix this at home
        txtMain.setText("You fly over the badlands in your small craft, carrying cargo to another city. "
                + "The sigils on the canvas wings, that do most of the job of keeping the plane in the air, glow a barely percivalble blue under the bright red sun. "
                + "A parchment map, one enchanted to track your location, has been pinned to the inside of the cockpit, and a compass installed into the dashboard shows the direction you need to travel. "
                + "You fly for several hours in relative peace. The badlands between the cities aren't very eventful, as least from this high up. "
                + "Of course, very few people have even been on ground level for as long as anyone can remember, and even fewer have returned. "
                + "Cities are held high in the sky by mesas and buttes that reach several kilometers up. "
                + "Hundreds of similar but smaller formations cover the badlands, most of them in small clusters. "
                + "Off to the distance, you see a black smear creeping across the horizon. "
                + "For a split second, you hope that it might be a normal thunderstorm, one that you can fly through. "
                + "Those hopes are soon dashed when you see a flash of green light, and hear the telltale high wistling noise magical sotrms always give off. "
                + "The storm is heading straight for you, and there doesn't seem to be a way to advoid it. "
                + "It's speeding up with every second, whipping up the red sands below into a swirling sea. "
                + "Getting caught in a magical storm is a certain death sentance. They make magical devices, like the ones currently keeping you in the air, fail. "
                + "You have no choice to land. "
                + "You tilt the nose of the plane forwards and pull into a steep dive. "
                + "As you descend rapidly, the storm moves closer and closer. Yor navigational instruments begin to flicker, and you can see the compass needle swinging wildly. "
                + "You eventually manage to land, in the middle of a cluster of jagged rocks you couldn't see from above. "
                + "One of the canvas wings on you plane tears, and you land, tangled up in a pile of broken wood and canvas wings. "
                + "You're badly bruised and you have a shallow cut on your arm, but aside from that, you are unhurt. "
                + "Your plane, however, is definitly not airworthy. "
                + "One of the wings has torn, and the sigil that keeps the planbe in the air is broken. "
                + "The magical storm still rages on around you, and you can barely see through the haze of terracotta sand. "
                + "You know that you have a helf-empty water bottle you were keeping in the cockpit, as well as the map and navigational equipment you grab on your way out of the plane. "
                + "\n"
                + "Do you:");
        //give options
        btnChoice1.setText("Look for shelter, who knows how dangerous this storm will get");
        btnChoice2.setText("Look for food and water, I'll need it if I want to get out of here safely");
        
    }
    
   public void food()
   {
       btnChoice1.setText("---");
       btnChoice2.setText("---");
       txtMain.setText("Using your hand to shield your face from the sand, you begin to head downhill. "
               + "You figure that if anything is going to be alive in the badlands, it will be near a creekbed, and creeks flow downhill. "
               + "Out of sheer luck, you happen upon a dried up creekbed, and after following it for what seems like hours, it becomes muddy, then full of water. "
               + "You fill up your waterskein, and as you do, you notice some small fish. "
               + "It takes some doing, but you evenutally manage to catch some in your water bottle to eat later. "
               + "By now, the storm has blown over, and the sun has begun to set. "
               + "\n"
               + "Do you:");
       //Present choices
       btnChoice1.setText("Press on and look for shelter through the night?");
       btnChoice2.setText("Sleep where you are?");
   }
   
   public void shelter()
   {
       btnChoice1.setText("---");
       btnChoice2.setText("---");       
       //Up to the next comment deals with conditional dialogue.
       //The only way someone seeing this could possibly be tired is if they went to get food and came back
       //Since they are doing the same thing at different times, string x stores description text that chagnes based on what they do
       //x is incorporated into the main text later
       if (shelter==false)
       {
          begin(); 
       }
       String x = "";
       if (tired)
       {
           x += "Night has already fallen, and you are struggling to keep yourself awake after several hours spent looking for food and water. "
                   + "Off to the distance, you hear short yapping noises from some kinf of wild animal. "
                   + "Your're not sure what can survive here, but you defninitly don't want to meet it. ";
       }
       else
       {
       x += "The swirling sands whip at your face as you press on. Your map still not showing your location due to the magical storm, you travel based on your memory. ";
       }
       //main text
       txtMain.setText("You press forwards." + x
               +"You aim for a group of low mesas, who seemed to have shadows on the side that might have been caves when you flew over. "
               + "Eventually, you find them. "
               + "On the side of one is a cave, and as you enter, you notice that it goes far deeper than you previously thought, presumalby connecting to a cave system. "
               + "Towards the back of the cave, you see a broken window, set into the cave wall."
               + "The cave, as well, seems far to geometrical to be natural."
               + "The walls are stright, and, though extremly erroded are obviously manmade."
               + "Do you:");
       //choices
       btnChoice1.setText("Explore deeper");
       btnChoice2.setText("Stay in the room you are in");
   }
    public void sleep()
    {
        btnChoice1.setText("---");
        btnChoice2.setText("---");
        txtMain.setText("You figure it's best not to travel in the badlands at night. "
                + "You curl up near the creek, and try to go to bed. "
                + "Eventually, you manage to drift off. "
                + "You awake to the sound of snuffling around where you are sleeping. "
                + "");
        btnChoice1.setText("Run");
        btnChoice2.setText("Fight");
    }
    public MainGameGUI() {
    initComponents();
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMain = new javax.swing.JTextArea();
        btnChoice1 = new javax.swing.JButton();
        btnChoice2 = new javax.swing.JButton();
        btnChoice3 = new javax.swing.JButton();
        btnChoice4 = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnMap = new javax.swing.JButton();
        lblHPText = new javax.swing.JLabel();
        lblHPNum = new javax.swing.JLabel();
        lblStatusEffectsText = new javax.swing.JLabel();
        lblStatusEffectsInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        txtMain.setColumns(20);
        txtMain.setLineWrap(true);
        txtMain.setRows(5);
        txtMain.setText("The main text of the game will appear here. Click on the buttons below to make choices or view\n your inventory or map.");
        jScrollPane1.setViewportView(txtMain);

        btnChoice1.setText("Continue");
        btnChoice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoice1ActionPerformed(evt);
            }
        });

        btnChoice2.setText("---");
        btnChoice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoice2ActionPerformed(evt);
            }
        });

        btnChoice3.setText("----");
        btnChoice3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoice3ActionPerformed(evt);
            }
        });

        btnChoice4.setText("----");
        btnChoice4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoice4ActionPerformed(evt);
            }
        });

        btnInventory.setText("View Inventory");
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        btnMap.setText("View Map");
        btnMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapActionPerformed(evt);
            }
        });

        lblHPText.setForeground(new java.awt.Color(255, 255, 255));
        lblHPText.setText("HP: ");

        lblHPNum.setForeground(new java.awt.Color(255, 255, 255));
        lblHPNum.setText("----");

        lblStatusEffectsText.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusEffectsText.setText("Status Effects:");

        lblStatusEffectsInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusEffectsInfo.setText("None");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblHPText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHPNum)
                        .addGap(282, 282, 282)
                        .addComponent(lblStatusEffectsText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatusEffectsInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMap, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                            .addComponent(btnChoice3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChoice2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChoice1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(btnChoice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHPText)
                    .addComponent(lblHPNum)
                    .addComponent(lblStatusEffectsText)
                    .addComponent(lblStatusEffectsInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMap, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnChoice2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice2ActionPerformed
       //This is button 2 
       //The begin method sets the text to this. leads to the food() method
        if ((btnChoice2.getText()).equals("Look for food and water, I'll need it if I want to get out of here safely"))
        {
            food();
        }
        //The food mothod sets the code to this. Leads to getting attacked
        else if ((btnChoice2.getText()).equals("Sleep where you are?"))
        {
            sleep();
        }
    }//GEN-LAST:event_btnChoice2ActionPerformed

    private void btnChoice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice1ActionPerformed
        //On the start screen, button 1 says continue. This leads to starting the story. (the begin method)
        if ((btnChoice1.getText()).equals("Continue"))
        {
            begin();
        }
        //The begin method sets the text to this. leads to the shelter() method
        else if ((btnChoice1.getText()).equals("Look for shelter, who knows how dangerous this storm will get"))
        {
            shelter();
        }
        //The food mothod sets the code to this. Leads to the shelter method
        else if ((btnChoice1.getText()).equals("Press on and look for shelter through the night?"))
        {
            shelter();
            //you waled through the night so you are tired
            tired = true;
            updateEffect();
        }
    }//GEN-LAST:event_btnChoice1ActionPerformed

    private void btnChoice3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice3ActionPerformed
       //This is button 3
       
    }//GEN-LAST:event_btnChoice3ActionPerformed

    private void btnChoice4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice4ActionPerformed
        //This is button 4
        
    }//GEN-LAST:event_btnChoice4ActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        new InventoryGUI().setVisible(true);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapActionPerformed
        new MapGUI().setVisible(true);
    }//GEN-LAST:event_btnMapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGameGUI().setVisible(true);
            }
        });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoice1;
    private javax.swing.JButton btnChoice2;
    private javax.swing.JButton btnChoice3;
    private javax.swing.JButton btnChoice4;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnMap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHPNum;
    private javax.swing.JLabel lblHPText;
    private javax.swing.JLabel lblStatusEffectsInfo;
    private javax.swing.JLabel lblStatusEffectsText;
    private javax.swing.JTextArea txtMain;
    // End of variables declaration//GEN-END:variables
}
