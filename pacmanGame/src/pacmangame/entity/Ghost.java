/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import pacmangame.GameEngine;
import pacmangame.Map;

/**
 *
 * @author Cass.Nero
 */
public class Ghost extends Entity {
    protected Image [] ghostImage;
    //Image [] scaredImage;
    protected  int ghostImageIdx;
    protected  int scaredImageIdx;
    
    protected  int [] targetPosition; //define wich the current target
    protected  int [] previousPosition;
    protected  int target_x, target_y;
    
    protected  boolean eaten;
    protected  String currentMode; //scatter,chaser,scared, eaten
    
    protected String image_path;
   
    
        //constructor
    public Ghost (int y, int x, String image_path) {
        this.y = y * GameEngine.TILE_SIZE;
        this.x = x * GameEngine.TILE_SIZE;   
        this.velocity = 2;
        this.direction = "none";
        this.next_direction = "none";
        this.eaten = false;
        
        ghostImage = new Image[11];
        //scaredImage = new Image[6];
        ghostImageIdx = 0;
        scaredImageIdx = 0;
        
        this.image_path = image_path;
        
        //the target vector
       // targetPosition = new int[]{18,18}; //y,x
        //previousPosition = new int[] {this.y/30, this.x/30};
        
        this.currentMode = "scatter";
        
      //  this.target_y = 18;
      //  this.target_x = 18;
        
        loadImages();    
        
    }
    
    @Override
    protected void loadImages() {
        ghostImage[0] = new ImageIcon("images/Blinky/" + this.image_path + "_default.png").getImage(); //stand by
        ghostImage[1] = new ImageIcon("images/Blinky/"+ this.image_path + "_right.png").getImage();
        ghostImage[2] = new ImageIcon("images/Blinky/" + this.image_path + "_left.png").getImage();
        ghostImage[3] = new ImageIcon("images/Blinky/"+  this.image_path + "_up.png").getImage();
        ghostImage[4] = new ImageIcon("images/Blinky/" + this.image_path + "_down.png").getImage();
        ghostImage[5] = new ImageIcon("images/Ghost/eyes_right.gif").getImage();
        ghostImage[6] = new ImageIcon("images/Ghost/eyes_left.gif").getImage();
        ghostImage[7] = new ImageIcon("images/Ghost/eyes_up.gif").getImage();
        ghostImage[8] = new ImageIcon("images/Ghost/eyes_down.gif").getImage();
        ghostImage[9] = new ImageIcon("images/Ghost/ghost_eaten.gif").getImage();
        ghostImage[10] = new ImageIcon("images/Ghost/ghost_vulnerable.gif").getImage();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        //g.fillRect(this.x, this.y, GameEngine.TILE_SIZE, GameEngine.TILE_SIZE);
        //g.setColor(Color.ORANGE);
        //g.fillRect(targetPosition[1] * 30, targetPosition[0] * 30, GameEngine.TILE_SIZE, GameEngine.TILE_SIZE);
       
        
        /*if (this.currentMode.equals("scared")) {
            g.drawImage(this.scaredImage[4], this.x, this.y, null);
        }
        else if (this.currentMode.equals("eaten")) {
            g.drawImage(this.scaredImage[this.ghostImageIdx -1], this.x, this.y, null);
        }
        else {
            g.drawImage(this.ghostImage[this.ghostImageIdx], this.x, this.y, null);
        }*/
        g.drawImage(this.ghostImage[this.ghostImageIdx], this.x, this.y, null);
        
        //Rectangle gh = new Rectangle(this.x, this.y, 30, 30);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(this.hitbox);
    }
    
    
    
