import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionProjects implements ActionListener{
    public JFrame frame ; 
    public String action ; 
    public Lecture lecture ;
 
    public ActionProjects(String action, JFrame frame, Lecture lecture){
        this.frame = frame ; 
        this.action = action; 
        this.lecture = lecture ; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        switch (action) {
            //case "Generate the student list" :
            case "Add a new project":
            Menu.refresh(frame,4); 
            create_project(); 
            break ; 

            case "Remove a project":
            Menu.refresh(frame,4); 
            remove_project();
            break; 
             

            case "My projects":
            Menu.refresh(frame,4); 
            my_projects();
            break; 

            case "Grade students" :
            

            break ;  

            case "Check all my projects" :
            check_all_projects();  
            break ; 

         
        }
    }

    public void create_project() {
        Menu.refresh(frame,4); 
        JLabel nameproject = new JLabel("Project Name");
        nameproject.setBounds(100, 200, 150, 25);
        frame.add(nameproject);

        JLabel deadline = new JLabel("Deadline");
        deadline.setBounds(100, 230, 150, 25);
        frame.add(deadline);

        JLabel explication = new JLabel("Explication");
        explication.setBounds(100, 250, 150, 25);
        frame.add(explication);

        JTextField nameproject_text = new JTextField(20);
        nameproject_text.setBounds(300, 200, 300, 25);
        frame.add(nameproject_text);


        JTextField deadline_text = new JTextField(20);
        deadline_text.setBounds(300, 230, 300, 25);
        frame.add(deadline_text);

        JTextField explication_text = new JTextField(20);
        explication_text.setBounds(300, 250, 300, 100);
        frame.add(explication_text);

        JButton create_project = new JButton("Create project");
        create_project.setBounds(300, 400, 150, 25);
        frame.add(create_project);

        frame.revalidate();
        frame.repaint();
        explication.setVisible(true);
        explication_text.setVisible(true);
        nameproject.setVisible(true);
        deadline.setVisible(true);
        nameproject_text.setVisible(true);
        deadline_text.setVisible(true);
        create_project.setVisible(true);
        frame.revalidate();
        frame.repaint();
        create_project.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
            Container contentPane = frame.getContentPane(); 
            Component[] components = contentPane.getComponents(); 
            String subject = ((JTextField)(contentPane.getComponent(7))).getText();
            String deadline = ((JTextField)(contentPane.getComponent(8))).getText();
            String explication = ((JTextField)(contentPane.getComponent(9))).getText();
            Project pro = new Project(lecture, subject, new MyDate(deadline), explication); 
            lecture.add_project(pro);
            String t = " Your project  has been successfully created \n"  + pro.toString() + "\n If you want to add pairs, go to 'My projects', select your project and add yours pairs there ";   
            JLabel texte = new JLabel("<html>" + t.replace("\n", "<br/>") + "</html>");
            texte.setLayout(null);
            texte.setBounds(300, 400, 1000, 100);
            
            texte.setVisible(true);
            frame.revalidate(); 
            frame.repaint();
            frame.add(texte);
            Menu.refresh(frame, 4); 
            /* 
            for (int i = 4; i<= 10 ; i++){
                frame.remove(components[i]);  
            }*/
            frame.revalidate();
            frame.repaint();
            JButton OK = new JButton("OK");
            
            OK.setBounds(300, 600, 150, 25);
            frame.add(OK); 
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    
                    Container contentPane = frame.getContentPane(); 
                    Component[] components = contentPane.getComponents(); 
                    Menu.refresh(frame, 4); 
                    /*frame.remove(components[4]);
                    frame.remove(components[5]);
                    frame.revalidate(); 
                    frame.repaint();*/
                }
            });
            }
    });
}
    
    public void remove_project(){
        
    }

    public void my_projects(){ 

        JButton grade_students = new JButton("Grade students"); 
        grade_students.setBounds(100, 250, 150, 25);
        frame.add(grade_students);
        grade_students.addActionListener(new ActionProjects("Grade students", frame, lecture));

        JButton check = new JButton("Check all my projects"); 
        check.setBounds(100, 280, 200, 25);
        frame.add(check);
        grade_students.setVisible(true);
        check.setVisible(true);
        frame.revalidate(); 
        frame.repaint(); 
        //Menu.refresh(frame, 6); 
        check.addActionListener(new ActionProjects("Check all my projects", frame, lecture));

    }

    public void check_all_projects(){
        int i = 250 ; 
        ArrayList<Project> projects = lecture.lecture_project; 
        if (projects.size() == 0) { 
            JLabel project_null = new JLabel("You don't have any project ! "); 
            project_null.setBounds(300, 100, 200, 200);
            frame.add(project_null); 
            project_null.setVisible(true);
            JButton OK = new JButton("OK");
            OK.setBounds(300, 600, 150, 25);
            frame.add(OK); 
            frame.revalidate(); 
            frame.repaint();
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Container contentPane = frame.getContentPane(); 
                    Component[] components = contentPane.getComponents(); 
                    //for (int i = 0 ;i<components.length ; i++){System.out.println(components[i].getClass()); }
                    frame.remove(components[components.length -2]); 
                    frame.remove(components[components.length -1]); 
                    frame.revalidate();
                    frame.repaint();
                }
            });
        }
        else {
            for (Project project : projects){
            JButton projet_label = new JButton(project.toString()); 
            projet_label.setBounds(100, i, 300, 100);
            i+=20 ; 
            frame.add(projet_label);
            projet_label.setVisible(true);
            }
        }
        frame.revalidate();
        frame.repaint(); 
    }


}


    

