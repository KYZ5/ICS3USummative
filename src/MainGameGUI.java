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
    /*
    ****Read before reading code******
    -Most of the methods are essentially the same. Those that don't are more thouroughly documented.
      They follow the general format of:
        1. Set the main text field to the text that describes the story
        2. Alter variables based on the story. This also alters status effects.
        3. Set the button text to the next options
        4. Change the location
        5. Check if the person is dead
    -There are too many ways to die at assorted points in the story, so running the checkIfDead method after every method ensures that dead people die. 
    -I'm not going to go into a lot of detail about what exactly happens in each method because the txtMain.setText functions do that really well already.
    -When each button is clicked, it runs through all possible options the text on that button can be set to. Each method has unique text that it sets the buttons to.
        Whatever you do, do not alter the text on the button outputs without also chainging the code that checks what the button says.
        That will "lock off" the option and will break the game.
    */
    //Create needed variables
    //they are all static so they can all be changed by the methods and keep those changes. 
    //Tracks HP
    static int HP = 10;
    //Tracks assorted status effects
    //only thirsty and injured can acutally kill you
    //tired and hungry are just meant to stress out the user
    //They do nothing but I think it makes the game more stressful so they're staying
    static boolean thirsty = false;
    static boolean hungry = false;
    static boolean tired = false;
    static boolean injured = false;
    //Tracks useful items you can collect
    static boolean map = true;
    static boolean food = false;
    static boolean water = true;
    //these track completly useless collectables that I put in for fun
    //fork is never fully described, only as a strange tool, so if you see a reference to that, it's the fork.
    //You also have several of them, but one extra letter is too much to type
    static boolean fork = false;
    static boolean rubbing = false;
    //This tracks the days you have spent out in the badlands. It has no purpose, but if I wanted to expand the game more it could be very useful so I'm keeping it
    static int days = 0;
    //If you go three days without water, you die. This is the variable that tells the computer that you are dead.
    static int daysNoWater = 0;
    //This is used in the map, to say where you are. 
    static String location = "The crashed plane";
    //A method that updates the status effect bar.
    //It just takes every single status effect, sees if you have it, and adds all the ones you have to a string called x.
    //The status effect text block is then set to x.
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
    //This doesn't update the value, it just takes the number that is stored for calcualtions and spits it out onto the screen.
    private void updateHP()
    {
        lblHPNum.setText("" + HP);
    }
    //a method that deals with daily things, like using food and updating status effects
    private void count()
    {
        //Gets the HP, you'll need it later
        HP = Integer.parseInt(lblHPNum.getText());
        //If you have food, you eat it.
        //If you don't have food, you are hungry.
        if (food)
        {
            food = false;
        }
        else
        {
        hungry = true;
        }
        //if you have water, you drink it
        //if you don't, you are thirsty and have spend another day without water
        if (water)
        {
        water = false;
        }
        else
        {
        thirsty = true;
        //It's very important to run the check if dead method after this one, because this counter needs to increase to kill you and we can't have people living without water, can we. 
        daysNoWater++;
        //If you have a gaping wound on your arm, you lose 2 hit points.
        if (injured)
        {
            HP -= 2;
        }
        //status effects and hit points may have changed, so you need to update and run them.
        updateEffect();
        updateHP();
        }
    }
    //A method that checks if you are dead and runs the relevant methods
    public void checkIfDead()
    {
        //There are two kinds of dead that might happen not as the direct result of a button click.
        //If you go three (or somehow more) days without water, you die. 
        if (daysNoWater >= 3)
        {
            //This is an ending method
            deathFromDehydration();
        }
        //If your HP are 0 or less, you die.
        if (HP <= 0)
        {
            //This is an ending method
            deathFromInjury();
        }
    }
    //Begins the story, gives the exposition and continues the plot. 
    private void begin()
    {
        //resets hp and status effects if the user is replaying
        //This resets all variables to their original state
        HP = 10;
        thirsty = false;
        hungry = false;
        tired = false;
        injured = false;
        map = true;
        food = false;
        water = true;
        days = 0;
        daysNoWater = 0;
        fork = false;
        rubbing = false;
        location = "The crashed plane";
        //If the user is replaying, I need to reset labels.
        //The user cannot click this while another window is open, and those auto-reset when opened, so only these things need to be changed
        updateHP();
        updateEffect();
        //main Text
        txtMain.setText("You fly over the badlands in your small craft, carrying cargo to another city. "
                + "The sigils on the canvas wings, which do most of the job of keeping the plane in the air, glow a\nbarely perceivable blue under the bright red sun. "
                + "A parchment map, one enchanted to track your location, has been pinned to the inside of the cockpit, and a compass\ninstalled into the dashboard shows the direction you need to travel. "
                + "You fly for several hours in relative peace. The badlands between the cities aren't very eventful, at\nleast from this high up. "
                + "Of course, very few people have even been on ground level for as long as anyone can remember, and even fewer have returned. "
                + "Cities are held\nhigh in the sky by mesas and buttes that reach several kilometres into the sky. "
                + "Hundreds of similar but smaller formations cover the badlands, most of them in small\nclusters. "
                + "Off in the distance, you see a black smear creeping across the horizon. "
                + "For a split second, you hope that it might be a normal thunderstorm, one that you can fly\nthrough. "
                + "Those hopes are soon dashed when you see a flash of green light, and hear the telltale high wistling noise magical storms always give off. "
                + "The storm is\nheading straight for you, and there doesn't seem to be a way to avoid it. "
                + "It's speeding up with every second, whipping up the red sands below into a swirling sea. "
                + "Getting caught in a magical storm is a certain death sentence. "
                + "\nYou have no choice but to land. "
                + "You tilt the nose of the plane forwards and pull into a steep dive. "
                + "As you descend rapidly,\nthe storm moves closer and closer. Your navigational instruments begin to flicker, and you can see the compass needle swinging wildly. "
                + "You eventually manage to land, in the middle of a cluster of jagged rocks you couldn't see from above. "
                + "One of the canvas wings on your plane tears, and you land, tangled up in a pile of broken wood\nnd canvas wings. "
                + "You're badly bruised and you have a shallow cut on your arm, but aside from that, you are unhurt. "
                + "Your plane, however, is definitly not airworthy. \n"
                + "One of the wings has torn, and the sigil that keeps the planbe in the air is broken. "
                + "The magical storm still rages on around you, and you can barely see through the haze of terracotta sand. "
                + "You know that you have a half-empty waterskein you were keeping in the cockpit, as well as the map and navigational equipment you grabbed on your way out\nof the plane. "
                + "\n"
                + "Do you:");
        //give options
        btnChoice1.setText("Look for shelter, who knows how dangerous this storm will get");
        btnChoice2.setText("Look for food and water, I'll need them if I want to get out of here safely.");
    }
    
   //if the user decides to look for food in the storm 
   public void food()
   {
       txtMain.setText("Using your hand to shield your face from the sand, you begin to head downhill. \n"
               + "You figure that if anything is going to be alive in the badlands, it will be near a creekbed, and creeks flow downhill. \n"
               + "Out of sheer luck, you happen upon a dried up creekbed, and after following it for what seems like hours, it becomes muddy, then full of water. \n"
               + "You fill up your waterskin, and as you do, you notice some small fish. \n"
               + "It takes some doing, but you eventually manage to catch some in your water bottle to eat later. \n"
               + "By now, the storm has blown over, and the sun has begun to set. \n"
               + "\n"
               + "Do you:");
       //you got food and water
       food = true;
       water = true;
       //Present choices
       btnChoice1.setText("Press on and look for shelter through the night?");
       btnChoice2.setText("Sleep where you are?");
       location = "The streambed";
       //from here on out, the game is going to check if you are dead after every single method.
       checkIfDead();
   }
   //if the user decides to look for shelter
   public void shelter()
   {     
       //Up to the next section of comments deals with conditional dialogue.
       //The only way someone seeing this could possibly be tired is if they went to get food and came back
       //Since they are doing the same thing at different times, string x stores description text that chagnes based on what they do
       //x is incorporated into the main text later.
       String x = "";
       if (tired)
       {
           x += "Night has already fallen, and you are struggling to keep yourself awake after several hours spent looking for food and water. \n"
                   + "Off in the distance, you hear short yapping noises from some kind of wild animal. \n"
                   + "Your're not sure what can survive here, but you defninitly don't want to meet it. v";
       }
       else if (!map)
       {
           x += "You're exhausted from running all night, but you manage to keep going. \n";
       }
       else
       {
       x += "The swirling sands whip at your face as you press on. Your map still not showing your location due to the magical storm, you travel based on your memory. \n";
       }
       //main text
       txtMain.setText("You press forwards.\n" + x
               //x is added in here
               +"You aim for a group of low mesas, who seemed to have shadows on the side that might have been caves when you flew over. \n"
               + "Eventually, you reach the mesas. \n"
               + "On the side of one is a cave, and as you enter, you notice that it goes far deeper than you previously thought, presumably connecting to a cave system. \n"
               + "Towards the back of the cave, you see a broken window, set into the cave wall.\n"
               + "The cave, as well, seems far too geometrical to be natural.\n"
               + "The walls are stright, and, though extremly erroded are obviously manmade.\n"
               + "Do you:");
       //choices
       btnChoice1.setText("Explore deeper");
       btnChoice2.setText("Stay in the room you are in");
       btnChoice3.setText("---");
       btnChoice4.setText("---");
       
       location = "The mesas with the buildings inside";
       checkIfDead();
   }
   //if the user decides to sleep at the stream
    public void sleep()
    {
        //main text
        txtMain.setText("You figure it's best not to travel in the badlands at night. \n"
                + "You curl up near the creek, and try to go to bed. \n"
                + "Eventually, you manage to drift off. \n"
                + "You awake to the sound of snuffling around where you are sleeping. \n"
                + "You tentativly open one eye, and you see a small horse-like creature nosing at your map. \n"
                + "It's no bigger than a dog, and you cound swear it has feathers instead of fur. \n"
                + "You watch it for at bit, unsure of what to do. \n"
                + "Eventually, it looks you straight in the eye, and it opens it's mouth to reveal rows of sharp teeth, most of them longer than your hand. \n"
                + "It hisses at you, and you have no choice but to...\n");
        //label buttons
        btnChoice1.setText("Run");
        btnChoice2.setText("Fight");
        checkIfDead();
    }
    //if the user runs from the monster at the stream
    public void run()
    {
        //main text
        txtMain.setText("You get up and run as fast as you can, leaving your map and water bottle behind. \n"
                + "You can hear the monster behind you, running across the badlands. \n"
                + "Eventually, you have to stop running to catch your breath, and you realize you are lost. \n"
                + "You can't seem to remember what direction you came from. \n"
                + "You walk: ");
        //you lost your map and other supplies
        map = false;
        food = false;
        water = false;
        //label butons
        btnChoice1.setText("Left");
        btnChoice2.setText("Right");
        btnChoice3.setText("Forwards");
        btnChoice4.setText("Backwards");
        checkIfDead();
    }
    //if the user fights the monster at the stream
    public void fight()
    {
        txtMain.setText("Without anything better to do, you punch the monster in the eye. \n"
                + "It reels back, and you think for a second it's going to run away. \n"
                + "Then it lunges forwards, and manages to sink one of its teeth into your arm. \n"
                + "You reel back in pain, and the monster goes in to bite your side. \n"
                + "You manage to roll out of the way in time, and grab one of its legs as you go. \n"
                + "It falls over and you take advantage of the monster's momentary confusion to kick it in the stomach. \n"
                + "It curls up on itself, and you manage to stomp on its neck hard enough that it goes limp after a few seconds. \n"
                + "You curl up next to the stream and go back to sleep.\n"
                + "You wake up to the bright light of the sunrise shinging in your eyes. \n"
                + "You take a look at your map, and start to figure out the quickest way to get to a city. \n");
        //You got bit, so you are injured and lose HP
        HP -= 3;
        injured = true;
        updateHP();
        updateEffect();
        //button choices
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        checkIfDead();
    }
    //if the user runs left
    public void left()
    {
        txtMain.setText("You make it back to the stream, and find your map and supplies piled up where you left them. \n"
                + "You go back to sleep at the streambed, hoping the creature won't return. \n" 
                + "When you are woken up by the sun, you take a look at your map and try to figure out where you are, and plot your route to the nearest city. \n");
        //You sleep and get your stuff back
        tired = false;
        map = true;
        food = true;
        water = true;
        updateEffect();
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //if the user runs right
    public void lost()
    {
        //This output is a little underwhelming, but I can't think of a better way to phrase it.
        txtMain.setText("You are lost in the badlands, and eventually die of thirst without supplies or a map.\nGame over.");
        //From here on out, all methods where you die will set all buttons to nothing, except for the first one, which will be "Play again?"
        //This will link dirctly back to the beginning again.
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        //This doesn't output, but I think it's a cool easter egg, even if it's only in the code, so I'm keeping it
        location = "Unknown territory, hic sunt dracones";
        checkIfDead();
    }
    //if the user goes deeper into the caverns
    public void deeper()
    {
        txtMain.setText("The inside of the mesas looks like an old building, far older than anything you've ever seen before. \n"
                + "Very few things remain in the buildings, almost everything there seems to have erroded or rotted away over time. \n"
                + "The inside of the building looks like it used to be a castle or a keep. \n"
                + "There are heavily erroded statues and relifs that dot the halls, and the doorways are huge and arched. \n"
                + "The occasional shatterd glass window will show you another room, equally desolate and dark. \n"
                + "You do find some old worn out objects and tools, made of a material that you have no idea what it is. \n"
                + "They seem to be the only items still around. \n"
                + "You take some of the objects with you, they're fairly light and they can't hurt to keep. \n"
                + "As you explore, you find a tunnel that leads to a dark cavern deep underground, filled with water. \n"
                + "You drink and fill up your waterskein at the lake, and return to the surface after spending the night in the mesas. \n");
        tired = false;
        thirsty = false;
        if (map)
        {
        water = true;
        }
        fork = true;
        updateEffect();
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //if the user doesn't explore the caves and is boring
    public void stay()
    {
        txtMain.setText("You sleep in the room, and nothing disturbs you until morning, when you are woken by sunlight streaming into the cave entrance. \n"
                + "");
        btnChoice1.setText("Start walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //the first day of walking
    public void walk()
    {
        txtMain.setText("You wander for a day and head towards a city. \n"
                + "Towards the end of the day, you see a plane flying on the horizon, and you think it might be a search party. \n");
        //this won't work as a method so it's here for now. 
        //I have no idea why this is happening so I'm fixing it like this for now
        //It's literally just this one instance where the count method doesn't update HP
        //I have no idea what is going on
        HP = Integer.parseInt(lblHPNum.getText());
        if (injured)
        {
            HP -= 2;
        }
        //a day passes
        //count basically makes a day pass
        count();
        updateHP();
        btnChoice1.setText("Keep following your map");
        btnChoice2.setText("Follow the plane");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        //The location strings are getting a bit long but I'm keeping them like this so the map doens't get cluttered
        location = "In the badlands, past the mesas with the buildings inside";
        checkIfDead();
    }
    //If the user chases the plane
    public void plane()
    {
        txtMain.setText("You chase after the plane, and you soon lose sight of it. \n"
                + "It takes you quite a while to figure out where you are, and you lose a day trying to get back on track. \n"
                + "You can't find any shelter, and you have to sleep out in the open that night. \n");
        //See it works in here
        //What on earth is going on
        count();
        btnChoice1.setText("Keep following your map");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //If the user keeps following their map
    public void map()
    {
        txtMain.setText("You follow your map, spending a fairly uneventful day pushing forwards into the badlands. \n"
                + "Towards the end of the day, you see a small creature hop behind a rock. \nDo you:");
        count();
        btnChoice1.setText("Leave it be");
        btnChoice2.setText("Try to catch it for food");
        btnChoice3.setText("Follow it to see if it will lead you to water");
        btnChoice4.setText("---");
        //This isn't really a location but it's marked on the map
        location = "The small creature";
        checkIfDead();
    }
    //Once the user is past the small animal
    //There's a few ways to get here
    public void keepWalking()
    {
        txtMain.setText("You keep walking and you see the spire of the nearest city off in the distance. \n"
                + "You can also see a small cluster of mesas off to one side. \n"
                + "They would probably take you about an hour out of your way to get to.\n "
                + "Do you:");
        //There was already a count done for this day.
        btnChoice1.setText("Use them as shelter for the night");
        btnChoice2.setText("Sleep where you are, they're too far away.");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        location = "The badlands, in between the small creature and the mesas where you found the sigil";
        checkIfDead();
    }
    //If the user tries to catch the animal
    public void hunt()
    {
        txtMain.setText("You grab a rock, and sneak up behind the creature. \n"
                + "You try to pound the rock into the creature's head, and are met with far more resistance than you were expecting. \n"
                + "The scales seem to be made of metal or stone, and can't be broken. \n"
                + "You grab it by the tail, and flip it over. Its long claws scrach at your hand, marking them badly. \n"
                + "You eventually manage to flip it over, and it's softer underbelly is far easier to break through to. \n"
                + "You eventually cut through, and get the first bits of food you've had in a long time. \n");
        //You got food
        hungry = false;
        //It's little so you only take 1 damage
        HP--;
        updateHP();
        updateEffect();
        btnChoice1.setText("Keep walking");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //If the user follows the creature
    public void follow()
    {
        txtMain.setText("You circle around to get a better look at the creature. \n"
                + "It's covered in scales like a pangolin, but has far more legs. \n"
                + "After several hours of following the creature and trying not to spook it, it leads you to a stream. \n"
                + "You stop to fill up your waterskin, and take a drink. \n"
                + "Once you have done this, do you: ");
        //This assumes the user gets water, drinks, and then gets more
        //Because that makes sense
        thirsty = false;
        water = true;
        updateEffect();
        btnChoice1.setText("Leave it be");
        btnChoice2.setText("Try to catch it for food");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //If the user goes to sleep in the mesas (like the second ones) 
    public void mesas()
    {
        txtMain.setText("You head towards the mesas. \n"
                + "The inside of the caves inside the mesas are sandstone, similar to the outside,\nbut the walls are carved, with writing in a language you don't recognise engraved on the stone. \n"
                + "Once or twice, you try to enter a cavern, only to be pushed back by some magical force. \n"
                + "You find their source in a sigil carved into the wall. \n"
                + "You're no wizard, so you take the best rubbing you can, by scratching the image of the sigil into the back of your map with a rock. \n"
                + "You spend an uneventful night in the cavern, and wake up the next day to keep walking. \n");
        rubbing = true;
        btnChoice1.setText("Head towards the city");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        location = "The mesas where you found the sigil";
        checkIfDead();
    }
    public void outside()
    {
        txtMain.setText("You go to sleep in the middle of the badlands, and get up early the next day, woken yet again by the sun.");
        btnChoice1.setText("Head towards the city");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    public void city()
    {
        txtMain.setText("You get to the base of the spire, and are now faced with a problem that hadn't occurred to you before. \n"
                + "The spires rarely have access to the badlands by land. \n"
                + "All transport of goods is done by plane, and communication consists mostly of teleporting wizards passing information around. \n"
                + "The spire is made up of sandstone, and is far to tall too be able to talk to people at the top. \n"
                + "How do you try to get to the top?");
        count();
        //I might want to make it a bit more clear that the spire is like 5km up
        btnChoice1.setText("Climb the spire.");
        btnChoice2.setText("Look for a door");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        location = "The nearest city";
        checkIfDead();
    }
    public void climb()
    {
        txtMain.setText("You try to climb the cliff, and manage to get pretty high off the ground. \n"
                + "Eventually, a rock you were using for a foothold breaks under your weight, and you fall down, dying on impact. \n"
                + "Game Over");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void door()
    {
        //x and y are conditional dialogue options. 
        //x shows if you got injured'
        //y deals with useless collectables and the outcome of having them
        String x = "";
        String y = "";
        if (injured)
        {
            x += "You go to a hospital, and they treat the gash on your arm. \n"
                    + "There's no lasting damage, but it does leave a pretty bad scar. \n";
        }
        if (fork && rubbing)
        {
            y += "You show the tool you found in the mesas on the first night and the sigil from the second mesa to some local wizards. \n"
                    + "They still have no idea what the tool is for, and all they know about the sigil is that it's some kind of warding magic, far more advanced than any modern magic.\n";
        }
        else if (fork)
        {
            y += "You show the tool you found in the mesas on the first night to some local wizards. \n"
                    + "They still have no idea what the tool is for, and don't have enough context to figure out what it is.\n";
        }
        else if (rubbing)
        {
            y += "You show the magical sigil from the mesas to some local wizards. \n"
                    + "All they know about it is that it's some kind of warding magic, far more advanced than any modern magic.\n";
        }
        txtMain.setText("You walk for several hours and find a door that leads to a staircase that heads up. You go up. \n"
                + "It takes you a while to readjust to the hustle and bustle of a city, but you eventually manage to get yourself oriented. \n"
                + x
                + y
                + "You eventually return to being a pilot, but stay far away from the paths where magical storms often spring up. \n");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
        checkIfDead();
    }
    //The next two methods are a bit underwhelmig, but I can't think of better dialogue
    public void deathFromDehydration()
    {
        txtMain.setText("You die from dehydration");
        btnChoice1.setText("Play again?");
        btnChoice2.setText("---");
        btnChoice3.setText("---");
        btnChoice4.setText("---");
    }
    public void deathFromInjury()
    {
        txtMain.setText("You die from injury");
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
        btnMap1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        txtMain.setColumns(20);
        txtMain.setLineWrap(true);
        txtMain.setRows(5);
        txtMain.setText("Welcome to my choose your own adventure game!\nThe main text of the game will appear here\nUse the buttons below the main text field to make choices and progress the story.\nYour hit points and status effects display above the main text area.\nStatus effects have varying levels of severity.\nThe injured status effect makes you lose 2 hit points per day.\nIf you spend three days in a row with the thirsty status effect, you die of dehydration.\nShow Inventory shows you inventory, and Show Map shows a map with your location on the bottom of the screen.\nYou can always view these instructions again by clicking the instructions button.");
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

        btnMap1.setText("View Instructions");
        btnMap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMap1ActionPerformed(evt);
            }
        });

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
                        .addComponent(lblStatusEffectsInfo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMap1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMap, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnMap, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMap1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        switch (btnChoice2.getText()) {
            //The begin method sets the text to this. leads to the food() method
            case "Look for food and water, I'll need them if I want to get out of here safely.":
                food();
                break;
            //the food method sets the button to this. Leads to getting attacked 
            case "Sleep where you are?":
                sleep();
                break;
            //the sleep method sets the button to this
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
            //the walk method sets the text to this
            case "Follow the plane":
                plane();
                break;
            //the map method sets the text to this
            case "Try to catch it for food":
                hunt();
                break;
            //the keepWalking method sets the text to this
            case "Sleep where you are, they're too far away.":
                outside();
                break;
            //the city method sets the text to this
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
            //the shelter method sets the text to this
            case "Explore deeper":
                deeper();
                break;
            // all deaths set the button to this
            case "Play again?":
                begin();
                break;
            //several methods set the text to this, it all leads to the first day of walking. (Or getting lost if you don't have a map)
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
            //this is from the map, hunt, and follow methods. They all make you keep walking
            case "Keep walking":
                //fall through
            case "Leave it be":
                keepWalking();
                break;
            //the keepWalking method sets the text to this
            case "Use them as shelter for the night":
                mesas();
                break;
            //the outside and measas methods both set the text to this
            case "Head towards the city":
                city();
                break;
            //the city method sets the text to this. 
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
       //the keepWalking method sets the code to this
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
        //Create and show the inventory GUI
        new InventoryGUI().setVisible(true);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapActionPerformed
        //if you don't have a map in the game you don't get to see the interface
        if (map == true)
        {
            new MapGUI().setVisible(true);
        }
    }//GEN-LAST:event_btnMapActionPerformed

    private void btnMap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMap1ActionPerformed
        //Creates and shows the instructions GUI
        new InstructionsGUI().setVisible(true);
    }//GEN-LAST:event_btnMap1ActionPerformed

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
    private javax.swing.JButton btnMap1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHPNum;
    private javax.swing.JLabel lblHPText;
    private javax.swing.JLabel lblStatusEffectsInfo;
    private javax.swing.JLabel lblStatusEffectsText;
    private javax.swing.JTextArea txtMain;
    // End of variables declaration//GEN-END:variables
}
