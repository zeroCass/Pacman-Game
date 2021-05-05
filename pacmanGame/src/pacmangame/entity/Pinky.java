
package pacmangame.entity;

import javax.swing.ImageIcon;
import pacmangame.GameEngine;
import pacmangame.Map;
import pacmangame.entity.Ghost;
import pacmangame.entity.Pacman;


public class Pinky extends Ghost {
    
    public Pinky(int y, int x) {
        super(y, x);
        loadImagesPrivate ();
    }
    
        private void loadImagesPrivate () {
        ghostImage[0] = new ImageIcon("images/Pinky/pinky_default.gif").getImage(); //stand by
        ghostImage[1] = new ImageIcon("images/Pinky/pinky_right.gif").getImage();
        ghostImage[2] = new ImageIcon("images/Pinky/pinky_left.gif").getImage();
        ghostImage[3] = new ImageIcon("images/Pinky/pinky_up.gif").getImage();
        ghostImage[4] = new ImageIcon("images/Pinky/pinky_down.gif").getImage();
    }
    
    @Override
    public void chase (Map map, Pacman pacman) {

       int y, x;
        if (pacman.getDirection().equals("up")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE) - 4;
            x = (pacman.getX() / GameEngine.TILE_SIZE) - 4;  
        }else if (pacman.getDirection().equals("down")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE) + 4;
            x = (pacman.getX() / GameEngine.TILE_SIZE);
        }else if (pacman.getDirection().equals("right")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE);
            x = (pacman.getX() / GameEngine.TILE_SIZE) + 4;
        }else if (pacman.getDirection().equals("left")) {
            y = (pacman.getY() / GameEngine.TILE_SIZE);
            x = (pacman.getX() / GameEngine.TILE_SIZE) - 4;
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
