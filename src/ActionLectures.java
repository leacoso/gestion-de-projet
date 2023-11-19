import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows access to all the features concerning a lecture
public class ActionLectures implements ActionListener {
    public Lecture lecture ; 
    public JFrame frame ; 
    public String action ; 
    public int case_action ; 

    public ActionLectures(JFrame frame, String action, int case_a){
        this.frame = frame; 
        this.action = action ; 
        case_action = case_a ; 
    }
    //This function return the lecture associated to the name of the lecture and its level
    public Lecture find_Lecture(String name1, String niveau1){
        for (Lecture lecture : General_List.list_lecture){
            if ((lecture.get_name().equalsIgnoreCase(name1)) && (lecture.get_grade().equalsIgnoreCase(niveau1))){ 
                this.lecture = lecture ; 
                return lecture ; 
            }
        } 
        return null; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        Menu.refresh(frame,0);
        String[] list = action.split(",");
        Lecture lecture = find_Lecture(list[0].trim(), list[1].trim());
        

        switch(case_action){
            case 1 : 
            //Use the features that manipulate this course

            Menu.refresh_menu(frame); 

            JMenuBar menubar = frame.getJMenuBar();
            JMenu current_lecture = new JMenu(action); 
            menubar.add(current_lecture);  // Add the new lecture

            JMenuItem add_project = new JMenuItem("Add a new project");
            current_lecture.add(add_project);

            JMenuItem generate_student_list = new JMenuItem("Generate the students list");
            current_lecture.add(generate_student_list);

            JMenuItem check_project = new JMenuItem("My projects");
            current_lecture.add(check_project);

            generate_student_list.addActionListener(new ActionLectures(frame, action ,2)); 
            add_project.addActionListener(new ActionProjects("Add a new project", frame, lecture));
            check_project.addActionListener(new ActionProjects("My projects", frame, lecture));
            frame.revalidate();
            frame.repaint();
            break; 

            case 2 : 
            //Print the students of this lecture
            print_students(); 
            break; 
            

        }


    }

    //This function displays all students of this lecture
    public void print_students(){

        ArrayList<Student> students = lecture.get_lecture_student() ;
        Table_student model = new Table_student(students);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JButton back = new JButton("back to menu");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                frame.setLayout(null);
            }
        });

        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        for (Component co : components){co.setVisible(false);}
        frame.setLayout(new BorderLayout());
        
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(10)); 
        buttonBox.add(back);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();


    }
}
  