package gestionrecette;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeremy
 */
public class MenuPrincipal extends javax.swing.JFrame
{

    /**
     * Creates new form MenuPrincipal
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public MenuPrincipal() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        initComponents();
        if(GestionRecette.save == true)
        {
            MenuPrincipal.restaurationDonnees();
        }
        this.setLocationRelativeTo(null);
    }
    
    private static void restaurationDonnees() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String messageRetour;
        String message = "Saisissez le dossier dans lequel les données sont enregistrés (sans '/' a la fin)\nLaissez le champ vide pour ne rien restaurer";
        File f;
        boolean first = true;
        GestionRecette.save = false;
        do
        {
            if(!first)
            {
                GestionRecette.fenetre("Le chemin du dossier est invalide !");
            }
            messageRetour = JOptionPane.showInputDialog(null, message);
            if(messageRetour.compareTo("") == 0)
            {
                break;
            }
            f = new File(messageRetour);
            first = false;
            if(f.isDirectory())
            {
                try
                {
                    File fAliment = new File(f + "/aliments");
                    FileInputStream fisAliment = new FileInputStream(fAliment);
                    ObjectInputStream oisAliment = new ObjectInputStream(fisAliment);
                    if(fAliment.exists())
                    {
                        GestionRecette.lesAliments = (ArrayList<Aliment>) oisAliment.readObject();
                    }
                    else
                    {
                        GestionRecette.fenetre("Fichier de stockage des aliments non trouvé.");
                    }
                }
                catch(FileNotFoundException e)
                {
                    GestionRecette.fenetre("Fichier de stockage des aliments non trouvé.");
                }
                try
                {
                    File fRecette = new File(f + "/recettes");
                    FileInputStream fisRecette = new FileInputStream(fRecette);
                    ObjectInputStream oisRecette = new ObjectInputStream(fisRecette);
                    if(fRecette.exists())
                    {
                        GestionRecette.lesRecettes = (ArrayList<Recette>) oisRecette.readObject();
                    }
                    else
                    {
                        GestionRecette.fenetre("Fichier de stockage des recettes non trouvé.");
                    }
                }
                catch(FileNotFoundException e)
                {
                    GestionRecette.fenetre("Fichier de stockage des recettes non trouvé.");
                }

                GestionRecette.fenetre("Données restaurées en fonction des fichiers trouvés.");
                GestionRecette.pathSave = messageRetour;
            }
        }
        while(!f.isDirectory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitre = new javax.swing.JLabel();
        btnCreateAliment = new javax.swing.JButton();
        btnCreateRecette = new javax.swing.JButton();
        btnConsultRecette = new javax.swing.JButton();
        btnQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitre.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        labelTitre.setText("GESTION DES RECETTES");

        btnCreateAliment.setText("Créer un aliment");
        btnCreateAliment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAlimentActionPerformed(evt);
            }
        });

        btnCreateRecette.setText("Créer une recette");
        btnCreateRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRecetteActionPerformed(evt);
            }
        });

        btnConsultRecette.setText("Consulter les recette");
        btnConsultRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultRecetteActionPerformed(evt);
            }
        });

        btnQuitter.setText("Quitter");
        btnQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnCreateAliment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btnCreateRecette)
                .addGap(134, 134, 134)
                .addComponent(btnConsultRecette)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(labelTitre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitter)
                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitre)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateAliment)
                    .addComponent(btnCreateRecette)
                    .addComponent(btnConsultRecette))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btnQuitter)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAlimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAlimentActionPerformed
        // Affichage du menu de saisie des offres de stage
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuSaisieAliment().setVisible(true);
            }
        });
        // ***************************
        this.dispose();
    }//GEN-LAST:event_btnCreateAlimentActionPerformed

    private void btnCreateRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRecetteActionPerformed
        // Affichage du menu de saisie des offres de stage
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuSaisieRecette().setVisible(true);
            }
        });
        // ***************************
        this.dispose();
    }//GEN-LAST:event_btnCreateRecetteActionPerformed

    private void btnConsultRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultRecetteActionPerformed
        // Affichage du menu de saisie des offres de stage
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuConsultRecettes().setVisible(true);
            }
        });
        // ***************************
        this.dispose();
    }//GEN-LAST:event_btnConsultRecetteActionPerformed

    private void btnQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitterActionPerformed
        try
        {
            File fDossier;
            if(GestionRecette.pathSave.compareTo("") == 0)
            {
                fDossier = GestionRecette.fenetreInputPath();
            }
            else
            {
                fDossier = new File(GestionRecette.pathSave);
            }
            File fAliment = new File(fDossier + "/aliments");
            File fRecette = new File(fDossier + "/recettes");

            FileOutputStream fosAliment = new FileOutputStream(fAliment);
            FileOutputStream fosRecette = new FileOutputStream(fRecette);

            ObjectOutputStream oosAliment = new ObjectOutputStream(fosAliment);
            oosAliment.writeObject(GestionRecette.lesAliments);
            oosAliment.close();

            ObjectOutputStream oosRecette = new ObjectOutputStream(fosRecette);
            oosRecette.writeObject(GestionRecette.lesRecettes);
            oosRecette.close();
        }
        catch(IOException e)
        {
            GestionRecette.fenetre("Problème d'I/O");
        }
        GestionRecette.fenetre("Données sauvegardées avec succès !");
        this.dispose();
    }//GEN-LAST:event_btnQuitterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    new MenuPrincipal().setVisible(true);
                }
                catch(IOException ex)
                {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(ClassNotFoundException ex)
                {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultRecette;
    private javax.swing.JButton btnCreateAliment;
    private javax.swing.JButton btnCreateRecette;
    private javax.swing.JButton btnQuitter;
    private javax.swing.JLabel labelTitre;
    // End of variables declaration//GEN-END:variables
}