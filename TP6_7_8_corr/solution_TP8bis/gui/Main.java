package gui;
import javax.swing.JFrame;

public class Main{
    public static void main(String argv[]) {
        BibGui fenetre = new BibGui();
        fenetre.setSize(500, 300);
        fenetre.setTitle("Bibliotheque");
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
