
package pacmangame.entity;

import javax.swing.ImageIcon;
import pacmangame.GameEngine;
import pacmangame.Map;

public class Blinky extends Ghost {
    
    public Blinky(int y, int x) {
        super(y, x);
        loadImagesPrivate();
    }
    
    
    //@Override
    private void loadImagesPrivate () {
        ghostImage[0] = new ImageIcon("images/Blinky/blinky_default.gif").getImage(); //stand by
        ghostImage[1] = new ImageIcon("images/Blinky/blinky_right.gif").getImage();
        ghostImage[2] = new ImageIcon("images/Blinky/blinky_left.gif").getImage();
        ghostImage[3] = new ImageIcon("images/Blinky/blinky_up.gif").getImage();
        ghostImage[4] = new ImageIcon("images/Blinky/blinky_down.gif").getImage();
    }
    
    @Override
    public void chase (Map map, Pacman pacman) {
        //System.out.println("entrou teste aqui");
        /*int x, y;
        
        while (true) {
            y = (int)((Math.random() * 2 - (-2)) + (-2));
            x = (int)((Math.random() * 2 - (-2)) + (-2));
            x += pacman.getX()/30;
            y += pacman.getY()/30;

                    
            if ((map.screenData[(y * GameEngine.TILE_SIZE) + x] == 0 
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 63
                || map.screenData[(y * GameEngine.TILE_SIZE) + x] == 64)) {
                break;
            }
        }
        this.target_y = y;
        this.target_x = x;*/
       int y, x;
        if (pacman.getDirection().equals("up")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE) - 2;
            x = (pacman.getX() / GameEngine.TILE_SIZE) - 2;  
        }else if (pacman.getDirection().equals("down")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE) + 2;
            x = (pacman.getX() / GameEngine.TILE_SIZE);
        }else if (pacman.getDirection().equals("right")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE);
            x = (pacman.getX() / GameEngine.TILE_SIZE) + 2;
        }else if (pacman.getDirection().equals("left")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE);
            x = (pacman.getX() / GameEngine.TILE_SIZE) - 2;
        }else {
            y = (pacman.getY() / GameEngine.TILE_SIZE);
            x = (pacman.getX() / GameEngine.TILE_SIZE);
        }
        
        if (x > 0 && x < GameEngine.MAZE_SIZE_X && y > 0 && y < GameEngine.MAZE_SIZE_Y 
            &&(map.screenData[y * GameEngine.MAZE_SIZE_X + x] == 0 
            || map.screenData[y * GameEngine.MAZE_SIZE_X + x] == 1
            || map.screenData[y * GameEngine.MAZE_SIZE_X + x] == 63
            || map.screenData[y * GameEngine.MAZE_SIZE_X + x] == 64)) {
            this.target_y = y;
            this.target_x = x;
        }
        
        
    }   
        
        
    
    
}
