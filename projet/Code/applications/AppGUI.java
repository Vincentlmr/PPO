package applications;
import lib.*;
import exceptions.*;
import javax.swing.*;
import java.io.*;
import ihm.*;

public class AppGUI {

    public static void main(String[] args) {
        //chargement de la grille sérialisée
        Grille gril = new Grille();// on crée une grille
        try {
             gril.load(args[0]);
        } catch(IOException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
        catch(ClassNotFoundException cl) {
            System.out.println(cl.getMessage());
            cl.printStackTrace();
        }
         
        TabObj tableur = new TabObj(gril);
        // Creation de le main et lancement
        // Fourni: ne rien changer (a part le nom de la JFrame si vous le souhaitez).
        JFrame frame = new JFrame("TABOBJ proto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableur.setOpaque(true);
        frame.setContentPane(tableur);
        frame.pack();
        frame.setVisible(true);

    }
}
