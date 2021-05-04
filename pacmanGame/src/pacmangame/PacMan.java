
package pacmangame;

import java.awt.Color;
import java.awt.Graphics;


public class PacMan {
    private int x;
    private int y;
    //double x, y;
    private int dlt;
    private String direction;
    private String old_direction;
    
    private double velocity = 0.1f;
    
    
    /*public PacMan (double x, double y) {
        this.x = x;
        this.y = y;
        this.dlt = 0;
        this.direction = "none";
    }*/
    
    public PacMan (int x, int y) {
        this.x = x;
        this.y = y;
        this.dlt = 0;
        this.direction = "none";
    }
    
    
    public void drawPacMan (Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)this.x * GameEngine.TILE_SIZE, (int)this.y * GameEngine.TILE_SIZE, 
                   GameEngine.TILE_SIZE, 
                   GameEngine.TILE_SIZE);
        
    }

    
    public void updatePacMan (Map0 map) {
        
        //check if the next position is free
        //this.old_direction = this.direction;
           switch (this.direction) {
            case "up":
                if(!map.colisionCheck(this.x, this.y - 1)) 
                    this.y--;
                else
                    this.direction = this.old_direction;
                break;
            case "down":
                if(!map.colisionCheck(this.x, this.y + 1)) 
                    this.y++;
                else
                    this.direction = this.old_direction;
                break;
            case "right":
                if(!map.colisionCheck(this.x + 1, this.y)) {
                    this.x++; 
                }
                else
                    this.direction = this.old_direction;             
                break;
            case "left":
                if(!map.colisionCheck(this.x - 1, this.y)) 
                    this.x--;
                else
                    this.direction = this.old_direction;
                break;
                
            } 
 
           
}

    
   /* public void updatePacMan () {
        
        if ((this.y + this.dlt * velocity) > 0 && (this.y + this.dlt * velocity) < 20 &&
            (this.x +  this.dlt * velocity) > 0 && (this.x + this.dlt * velocity) < 30) {
            switch (this.direction) {
            case "up":
                this.y+= this.dlt * velocity;
                break;
            case "down":
                this.y+= this.dlt * velocity;
                break;
            case "right":
                this.x+= this.dlt * velocity;                                 
                break;
            case "left":
                this.x+= this.dlt * velocity;
                break;
             default:
                 this.direction = "none";
                 this.dlt = 0;
                break;
            } 
        }
        else {
            this.direction = "none";
            this.dlt = 0;
        }

    }*/
    
/*    public void updatePacMan (Map map) {
        if (!map.colisionCheck(this.x + this.dlt * velocity, this.y + this.dlt * velocity)) {
            switch (this.direction) {
            case "up":
                this.y+= this.dlt * velocity;
                break;
            case "down":
                this.y+= this.dlt * velocity;
                break;
            case "right":
                this.x+= this.dlt * velocity;                                 
                break;
            case "left":
                this.x+= this.dlt * velocity;
                break;
             default:
                 this.direction = "none";
                 this.dlt = 0;
                break;
            } 
        }
        else {
            this.direction = "none";
            this.dlt = 0;
        }
    }
        
   */
    
    
    
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    
    
    public void setOld_direction (String direction){
        this.old_direction = direction;
    }
    
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setDlt (int value) {
        this.dlt = value;
    }
    public int getDlt () {
        return this.dlt;
    }
    
}
