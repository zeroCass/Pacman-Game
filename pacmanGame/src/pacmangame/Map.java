
package pacmangame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Map {
   private final int sizeX;
   private final int sizeY;
    
   
    private Image [] mapImages;
    
    
    private int map[];
    public int numPills; //number of pills in the maze
    public int screenData[]; //aux array of the map
    public int [][] ghostHome = {{9,13},{9,14},{9,15}};
    
    //constructor
    public Map() {
            this.sizeY = GameEngine.MAZE_SIZE_Y;//this is the map lenght in X coord
            this.sizeX = GameEngine.MAZE_SIZE_X; //this is the map lenght in X coord

               map = new int [] {
                    1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,10, 9,11, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3,
                    8,46,45,45,45,45,45,45,45,45,45,45,45,45,12,45,45,45,45,45,45,45,45,45,45,45,45,45,46, 4,
                    8,45,22,17,17,18,45,22,17,17,17,17,18,45,13,45,22,17,17,17,17,18,45,22,17,17,17,18,45, 4,
                    8,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45,45, 4,
                    8,45,22,17,29,17,18,45,45,45,27,45,22,17,29,17,18,45,28,17,18,45,22,17,29,17,17,18,45, 4,
                    8,45,45,45,12,45,45,45,45,45,12,45,45,45,12,45,45,45,12,45,45,45,45,45,12,45,45,45,45, 4,
                    8,45,27,45,12,45,28,17,32,45,31,17,18,45,13,45,22,17,33,45,27,45,27,45,13,45,28,18,45, 4,
                    8,45,12,45,12,45,12, 0,12,45,12, 0, 0, 0, 0, 0, 0, 0,12,45,12,45,12,45,45,45,26,32,45, 4,
                    8,45,12,45,12,45,12, 0,12,45,13, 0,35,36,37,38,39, 0,13,45,26,17,30,45,27,45,45,13,45, 4,
                    8,45,13,45,13,45,31,17,30,45,45, 0,44, 0, 0, 0,40, 0,45,45,45,45,45,45,31,32,45,45,45, 4,
                    8,45,45,45,45,45,12,45,45,45,27, 0,43,42,42,42,41, 0,27,45,28,17,18,45,12,26,32,45,45, 4,
                    8,45,22,32,45,45,13,45,27,45,12, 0, 0, 0, 0, 0, 0, 0,12,45,12,45,45,45,12,45,12,45,45, 4,
                    8,45,45,31,18,45,45,45,12,45,13,45,22,17,29,17,18,45,13,45,12,45,22,17,30,45,26,18,45, 4,
                    16,45,45,12,45,45,22,17,33,45,45,45,45,45,13,45,45,45,45,45,13,45,45,45,45,45,45,45,45,24,
                    14,18,45,12,45,45,45,45,26,18,45,27,45,45, 0,45,45,27,45,45,45,45,22,32,45,28,17,17,17,23,
                    15,45,45,26,18,45,27,45,45,45,45,12,45,22,29,18,45,12,45,27,45,45,45,12,45,12,45,45,45,25,
                    8,45,45,45,45,45,12,45,45,45,45,12,45,45,12,45,45,12,45,12,45,45,45,12,45,12,46,27,45, 4,
                    8,45,22,17,17,17,34,17,17,18,45,13,45,45,13,45,45,26,17,34,17,18,45,12,45,26,17,30,45, 4,
                    8,46,45,45,45,45,45,45,45,45,45,45,45,45,46,45,45,45,45,45,45,45,45,12,45,45,45,45,45, 4,
                    7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,21,19,20, 6, 6, 6, 6, 5,
               };
                         
            screenData = new int [this.sizeX * this.sizeY];
            for(int i = 0; i < (this.sizeX * this.sizeY);i++) {
                screenData[i] = map[i];
                //checks the amount of pills 
                if (map[i] == 45 || map[i] == 46)
                    numPills++; //increase the number of pills
            }
            
            loadMapImages();         
    }
       
    //this method load the image of map
    public void loadMapImages () {

        mapImages = new Image[47];
	
        mapImages[0] = new ImageIcon("images/mapa/00.jpg").getImage();
	mapImages[1] = new ImageIcon("images/mapa/01.png").getImage();
        mapImages[2] = new ImageIcon("images/mapa/02.png").getImage();
        mapImages[3] = new ImageIcon("images/mapa/03.png").getImage();
        mapImages[4] = new ImageIcon("images/mapa/04.png").getImage();
        mapImages[5] = new ImageIcon("images/mapa/05.png").getImage();
        mapImages[6] = new ImageIcon("images/mapa/06.png").getImage();
        mapImages[7] = new ImageIcon("images/mapa/07.png").getImage();
        mapImages[8] = new ImageIcon("images/mapa/08.png").getImage();
        mapImages[9] = new ImageIcon("images/mapa/09.png").getImage();
        mapImages[10] = new ImageIcon("images/mapa/10.png").getImage();
        mapImages[11] = new ImageIcon("images/mapa/11.png").getImage();
        mapImages[12] = new ImageIcon("images/mapa/12.png").getImage();
        mapImages[13] = new ImageIcon("images/mapa/13.png").getImage();
        mapImages[14] = new ImageIcon("images/mapa/14.png").getImage(); 
        mapImages[15] = new ImageIcon("images/mapa/15.png").getImage();
        mapImages[16] = new ImageIcon("images/mapa/16.png").getImage();
        mapImages[17] = new ImageIcon("images/mapa/17.png").getImage();
        mapImages[18] = new ImageIcon("images/mapa/18.png").getImage();
        mapImages[19] = new ImageIcon("images/mapa/19.png").getImage();
        mapImages[20] = new ImageIcon("images/mapa/20.png").getImage();
        mapImages[21] = new ImageIcon("images/mapa/21.png").getImage();
        mapImages[22] = new ImageIcon("images/mapa/22.png").getImage();
        mapImages[23] = new ImageIcon("images/mapa/23.png").getImage();
        mapImages[24] = new ImageIcon("images/mapa/24.png").getImage();
        mapImages[25] = new ImageIcon("images/mapa/25.png").getImage();
        mapImages[26] = new ImageIcon("images/mapa/26.png").getImage();
        mapImages[27] = new ImageIcon("images/mapa/27.png").getImage();
        mapImages[28] = new ImageIcon("images/mapa/28.png").getImage();
        mapImages[29] = new ImageIcon("images/mapa/29.jpg").getImage(); 
        mapImages[30] = new ImageIcon("images/mapa/30.png").getImage();
        mapImages[31] = new ImageIcon("images/mapa/31.jpg").getImage();
        mapImages[32] = new ImageIcon("images/mapa/32.png").getImage();
        mapImages[33] = new ImageIcon("images/mapa/33.jpg").getImage();
        mapImages[34] = new ImageIcon("images/mapa/34.jpg").getImage();
        mapImages[35] = new ImageIcon("images/mapa/35.png").getImage();
        mapImages[36] = new ImageIcon("images/mapa/36.png").getImage();
        mapImages[37] = new ImageIcon("images/mapa/37.png").getImage();
        mapImages[38] = new ImageIcon("images/mapa/38.png").getImage();
        mapImages[39] = new ImageIcon("images/mapa/39.png").getImage();
        mapImages[40] = new ImageIcon("images/mapa/40.png").getImage();
        mapImages[41] = new ImageIcon("images/mapa/41.png").getImage();
        mapImages[42] = new ImageIcon("images/mapa/42.png").getImage();
        mapImages[43] = new ImageIcon("images/mapa/43.png").getImage();
        mapImages[44] = new ImageIcon("images/mapa/44.png").getImage(); 
        mapImages[45] = new ImageIcon("images/mapa/45.gif").getImage();
        mapImages[46] = new ImageIcon("images/mapa/46.gif").getImage();  
    }
    
    
    
    public void drawMaze (Graphics g) {
        
        int i = 0;
        for (int y = 0; y < GameEngine.SCREEN_HEIGHT; y+= GameEngine.TILE_SIZE) { 
            for (int x = 0; x < GameEngine.SCREEN_WIDTH; x+= GameEngine.TILE_SIZE) {
                g.drawImage(mapImages[screenData[i]],x,y, null);
                i++;
            }
        }

        //draw the white clomuns and lines for debugg
      
       /* for (int y = 0; y < 20; y++) { 
            g.setColor(Color.white);
            //g.drawLine(y * TILE_SIZE, 0 , y * TILE_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, y * GameEngine.TILE_SIZE, GameEngine.SCREEN_WIDTH, y * GameEngine.TILE_SIZE);
            for (int x = 0; x < 30; x++) {
               // g.drawImage(mapImages[map[y][x]], x * TILE_SIZE,( y * TILE_SIZE), null);
                //g.drawLine(x * TILE_SIZE, 0 , x * TILE_SIZE, SCREEN_HEIGHT);
                g.drawLine(x * GameEngine.TILE_SIZE, 0 , x * GameEngine.TILE_SIZE, GameEngine.SCREEN_HEIGHT);
           
            }
        }*/
    }
    
    //verify if the the object-x,y is in map home
    public boolean isHome (int y, int x) {     
           for (int i = 0; i < this.ghostHome.length; i++) {
               if (y  == this.ghostHome[i][0] && x  == this.ghostHome[i][1]) {
                   return true;    
           }           
        }
                 
        return false;
    }
    

}
