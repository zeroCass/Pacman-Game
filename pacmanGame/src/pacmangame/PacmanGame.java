
package pacmangame;

import javax.swing.JFrame;


public class PacmanGame extends JFrame{

   
    public static void main(String[] args) {
        JFrame Game = new JFrame();
        Game.add(new GameEngine());
        Game.setTitle("Pacman");
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.pack();
        Game.setResizable(false);
        Game.setVisible(true);
        Game.setLocationRelativeTo(null);
        //Game.setContentPane(new GameEngine());
  
    }
    
}
