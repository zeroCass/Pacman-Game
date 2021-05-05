
package pacmangame.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    //the coordinates values of pixels in screen
    protected int x;
    protected int y;
    
    //variables the contais the next(uncertain)
    protected int req_x; 
    protected int req_y;
    
    //variables that decide the next position(for sure)
    protected int dx;
    protected int dy;
    
    protected int velocity;
    protected String direction; //current position
    protected String next_direction; //the next position (able or not)
    
   public Rectangle hitbox; //variable for check colisions
    
    //basic constructor
    public Entity() {
    }
    
    
    protected abstract void loadImages ();
    public void updateMovement () {}
    public abstract void render (Graphics g);
    
    
    
    //getters and setters
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.next_direction = direction;
    }

    
    public int getX() {
        return (int)x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return (int)y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getReq_x() {
        return req_x;
    }

    public void setReq_x(int req_x) {
        this.req_x = req_x;
    }

    public int getReq_y() {
        return req_y;
    }

    public void setReq_y(int req_y) {
        this.req_y = req_y;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    
    
}

