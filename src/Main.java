import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Exemple de Bannière");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Création du bouton
        JButton button = new JButton("Afficher la Bannière");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Affichage de la boîte de dialogue avec options 'OK' et 'Annuler'
                int result = JOptionPane.showConfirmDialog(frame, "Voulez-vous continuer ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    // Traitement pour l'option 'OK'
                    System.out.println("Option 'OK' sélectionnée");
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    // Traitement pour l'option 'Annuler'
                    System.out.println("Option 'Annuler' sélectionnée");
                }
            }
        });

        // Ajout du bouton à la fenêtre
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
