
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
    }
    
}
    