    protected void findPath (Map map) {
        //System.out.println("entrou path");
        //instaciate the aux variables
        int [][] position = {{1,0},{0,-1},{0,1},{-1,0}};
        
        Node current = new Node (this.y/GameEngine.TILE_SIZE, this.x/GameEngine.TILE_SIZE); //current position
        Node target = new Node (this.target_y, this.target_x);
        
        ArrayList <Node> node = new ArrayList();
        ArrayList <Node> visited = new ArrayList();
        node.add(current);
        visited.add(current);
       
        ArrayList <String> path = new ArrayList(); //array that keep the final path
        String currentPath = "";
        String newCurrentPath = "";
        path.add(currentPath);
        
        boolean find = false;
        boolean notEqual;
        
        // Bredth first search
        while (!find) {
            if (node.size() > 0) {
                current = node.get(0); //get the first element
                node.remove(0); //remove the first element
            }
            else {
                System.out.println(map.screenData[this.y /30 * this.x /30 + 30]);
                System.out.println("erro ta aqui 1");
                break;
            }

            if (path.size() > 0) {
                currentPath = path.get(0);
                path.remove(0);
            }else {
                System.out.println(map.screenData[this.y /30 * this.x /30 + 30]);
                System.out.println("erro ta aqui 2");
                break;
            }
            
            //System.out.println("passou do erro");
            
            //check if find the target
            if (current.getY() == target.getY() && current.getX() == target.getX()) {
                find = true;
             }
            
            //loop the cover all positions (4)
            for (int i = 0; i < position.length; i++) {
                int pos = current.getY() * GameEngine.MAZE_SIZE_X + current.getX();
                //check if the position is valid
                if (current.getY() + position[i][0] >= 0 && current.getY() + position[i][0] < GameEngine.MAZE_SIZE_Y
                    && current.getX() + position[i][0] >= 0 && current.getX() + position[i][0] < GameEngine.MAZE_SIZE_X
                    && map.screenData[pos] == 0 || map.screenData[pos] == 1 || map.screenData[pos] == 28) {
                    
                    //creat a aux node that contain the next position
                    Node newNode = new Node(current.getY() + position[i][0],current.getX() + position[i][1]);                     
                    notEqual = false;
                    
                    //check if the new position was not visited 
                    for (int j = 0; j < visited.size(); j++) {
                        if (newNode.getY() == visited.get(j).getY() && newNode.getX() == visited.get(j).getX()) {
                            notEqual = true;
                            break;
                        }
                    }
                    if(!notEqual) {
                        visited.add(newNode); //add the position as visited
                        node.add(newNode); //add the new position to the main node
                        
                        //building the string path
                        if (i == 0) {
                            path.add(currentPath.concat("D"));
                            newCurrentPath = currentPath.concat("D");
                        }
                        else if(i == 1) {
                            path.add(currentPath.concat("L"));
                            newCurrentPath = currentPath.concat("L");
                        }else if (i == 2){
                            path.add(currentPath.concat("R")); 
                            newCurrentPath = currentPath.concat("R");
                        }else if (i == 3){
                            path.add(currentPath.concat("U"));
                            newCurrentPath = currentPath.concat("U");
                        }
                        
                        
                      /*  //cehck if the next position
                        if (newNode.getY() == target.getY() && newNode.getX() == target.getX()) {
                            currentPath = newCurrentPath;
                            find = true;
                            break;
                        }*/
                        
                    }
                    
                }
            }
            
        }
        //if the path is bigger thant 0, then the ghost is not stopped
        if (currentPath.length() > 0){
            //define the frist position of the path to real the next postion
            switch (currentPath.charAt(0)) {
            case 'U':
                this.direction = "up";
                break;
            case 'D':
                this.direction = "down";
                break;
            case 'R':
                this.direction = "right";
                break;
            case 'L':
                this.direction = "left";
                break;
            default:
                this.direction = "none";
            }
        }
        else {
            this.direction = "none";
        }
        //System.out.println("saiu path");    
        
    }
    
    
    protected void randomPosition (Map map,Pacman pacman,int max_y, int min_y, int max_x, int min_x) {
        int x, y;
            while (true) {
                y = (int)((Math.random() * max_y - min_y) + min_y);
                x = (int)((Math.random() * max_x - min_x) + min_x);
                if (map.screenData[(y * GameEngine.TILE_SIZE) + x] == 0 
                   || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 1
                   || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 28)
                    break;
            }
        
        this.target_y = y;
        this.target_x = x;
      
        //System.out.println(this.target_y + " " + this.target_x);
        
    }
    
