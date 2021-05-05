
package pacmangame;

import javax.swing.JFrame;

/**
 *
 * @author Cass.Nero
 */
public class PacmanGame extends JFrame{


    public static void main(String[] args) {
        

        
        JFrame Game = new JFrame();
        GameEngine gameEngine = new GameEngine();
        Game.add(gameEngine);
        Game.setTitle("Pacman");
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.pack();
        Game.setResizable(false);
        Game.setVisible(true);
        Game.setLocationRelativeTo(null);
        gameEngine.start();
        //Game.setContentPane(new GameEngine());
        
        /*while (true) {
            try {
                gameEngine.thread.join();
                if (gameEngine.lives > 0)
                    gameEngine.restart();
                else
                    break;
            }catch (Exception e) {
            }
        }*/
        try {
            gameEngine.thread.join();
            }catch (Exception e) {
            }
        System.out.println("Acabou");
        
        
    }
    
}
    