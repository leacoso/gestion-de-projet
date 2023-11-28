package pck;
import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*This class is the main class that will allow the graphical interface to start. 
This class enables the manipulation of the interface and the management of different actions */

public class Menu {

    public static void identification(JFrame frame){
    	
        frame.setLayout(null);
        
        JLabel titleLabel = new JLabel("Welcome to ScholarProject ! ");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        titleLabel.setBounds(300, 50, 500, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER); 
        titleLabel.setForeground(Color.BLACK);
        frame.add(titleLabel);
        
        JLabel name1 = new JLabel ("Léa Cohen-Solal"); 
        name1.setFont(new Font("Serif", Font.PLAIN, 17));
        name1.setBounds(10, 680,200, 100);
        name1.setHorizontalAlignment(JLabel.CENTER); 
        name1.setForeground(Color.BLACK);
        frame.add(name1);
        
        JLabel name2 = new JLabel ("Melvin Guirchoun"); 
        name2.setFont(new Font("Serif", Font.PLAIN, 17));
        name2.setBounds(10,700,200, 100);
        name2.setHorizontalAlignment(JLabel.CENTER); 
        name2.setForeground(Color.BLACK);
        frame.add(name2);
        
        JLabel userLabel = new JLabel("User ");
        userLabel.setBounds(400, 200, 150, 25);
        frame.add(userLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(400, 250, 150, 25);
        frame.add(passwordLabel);

        JTextField usertext = new JTextField(20);
        usertext.setBounds(480, 200, 150, 25);
        frame.add(usertext);

        JTextField passtext = new JTextField(20);
        passtext.setBounds(480, 250, 150, 25);
        frame.add(passtext);

        JButton bouttonid = new JButton("Identification");
        bouttonid.setBounds(480, 280, 150, 25);
        frame.add(bouttonid);

        JLabel errorMessage = new JLabel("");
        errorMessage.setBounds(480, 310, 300, 25);
        frame.add(errorMessage);
        
        name1.setVisible(true);
        name2.setVisible(true);
        titleLabel.setVisible(true); 
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
                    errorMessage.setText("User or Password incorrect, please retry ");}
                else {
                    refresh(frame, 3);
                    Teacher teacher = General_List.teacher ; 
                    createMenu(frame, teacher);
                }
            }
        });
    }

    public static void createMenu(JFrame frame, Teacher teacher){
    	Menu.refresh(frame, 0);
    	frame.setLayout(null);
    	String t = "Interface of " + teacher.toString(); 
    	JLabel t_label = new JLabel(t) ; 
    	t_label.setFont(new Font("Serif", Font.PLAIN, 17));
    	t_label.setBounds(800,680,300,100);
    	t_label.setHorizontalAlignment(JLabel.CENTER); 
    	t_label.setForeground(Color.BLACK);
        frame.add(t_label);
        t_label.setVisible(true);
    	
        //String user = teacher.get_user(); 
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu my_lectures = new JMenu("MY LECTURES"); 
        menubar.add(my_lectures); 

        //We add all the lectures of the teacher
        ArrayList<Lecture> lectures = teacher.get_subject(); 
        ArrayList<String> subjects = Teacher.lecture_to_string(lectures);  
        for (String sub : subjects){
            JMenuItem lecture = new JMenuItem(sub); 
            my_lectures.add(lecture); 
            lecture.addActionListener(new ActionLectures(frame,sub, 1)); 
        }

        JMenu parameter = new JMenu(" PARAMETER"); 
        menubar.add(parameter); 

        JMenuItem logout = new JMenuItem("LOGOUT");
        parameter.add(logout);

        JMenuItem about = new JMenuItem("ABOUT");
        parameter.add(about);

        JMenuItem exit = new JMenuItem("EXIT");
        parameter.add(exit);
        
        JMenuItem add_new_lecture = new JMenuItem("ADD A NEW LECTURE");
        parameter.add(add_new_lecture);

        
        frame.setJMenuBar(menubar);
        frame.revalidate();
        frame.repaint();

        about.addActionListener(new Parametre(frame, "A propos")); 
        logout.addActionListener(new Parametre(frame, "Deconnexion")); 
        exit.addActionListener(new Parametre(frame, "Exit"));
        add_new_lecture.addActionListener(new Parametre(frame, "Add a new lecture"));
        

    }

    //This function removes all components from the frame starting from the j item component
    public static void refresh(JFrame frame, int j){

        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        for (int i = j; i< components.length; i++){frame.remove(components[i]); }
        frame.revalidate();
        frame.repaint();

    }
   
    //This function allows the removal of the current course displayed on the menu, to change it as requested by the professor.
    public static void refresh_menu(JFrame frame){

        JMenuBar menubar = frame.getJMenuBar();        
        if (menubar != null) {
            int size = menubar.getMenuCount();
            if (size > 2){menubar.remove(size - 1);}
            frame.revalidate(); 
            frame.repaint(); 
        }
    
}

    
public static void main(String[] args) {
    JFrame frame = new JFrame("Menu");
    frame.setVisible(true);
    frame.setSize(1000, 1000);
    frame.getContentPane().setBackground(new Color(250, 240, 230));    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    General_List.loadData();
    identification(frame);

}

}