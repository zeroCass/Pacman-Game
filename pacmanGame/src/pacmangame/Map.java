
package pacmangame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Map {
   private int score = 0;
   private final int sizeX;
   private final int sizeY;
    
   
    private Image [] mapImages;
    
    
    private int map[];
    public int screenData[];
    public int [][] ghostHome = {{9,14},{9,15}};
    
    //constructor
    public Map() {
        
            this.sizeX = 29; //this is the map lenght in X coord
            this.sizeY = 19;//this is the map lenght in X coord
            //map init
           /* map = new int[]{
    		 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3, 
    		 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 
    		 6, 1,14,24,16,16,16,13, 1,14,16,16,16,16,16,16,16,16,16,16,13, 1,14,16,16,16,24,13, 1, 7, 
    		 6, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 7, 
    		27,13, 1,15, 1,19,16,13, 1,19,16,16,20, 1,19,16,13, 1,19,16,13, 1,11, 1,11, 1,15, 1,14,29, 
    		 6, 1, 1,15, 1,15, 1, 1, 1,15, 0, 0,15, 1,15, 1, 1, 1,15, 1, 1, 1,15, 1,15, 1,15, 1, 1, 7, 
    		 6, 1,14,25, 1,23,13, 1, 1,23,16,24,18, 1,23,13, 1, 1,17,16,20, 1,23,16,25, 1,23,13, 1, 7, 
    		 6, 1, 1,15, 1,15, 1, 1, 1,15, 1,15, 1, 1,15, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1,15, 1, 1, 7, 
    		27,13, 1,12, 1,12, 1, 1, 1,12, 1,12, 1, 1,17,16,13, 1,14,16,18, 1,12, 1,12, 1,12, 1,14,29, 
    		 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 
    		 6, 1,19,16,16,16,20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,19,16,16,16,20, 1, 7, 
    		 6, 1,15, 1, 1, 1,15, 1,19,16,24,16,20, 1,19,16,20, 1,19,16,16,20, 1,15, 1, 1, 1,15, 1, 7, 
    		 6, 1,15, 1,11, 1,15, 1,15, 1,15, 1,15, 1,15, 0,15, 1,15, 1, 1,15, 1,15, 1,11, 1,15, 1, 7, 
    		 6, 1,12, 1,15, 1,15, 1,15, 1,15, 1,15, 1,23,16,25, 1,15, 1, 1,15, 1,15, 1,15, 1,12, 1, 7, 
    		 6, 1, 1, 1,15, 1,15, 1,15, 1,12, 1,15, 1,15, 1,15, 1,15, 1, 1,15, 1,15, 1,15, 1, 1, 1, 7, 
    		 6, 1,11, 1,15, 1,15, 1,12, 1, 1, 1,12, 1,12, 1,12, 1,12, 1, 1,12, 1,15, 1,15, 1,11, 1, 7, 
    		 6, 1,15, 1,15, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1, 7, 
    		 6, 1,12, 1,15, 1,17,16,13, 1,14,16,16,16,16,16,16,16,16,16,13, 1,14,18, 1,15, 1,12, 1, 7, 
    		 6, 1, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 0, 7, 
    		 4, 9, 9, 9,26, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,26, 9, 9, 9, 5, 
                };*/
               /* map = new int []{
                2, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3,
                7, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0,18,12, 1,13,19,18,15,15,15,19, 0, 0, 0, 0, 0, 0,18,12, 1,13,19,18,15,15,15,19, 0, 6,
                7, 0,14, 1, 1, 1,14,14, 1, 1, 1,11, 0, 0, 0, 0, 0, 0,14, 1, 1, 1,14,14, 1, 1, 1,11, 0, 6,
                7, 0,16,19, 1,18,17,14, 1, 1, 1, 1, 0,35, 0, 0,36, 0,16,19, 1,18,17,14, 1, 1, 1, 1, 0, 6,
                7, 0, 0,14, 1,14, 0,14, 1, 1, 1,10, 0, 7, 0, 0, 6, 0, 0,14, 1,14, 0,14, 1, 1, 1,10, 0, 6,		
                7, 0, 0,14, 1,14, 0,14, 1,18,15,17, 0,33, 8, 8,34, 0, 0,14, 1,14, 0,14, 1,18,15,17, 0, 6,
                7, 0, 0,14, 1,14, 0,14, 1,14, 0, 0, 0, 0, 0, 0, 0, 0, 0,14, 1,14, 0,14, 1,14, 0, 0, 0, 6,		
                7, 0, 0,16,15,17, 0,16,15,17, 0, 0, 0, 0, 0, 0, 0, 0, 0,16,15,17, 0,16,15,17, 0, 0, 0, 6,		
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,	
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,                
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,                
                7, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 6,
                4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5, 
                };*/
               
               map = new int [] {
                 2, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,27, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0,29,37,37,30, 0,29,37,37,37,37,30, 0,11, 0,29,37,37,37,37,37,30, 0,29,37,30, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6,
                7, 0,13,15,22,15,12, 0, 0, 0,10, 0,13,15,22,15,12, 0,18,15,12, 0,13,15,22,15,12, 0, 6,
                7, 0, 0, 0,14, 0, 0, 0, 0, 0,14, 0, 0, 0,14, 0, 0, 0,14, 0, 0, 0, 0, 0,14, 0, 0, 0, 6,
		7, 0,32, 0,14, 0,18,15,19, 0,21,15,12, 0,11, 0,13,15,23, 0,10, 0,10, 0,11, 0,32, 0, 6,
                7, 0,38, 0,14, 0,14, 0,14, 0,14, 0, 0, 0, 0, 0, 0, 0,14, 0,14, 0,14, 0, 0, 0,31, 0, 6,
                7, 0,38, 0,14, 0,14, 0,14, 0,11, 0,35, 0, 0, 0,36, 0,11, 0,16,15,17, 0,10, 0, 0, 0, 6,
                7, 0,31, 0,11, 0,21,15,17, 0, 0, 0, 7, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0,21,15,19, 0, 6,
                7, 0, 0, 0, 0, 0,14, 0, 0, 0,10, 0,33, 8, 8, 8,34, 0,10, 0,18,15,12, 0,14, 0,14, 0, 6,
		7, 0,13,19, 0, 0,11, 0,10, 0,14, 0, 0, 0, 0, 0, 0, 0,14, 0,14, 0, 0, 0,14, 0,14, 0, 6,
                7, 0, 0,21,12, 0, 0, 0,14, 0,11, 0,13,15,22,15,12, 0,11, 0,14, 0,13,15,17, 0,11, 0, 6,
                25,12,0,14, 0, 0,13,15,23, 0, 0, 0, 0, 0,11, 0, 0, 0, 0, 0,11, 0, 0, 0, 0, 0, 0, 0, 6,	
                7, 0, 0,16,12, 0, 0, 0,16,12, 0,10, 0, 0, 0, 0, 0,10, 0, 0, 0, 0,13,19, 0,18,15,15,24,
                7, 0, 0, 0, 0, 0,10, 0, 0, 0, 0,14, 0,13,22,12, 0,14, 0,10, 0, 0, 0,14, 0,14, 0, 0, 6,                
                7, 0,13,15,15,15,20,15,15,12, 0,11, 0, 0,11, 0, 0,16,15,20,15,12, 0,14, 0,16,12, 0, 6,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,14, 0, 0, 0, 0, 6,                
                4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,26, 8, 8, 8, 8, 5, 
          
               };
           
           
           
            screenData = new int [this.sizeX * this.sizeY];
            for(int i = 0; i < (this.sizeX * this.sizeY);i++) {
                screenData[i] = map[i];
            }
        
            mapImages = new Image[40];
            loadMapImages();
   
            
            
            
    }
    
    
    //this method
    public void loadMapImages () {
        //emptySpace = new ImageIcon("images/fld/fld_00.png").getImage();
        //mapImages[0] = ImageIO.read(new File("images/fld/fld_00.png"));
        //System.out.println("Entrou");
       /* mapImages[0] = new ImageIcon("images/fld/fld_00.png").getImage();
        mapImages[1] = new ImageIcon("images/fld/fld_01.png").getImage();
        mapImages[2] = new ImageIcon("images/fld/fld_02.png").getImage();
        mapImages[3] = new ImageIcon("images/fld/fld_03.png").getImage();
        mapImages[4] = new ImageIcon("images/fld/fld_04.png").getImage();
        mapImages[5] = new ImageIcon("images/fld/fld_05.png").getImage();
        mapImages[6] = new ImageIcon("images/fld/fld_06.png").getImage();
        mapImages[7] = new ImageIcon("images/fld/fld_07.png").getImage();
        mapImages[8] = new ImageIcon("images/fld/fld_08.png").getImage();
        mapImages[9] = new ImageIcon("images/fld/fld_09.png").getImage();
        mapImages[10] = new ImageIcon("images/fld/fld_10.png").getImage();
        mapImages[11] = new ImageIcon("images/fld/fld_11.png").getImage();
        mapImages[12] = new ImageIcon("images/fld/fld_12.png").getImage();
        mapImages[13] = new ImageIcon("images/fld/fld_13.png").getImage();
        mapImages[14] = new ImageIcon("images/fld/fld_14.png").getImage();
        mapImages[15] = new ImageIcon("images/fld/fld_15.png").getImage();
        mapImages[16] = new ImageIcon("images/fld/fld_16.png").getImage();
        mapImages[17] = new ImageIcon("images/fld/fld_17.png").getImage();
        mapImages[18] = new ImageIcon("images/fld/fld_18.png").getImage();
        mapImages[19] = new ImageIcon("images/fld/fld_19.png").getImage();
        mapImages[20] = new ImageIcon("images/fld/fld_20.png").getImage();
        mapImages[21] = new ImageIcon("images/fld/fld_21.png").getImage();
        mapImages[22] = new ImageIcon("images/fld/fld_22.png").getImage();
        mapImages[23] = new ImageIcon("images/fld/fld_23.png").getImage();
        mapImages[24] = new ImageIcon("images/fld/fld_24.png").getImage();
        mapImages[25] = new ImageIcon("images/fld/fld_25.png").getImage();
        mapImages[26] = new ImageIcon("images/fld/fld_26.png").getImage();
        mapImages[27] = new ImageIcon("images/fld/fld_27.png").getImage();
        mapImages[28] = new ImageIcon("images/fld/fld_28.png").getImage();
        mapImages[29] = new ImageIcon("images/fld/fld_29.png").getImage();*/
       
       
        //pacman = new ImageIcon("images/fld/monster1.png").getImage();
     
        mapImages[0] = new ImageIcon("images/fld/00.jpg").getImage();
        mapImages[1] = new ImageIcon("images/fld/01_ball.gif").getImage();
        mapImages[2] = new ImageIcon("images/fld/02.jpg").getImage();
        mapImages[3] = new ImageIcon("images/fld/03.jpg").getImage();
        mapImages[4] = new ImageIcon("images/fld/04.jpg").getImage();
        mapImages[5] = new ImageIcon("images/fld/05.jpg").getImage();
        mapImages[6] = new ImageIcon("images/fld/06.jpg").getImage();
        mapImages[7] = new ImageIcon("images/fld/07.jpg").getImage();
        mapImages[8] = new ImageIcon("images/fld/08.jpg").getImage();
        mapImages[9] = new ImageIcon("images/fld/09.jpg").getImage();
        mapImages[10] = new ImageIcon("images/fld/10.jpg").getImage();
        mapImages[11] = new ImageIcon("images/fld/11.jpg").getImage();
        mapImages[12] = new ImageIcon("images/fld/12.jpg").getImage();
        mapImages[13] = new ImageIcon("images/fld/13.jpg").getImage();
        mapImages[14] = new ImageIcon("images/fld/14.jpg").getImage();
        mapImages[15] = new ImageIcon("images/fld/15.jpg").getImage();
        mapImages[16] = new ImageIcon("images/fld/16.jpg").getImage();
        mapImages[17] = new ImageIcon("images/fld/17.jpg").getImage();
        mapImages[18] = new ImageIcon("images/fld/18.jpg").getImage();
        mapImages[19] = new ImageIcon("images/fld/19.jpg").getImage();
        mapImages[20] = new ImageIcon("images/fld/20.jpg").getImage();
        mapImages[21] = new ImageIcon("images/fld/21.jpg").getImage();
        mapImages[22] = new ImageIcon("images/fld/22.jpg").getImage();
        mapImages[23] = new ImageIcon("images/fld/23.jpg").getImage();
        mapImages[24] = new ImageIcon("images/fld/24.jpg").getImage();
        mapImages[25] = new ImageIcon("images/fld/25.jpg").getImage();
        mapImages[26] = new ImageIcon("images/fld/26.jpg").getImage();
        mapImages[27] = new ImageIcon("images/fld/27.jpg").getImage();
        mapImages[28] = new ImageIcon("images/fld/28_power_ball.gif").getImage();
        mapImages[29] = new ImageIcon("images/fld/29.jpg").getImage();
        mapImages[30] = new ImageIcon("images/fld/30.jpg").getImage();
        mapImages[31] = new ImageIcon("images/fld/31.jpg").getImage();
        mapImages[32] = new ImageIcon("images/fld/32.jpg").getImage();
        mapImages[33] = new ImageIcon("images/fld/33.jpg").getImage();
        mapImages[34] = new ImageIcon("images/fld/34.jpg").getImage();
        mapImages[35] = new ImageIcon("images/fld/35.jpg").getImage();
        mapImages[36] = new ImageIcon("images/fld/36.jpg").getImage();
        mapImages[37] = new ImageIcon("images/fld/37.jpg").getImage();
        mapImages[38] = new ImageIcon("images/fld/38.jpg").getImage();
               
        
    }
    
    
    
    public void drawMaze (Graphics g) {
        
        int i = 0;
        for (int y = 0; y < GameEngine.SCREEN_HEIGHT; y+= GameEngine.TILE_SIZE) { 
            for (int x = 0; x < GameEngine.SCREEN_WIDTH; x+= GameEngine.TILE_SIZE) {
                //g.drawImage(mapImages[map[y][x]], x * GameEngine.TILE_SIZE,(y *  GameEngine.TILE_SIZE), null);
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
    
    
       public boolean isHome (int y, int x) {
           
           for (int i = 0; i < this.ghostHome.length; i++) {
            
               if (y  == this.ghostHome[i][0] && x  == this.ghostHome[i][1]) {
                   //System.out.println(this.ghostHome[i][0]);
                   //System.out.println("is home");
                   return true;
                     
                     
           }           
        }
           
            
        return false;
    }
    

}
