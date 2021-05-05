
package pacmangame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pacman_menu.menu;

/**
 *
 * @author Cass.Nero
 */
public class PacmanGame extends JFrame{

    public static void main(String[] args) {
        //System.out.println("entra qui");
       // menu_principal menu = new menu_principal();
       SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            menu gui = new menu();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(gui);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
        System.out.println("passa ?");
        
       /* JFrame Game = new JFrame();
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
        /*try {
            gameEngine.thread.join();
            }catch (Exception e) {
            }
        System.out.println("Acabou");*/
        
        
    }
    
}
    