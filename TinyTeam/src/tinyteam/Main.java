/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyteam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Matear
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        for(;;) {
            
            FolderHandler handler = new FolderHandler();
            try {
                handler.checkPaths();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /*PDFTextParser parser = new PDFTextParser();
        try {
            KeywordCollection exclude = new KeywordCollection(args[0]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){ System.out.println(e.getMessage());

        }*/
        

    }
}