    protected void justRun (Map map,Pacman pacman) {
        int x, y;
        
        while (true) {
            y = (int)((Math.random() * 19 - 1) + 1);
            x = (int)((Math.random() * 29 - 1) + 1);
            
            double distance = Math.sqrt(Math.pow(pacman.getY()/ GameEngine.TILE_SIZE - y, 2) 
                              + Math.pow(pacman.getX()/ GameEngine.TILE_SIZE  - x, 2));
                    
            if ((map.screenData[(y * GameEngine.TILE_SIZE) + x] == 0 
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 1
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 28)
                && distance > 10) {
                break;
            }
        }
        this.target_y = y;
        this.target_x = x;
        
    }
    
 
    
    public void updateMovement (Map map, Pacman pacman, int targetY, int targetX) {
         
        //check if the current position is valid to change
            if(this.x %GameEngine.TILE_SIZE == 0 && this.y % GameEngine.TILE_SIZE == 0){
                this.velocity = 2;
                //if in chase mode, go for the player
                if (this.currentMode.equals("chaser")) {
                    this.target_y = targetY;
                    this.target_x = targetX;
                    
                    
                   findPath(map);
                }
                //generate the randon target to go for
                else if (this.currentMode.equals("scatter")) {
                    this.velocity = 2;
                    if (!(GameEngine.timerEvent > 0 && GameEngine.timerEvent < 10000)
                        || this.direction.equals("none")) {
                        this.randomPosition(map, pacman,GameEngine.MAZE_SIZE_Y-1, 1, GameEngine.MAZE_SIZE_X-1, 1);
                        this.velocity = 2;
                    }
                    findPath(map);
                }
                else if (this.currentMode.equals("scared")) {
                    this.velocity = 1;
                    //this.direction = "none";
                    double distance = Math.sqrt(Math.pow(pacman.getY()/ GameEngine.TILE_SIZE - this.y / GameEngine.TILE_SIZE  , 2) 
                              + Math.pow(pacman.getX()/ GameEngine.TILE_SIZE  - this.x / GameEngine.TILE_SIZE , 2));
                    if (!(GameEngine.scaredTimer > 0 && GameEngine.scaredTimer < 10000)
                       || this.direction.equals("none") || distance < 10) {
                        //System.out.println("entrou");
                        this.justRun(map, pacman);
                        
                    }
                    findPath(map);
                }
                //mudanã
                else if (this.currentMode.equals("eaten") && !map.isHome(this.y / GameEngine.TILE_SIZE, this.x / GameEngine.TILE_SIZE)) {
                    this.velocity = 5;
                    for (int i = 0;i  < map.ghostHome.length; i++) {
                        if (map.screenData[map.ghostHome[i][0] * GameEngine.TILE_SIZE + map.ghostHome[i][1]] == 0) {
                            this.target_y = map.ghostHome[i][0];
                            this.target_x = map.ghostHome[i][1];
                        }
                    }
                        
                    findPath(map);
                        
                }else if (this.currentMode.equals("eaten") && !map.isHome(this.y / GameEngine.TILE_SIZE, this.x / GameEngine.TILE_SIZE)) {
                    findPath(map);
                }
                else if (this.currentMode.equals("eaten") && map.isHome(this.y / GameEngine.TILE_SIZE, this.x / GameEngine.TILE_SIZE)) {
                    //this.currentMode = "scatter";
                    this.currentMode = GameEngine.oldGhostMode;
                }
                
                /*
                else if (this.eaten == true) {
                    if (this.target_y != map.ghostHome[0][0] && this.target_x != map.ghostHome[0][1]
                        || this.target_y != map.ghostHome[1][0] && this.target_x != map.ghostHome[1][1]) {
                        if (map.screenData[map.ghostHome[0][0] * GameEngine.TILE_SIZE + map.ghostHome[0][1]] == 0) {
                            this.target_y = map.ghostHome[0][0];
                            this.target_x = map.ghostHome[0][1];
                            
                        }else if (map.screenData[map.ghostHome[1][0] * GameEngine.TILE_SIZE + map.ghostHome[1][1]] == 0) {
                            this.target_y = map.ghostHome[0][0];
                            this.target_x = map.ghostHome[0][1];
                        }
                        findPath(map);
                    }
                    else if (this.y/30 != map.ghostHome[0][0] && this.x/30 != map.ghostHome[0][1]
                        || this.y/30 != map.ghostHome[1][0] && this.x/30 != map.ghostHome[1][1]) {
                        this.eaten = false;
                        GameEngine.ghostMode = "scatter";
                    }
                }*/
                    
                
               //findPath(map); //calls the method the will find the path

            }
            //findPath(map);
            
        /*if(this.x %GameEngine.TILE_SIZE == 0 && this.y % GameEngine.TILE_SIZE == 0) {
            this.target_y = pacman.getY() / GameEngine.TILE_SIZE;
            this.target_x = pacman.getX() / GameEngine.TILE_SIZE;
            findPath(map); //calls the method the will find the path
        }*/
       
        
        //if the current positions is not valid or
        //if it is, update the movement
        
        //System.out.println(this.direction);
        //System.out.println(map.screenData[this.y /30 * this.x /30 + 30]);
        switch (this.direction) {
                    case "up":
                        this.y-=velocity;
                        //this.ghostImageIdx = 3;
                        this.dx = 0;
                        this.dy = -1;
                        
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 3;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 7;       
                        break;
                    case "down":
                        this.y+=velocity;
                        //this.ghostImageIdx = 4;
                        this.dx = 0;
                        this.dy = 1;
                        
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 4;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 8;   
                        break;
                    case "right":
                        this.x+=velocity;
                        //this.ghostImageIdx = 1;
                        this.dx = 1;
                        this.dy = 0;
                        
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 1;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 5;  
                        break;
                    case "left":
                        this.x-=velocity;
                        //this.ghostImageIdx = 2;
                        this.dx = -1;
                        this.dy = 0;
                        
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 2;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 6;  
                        break;
                    default:
                        this.direction = "none";
                        this.ghostImageIdx = 0;
                        this.dx = 0;
                        this.dy = 0;
        }
        
        if (this.currentMode.equals("scared") && GameEngine.scaredTimer > 7000)
            this.ghostImageIdx = 10;
        else if (this.currentMode.equals("scared"))
            this.ghostImageIdx = 9;
            
        
        //checa se a proxima posicao é valida
              if(this.x%GameEngine.TILE_SIZE == 0 && this.y% GameEngine.TILE_SIZE ==0){
                  int pos = (this.x + (GameEngine.TILE_SIZE * this.dx)) /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)((this.y+ (GameEngine.TILE_SIZE * this.dy))/GameEngine.TILE_SIZE);
                  //se nao for valida, a posicao é nula
                  if(map.screenData[pos] != 0 && map.screenData[pos] != 1 && map.screenData[pos] != 28)
                    this.direction = "none";
              }
         //upate the hitbox
        this.hitbox = new Rectangle (this.x, this.y, GameEngine.TILE_SIZE,GameEngine.TILE_SIZE);
        
        
       /* if (pacman.getX() == this.x && pacman.getY() == this.y
                || pacman.getX() / GameEngine.TILE_SIZE == this.x / GameEngine.TILE_SIZE && pacman.getY() / GameEngine.TILE_SIZE == this.y / GameEngine.TILE_SIZE
                || pacman.getX() / GameEngine.TILE_SIZE == this.x && pacman.getY() / GameEngine.TILE_SIZE == this.y
                || pacman.getX() == this.x / GameEngine.TILE_SIZE && pacman.getY() == this.y / GameEngine.TILE_SIZE)
                    GameEngine.running = false;*/
        
       /*if (this.x + GameEngine.TILE_SIZE == pacman.getX() && this.y + GameEngine.TILE_SIZE == pacman.getY()
          || pacman.getX() + GameEngine.TILE_SIZE == this.x &&  pacman.getY() + GameEngine.TILE_SIZE == this.y
          )
           GameEngine.running = false;*/
      // System.out.println("saiu update");
       
    }
    
        //getters and setters

    public int getTarget_x() {
        return target_x;
    }

    public void setTarget_x(int target_x) {
        this.target_x = target_x;
    }

    public int getTarget_y() {
        return target_y;
    }

    public void setTarget_y(int target_y) {
        this.target_y = target_y;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }
    
    
}
