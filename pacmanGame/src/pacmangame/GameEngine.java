package pacmangame;

import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import pacman_menu.save_score;
import pacmangame.entity.Blinky;
import pacmangame.entity.Clyde;
import pacmangame.entity.Inky;
import pacmangame.entity.Ghost;
import pacmangame.entity.Pacman;
import pacmangame.entity.Pinky;

public class GameEngine extends Canvas implements Runnable, KeyListener {
    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 600;
    public static final int TILE_SIZE = 30; //size in pixels of each object in game
    public static final int MAZE_SIZE_Y = 20;
    public static final int MAZE_SIZE_X = 30;
    public static int timerEvent; //counter that chenge ghosts mode
    public static int scaredTimer; //counter that turn on/off the scared ghost mdoe
     public static boolean pauseTimer = false; //pause gameloop after eaten a ghost
    public static String ghostMode; //scatter,chaser,scared, eaten
    public static String oldGhostMode; //keep the old mode
    public static int score;
    public static int ateGhost; //variable responsible for accumulating points when eating ghost 
    private int eatenGhostIdx; //varibale that save that current eaten ghost
    private boolean winner;
    public static int lives;
    //the main thread of this object
    public static Thread thread;
    public static boolean running = false; //the main variable the makes game loop running
    
    Sound sound_death;
    Sound sound_pill;
    Sound sound_superPill;
    Sound sound_intro;
    Sound sound_main_music;
    Sound sound_ate_ghost;
    Sound sound_interdimension;
    Sound sound_win;
    
    private Font PAC_FONT; //inused 
    
  
    //objects
    private Pacman pacman;
    private Map map;
    //private ArrayList <Ghost> ghosts;
    private Ghost [] ghosts;
    private Image pacman_live;
    private Image [] ghostPoints;
     
