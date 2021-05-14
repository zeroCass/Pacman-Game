
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


public class Ghost extends Entity {
    Image [] ghostImage;
    protected int ghostImageIdx;
    protected int target_x, target_y;//define wich the current target
    protected String currentMode; //scatter,chaser,scared, eaten
    protected boolean canOut;
   
    //constructor
    public Ghost (int y, int x) {
        this.y = y * GameEngine.TILE_SIZE;
        this.x = x * GameEngine.TILE_SIZE;   
        this.velocity = 2;
        this.direction = "none";
        this.next_direction = "none"; 
        ghostImage = new Image[11];
        ghostImageIdx = 0;
        this.canOut = false;
        this.hitbox = new Rectangle(this.x, this.y, GameEngine.TILE_SIZE,GameEngine.TILE_SIZE);     
        this.currentMode = "scatter";
        
        loadImages();
        
       
        
    }
    
    
    @Override
    protected void loadImages() {     
        ghostImage[5] = new ImageIcon("images/Ghost/eyes_right.gif").getImage();
        ghostImage[6] = new ImageIcon("images/Ghost/eyes_left.gif").getImage();
        ghostImage[7] = new ImageIcon("images/Ghost/eyes_up.gif").getImage();
        ghostImage[8] = new ImageIcon("images/Ghost/eyes_down.gif").getImage();
        ghostImage[9] = new ImageIcon("images/Ghost/ghost_eaten.gif").getImage();
        ghostImage[10] = new ImageIcon("images/Ghost/ghost_vulnerable.gif").getImage();
          
    }
    
    
    private void findPath (Map map) {
        
        //instaciate the aux variables
        int [][] position = {{1,0},{0,-1},{0,1},{-1,0}};
        
        Node current = new Node (this.y/GameEngine.TILE_SIZE, this.x/GameEngine.TILE_SIZE); //current position
        //Node target = new Node (this.target_y, this.target_x); //the target
        
        ArrayList <Node> node = new ArrayList();
        ArrayList <Node> visited = new ArrayList();
        node.add(current);
        visited.add(current);
       
        ArrayList <String> path = new ArrayList(); //array that keep the final path
        //init the lists
        String currentPath = "";
        String newCurrentPath = "";
        path.add(currentPath);
        
        boolean find = false;
        boolean notEqual;
        
        // Bredth first search
        while (!find) {
            //check if the path exists, if is not, break the loop
            if (node.size() > 0 && path.size() > 0) {
                current = node.get(0); //get the first element
                node.remove(0); //remove the first element
                
                currentPath = path.get(0);
                path.remove(0);
            }
            else {
                break;
            }

            
            //check if find the target
            if (current.getY() == this.target_y && current.getX() == this.target_x) {
                find = true;
             }
            
            //loop the cover all positions (4)
            for (int i = 0; i < position.length; i++) {
                int pos = current.getY() * GameEngine.MAZE_SIZE_X + current.getX();
                //check if the position is valid
                if (current.getY() + position[i][0] >= 0 && current.getY() + position[i][0] < GameEngine.MAZE_SIZE_Y
                    && current.getX() + position[i][0] >= 0 && current.getX() + position[i][0] < GameEngine.MAZE_SIZE_X
                    && map.screenData[pos] == 0 || map.screenData[pos] == 63 || map.screenData[pos] == 64 || map.screenData[pos] == 55) {
                    
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
                       
                        
                    }
                    
                }
            }
            
        }
        
        //if the path is bigger than 0, then the ghost is not stopped
        if (currentPath.length() > 0){
            //define the first position of the path to real the next postion
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
            
        
    }
    
    
    protected void randomPosition (Map map,Pacman pacman,int max_y, int min_y, int max_x, int min_x) {
        int x = this.x / GameEngine.TILE_SIZE, y = this.y / GameEngine.TILE_SIZE;
        boolean find = false;
            while (!find) {
                y = (int)((Math.random() * max_y - min_y) + min_y);
                x = (int)((Math.random() * max_x - min_x) + min_x);
                if (map.screenData[(y * GameEngine.TILE_SIZE) + x] == 0 
                   || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 64
                   || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 63
                   || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 55)
                    find = true;
            }
        
        this.target_y = y;
        this.target_x = x;
      
        //System.out.println(this.target_y + " " + this.target_x);
        
    }
    //this methed is just for the ghost get way for the pacman 
    private void justRun (Map map,Pacman pacman) {
        int x = this.x / GameEngine.TILE_SIZE, y = this.y / GameEngine.TILE_SIZE;
        boolean find = false;
        while (!find) {
            y = (int)((Math.random() * GameEngine.MAZE_SIZE_Y-1 - 1) + 1);
            x = (int)((Math.random() * GameEngine.MAZE_SIZE_X-1 - 1) + 1);
            
            double distance = Math.sqrt(Math.pow(pacman.getY()/ GameEngine.TILE_SIZE - y, 2) 
                              + Math.pow(pacman.getX()/ GameEngine.TILE_SIZE  - x, 2));
                    
            if ((map.screenData[(y * GameEngine.TILE_SIZE) + x] == 0 
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 63
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 64)
                && distance > 10) {
                find = true;
            }
        }
        this.target_y = y;
        this.target_x = x;
        
    }
    //this method variates in wich ghost type
    public void chase (Map mpa, Pacman pacman){
    }
    
