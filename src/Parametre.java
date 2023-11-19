import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JOptionPane;



public class Parametre implements ActionListener{
    private JFrame frame ;  
    private String action ; 
 
    public Parametre(JFrame f, String action){
        frame = f; 
        this.action = action; }

    @Override
    public void actionPerformed(ActionEvent e) {
        Menu.refresh(frame,0);
        switch (action) {

            case "Deconnexion": 

            Menu.refresh(frame, 0); //Remove all the components (Label, Text) of the frame. 
            frame.setJMenuBar(null);  //Remove the menu with the lectures
            Menu.identification(frame);
            break ; 

            case "A propos":

            Menu.refresh(frame, 0);
            String resume = "Gestion des étudiants : permet de créer et de gérer les profils des étudiants, y compris leurs informations personnelles, leurs compétences et leurs projets.\n Gestion des binômes projet : permet de créer et de gérer les binômes projet, y compris les étudiants qui les composent et les rôles de chacun.\n" +
            "Gestion des tâches : permet de créer et de gérer les tâches, y compris leurs descriptions, leurs deadlines et leurs statuts.\n" +
            "Gestion des deadlines : permet de définir et de suivre les deadlines des tâches.\n" +
            "Gestion des réunions : permet de planifier et de suivre les réunions.\n" +
            "Avantages\n" + "\n" + "L'application offre plusieurs avantages aux étudiants, notamment :\n" + "\n" +
            
                            "Une meilleure organisation : l'application permet aux étudiants de mieux organiser leurs projets en centralisant toutes les informations et les tâches dans un seul endroit.\n" +
                            "Une meilleure communication : l'application permet aux étudiants de communiquer plus facilement entre eux et avec les professeurs.\n" +
                            "Une meilleure collaboration : l'application permet aux étudiants de collaborer plus efficacement sur leurs projets.\n" +
                            "Disponibilité\n" +
                            "\n" +
                            "L'application est disponible sur PC, Mac, Android et iOS.\n" +
                            "\n" +
                            "Contact\n" +
                            "\n" +
                            "Pour plus d'informations, veuillez contacter l'équipe de développement de l'application à l'adresse suivante :\n" +
                            "\n" +
                            "[adresse email]\n" +
                            "\n" +
                            "Conclusion\n" +
                            "\n" +
                            "L'application de gestion de projets pour les étudiants de Dauphine est un outil précieux qui peut aider les étudiants à réussir leurs projets. Elle est facile à utiliser et offre de nombreuses fonctionnalités pour améliorer l'organisation, la communication et la collaboration.\n" +
                            "\n" +
                            "J'ai ajouté une ligne vide à la fin pour faciliter la lecture.";
                            

            JLabel message = new JLabel("<html>" + resume.replace("\n", "<br/>") + "</html>");            
            message.setBounds(20, 20, 960, 560);
            frame.add(message);
            message.setVisible(true);
            frame.revalidate(); 
            frame.repaint(); 
            break; 

            case "Exit" : 
            Pause();
            break ;  
 
                }
            }
            public void Pause(){
            Menu.refresh(frame, 0); //Remove all the components (Label, Text) of the frame. 
            frame.setJMenuBar(null);  //Remove the menu with the lectures
            JButton continu = new JButton ("Log in");
            continu.setBounds(330, 200, 400, 50);
            frame.add(continu);
            continu.addActionListener(new Parametre(frame ,"Deconnexion"));
        
}
        
            
    
}
