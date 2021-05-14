
package pacmangame.entity;

import javax.swing.ImageIcon;
import pacmangame.GameEngine;
import pacmangame.Map;


public class Blinky extends Ghost {
    
    public Blinky(int y, int x) {
        super(y, x);
        this.canOut = true;
        loadImagesPrivate();
    }
    
    
    private void loadImagesPrivate () {
        
        ghostImage[0] = new ImageIcon("images/Ghost/Blinky/blinky_default.png").getImage(); //stand by
        ghostImage[1] = new ImageIcon("images/Ghost/Blinky/blinky_right.png").getImage();
        ghostImage[2] = new ImageIcon("images/Ghost/Blinky/blinky_left.png").getImage();
        ghostImage[3] = new ImageIcon("images/Ghost/Blinky/blinky_up.png").getImage();
        ghostImage[4] = new ImageIcon("images/Ghost/Blinky/blinky_down.png").getImage();
    }
    
    @Override
    public void chase (Map map, Pacman pacman) {
        this.target_y = pacman.getY() / GameEngine.TILE_SIZE;
        this.target_x = pacman.getX() / GameEngine.TILE_SIZE;
        
    }
    
}
