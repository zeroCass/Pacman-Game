
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
    public int numPills; //number of pills in the maze
    public int screenData[];
    public int [][] ghostHome = {{9,13},{9,14},{9,15}};
    
    //constructor
    public Map() {
            this.sizeY = GameEngine.MAZE_SIZE_Y;//this is the map lenght in X coord
            this.sizeX = GameEngine.MAZE_SIZE_X; //this is the map lenght in X coord
            
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
                /*map = new int []{
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
                
               /* map = new int [] {
                 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,10, 9,11, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3,0,
                 8,64,63,63,63,63,63,63,63,63,63,63,63,63,12,63,63,63,63,63,63,63,63,63,63,63,63,64, 4,0,
                 8,63,47,51,51,48,63,47,51,51,51,51,48,63,13,63,47,51,51,51,51,48,63,47,51,51,48,63, 4,0,
                 8,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63, 4,0,
                 8,63,22,26,29,30,18,63,63,63,27,63,22,26,29,30,18,63,28,17,18,63,22,26,29,30,18,63, 4,0,
                 8,63,63,63,31,63,63,63,63,63,45,63,63,63,31,63,63,63,33,63,63,63,63,63,31,63,63,63, 4,0,
		 8,63,49,63,12,63,28,17,32,63,44,46,18,63,13,63,22,36,34,63,27,63,27,63,13,63,49,63, 4,0,
                 8,63,52,63,12,63,12,0,12,63,43, 0, 0, 0, 0, 0, 0, 0,35,63,12,63,12,63,63,63,50,63, 4,0,
                 8,63,52,63,12,63,45,0,12,63,13, 0,53,54,55,56,57, 0,13,63,42,17,37,63,27,63,63,63, 4,0,
                 8,63,50,63,13,63,44,46,37,63,63, 0,62, 0, 0, 0,58, 0,63,63,63,63,63,63,44,46,32,63, 4,0,
                 8,63,63,63,63,63,43,63,63,63,27, 0,61,60,60,60,59, 0,27,63,28,17,18,63,43,63,12,63, 4,0,
		 8,63,22,32,63,63,13,63,27,63,12, 0, 0, 0, 0, 0, 0, 0,12,63,12,63,63,63,12,63,12,63, 4,0,
		 8,63,63,44,18,63,63,63,33,63,13,63,22,26,29,30,18,63,13,63,12,63,22,17,37,63,13,63, 4,0,
                16,63,63,43,63,63,22,36,34,63,63,63,63,63,13,63,63,63,63,63,13,63,63,63,63,63,63,63,24,0,
                14,18,63,42,18,63,63,63,42,18,63,27,63,63, 0,63,63,27,63,63,63,63,22,32,63,28,17,17,23,0,               
                15,63,63,63,63,63,27,63,63,63,63,12,63,22,29,18,63,12,63,27,63,63,63,12,63,12,64,63,25,0,
                 8,63,22,17,17,40,39,38,17,18,63,13,63,63,13,63,63,42,40,39,38,18,63,12,63,42,18,63, 4,0, 
		 8,64,63,63,63,63,63,63,63,63,63,63,63,63,64,63,63,63,63,63,63,63,63,12,63,63,63,63, 4,0,
                 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,21,19,20, 6, 6, 6, 5,0,
                 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,21,19,20, 6, 6, 6, 5,0,
                 };*/
               /* map = new int []  {
                 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,10, 9,11, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3,
                 8,64,63,63,63,63,63,63,63,63,63,63,63,63,12,63,63,63,63,63,63,63,63,63,63,63,63,64,64, 4,
                 8,63,47,51,51,48,63,47,51,51,51,51,48,63,13,63,47,51,51,51,51,48,63,47,51,51,48,63,63, 4,
                 8,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63, 4,
                 8,63,22,26,29,30,18,63,63,63,27,63,22,26,29,30,18,63,28,17,18,63,22,26,29,30,18,63,63, 4,
                 8,63,63,63,31,63,63,63,63,63,45,63,63,63,31,63,63,63,33,63,63,63,63,63,31,63,63,63,63, 4,
		 8,63,49,63,12,63,28,17,32,63,44,46,18,63,13,63,22,36,34,63,27,63,27,63,13,63,49,63,63, 4,
                 8,63,52,63,12,63,12, 0,12,63,43, 0, 0, 0, 0, 0, 0, 0,35,63,12,63,12,63,63,63,50,63,63, 4,
                 8,63,52,63,12,63,45, 0,12,63,13, 0,53,54,55,56,57, 0,13,63,42,17,37,63,27,63,63,63,63, 4,
                 8,63,50,63,13,63,44,46,37,63,63, 0,62, 0, 0, 0,58, 0,63,63,63,63,63,63,44,46,32,63,63, 4,
                 8,63,63,63,63,63,43,63,63,63,27, 0,61,60,60,60,59, 0,27,63,28,17,18,63,43,63,12,63,63, 4,
		 8,63,22,32,63,63,13,63,27,63,12, 0, 0, 0, 0, 0, 0, 0,12,63,12,63,63,63,12,63,12,63,63, 4,
		 8,63,63,44,18,63,63,63,33,63,13,63,22,26,29,30,18,63,13,63,12,63,22,17,37,63,13,63,63, 4,	
                16,63,63,43,63,63,22,36,34,63,63,63,63,63,13,63,63,63,63,63,13,63,63,63,63,63,63,63,63,24,
                14,18,63,42,18,63,63,63,42,18,63,27,63,63, 0,63,63,27,63,63,63,63,22,32,63,28,17,17,17,23,               
                15,63,63,63,63,63,27,63,63,63,63,12,63,22,29,18,63,12,63,27,63,63,63,12,63,12,64,63,63,25,
                8,63,22,17,17,40,39,38,17,18,63,13,63,63,13,63,63,42,40,39,38,18,63,12,63,42,18,63,63,4, 
		 8,64,63,63,63,63,63,63,63,63,63,63,63,63,64,63,63,63,63,63,63,63,63,12,63,63,63,63,63,4,
                 8,64,63,63,63,63,63,63,63,63,63,63,63,63,64,63,63,63,63,63,63,63,63,12,63,63,63,63,63,4,
                 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,21,19,20, 6, 6, 6, 6,5,
                };*/
                
               /* map = new int [] {
                    1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3,
                    8,64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,64, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0,28,18,63,22,32,28,17,17,17,32, 0, 0, 0, 0, 0, 0,28,18,63,22,32,28,17,17,17,32, 0, 4,
                    8, 0,12,63,63,63,12,12,63,63,63,13, 0, 0, 0, 0, 0, 0,12,63,63,63,12,12,63,63,63,13, 0, 4,
                    8, 0,42,32,63,28,37,12,63,63,63,63, 0,53, 0, 0,57, 0,42,32,63,28,37,12,63,63,63,63, 0, 4,
                    8, 0, 0,12,63,12, 0,12,63,63,63,27, 0,62, 0, 0,58, 0, 0,12,63,12, 0,12,63,63,63,27, 0, 4,
                    8, 0, 0,12,63,12, 0,12,63,28,17,37, 0,61,60,60,59, 0, 0,12,63,12, 0,12,63,28,17,37, 0, 4,
                    8, 0, 0,12,63,12, 0,12,63,12, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,63,12, 0,12,63,12, 0, 0, 0, 4,
                    8, 0, 0,42,17,37, 0,42,17,37, 0, 0, 0, 0, 0, 0, 0, 0, 0,16,15,17, 0,42,17,37, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    8,64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,64, 4,
                    7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 

                };*/
               map = new int [] {
                   1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,10, 9,11, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3,
                    8,64,63,63,63,63,63,63,63,63,63,63,63,63,12,63,63,63,63,63,63,63,63,63,63,63,63,63,64, 4,
                    8,63,22,17,17,18,63,22,17,17,17,17,18,63,13,63,22,17,17,17,17,18,63,22,17,17,17,18,63, 4,
                    8,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63,63, 4,
                    8,63,22,26,29,30,18,63,63,63,27,63,22,26,29,30,18,63,28,17,18,63,22,26,29,30,17,18,63, 4,
                    8,63,63,63,31,63,63,63,63,63,45,63,63,63,31,63,63,63,33,63,63,63,63,63,31,63,63,63,63, 4,
                    8,63,27,63,12,63,28,17,32,63,44,46,18,63,13,63,22,36,34,63,27,63,27,63,13,63,28,18,63, 4,
                    8,63,12,63,12,63,12, 0,12,63,43, 0, 0, 0, 0, 0, 0, 0,35,63,12,63,12,63,63,63,42,32,63, 4,
                    8,63,12,63,12,63,45, 0,12,63,13, 0,53,54,55,56,57, 0,13,63,42,17,37,63,27,63,63,13,63, 4,
                    8,63,13,63,13,63,44,46,37,63,63, 0,62, 0, 0, 0,58, 0,63,63,63,63,63,63,44,32,63,63,63, 4,
                    8,63,63,63,63,63,43,63,63,63,27, 0,61,60,60,60,59, 0,27,63,28,17,18,63,43,42,32,63,63, 4,
                    8,63,22,32,63,63,13,63,27,63,12, 0, 0, 0, 0, 0, 0, 0,12,63,12,63,63,63,12,63,12,63,63, 4,
                    8,63,63,44,18,63,63,63,33,63,13,63,22,26,29,30,18,63,13,63,12,63,22,17,37,63,42,18,63, 4,
                    16,63,63,43,63,63,22,36,34,63,63,63,63,63,13,63,63,63,63,63,13,63,63,63,63,63,63,63,63,24,
                    14,18,63,12,63,63,63,63,42,18,63,27,63,63, 0,63,63,27,63,63,63,63,22,32,63,28,17,17,17,23,
                    15,63,63,42,18,63,27,63,63,63,63,12,63,22,29,18,63,12,63,27,63,63,63,12,63,12,63,63,63,25,
                    8,63,63,63,63,63,41,63,63,63,63,12,63,63,12,63,63,12,63,41,63,63,63,12,63,12,64,27,63, 4,
                    8,63,22,17,17,40,39,38,17,18,63,13,63,63,13,63,63,42,40,39,38,18,63,12,63,42,17,37,63, 4,
                    8,64,63,63,63,63,63,63,63,63,63,63,63,63,64,63,63,63,63,63,63,63,63,12,63,63,63,63,63, 4,
                    7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,21,19,20, 6, 6, 6, 6, 5,
               };
               
           
           
           
            screenData = new int [this.sizeX * this.sizeY];
            for(int i = 0; i < (this.sizeX * this.sizeY);i++) {
                screenData[i] = map[i];
                if (map[i] == 63 || map[i] == 64)
                    numPills++; //increase the number of pills
            }
            
            //mapImages = new Image[40];
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
     
        mapImages = new Image[65];
	
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
        mapImages[26] = new ImageIcon("images/mapa/26.jpg").getImage();
        mapImages[27] = new ImageIcon("images/mapa/27.png").getImage();
        mapImages[28] = new ImageIcon("images/mapa/28.png").getImage();
        mapImages[29] = new ImageIcon("images/mapa/29.jpg").getImage(); 
        mapImages[30] = new ImageIcon("images/mapa/30.png").getImage();
        mapImages[31] = new ImageIcon("images/mapa/31.png").getImage();
        mapImages[32] = new ImageIcon("images/mapa/32.png").getImage();
        mapImages[33] = new ImageIcon("images/mapa/33.png").getImage();
        mapImages[34] = new ImageIcon("images/mapa/34.jpg").getImage();
        mapImages[35] = new ImageIcon("images/mapa/35.png").getImage();
        mapImages[36] = new ImageIcon("images/mapa/36.png").getImage();
        mapImages[37] = new ImageIcon("images/mapa/37.png").getImage();
        mapImages[38] = new ImageIcon("images/mapa/38.png").getImage();
        mapImages[39] = new ImageIcon("images/mapa/39.jpg").getImage();
        mapImages[40] = new ImageIcon("images/mapa/40.png").getImage();
        mapImages[41] = new ImageIcon("images/mapa/41.png").getImage();
        mapImages[42] = new ImageIcon("images/mapa/42.png").getImage();
        mapImages[43] = new ImageIcon("images/mapa/43.png").getImage();
        mapImages[44] = new ImageIcon("images/mapa/44.jpg").getImage(); 
        mapImages[45] = new ImageIcon("images/mapa/45.png").getImage();
        mapImages[46] = new ImageIcon("images/mapa/46.png").getImage();
        mapImages[47] = new ImageIcon("images/mapa/47.png").getImage();
        mapImages[48] = new ImageIcon("images/mapa/48.png").getImage();
        mapImages[49] = new ImageIcon("images/mapa/49.png").getImage();
        mapImages[50] = new ImageIcon("images/mapa/50.png").getImage();
        mapImages[51] = new ImageIcon("images/mapa/51.png").getImage();
        mapImages[52] = new ImageIcon("images/mapa/52.png").getImage();
        mapImages[53] = new ImageIcon("images/mapa/53.png").getImage();
        mapImages[54] = new ImageIcon("images/mapa/54.png").getImage();
        mapImages[55] = new ImageIcon("images/mapa/55.png").getImage();
        mapImages[56] = new ImageIcon("images/mapa/56.png").getImage();
        mapImages[57] = new ImageIcon("images/mapa/57.png").getImage();
        mapImages[58] = new ImageIcon("images/mapa/58.png").getImage();
        mapImages[59] = new ImageIcon("images/mapa/59.png").getImage();       
        mapImages[60] = new ImageIcon("images/mapa/60.png").getImage();
        mapImages[61] = new ImageIcon("images/mapa/61.png").getImage();
        mapImages[62] = new ImageIcon("images/mapa/62.png").getImage();
		mapImages[63] = new ImageIcon("images/mapa/63.gif").getImage();
        mapImages[64] = new ImageIcon("images/mapa/64.gif").getImage();
               
        
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
