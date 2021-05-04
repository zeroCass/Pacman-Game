
package pacmangame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Map {
    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 600;
    static final int TILE_SIZE = 30; 
    //static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/TILE_SIZE;
   // static final int DELAY = 100;
    //Graphics g;
    
    char direction  = ' ';
    
    private int score = 0;
    
    
   // private Image [] mapImages = new Image [30];
    private Image [] mapImages;
    
    //public int pacman_x, pacman_y;
    //private Image pacman;
    private int map[][];
    
    public Map() {
        //System.out.println("entrou constructor");
            map = new int[][]{
    		{ 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3}, 
    		{ 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7}, 
    		{ 6, 1,14,24,16,16,16,13, 1,14,16,16,16,16,16,16,16,16,16,16,13, 1,14,16,16,16,24,13, 1, 7}, 
    		{ 6, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 7}, 
    		{27,13, 1,15, 1,19,16,13, 1,19,16,16,20, 1,19,16,13, 1,19,16,13, 1,11, 1,11, 1,15, 1,14,29}, 
    		{ 6, 1, 1,15, 1,15, 1, 1, 1,15, 0, 0,15, 1,15, 1, 1, 1,15, 1, 1, 1,15, 1,15, 1,15, 1, 1, 7}, 
    		{ 6, 1,14,25, 1,23,13, 1, 1,23,16,24,18, 1,23,13, 1, 1,17,16,20, 1,23,16,25, 1,23,13, 1, 7}, 
    		{ 6, 1, 1,15, 1,15, 1, 1, 1,15, 1,15, 1, 1,15, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1,15, 1, 1, 7}, 
    		{27,13, 1,12, 1,12, 1, 1, 1,12, 1,12, 1, 1,17,16,13, 1,14,16,18, 1,12, 1,12, 1,12, 1,14,29}, 
    		{ 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7}, 
    		{ 6, 1,19,16,16,16,20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,19,16,16,16,20, 1, 7}, 
    		{ 6, 1,15, 1, 1, 1,15, 1,19,16,24,16,20, 1,19,16,20, 1,19,16,16,20, 1,15, 1, 1, 1,15, 1, 7}, 
    		{ 6, 1,15, 1,11, 1,15, 1,15, 1,15, 1,15, 1,15, 0,15, 1,15, 1, 1,15, 1,15, 1,11, 1,15, 1, 7}, 
    		{ 6, 1,12, 1,15, 1,15, 1,15, 1,15, 1,15, 1,23,16,25, 1,15, 1, 1,15, 1,15, 1,15, 1,12, 1, 7}, 
    		{ 6, 1, 1, 1,15, 1,15, 1,15, 1,12, 1,15, 1,15, 1,15, 1,15, 1, 1,15, 1,15, 1,15, 1, 1, 1, 7}, 
    		{ 6, 1,11, 1,15, 1,15, 1,12, 1, 1, 1,12, 1,12, 1,12, 1,12, 1, 1,12, 1,15, 1,15, 1,11, 1, 7}, 
    		{ 6, 1,15, 1,15, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1, 7}, 
    		{ 6, 1,12, 1,15, 1,17,16,13, 1,14,16,16,16,16,16,16,16,16,16,13, 1,14,18, 1,15, 1,12, 1, 7}, 
    		{ 6, 1, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 0, 7}, 
    		{ 4, 9, 9, 9,26, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,26, 9, 9, 9, 5}, 
                };
            mapImages = new Image[30];
            loadMapImages();
    }
    /*private int map[][] = {
    		{ 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3}, 
    		{ 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7}, 
    		{ 6, 1,14,24,16,16,16,13, 1,14,16,16,16,16,16,16,16,16,16,16,13, 1,14,16,16,16,24,13, 1, 7}, 
    		{ 6, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 7}, 
    		{27,13, 1,15, 1,19,16,13, 1,19,16,16,20, 1,19,16,13, 1,19,16,13, 1,11, 1,11, 1,15, 1,14,29}, 
    		{ 6, 1, 1,15, 1,15, 1, 1, 1,15, 0, 0,15, 1,15, 1, 1, 1,15, 1, 1, 1,15, 1,15, 1,15, 1, 1, 7}, 
    		{ 6, 1,14,25, 1,23,13, 1, 1,23,16,24,18, 1,23,13, 1, 1,17,16,20, 1,23,16,25, 1,23,13, 1, 7}, 
    		{ 6, 1, 1,15, 1,15, 1, 1, 1,15, 1,15, 1, 1,15, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1,15, 1, 1, 7}, 
    		{27,13, 1,12, 1,12, 1, 1, 1,12, 1,12, 1, 1,17,16,13, 1,14,16,18, 1,12, 1,12, 1,12, 1,14,29}, 
    		{ 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7}, 
    		{ 6, 1,19,16,16,16,20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,19,16,16,16,20, 1, 7}, 
    		{ 6, 1,15, 1, 1, 1,15, 1,19,16,24,16,20, 1,19,16,20, 1,19,16,16,20, 1,15, 1, 1, 1,15, 1, 7}, 
    		{ 6, 1,15, 1,11, 1,15, 1,15, 1,15, 1,15, 1,15, 0,15, 1,15, 1, 1,15, 1,15, 1,11, 1,15, 1, 7}, 
    		{ 6, 1,12, 1,15, 1,15, 1,15, 1,15, 1,15, 1,23,16,25, 1,15, 1, 1,15, 1,15, 1,15, 1,12, 1, 7}, 
    		{ 6, 1, 1, 1,15, 1,15, 1,15, 1,12, 1,15, 1,15, 1,15, 1,15, 1, 1,15, 1,15, 1,15, 1, 1, 1, 7}, 
    		{ 6, 1,11, 1,15, 1,15, 1,12, 1, 1, 1,12, 1,12, 1,12, 1,12, 1, 1,12, 1,15, 1,15, 1,11, 1, 7}, 
    		{ 6, 1,15, 1,15, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1,15, 1,15, 1, 7}, 
    		{ 6, 1,12, 1,15, 1,17,16,13, 1,14,16,16,16,16,16,16,16,16,16,13, 1,14,18, 1,15, 1,12, 1, 7}, 
    		{ 6, 1, 1, 1,15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,15, 1, 1, 0, 7}, 
    		{ 4, 9, 9, 9,26, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,26, 9, 9, 9, 5}, 
    };*/
    
    public void loadMapImages () {
        //emptySpace = new ImageIcon("images/fld/fld_00.png").getImage();
        //mapImages[0] = ImageIO.read(new File("images/fld/fld_00.png"));
        System.out.println("Entrou");
        mapImages[0] = new ImageIcon("images/fld/fld_00.png").getImage();
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
        mapImages[29] = new ImageIcon("images/fld/fld_29.png").getImage();
       
        //pacman = new ImageIcon("images/fld/monster1.png").getImage();
     
  
               
        
    }
    
    
    public void drawMaze (Graphics g) {
        
        for (int y = 0; y < 20; y++) { 
            for (int x = 0; x < 30; x++) {
                g.drawImage(mapImages[map[y][x]], x * TILE_SIZE,(y * TILE_SIZE), null);
           
            }
        }
        //int z = GameEngine.SCREEN_HEIGHT;
        
       /*for (int y = 0; y < 22; y++) { 
            g.setColor(Color.WHITE);
            //g.drawLine(y * TILE_SIZE, 0 , y * TILE_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, y * TILE_SIZE, SCREEN_WIDTH, y * TILE_SIZE);
            for (int x = 0; x < 30; x++) {
               // g.drawImage(mapImages[map[y][x]], x * TILE_SIZE,( y * TILE_SIZE), null);
                //g.drawLine(x * TILE_SIZE, 0 , x * TILE_SIZE, SCREEN_HEIGHT);
                g.drawLine(x * TILE_SIZE, 0 , x * TILE_SIZE, SCREEN_HEIGHT);
           
            }
        }*/
    }
    
    //check colision
    public boolean colisionCheck (double x, double y) {
      x = Math.floor(x);
      y = Math.floor(y);
       
        if (map[(int)y][(int)x] != 1 && map[(int)y][(int)x] != 0)
            return true;
        return false;
    }
    
    public void updateMap(int x, int y) {
        if (map[y][x] == 1){
            map[y][x] = 0;
            this.score++;
            System.out.println("Pontos :" + score);
        }
            
        
    }
    
    
    
}