    public GameEngine () {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + 50));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        addKeyListener(this);
    }
    
    private void init_objects() {
        //init the variables and objects
        pacman = new Pacman(14, 14); //!! the fisrt position !!
        ghosts = new Ghost[4];
        Blinky blinky = new Blinky(7,14);
        ghosts[0] = blinky;
        
        Pinky pinky = new Pinky(9,14);
        ghosts[1] = pinky;
        
        Inky inky = new Inky(9,13);
        ghosts[2] = inky;
        
        Clyde clyde = new Clyde(9,15);
        ghosts[3] = clyde;
        
        //init variables
        ghostMode = "scatter"; //the initial ghost mode
        timerEvent = 0;
        scaredTimer = 0;
        winner = false;
        pauseTimer = false;
    }
    
    private void init_sound () {
        this.sound_death = new Sound("soundfx/pacman_death.wav");
        this.sound_main_music = new Sound("music/main.wav");
        this.sound_intro = new Sound("soundfx/intro_2.wav");
        this.sound_pill = new Sound("soundfx/ate_pill.wav");
        this.sound_superPill = new Sound("soundfx/ate_super_pill.wav");
        this.sound_ate_ghost = new Sound("soundfx/ate_ghost.wav");
        this.sound_win = new Sound("soundfx/win.wav");
        this.sound_interdimension = new Sound("music/interdimension.wav");
    }
    
    private void init_images () {
        ghostPoints = new Image [4];
        pacman_live = new ImageIcon("images/pacman/pacman_left.gif").getImage();
        ghostPoints[0] = new ImageIcon("images/GameStates/200pts.png").getImage();
        ghostPoints[1] = new ImageIcon("images/GameStates/400pts.png").getImage();
        ghostPoints[2] = new ImageIcon("images/GameStates/800pts.png").getImage();
        ghostPoints[3] = new ImageIcon("images/GameStates/1600pts.png").getImage();
        //init font
        try {
            PAC_FONT = Font.createFont(Font.TRUETYPE_FONT, new File("font/8-bit Arcade In.ttf")).deriveFont(35f);
            //PAC_FONT.deriveFont(100f);
        }catch (IOException | FontFormatException e) {
            System.out.println("Erro na fonte");
        }
    }
    
    private void close_sound () {
        this.sound_death.close();
        this.sound_main_music.close();
        this.sound_intro.close();
        this.sound_pill.close();
        this.sound_superPill.close();
        this.sound_ate_ghost.close();
        this.sound_win.close();
        this.sound_interdimension.close();
    }
    
    public synchronized void start () { 
        map = new Map(); //intanciate the map
        lives = 3;
        score = 0;
          
        init_objects();
        init_images();
        init_sound();

        
        this.sound_intro.play(); //intro music play
        //wait for 4sec until intro music play
        long timer = System.currentTimeMillis();
        long newTimer = timer;
        while (newTimer - timer < 4000) { 
            render();//show the ready msg
            newTimer = System.currentTimeMillis();
        }
        
        this.sound_main_music.loop(); //start the main music
        if (running)return;
         running = true;
         thread = new Thread(this);
         thread.start();
        
        
        
    }
    
    //this check restart or game over
    public synchronized void restart () {
        
        
        //if the live is bigger than 0, restart the game
        if (lives > 0) {
          //init the variables and objects
            init_objects();
            //wait 1 sec 
            long timer = System.currentTimeMillis();
            long newTimer = timer;
            while (newTimer - timer < 1000) { 
                render();//show the ready msg
                newTimer = System.currentTimeMillis();
            }
           
            this.sound_main_music.loop(); //plays the main music
            if (running)return;
             running = true;
             run();
         }
        else {
             running = false;
             gameOver();
         }
        
        
    }
      
    //stop the thread (and open the next jframe)
    public synchronized void stop () {
        new save_score().setVisible(true);
        running = false;
        try {
            thread.join();
        }
        catch (InterruptedException e) {
        }   
    }
    
    //shutdown the gameloop and variables
    //game its over, win or lose
    private void gameOver () {
        running = false;
        this.sound_main_music.stop(); //stop the main music
        long timer = System.currentTimeMillis();
        long newTimer = timer;
        int miliseconds = 3000;
        if (winner) {
            miliseconds = 7000;
        }
            
        while (newTimer - timer < miliseconds) { 
            render(); //
            newTimer = System.currentTimeMillis();
        }
        
        close_sound(); //close all sounds of the game               
        stop();
    }
    
    //this method is responsable to pause the game for x miliseconds
    public synchronized void waitUntilDone(int miliseconds, boolean isOver) {
        running = false;
        //if in pauseTimer , what it means that pacman eaten a ghost
        //then render the points at eaten ghost
        if (pauseTimer) {
            render();
        }         
        long timer = System.currentTimeMillis();
        long newTimer = timer;
        while (newTimer - timer < miliseconds) {
            if (pacman.isDead()) {
                render();
            }
            newTimer = System.currentTimeMillis();
        }
        if (pauseTimer)
            this.sound_interdimension.resume();
        pauseTimer = false;
        if (!isOver) {
             running = true;
             this.run();

         }
  
    } 
     
    //update all the engine stuffs, check gameover, collisions, update movement...
    private void update () {
        pacman.updateMovement(map); //move the pacman
        checkPills(pacman.getY(), pacman.getX()); //check if the players got the pill
        //win condition
        if (map.numPills == 0) {
            winner = true;
            System.out.println("entrou yin condition");
            this.sound_win.play();
            gameOver();
        }
                       
        //update movement and check colisions
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].updateMovement(map, pacman);
            
            if (ghostMode.equals("scared")) {
                
             //check if the pacman eat a ghost
                if (ghosts[i].hitbox.intersects(pacman.hitbox) 
                   && !ghosts[i].getCurrentMode().equals("eaten") && ghosts[i].getCurrentMode().equals("scared")) {
                    //teste = true;
                    this.sound_ate_ghost.play();
                    pauseTimer = true;
                    ghosts[i].setCurrentMode("eaten");
                    
                    score += (200 * (Math.pow(2,ateGhost))); //calculates the number of points at eat a ghost
                    //System.out.println((Math.pow(2,ateGhost)) + " " + (200 * (Math.pow(2,ateGhost))));
                    eatenGhostIdx = i; //update the current ghost the was eaten
                    
                    
                
            }
            //check gameOver in scared Mode
                else if (ghosts[i].hitbox.intersects(pacman.hitbox) 
                   && !ghosts[i].getCurrentMode().equals("eaten") && !ghosts[i].getCurrentMode().equals("scared")) {
                    this.sound_main_music.stop();
                    this.sound_interdimension.stop();
                    waitUntilDone(1000, true);
                    this.sound_death.play();
                    
                    pacman.setIsDead(true);
                    waitUntilDone(4000, true);
                   
                    //System.out.println("GameOver in Scared");
                    lives--;
                    
                    restart();
                }
            }
            //if the current is not scared, then the colision is GameOver
            else if ((ghosts[i].hitbox.intersects(pacman.hitbox) || ghosts[i].hitbox.intersects(pacman.hitbox))) {
                //System.out.println("entrou");
                //System.out.println("GameOver in Scatter or Chase");
                this.sound_main_music.stop();
                waitUntilDone(1000, true);
                this.sound_death.play();
                pacman.setIsDead(true);
                waitUntilDone(4000, true);
                lives--;     
                restart();           
            }       
                
        }
        
    }
    
    //render all graphical objects on the screen
    private void render () {    
        //creat the buffer (graphics)
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        
        //draw the Objects
        map.drawMaze(g); //draw the game Maze
        drawScore(g);

        //draw the points at eat a ghost
        if (pauseTimer && !running) {
            //make sure that will never acess a invalid position
            if (ateGhost > 3)
                ateGhost = 0;
            g.drawImage(ghostPoints[ateGhost], ghosts[eatenGhostIdx].getX(), ghosts[eatenGhostIdx].getY(), null);
            ateGhost++;//increase the variable the count how many ghost was ate
        }else {
            pacman.render(g); //render the pacman if is not eating a ghost
        }
        
        //render each ghost
        if (running || pauseTimer) {
            for (int i = 0; i < ghosts.length; i++) {
                //make sure that the eaten ghost will not render at the time
                //that he is in score mode (showing points)
               if (pauseTimer && eatenGhostIdx == i)
                    continue;
                ghosts[i].render(g);
                
            }
        }
        //render the win screen
        else if (!running && lives > 0 && !pauseTimer && !pacman.isDead() && winner){  
            Image youwin;
            youwin = new ImageIcon("images/GameStates/youwin.png").getImage();
            g.drawImage(youwin, 360, 335, null);
        }
        //if is not running, then it is in screen start or gameOver
        else if (!running && lives > 0 && !pauseTimer && !pacman.isDead()){
            //draw the ready intro
            Image ready;
            ready = new ImageIcon("images/GameStates/ready.png").getImage();
            g.drawImage(ready, 390, 335, null);
            //g.drawString("Read!", 420, 350);
            //play the start music
        }
        //game over screen
        else if (!running && lives == 0) {
            Image gameover;
            gameover = new ImageIcon("images/GameStates/gameover.png").getImage();
            g.drawImage(gameover, 365, 335, null);
        }
        
        //redraw and show the graphcis
        g.dispose();
        buffer.show();
    }
    
    private void drawScore (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 600, 900, 50); //RE_draw the backgroud of the score
        for (int i = 0; i < lives; i++) {
            g.drawImage(pacman_live, 860 - (i * 40), 610, null); //draw the lives
        }
        g.setColor(Color.white);
        //g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setFont(PAC_FONT);
        g.drawString(String.valueOf(score), 40, 625);
    }
    
    //the gameLoop
    @Override
    public void run() {
        //variables for controls ghost respawn
        int respawnTimer = 0;
        int idxRespawn = 1; //start at 1, cause red ghost begin out of the house
        //variable for constrols gameloop and updates/renders
        this.requestFocus();
        int fps = 0; 
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetFPS = 60.0;
        double delta = 0;
        double ns = 1000000000 / targetFPS;
        
        while (running) {
            if (!pauseTimer) {
                long currentTime = System.nanoTime();
                delta+= (currentTime - lastTime) / ns;
                lastTime = currentTime;
                while(delta >= 1) {
                        update();
                        render();
                        fps++;
                        delta--;                 
                }
                //count of seconds (contagem de segundos)
                if (System.currentTimeMillis() - timer >= 1000) {
                   // System.out.println(fps);
                    fps = 0;
                    timer+=1000;

                    //constrol the respawn time for each ghost at 5 seconds
                    if (respawnTimer < 3000 && idxRespawn < 4) {
                       respawnTimer += 1000;
                    }else if (respawnTimer == 3000 && idxRespawn < 4) {
                        ghosts[idxRespawn].setCanOut(true);
                        respawnTimer = 0;
                        idxRespawn++;
                    }


                    //controlls what is the ghost mode
                    //1 - until 10 seconds = scatter
                    //2 - 20 seconds in "chaser" mode  

                    //check if the ghost in scared mode
                    //case 1: the main timer is scaredTimer
                    //case 2: the main timer is timerEvent
                    if (ghostMode.equals("scared")) {
                        scaredTimer+=1000;
                    }
                    else {
                        ateGhost = 0;
                        timerEvent+=1000;
                    }

                    //if passed 10 sec, change the current mode scatter
                    if (timerEvent == 10000 && ghostMode.equals("scatter")) {
                        //System.out.println(timerEvent);
                        changeMode();
                        timerEvent = 0; 
                    }
                    //if passed 20 sec change the chaser mode to scatter 
                    else if (timerEvent == 20000 && ghostMode.equals("chaser")) {
                        //System.out.println(timerEvent);
                        changeMode();
                        timerEvent = 0;
                        ateGhost = 0;
                     //reset the state of ghost of scared to the previus state
                    }else if (scaredTimer == 10000 && ghostMode.equals("scared")) {
                        this.sound_interdimension.stop();
                        this.sound_main_music.loop();
                        
                        scaredTimer = 0;
                        ghostMode = oldGhostMode;
                        System.out.println(oldGhostMode);

                        for (int i = 0; i < ghosts.length; i++) {
                            if (!ghosts[i].getCurrentMode().equals("eaten")) {
                                ghosts[i].setCurrentMode(oldGhostMode);
                                // ghost.setVelocity(2); //normal speed
                            }
                            if (!ghosts[i].getCurrentMode().equals("eaten")) {
                                ghosts[i].setCurrentMode(oldGhostMode);
                            }
                        }

                    }
                }
            }else {
                this.sound_interdimension.stop();
                //wait 1 second when pacman eats
                waitUntilDone(1000, false);
                
            }
            
        }
        //stop();
    }
      
    //this method change the mode od ghosts based on the current statte
    public void changeMode () {
        if (ghostMode.equals("chaser")) {
            ghostMode = "scatter";
            
            for (int i = 0; i < ghosts.length; i++) {
                if (!ghosts[i].getCurrentMode().equals("eaten"))
                    ghosts[i].setCurrentMode("scatter");
                if (!ghosts[i].getCurrentMode().equals("eaten"))
                    ghosts[i].setCurrentMode("scatter");
            }
            
        }
            
        else {
            ghostMode = "chaser";
            for (int i = 0; i < ghosts.length; i++) {
                if (!ghosts[i].getCurrentMode().equals("eaten"))
                    ghosts[i].setCurrentMode("chaser");
                if (!ghosts[i].getCurrentMode().equals("eaten"))
                    ghosts[i].setCurrentMode("chaser");
            }
            
        }
            
    }
    
     //check if the postiion of the pacman is a pill
    public void checkPills(int y, int x) {
        //normal pill
        if (map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] == 63){
            map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] = 0;
            this.score+=10;
            this.sound_pill.play();
            map.numPills--; //decrease number os pills remaning
        }
        //super pill
        else if (map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] == 64) {
            map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] = 0;
            this.score+=50;
            ateGhost = 0;
            this.sound_superPill.play();
            this.sound_main_music.stop();
            this.sound_interdimension.play();
            map.numPills--; //decrease number os pills remaning
            
            //change the current Mode to SCARED
            scaredTimer = 0;
            if (!ghostMode.equals("scared"))
                oldGhostMode = ghostMode; //save the old state
            ghostMode = "scared";
            //change the current Mode to SCARED of all ghost
            for (int i = 0; i < ghosts.length; i++) {
                ghosts[i].setCurrentMode("scared");
            } 
        }       
        
    }

    //never used
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
   
    //method that controls the keyevent of keyboard and change pacman direction
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                pacman.setDirection("up");
                pacman.setReq_x(0);
                pacman.setReq_y(-1);
                break;
            case KeyEvent.VK_UP:
                pacman.setDirection("up");
                pacman.setReq_x(0);
                pacman.setReq_y(-1);
                break;
            case KeyEvent.VK_S:
                pacman.setDirection("down");
                pacman.setReq_x(0);
                pacman.setReq_y(1);
                break;
            case KeyEvent.VK_DOWN:
                pacman.setDirection("down");
                pacman.setReq_x(0);
                pacman.setReq_y(1);
                break;
            case KeyEvent.VK_D:
                pacman.setDirection("right");
                pacman.setReq_x(1);
                pacman.setReq_y(0);
                break;
            case KeyEvent.VK_RIGHT:
                pacman.setDirection("right");
                pacman.setReq_x(1);
                pacman.setReq_y(0);
                break;
            case KeyEvent.VK_A:
                pacman.setDirection("left");
                pacman.setReq_x(-1);
                pacman.setReq_y(0);
                break;
            case KeyEvent.VK_LEFT:
                pacman.setDirection("left");
                pacman.setReq_x(-1);
                pacman.setReq_y(0);
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
  
}
