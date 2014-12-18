package gestionrecette;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jeremy
 */
public class GestionRecette
{
    public static ArrayList<Aliment> lesAliments = new ArrayList<Aliment>();
    public static ArrayList<Recette> lesRecettes = new ArrayList<Recette>();
    public static ArrayList<Type> lesTypes = new ArrayList<Type>();
    public static String pathSave = "";
    public static boolean save = true;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        
        for(int i=1; i<=10; i++)
        {
            lesTypes.add(new Type(i, "Type " + i));
        }
    }
    
    public static void fenetre(String message)
    {
        JFrame fen = new JFrame();
        JOptionPane.showMessageDialog(fen, message);
        fen.setVisible(true);
        fen.dispose();
    }
    
    public static File fenetreInputPath()
    {
        String messageRetour;
        String message = "Saisissez le dossier vers lequel enregistrez les données (sans '/' a la fin):";
        File f;
        boolean first = true;
        do
        {
            if(!first)
            {
                fenetre("Le chemin du dossier est invalide !");
            }
            messageRetour = JOptionPane.showInputDialog(null, message);
            f = new File(messageRetour);
            first = false;
        }
        while (!f.isDirectory());

        return f;
    }
    
}
