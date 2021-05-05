
package pacmangame;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameEngine extends Canvas implements Runnable, KeyListener{
    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 600;
    static final int TILE_SIZE = 30;
    
    private Thread thread;
    private boolean running = false;
    
    //creates a object pacman type
    PacMan pacman = new PacMan(15,10);
    
    //private int score = 0;
    
    //private Graphics g;
    
    Map0 map = new Map0();
    
   // Map map = new Map();
    
   // Pacman = new Pacman();
   // Ghost_red = new Ghost();
    
    public GameEngine () {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        //this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }
    
    
    @Override
    public void addNotify () {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        this.addKeyListener(this);
        running = true;
    }
    
    
    private void update () {
        //pacman.updatePacMan(map);
        //map.updateMap(pacman.getX(), pacman.getY());
        
        //pacman.updatePacMan();
       //System.out.println((int)pacman.getY() + " " + (int)pacman.getX());
       
        pacman.updatePacMan(map);
        map.updateMap(pacman.getX(), pacman.getY());
        
        //System.out.println(score);
        //map
        //player
        //todos os ghosts
    }
    
    
    private void render () {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        
        
        //drawBackground(g); //dont make sense
        
        //drawmap
        map.drawMaze(g);
        pacman.drawPacMan(g);
        //Pacman.drawPacman(g);
        
        g.dispose();
        buffer.show();
    }
    
    
    private void drawBackground (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
    
    

    @Override
    public void run() {
        this.requestFocus();
        int FPS = 60;
        int UPS = 5;
        double updateTime = 1000000000/FPS; //a cada updateTime ns terá a att
        double UupdateTime = 1000000000/UPS;
        double uDelta = 0;
        double fDelta = 0;
        long lastTime = System.nanoTime();
        long uLastTime = System.nanoTime();
        int currentFPS = 0;
        long secondTime = System.currentTimeMillis();
       
        while (running) {
            long currentTime = System.nanoTime();
            fDelta += (currentTime - lastTime);
            lastTime = currentTime;
            if (fDelta >= updateTime) {
                
                fDelta -= updateTime;
                
                render();
                //update();
                
                currentFPS++;
               
            }
            
            
            long uCurrentTime = System.nanoTime();
            uDelta+= (uCurrentTime - uLastTime);
            uLastTime = uCurrentTime;
                    if (uDelta >= UupdateTime) {
                        uDelta -= UupdateTime;
                        update();
                    }
            
            
            
            if (System.currentTimeMillis() - secondTime >= 1000) {
                //System.out.println(currentFPS);
                secondTime += 1000;
                currentFPS = 0;
            }
                    
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pacman.setOld_direction(pacman.getDirection());
        switch (key) {
            case KeyEvent.VK_W:
                pacman.setDirection("up");
                pacman.setDlt(-1);
                //System.out.println(pacman.getDlt());
                break;
            case KeyEvent.VK_S:
                pacman.setDlt(1);
                pacman.setDirection("down");
                break;
            case KeyEvent.VK_D:
                pacman.setDlt(1);
                pacman.setDirection("right");
                break;
            case KeyEvent.VK_A:
                pacman.setDirection("left");
                pacman.setDlt(-1);
                break;
            
        }
        //System.out.println(pacman.getDirection());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    
    /*public int getScore () {
        return this.score;
    }
    
    public void setScore () {
        this.score++;
    }*/
  
    
    
}