    public void updateMovement (Map map, Pacman pacman) {
        //if is in home and cant move
        if (!this.canOut)
            return;
        
        //check if the current position is valid to change
            if(this.x %GameEngine.TILE_SIZE == 0 && this.y % GameEngine.TILE_SIZE == 0){
                this.velocity = 2;
                //if in chase mode, go for the player
                if (this.currentMode.equals("chaser")) {
                    chase(map,pacman);   
                    findPath(map);
                }
                //generate the randon target to go for if in scatter mode
                else if (this.currentMode.equals("scatter")) {
                    this.velocity = 2;
                    //check if the timer of Scatter event is over, if is not, update the movement
                    if (!(GameEngine.timerEvent > 0 && GameEngine.timerEvent < 10000)
                        || this.direction.equals("none")) {
                        this.randomPosition(map, pacman,GameEngine.MAZE_SIZE_Y-1, 1, GameEngine.MAZE_SIZE_X-1, 1);
                        this.velocity = 2;
                    }
                    findPath(map);
                }
                else if (this.currentMode.equals("scared")) {
                    this.velocity = 1; //decrese the velocity
                    //calculates the distance between pacman and the ghost
                    double distance = Math.sqrt(Math.pow(pacman.getY()/ GameEngine.TILE_SIZE - this.y / GameEngine.TILE_SIZE  , 2) 
                              + Math.pow(pacman.getX()/ GameEngine.TILE_SIZE  - this.x / GameEngine.TILE_SIZE , 2));
                    //check if the timer of Scatter event is over, if is not, update the movement
                    if (!(GameEngine.scaredTimer > 0 && GameEngine.scaredTimer < 10000)
                       || this.direction.equals("none") || distance < 10) {
                        this.justRun(map, pacman);  
                    }
                    findPath(map);
                }
                
                else if (this.currentMode.equals("eaten") && !map.isHome(this.y / GameEngine.TILE_SIZE, this.x / GameEngine.TILE_SIZE)) {
                    this.velocity = 5;
                    //check if exist one place in home that is free to mark as target
                    for (int i = 0; i < map.ghostHome.length; i++) {
                        if (map.screenData[map.ghostHome[i][0] * GameEngine.MAZE_SIZE_X + map.ghostHome[i][1]] == 0) {
                            this.target_y = map.ghostHome[i][0];
                            this.target_x = map.ghostHome[i][1];
                            break;
                        }
                    }  
                    findPath(map);
                        
                }
                //if the ghost is in home, change the current mode to the old ghost mode
                else if (this.currentMode.equals("eaten") && map.isHome(this.y / GameEngine.TILE_SIZE, this.x / GameEngine.TILE_SIZE)) {
                    this.currentMode = GameEngine.oldGhostMode;
                }
            }

        //updates movement according to direction
        switch (this.direction) {
                    case "up":
                        this.y-=velocity;
                        this.dx = 0;
                        this.dy = -1;
                        //choose the imageIdx according to current ghost mode
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 3;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 7;       
                        break;
                    case "down":
                        this.y+=velocity;
                        this.dx = 0;
                        this.dy = 1;
                        //choose the imageIdx according to current ghost mode
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 4;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 8;   
                        break;
                    case "right":
                        this.x+=velocity;
                        this.dx = 1;
                        this.dy = 0;
                        //choose the imageIdx according to current ghost mode
                        if (!this.currentMode.equals("eaten") && !this.currentMode.equals("scared"))
                            this.ghostImageIdx = 1;
                        else if (this.currentMode.equals("eaten"))
                            this.ghostImageIdx = 5;  
                        break;
                    case "left":
                        this.x-=velocity;
                        this.dx = -1;
                        this.dy = 0;
                        //choose the imageIdx according to current ghost mode
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
        //if the current mode is SCARED and scaredTimer is bigger than 7 sec, the image is blank
        if (this.currentMode.equals("scared") && GameEngine.scaredTimer > 7000)
            this.ghostImageIdx = 10;
        else if (this.currentMode.equals("scared"))
            this.ghostImageIdx = 9;
            
        
        //checa se a proxima posicao é valida
        //check if the next position is valid
              if(this.x%GameEngine.TILE_SIZE == 0 && this.y% GameEngine.TILE_SIZE ==0){
                  //int pos = (this.x + (GameEngine.TILE_SIZE * this.dx)) /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)((this.y+ (GameEngine.TILE_SIZE * this.dy))/GameEngine.TILE_SIZE);
                  int pos = (this.y+ (GameEngine.TILE_SIZE * this.dy))/GameEngine.TILE_SIZE * GameEngine.MAZE_SIZE_X + ((this.x + (GameEngine.TILE_SIZE * this.dx)) /GameEngine.TILE_SIZE);
                  //se nao for valida, a posicao é nula
                  if(map.screenData[pos] != 0 && map.screenData[pos] != 63 && map.screenData[pos] != 64 && map.screenData[pos] != 55)
                    this.direction = "none";
              }
            //update the hitbox
            this.hitbox = new Rectangle (this.x + 5, this.y + 5, GameEngine.TILE_SIZE - 10,GameEngine.TILE_SIZE - 10);
        
       
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
        //g2d.draw(this.hitbox);
    }
   
    //inused method until now
    private boolean isHome (Map map) {
        if (this.y / GameEngine.TILE_SIZE == map.ghostHome[0][0] && this.x / GameEngine.TILE_SIZE == map.ghostHome[0][1]
           || this.y / GameEngine.TILE_SIZE == map.ghostHome[1][0] && this.x / GameEngine.TILE_SIZE == map.ghostHome[1][1]) {
            //System.out.println("is home");
            return true;
            
        }
            
        return false;
    }
    
    
    //getters and setters

    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public boolean isCanOut() {
        return canOut;
    }

    public void setCanOut(boolean canOut) {
        this.canOut = canOut;
    }
 
    
}
