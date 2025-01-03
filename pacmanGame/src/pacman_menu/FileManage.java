
package pacman_menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public interface FileManage {
   boolean ATTACH = true; //variable that verify if the file can be saved
   File SAVE_FILE = new File("ranking/ranking.txt"); //define the DIRECTORY
   
   //read the file and it is deafult 
   default void readFile(ArrayList nicknames, ArrayList scores) throws IOException {
       try{
            File directory = new File("ranking/ranking.txt"); //define the directory
            String playerScores;
            BufferedReader br;
            
            br = new BufferedReader(
                    new FileReader(directory));            
            while((playerScores = br.readLine())!= null){
                int pos = playerScores.indexOf("_"); //check the position of their char "_"
                nicknames.add(playerScores.substring(0, pos)); //the array recive just the nickname for the player
                scores.add(playerScores.substring(pos+1,playerScores.length())); //the array recive just the scores for the player
            }         
            br.close();
        }catch(FileNotFoundException ex){           
        }
   }

    // verify if the DIR and the file ranking exists; if not, create
    static void verifyDirectory() throws IOException {
        File directoryFolder = SAVE_FILE.getParentFile(); // Get the folder "ranking"
        if (!directoryFolder.exists()) {
            if (directoryFolder.mkdirs()) {
                System.out.println("Directory created: " + directoryFolder.getAbsolutePath());
            } else {
                throw new IOException("Failed to create directory: " + directoryFolder.getAbsolutePath());
            }
        }

        if (!SAVE_FILE.exists()) {
            if (SAVE_FILE.createNewFile()) {
                System.out.println("File created: " + SAVE_FILE.getAbsolutePath());
            } else {
                throw new IOException("Failed to create file: " + SAVE_FILE.getAbsolutePath());
            }
        }
    }
   
   //meth for save the file
   void saveFile();
   
   //can remove some line from the file
   void removeLine(String toRemove);

}
