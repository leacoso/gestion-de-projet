import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu {

    public static void identification(JFrame frame){
        
        frame.setLayout(null);
        JLabel userLabel = new JLabel("Nom d'utilisateur ");
        userLabel.setBounds(300, 60, 150, 25);
        frame.add(userLabel);
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(300, 100, 150, 25);
        frame.add(passwordLabel);
        JTextField usertext = new JTextField(20);
        usertext.setBounds(500, 60, 150, 25);
        frame.add(usertext);
        JTextField passtext = new JTextField(20);
        passtext.setBounds(500, 100, 150, 25);
        frame.add(passtext);
        JButton bouttonid = new JButton("S'identifier");
        bouttonid.setBounds(500, 260, 150, 25);
        frame.add(bouttonid);
        JLabel errorMessage = new JLabel("");
        errorMessage.setBounds(600, 300, 250, 25);
        frame.add(errorMessage);
        userLabel.setVisible(true);
        passwordLabel.setVisible(true);
        usertext.setVisible(true);
        passtext.setVisible(true);
        bouttonid.setVisible(true);
        bouttonid.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String user = usertext.getText(); 
                String password = passtext.getText();
                if (Teacher.verif(user, password) == false ){
                    errorMessage.setText("Identifiant ou mot de passe incorrect, merci de reessayer");}
                else {
                    userLabel.setVisible(false);
                    passwordLabel.setVisible(false);
                    usertext.setVisible(false);
                    passtext.setVisible(false);
                    bouttonid.setVisible(false);
                    errorMessage.setVisible(false);
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    Teacher teacher = Teacher.get_teacher(user); 
                    createMenu(frame, teacher);
                }
            }
        });
    }

    public static void createMenu(JFrame frame, Teacher teacher){

        String user = teacher.get_user(); 
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu mes_cours = new JMenu("MES COURS"); 
        menubar.add(mes_cours); 

        //ADD ALL THE SUBJECTS OH THE TEACHER 
        ArrayList<String> subjects = Teacher.get_subject(user);  
        for (String sub : subjects){
            JMenuItem cours = new JMenuItem(sub); 
            mes_cours.add(cours);
            cours.addActionListener(new ActionLectures(frame,sub)); 
        }

        JMenu parametre = new JMenu(" PARAMETRE"); 
        menubar.add(parametre); 

        JMenuItem deconnexion = new JMenuItem("DECONNEXION");
        parametre.add(deconnexion);

        JMenuItem a_propos = new JMenuItem("ABOUT");
        parametre.add(a_propos);

        a_propos.addActionListener(new Parametre(frame, "A propos")); 
        deconnexion.addActionListener(new Parametre(frame, "Deconnexion")); 
        }

    public static void refresh(JFrame frame){
        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        for (int i = 0 ; i< components.length; i++){frame.remove(components[i]);  }
        }
        public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<String> list = new ArrayList<>();
        list.add("maths,M1"); 
        list.add("info,M2");  

        Teacher t = new Teacher("Lea", "lahyani", "1", "OK",list); 
        System.out.println(Teacher.get_subject("OK")); 
       
        Teacher.ajout_user_password("1", "OK"); 
        Teacher.ajout_user_subject("1", list); 
        Teacher.ajout_user_teacher("1", t);
        identification(frame);

       
    }

}
