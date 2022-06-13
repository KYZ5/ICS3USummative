
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
    static int HP = 10;
    static boolean thirsty = false;
    static boolean hungry = false;
    static boolean tired = false;
    static boolean injured = false;
    static boolean map = true;
    static boolean food = false;
    static boolean water = true;
    static int days = 0;
    static int daysNoWater = 0;
    
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
    //a method that updates HP
    private void updateHP()
    {
        lblHPNum.setText("" + HP);
    }
    //a method that deals with daily things, like using food and updating status effects
    private void count()
    {
        HP = Integer.parseInt(lblHPNum.getText());
        if (food)
        {
            food = false;
        }
        else
        {
        hungry = true;
        }
        if (water)
        {
        water = false;
        }
        else
        {
        thirsty = true;
        daysNoWater++;
        if (injured)
        {
            HP -= 2;
        }
        updateEffect();
        updateHP();
        }
    }
    //Begins the story, gives the exposition and continues the plot. 
    private void begin()
    {
        //resets hp and status effects if the user is replaying
        HP = 10;
        thirsty = false;
        hungry = false;
        tired = false;
        injured = false;
        map = true;
        updateHP();
        updateEffect();
        //main Text
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
   //if the user decides to look for food in the storm 
   public void food()
   {
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
   //if the user decides to look for shelter
   public void shelter()
   {     
       //Up to the next comment deals with conditional dialogue.
       //The only way someone seeing this could possibly be tired is if they went to get food and came back
       //Since they are doing the same thing at different times, string x stores description text that chagnes based on what they do
       //x is incorporated into the main text later
       String x = "";
       if (tired)
       {
           x += "Night has already fallen, and you are struggling to keep yourself awake after several hours spent looking for food and water. "
                   + "Off to the distance, you hear short yapping noises from some kinf of wild animal. "
                   + "Your're not sure what can survive here, but you defninitly don't want to meet it. ";
       }
       else if (!map)
       {
           x += "You're exhausted from running all night, but you manage to keep going. ";
       }
       else
       {
       x += "The swirling sands whip at your face as you press on. Your map still not showing your location due to the magical storm, you travel based on your memory. ";
       }
       //main text
       txtMain.setText("You press forwards." + x
               +"You aim for a group of low mesas, who seemed to have shadows on the side that might have been caves when you flew over. "
               + "Eventually, you reach the mesas. "
               + "On the side of one is a cave, and as you enter, you notice that it goes far deeper than you previously thought, presumalby connecting to a cave system. "
               + "Towards the back of the cave, you see a broken window, set into the cave wall."
               + "The cave, as well, seems far to geometrical to be natural."
               + "The walls are stright, and, though extremly erroded are obviously manmade."
               + "Do you:");
       //choices
       btnChoice1.setText("Explore deeper");
       btnChoice2.setText("Stay in the room you are in");
   }
   //if the user decides to sleep at the stream
    public void sleep()
    {
        //main text
        txtMain.setText("You figure it's best not to travel in the badlands at night. "
                + "You curl up near the creek, and try to go to bed. "
                + "Eventually, you manage to drift off. "
                + "You awake to the sound of snuffling around where you are sleeping. "
                + "You tentativly open one eye, and you see a small horse-like creature nosing at your map. "
                + "It's no bigger than a dog, and you cound swear it has feathers instead of fur. "
                + "You watch it for at bit, unsure of what to do. "
                + "Eventually, it looks you stright in the eye, and it opens it's mouth to reaveal rows of sharp teeth, most of them longer than your hand. "
                + "It hisses at you, and you have no choice but to...");
        //label buttons
        btnChoice1.setText("Run");
        btnChoice2.setText("Fight");
    }
    //if the user runs from the monster at the stream
    public void run()
    {
        //main text
        txtMain.setText("You get up and run as fast as you can, leaving your map and water bottle behind. "
                + "You can hear the monster behind you, running across the badlands. "
                + "Eventually, you have to stop running to catch your breath, and you realize you are lost. "
                + "You can't seem to remember what direction you came from. "
                + "You walk: ");
        //you lost your map
        map = false;
        food = false;
        water = false;
        //label butons
        btnChoice1.setText("Left");
        btnChoice2.setText("Right");
        btnChoice3.setText("Forwards");
        btnChoice4.setText("Backwards");
    }
    //if the user fights the monster at the stream
    public void fight()
    {
        txtMain.setText("Without anything better to do, you punch the monster in the eye. "
                + "It reels back, and you think for a second it's going to run away. "
                + "Then it lunges forwards, and manages to sink on of it's teeth into your arm. "
                + "You reel back in pain, and the monster goes in to bite your side. "
                + "You manage to roll out of the way in time, and grab one of it's legs as you go. "
                + "It falls over and you take advantage of the monster's momentary confusion to kick it in the stomach. "
                + "It curls up on itself, and you manage to stomp on its neck hard enough that it goes limp after a few seconds. "
                + "You curl up next to the stream and go back to sleep."
                + "You wake up to the birght light of the sunrise shinging in your eyes. "
                + "You take a look at your map, and start to figure out the quickest way to get to a city. ");
        //You got bit, so you are injured and lose HP
        HP -= 3;
        injured = true;
        updateHP();
        updateEffect();
        //button choices
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        System.out.println(HP);
    }
    
    //if the user runs left
    public void left()
    {
        txtMain.setText("You make it back to the stream, and find your map and supplies piled up where you left them. "
                + "You take a look at your map and try to figure out where you are, and plot your route to the nearest city. ");
        map = true;
        food = true;
        water = true;
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    //if the user runs right
    public void lost()
    {
        txtMain.setText("You are lost and eventually die of thirst without supplies or a map. Game over.");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    //if the user goes deeper into the caverns
    public void deeper()
    {
        txtMain.setText("It's super old, you find barely anything of use. "
                + "All of it's like the inside of a castle/keep, there are cracked glass windows that look into other rooms. "
                + "You do find some really old worn out things, like cutlery, made of a material that you have no idea what it is. "
                + "You also go deep underground and find an underground lake, and get some water. ");
        thirsty = false;
        water = true;
        updateEffect();
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    //if the user doesn't explore the caves and is boring
    public void stay()
    {
        txtMain.setText("You sleep in the room, and nothing disturbs you until morning, when you are woken by sunlight streaming into the cave enterance. "
                + "");
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    //the first day of walking
    public void walk()
    {
        txtMain.setText("You wander for a day and head towards a city. "
                + "Towards the end of the day, you see a plane flying on the horizon, and you think it might be a search party. ");
        //this won't work as a method so it's here for now. 
        if (injured)
        {
            HP -= 2;
        }
        updateHP();
        //a day passes
        count();
        btnChoice1.setText("Keep following your map");
        btnChoice2.setText("Follow the plane");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        System.out.println(HP);
    }
    public void plane()
    {
        txtMain.setText("You chase after the plane, and you soon lose sight of it. "
                + "It takes you quite a while to figure out where you are, and you lose a day trying to get back on track. "
                + "You can't find any shelter, and you have to sleep out in the open that night. ");
        count();
        btnChoice1.setText("Keep following your map");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void map()
    {
        txtMain.setText("You follow your map, spending a fairly uneventful day pushing forwards into the badlands. "
                + "Towards the end of the day, you see a small creature hop behind a rock. Do you:");
        count();
        btnChoice1.setText("Leave it be");
        btnChoice2.setText("Try to catch it for food");
        btnChoice3.setText("Follow it to see if it will lead you to water");
        btnChoice4.setText("---");
    }
    public void keepWalking()
    {
        txtMain.setText("You keep walking and you see the spire of the nearest city off to the distance. "
                + "you can also see a small cluster of mesas off to the side. "
                + "They would probably take you about an hour out of your way to get to. "
                + "Do you:");
        btnChoice1.setText("Use them as shelter for the night");
        btnChoice2.setText("Sleep where you are, they're too far away.");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void hunt()
    {
        txtMain.setText("You grab a rock, and sneak up behind the creature. "
                + "You try to pound the rock into the creature's head, and are met with far more resistance than you were expecting. "
                + "The scales seem to be made of metal or stone, and can't be broken. "
                + "You grab it by the tail, and flip it over. Its long claws scrach at your hand, marking them badly. "
                + "You eventually manage to flip it over, and it's softer underbelly is far easier to break though to. "
                + "You eventually cut though, an get the first bits of food you've had in a long time. ");
        hungry = false;
        HP--;
        updateHP();
        updateEffect();
        btnChoice1.setText("Keep walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void follow()
    {
        txtMain.setText("You circle around to get a better look at the creature. "
                + "It's covered in scales like a pangolin, but has far more legs. "
                + "After several hours of following it and trying not to spook it, it leads you to a stream. "
                + "You stop to fill up your waterskein, and take a drink. "
                + "Once you have done this, do you: ");
        thirsty = false;
        water = true;
        updateEffect();
        btnChoice1.setText("Leave it be");
        btnChoice2.setText("Try to catch it for food");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void mesas()
    {
        txtMain.setText("You head towards the mesas. "
                + "The inside of the caves inside the mesas are sandstone, similar to the outside, but the walls are carved, with writing in a language you don't recognise engraved on the stone. "
                + "Once or twice, you try to enter a cavern, only to be pushed back by some magical force. "
                + "You find their source in a sigil carved into the wall. "
                + "You're no wizard, so you take the best rubbing you can, by scratching the image of the sigil into the back of your map with a rock. "
                + "You spend an uneventful night in the cavern, and wake up the next day to keep walking. ");
        btnChoice1.setText("Head towards the city");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void outside()
    {
        txtMain.setText("You go to sleep in the middle of the badlands, and get up early the next day, woken yet again by the sun.");
        btnChoice1.setText("Head towards the city");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void city()
    {
        count();
        txtMain.setText("You get to the base of the spire, and are now faced with a problem that hadn't occured to you before. "
                + "The spires rarely have access to the badlands by land. "
                + "The spire is made up of sandstone, and is far to tall to be able to talk to people at the top. "
                + "How do you try to get to the top?");
        btnChoice1.setText("Climb the spire.");
        btnChoice2.setText("Look for a door");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void climb()
    {
        txtMain.setText("You fall and die. It's like 5km of smooth cliff, what did you expect."
                + "Game Over");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void door()
    {
        txtMain.setText("You walk for several hours and find a door that leads to a staircase that heads up. You go up."
                + "You make it back to the city. wow. would you look at that. "
                + "You eventually return to being a pilot. ");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    /*
    //a default method to copy
    public void []()
    {
        txtMain.setText("");
        btnChoice1.setText("---");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    */
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
        switch (btnChoice2.getText()) {
        //The food mothod sets the code to this. Leads to getting attacked
            case "Look for food and water, I'll need it if I want to get out of here safely":
                food();
                break;
            //the food method sets the button to this
            case "Sleep where you are?":
                sleep();
                break;
            //the sleep methid sets the button to this
            case "Fight":
                fight();
                break;
            //the run method sets the button to this
            case "Right":
                lost();
                break;
            //the shelter method sets the button to this
            case "Stay in the room you are in":
                stay();
                break;
            case "Follow the plane":
                plane();
                break;
            case "Try to catch it for food":
                hunt();
                break;
            case "Sleep where you are, they're too far away.":
                outside();
                break;
            case "Look for a door":
                door();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnChoice2ActionPerformed

    private void btnChoice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice1ActionPerformed
        //On the start screen, button 1 says continue. This leads to starting the story. (the begin method)
        switch (btnChoice1.getText()) {
            //The begin method sets the text to this. leads to the shelter() method
            case "Continue":
                begin();
                break;
            //The food mothod sets the code to this. Leads to the shelter method
            case "Look for shelter, who knows how dangerous this storm will get":
                shelter();
                break;
            //the food method sets the text to this
            case "Press on and look for shelter through the night?":
                shelter();
                //you waled through the night so you are tired
                tired = true;
                updateEffect();
                break;
            //the sleep method sets the text to this
            case "Run":
               run();
               break; 
            //the run method sets the button to this
            case "Left":
                left();
                break;
            //the shelter method sets the code to this
            case "Explore deeper":
                deeper();
                break;
            // all deaths set the button to this
            case "Play again?":
                begin();
                break;
            //several methods set the text to this, it all leads to the first day of walking. 
            case "Start walking":
                if (map)
                {
                walk();
                }
                else
                {
                lost();
                }
                break;
            //the walk method sets the code to this    
            case "Keep following your map":
                map();
                break;
            case "Keep walking":
                //fall through
            case "Leave it be":
                keepWalking();
                break;
            case "Use them as shelter for the night":
                mesas();
                break;
            case "Head towards the city":
                city();
                break;
            case "Climb the spire.":
                climb();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnChoice1ActionPerformed

    private void btnChoice3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice3ActionPerformed
       //This is button 3
       //the run method sets the button to this
       if ((btnChoice3.getText().equals("Forwards")))
       {
            lost();
       }
       else if ((btnChoice3.getText().equals("Follow it to see if it will lead you to water")))
       {
            follow();
       }
       
    }//GEN-LAST:event_btnChoice3ActionPerformed

    private void btnChoice4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoice4ActionPerformed
        //This is button 4
        //the run method sets the button to this
        if ((btnChoice4.getText().equals("Backwards")))
       {
           shelter();
       }
    }//GEN-LAST:event_btnChoice4ActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        new InventoryGUI().setVisible(true);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapActionPerformed
        if (map == true)
        {
        new MapGUI().setVisible(true);
        }
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
