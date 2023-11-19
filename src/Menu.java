import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;


/*This class is the main class that will allow the graphical interface to start. 
This class enables the manipulation of the interface and the management of different actions */

public class Menu {


    public static void identification(JFrame frame){
        frame.setLayout(null);

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
                    refresh(frame, 0);
                    Teacher teacher = Teacher.get_teacher(user);  //
                    createMenu(frame, teacher);
                }
            }
        });
    }

    public static void createMenu(JFrame frame, Teacher teacher){

        String user = teacher.get_user(); 
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu my_lectures = new JMenu("MY LECTURES"); 
        menubar.add(my_lectures); 

        //We add all the lectures of the teacher
        ArrayList<Lecture> lectures = Teacher.get_subject(user); 
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

        frame.setJMenuBar(menubar);
        frame.revalidate();
        frame.repaint();

        about.addActionListener(new Parametre(frame, "A propos")); 
        logout.addActionListener(new Parametre(frame, "Deconnexion")); 
        exit.addActionListener(new Parametre(frame, "Exit"));

    }

    //This function removes all components from the frame starting from the j item component
    public static void refresh(JFrame frame, int j){

        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        for (int i = j ; i< components.length; i++){ frame.remove(components[i]); }
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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    General_List.initData(); 
   

    //ArrayList<Lecture> lectures = new ArrayList<>(keys);
    //General_List.list_lecture = lectures; 
    ArrayList<Lecture>  lectures = General_List.list_lecture ; 
    ArrayList<Lecture> listp = new ArrayList<>(); 
    listp.add(lectures.get(0)); 
    listp.add(lectures.get(5)); 
    listp.add(lectures.get(3)); 
    Teacher t1 = new Teacher ("gab", "lahyani", "1", "OK", listp);
    System.out.println(Teacher.get_subject("OK")); 
    Teacher.ajout_user_password("1", "OK"); 
    Teacher.ajout_user_subject("1", listp); 
    Teacher.ajout_user_teacher("1", t1);
    identification(frame);

}

}