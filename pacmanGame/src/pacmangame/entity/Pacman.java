
package pacmangame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import pacmangame.GameEngine;
import pacmangame.Map;


public class Pacman extends Entity {
    Image [] pacmanImage;
    private int pacmanImageIdx; //idx of array of images
    
    public int lives;
    
    //constructor
    public Pacman (int y, int x) {
        this.y = y * GameEngine.TILE_SIZE;
        this.x = x * GameEngine.TILE_SIZE;
        this.hitbox = new Rectangle (this.x, this.y, GameEngine.TILE_SIZE,GameEngine.TILE_SIZE);
        this.velocity = 2;
        this.direction = "none";
        this.next_direction = "none";
        this.pacmanImageIdx = 0;
        pacmanImage = new Image[6];
        
        this.lives = 3;
        loadImages();
        
    }
    
    
    @Override
    protected void loadImages() {
        pacmanImage[0] = new ImageIcon("images/pacman/pacman.gif").getImage(); //stand by
        pacmanImage[1] = new ImageIcon("images/pacman/pacman_dying.gif").getImage();
        pacmanImage[2] = new ImageIcon("images/pacman/pacman_right.gif").getImage();
        pacmanImage[3] = new ImageIcon("images/pacman/pacman_left.gif").getImage();
        pacmanImage[4] = new ImageIcon("images/pacman/pacman_up.gif").getImage();
        pacmanImage[5] = new ImageIcon("images/pacman/pacman_down.gif").getImage();
    }

    
    public void updateMovement(Map map) {
        //verifica se a mudanca de direcao eh valida
      if(this.x %GameEngine.TILE_SIZE == 0 && this.y % GameEngine.TILE_SIZE == 0 && this.next_direction != this.direction){
             int pos = (this.x + (GameEngine.TILE_SIZE * this.req_x)) /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)((this.y+ (GameEngine.TILE_SIZE * this.req_y))/GameEngine.TILE_SIZE);
             //System.out.println(pos);
             //System.out.println((map.isHome(((this.x + (GameEngine.TILE_SIZE * this.req_x)) /GameEngine.TILE_SIZE), ((this.y+ (GameEngine.TILE_SIZE * this.req_y))/GameEngine.TILE_SIZE))));
             if(map.screenData[pos] == 0 || map.screenData[pos]== 63 || map.screenData[pos] == 64) {
                   this.direction = this.next_direction;
                   //this.next_direction = "none";
             }//else this.next_direction = "none";
             
      }
          //determina a proxima direcao do pacman
          switch (this.direction) {
                    case "up":
                        this.dx = 0;
                        this.dy = -1;
                        this.pacmanImageIdx = 4;
                        break;
                    case "down":
                        this.dx = 0;
                        this.dy = 1;
                        this.pacmanImageIdx = 5;
                        break;
                    case "right":
                        this.dx = 1;
                        this.dy = 0;
                        this.pacmanImageIdx = 2;
                        break;
                    case "left":
                        this.dx = -1;
                        this.dy = 0;
                        this.pacmanImageIdx = 3;
                        break;
                    default:
                        this.direction = "none";
                        this.dx = 0;
                        this.dy = 0;
                        this.pacmanImageIdx = 0;
                }
              
              //faz com q o pacman ande de acordo coma  velocidade
              this.x+=this.dx * velocity;
              this.y+=this.dy * velocity;
              
              //checa se a proxima posicao é valida
              if(this.x%GameEngine.TILE_SIZE == 0 && this.y% GameEngine.TILE_SIZE ==0){
                  int pos = (this.x + (GameEngine.TILE_SIZE * this.dx)) /GameEngine.TILE_SIZE + GameEngine.TILE_SIZE * (int)((this.y+ (GameEngine.TILE_SIZE * this.dy))/GameEngine.TILE_SIZE);
                  //se nao for valida, a posicao é nula
                  if(map.screenData[pos] != 0 && map.screenData[pos] != 63 && map.screenData[pos] != 64)
                    this.direction = "none";
              }
              
          //update the hitbox    
         this.hitbox = new Rectangle (this.x + 10, this.y + 10, GameEngine.TILE_SIZE - 20 ,GameEngine.TILE_SIZE - 20);
              
    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
       //g.fillRect(this.x, this.y, GameEngine.TILE_SIZE, GameEngine.TILE_SIZE);
       g.drawImage(this.pacmanImage[this.pacmanImageIdx], this.x, this.y, null);
       //Rectangle pac = new Rectangle(this.x, this.y, 30, 30);
       Graphics2D g2d = (Graphics2D) g;
       g2d.draw(this.hitbox);
       
      // System.out.println(this.y/30 + " " + this.x/30);
        //System.out.println(this.y + " " + this.x + " " + this.y * 900 + this.x);
       //System.out.println(((this.y/30 * 30) + this.x/30) + " " + this.y/30 + " " + this.x/30);
        //System.out.println(this.x /30 + 30 * (int)(this.y/30));
    }

    
}
