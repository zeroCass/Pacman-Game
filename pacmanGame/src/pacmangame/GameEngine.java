package pacmangame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import pacmangame.entity.Blinky;
import pacmangame.entity.Ghost;
import pacmangame.entity.GhostRed;
import pacmangame.entity.Pacman;

public class GameEngine extends Canvas implements Runnable, KeyListener {
    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 600;
    public static final int TILE_SIZE = 30; //size in pixels of each object in game
    public static final int MAZE_SIZE_Y = 20;
    public static final int MAZE_SIZE_X = 30;
    public static int timerEvent = 0;
    public static int scaredTimer = 0;
    public static String ghostMode; //scatter,chaser,scared, eaten
    public static String oldGhostMode; //keep the old mode
    public static int score;
    
    //the main thread of this object
    public static Thread thread;
    public static boolean running = false; //the main variable the makes game loop running
    
    AudioClip death;
    
    //define if the update/draw is going on
    public static boolean pauseTimer = false; 
    
    public static int lives;
    
    //objects
    Pacman pacman;
    GhostRed ghost;
    //Ghost blinky;
    Ghost blinky;
    Map map;
    
    
    public GameEngine () {
        URL url = getClass().getResource("pacman_death.wav");
        this.death = Applet.newAudioClip(url);
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        addKeyListener(this);
    }
    
    
    public synchronized void start () {
        
        //init the variables and objects
        pacman = new Pacman(11, 4); //!! the fisrt position !!
        ghost = new GhostRed(9,15);
        //blinky = new Ghost(9,14, "blinky");
        blinky = new Blinky(9,14);
        
        map = new Map();
        ghostMode = "scatter";
        this.score = 0;
        
        this.lives = pacman.lives;
        
       if (running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
        
        
        
    }
    
    public synchronized void restart () {
        
        if (lives > 0) {
          //init the variables and objects
            pacman = new Pacman(11, 4); //!! the fisrt position !!
            ghost = new GhostRed(9,15);
            //blinky = new Ghost(9,14, "blinky");
            blinky = new Blinky(9,14);

            //map = new Map();
            ghostMode = "scatter";
            //this.score = 0;

           if (running)return;
            running = true;
            run();
            //thread = new Thread(this);
            //thread.start();  
        }else {
            stop();
        }
        
        
        
        
        
    }
    
    
    public synchronized void stop () {
        if (!running)return;
        running = false;
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
        
    }
    
    public synchronized void waitUntilDone(int miliseconds, boolean isOver) {
        pauseTimer = false;
        running = false;
        //System.out.println("entriu");
        long timer = System.currentTimeMillis();
        long newTimer = timer;
        while (newTimer - timer < miliseconds) {
            newTimer = System.currentTimeMillis();
        }
        
       if (!isOver) {
            running = true;
            this.run();
            
        }
            
        
        //teste = false;
      // System.out.println("entrou");
//       /Count contador = new Count();
        
               
     /* try {
             //TimeUnit.MILLISECONDS.sleep(1000);
             //Thread.sleep(1000);
             synchronized (thread){
                    try{
                       thread.wait();
                       aux.join();
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }
                 }
             

        } catch (Exception e) {
             e.printStackTrace();
        }*/
      
        //thread.interrupt();
        //thread.run();
      
        
        pauseTimer = false;
        //System.out.println("saiu");
        
    } 
    
    
    private void update () {
        
        //check gameover
        /*if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()
            || pacman.getX() / TILE_SIZE == ghost.getX() / TILE_SIZE && pacman.getY() / TILE_SIZE == ghost.getY() / TILE_SIZE
            || pacman.getX() / TILE_SIZE == ghost.getX() && pacman.getY() * TILE_SIZE == ghost.getY()
            || pacman.getX() == ghost.getX() / TILE_SIZE && pacman.getY() == ghost.getY() / TILE_SIZE)
            */
        
        pacman.updateMovement(map); //move the pacman
        checkPills(pacman.getY(), pacman.getX()); //check if the players got the pill
        ghost.updateMovement(map, pacman);
        //blinky.updateMovement(map, pacman, pacman.getY() / TILE_SIZE, pacman.getX() / TILE_SIZE);
        blinky.updateMovement(map, pacman);
        
        //check gameover
        //Rectangle pac = new Rectangle(pacman.getX(), pacman.getY(), 30, 30);
        //Rectangle gh = new Rectangle(ghost.getX(), ghost.getY(), 30, 30);
        
        //verifica se o ghost esta em modo scared e colidiu com o pacman
        //se sim, entra em modo eaten e
        if (ghostMode.equals("scared")) {
            if (ghost.hitbox.intersects(pacman.hitbox) 
               && !ghost.getCurrentMode().equals("eaten") && ghost.getCurrentMode().equals("scared")) {
                //teste = true;
                pauseTimer = true;
                ghost.setCurrentMode("eaten");
                
                
                
            }//check gameOver in scared Mode
            else if (ghost.hitbox.intersects(pacman.hitbox) 
               && !ghost.getCurrentMode().equals("eaten") && !ghost.getCurrentMode().equals("scared")) {
                death.play();
                System.out.println("GameOver");
                //pauseTimer = true;
                //waitUntilDone(4000, false);
                pacman.lives--;
                lives--;
                
                running = false;
                restart();
            }
                
            if (blinky.hitbox.intersects(pacman.hitbox) 
                && !blinky.getCurrentMode().equals("eaten") && ghost.getCurrentMode().equals("scared")) {
                //teste = true;
                pauseTimer = true;
                blinky.setCurrentMode("eaten");
                
            }//check gameOver in scared Mode
            else if (blinky.hitbox.intersects(pacman.hitbox) 
                && !blinky.getCurrentMode().equals("eaten") && !ghost.getCurrentMode().equals("scared")) {
                death.play();
                pacman.lives--;
                lives--;
                System.out.println("GameOver");
                //pauseTimer = true;
                //waitUntilDone(4000, false);
                running = false;
                restart();
               
                
                
            }
                
            
        }
        //if the current is not scared, then the colision is GameOver
        else if ((ghost.hitbox.intersects(pacman.hitbox) || blinky.hitbox.intersects(pacman.hitbox))) {
            death.play();
            System.out.println("GameOver");
            pauseTimer = true;
            waitUntilDone(4000, true);
            //System.exit(0);
            pacman.lives--;
            lives--;
            //pacman = new Pacman(11, 4); //!! the fisrt position !!
            //ghost = new GhostRed(9,15);
            //blinky = new Ghost(9,14, "blinky");
            //ghostMode = "scatter";
            running = false;
            restart();
            //stop();
            //this.restart();
            
           
            
            
                
        }
        
        //check gameOver
        /*if (gh.intersects(pac)) {
            System.out.println("GameOver");
                GameEngine.running = false;
            }*/
            
        /*if (pacman.lives == 0) {
            death.play();
            System.out.println("GameOver");
            pauseTimer = true;
            waitUntilDone(4000, true);
        }*/
        
    }
    
    
    private void render () {
        
        //creat the buffer (graphics)
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        
        //draw the Objects
        
        //drawBackground(g); //dont make sense
        map.drawMaze(g); //draw the game Maze
        pacman.render(g); //draw the Pacman
        ghost.render(g);
        blinky.render(g);
        //redraw adn show the graphcis
        g.dispose();
        buffer.show();
    }
    
  
    

    
    
    
    
//the gameLoop
    @Override
    public void run() {
        this.requestFocus();
        int fps = 0; 
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetFPS = 60.0;
        double delta = 0;
        double ns = 1000000000 / targetFPS;
        
        
        while (running) {
            //System.out.println("loop");
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
                 //reset the state of ghost of scared to the previus state
                }else if (scaredTimer == 10000 && ghostMode.equals("scared")) {
                    scaredTimer = 0;
                    ghostMode = oldGhostMode;
                    System.out.println(oldGhostMode);
                    if (!ghost.getCurrentMode().equals("eaten")) {
                        ghost.setCurrentMode(oldGhostMode);
                       // ghost.setVelocity(2); //normal speed
                    }
                    if (!blinky.getCurrentMode().equals("eaten")) {
                        blinky.setCurrentMode(oldGhostMode);
                    }
                        
                    //arumar ghost speed
                }
                //System.out.println(ghostMode);
                System.out.println(scaredTimer / 1000);
            }
            }else {
                System.out.println("entrou");
                //waitUntilDone();
              /*synchronized (this){
                    try{
                       thread.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                
                //System.out.println(ghost.getCurrentMode());
                //System.out.println(teste);
                //pauseTimer = false;
                //threadPause();
                waitUntilDone(1000, false);
                
            }
             
            //System.out.println(teste);
            
        }
        //stop();
    }
    
    
    private void threadResume () {
        this.running = true;
        pauseTimer = false;
        this.run();
    }
    
    private void threadPause () {
        System.out.println("entrou aqui");
        this.running = false;
        long timer = System.currentTimeMillis();
        long newTimer = timer;
        while (newTimer - timer < 1000) {
            newTimer = System.currentTimeMillis();
        }
        threadResume();
    }
    
    
    //this method change the mode od ghosts based on the current statte
    public void changeMode () {
        if (ghostMode.equals("chaser")) {
            ghostMode = "scatter";
            if (!ghost.getCurrentMode().equals("eaten"))
                ghost.setCurrentMode("scatter");
            if (!blinky.getCurrentMode().equals("eaten"))
                blinky.setCurrentMode("scatter");
        }
            
        else {
            ghostMode = "chaser";
            if (!ghost.getCurrentMode().equals("eaten"))
                ghost.setCurrentMode("chaser");
            if (!blinky.getCurrentMode().equals("eaten"))
                blinky.setCurrentMode("chaser");
        }
            
    }
    
    
     //check if the postiion of the pacman is a pill
    public void checkPills(int y, int x) {
        //normal pill
        if (map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] == 63){
            map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] = 0;
            this.score++;
        }
        //super pill
        else if (map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] == 64) {
            map.screenData[x /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)(y/GameEngine.TILE_SIZE)] = 0;
            this.score+=50;
            
            //change the current Mode to SCARED
            scaredTimer = 0;
            if (!ghostMode.equals("scared"))
                oldGhostMode = ghostMode; //save the old state
            ghostMode = "scared";
            //change the current Mode to SCARED of all ghost
            ghost.setCurrentMode("scared");
            blinky.setCurrentMode("scared");
            
  
            
        }
       //System.out.println("Pontos :" + score); 
        
    }
    
    
    
    //never used
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                pacman.setDirection("up");
            //    pacman.setNextDirection("up");
                 // pacman.setDx(0);
                 // pacman.setDy(-1);
                  pacman.setReq_x(0);
                  pacman.setReq_y(-1);
                break;
            case KeyEvent.VK_S:
                pacman.setDirection("down");
            //    pacman.setNextDirection("down");
                 // pacman.setDx(0);
                 // pacman.setDy(1);
                  pacman.setReq_x(0);
                  pacman.setReq_y(1);
                break;
            case KeyEvent.VK_D:
                  pacman.setDirection("right");
         //       pacman.setNextDirection("right");
                  //pacman.setDx(1);
                  //pacman.setDy(0);
                  pacman.setReq_x(1);
                  pacman.setReq_y(0);
                 break;
            case KeyEvent.VK_A:
                  pacman.setDirection("left");
                  pacman.setReq_x(-1);
                  pacman.setReq_y(0);
                  
          //      pacman.setNextDirection("left");
                  //pacman.setDx(-1);
                 // pacman.setDy(0);
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        /*int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                pacman.setDirection("none");
            //    pacman.setNextDirection("up");
                 // pacman.setDx(0);
                 // pacman.setDy(-1);
                  pacman.setReq_x(0);
                  pacman.setReq_y(0);
                break;
            case KeyEvent.VK_S:
                pacman.setDirection("none");
            //    pacman.setNextDirection("down");
                 // pacman.setDx(0);
                 // pacman.setDy(1);
                  pacman.setReq_x(0);
                  pacman.setReq_y(0);
                break;
            case KeyEvent.VK_D:
                  pacman.setDirection("none");
         //       pacman.setNextDirection("right");
                  //pacman.setDx(1);
                  //pacman.setDy(0);
                  pacman.setReq_x(0);
                  pacman.setReq_y(0);
                 break;
            case KeyEvent.VK_A:
                  pacman.setDirection("none");
                  pacman.setReq_x(0);
                  pacman.setReq_y(0);
                  
          //      pacman.setNextDirection("left");
                  //pacman.setDx(-1);
                 // pacman.setDy(0);
                break;
        }*/
    }
    

       /* private void drawBackground (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        
        for (int y = 0; y < 20; y++) { 
            g.setColor(Color.white);
            //g.drawLine(y * TILE_SIZE, 0 , y * TILE_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, y * GameEngine.TILE_SIZE, GameEngine.SCREEN_WIDTH, y * GameEngine.TILE_SIZE);
            for (int x = 0; x < 30; x++) {
               // g.drawImage(mapImages[map[y][x]], x * TILE_SIZE,( y * TILE_SIZE), null);
                //g.drawLine(x * TILE_SIZE, 0 , x * TILE_SIZE, SCREEN_HEIGHT);
                g.drawLine(x * GameEngine.TILE_SIZE, 0 , x * GameEngine.TILE_SIZE, GameEngine.SCREEN_HEIGHT);
           
            }
        }
        
    }*/
    
    
}
