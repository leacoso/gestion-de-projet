import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


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
            
            case "Add a new project":
        
            Menu.refresh(frame,0); 
            create_project(); 
            break ; 

            case "My projects":

            Menu.refresh(frame,0); 
            check_all_projects(); 
            break; 
 
            case "Generate the students list" :
            check_all_projects();  
            break ;

            case "create2 my project": 
            create2_project();
            break;
        }
    }

    public void create_project() {
        Menu.refresh(frame, 0);
        frame.setLayout(null);

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

        JLabel error = new JLabel(" Your format is wrong, retry"); 
        error.setBounds(300, 100, 300, 25);
        frame.add(error);

        error.setVisible(false);
        explication.setVisible(true);
        explication_text.setVisible(true);
        nameproject.setVisible(true);
        deadline.setVisible(true);
        nameproject_text.setVisible(true);
        deadline_text.setVisible(true);
        create_project.setVisible(true);
        frame.revalidate();
        frame.repaint();
        create_project.addActionListener(new ActionProjects("create2 my project", frame, lecture));
}

    public void remove_project(Project project){
        Project.get_list_project_pair().remove(project) ; 
        lecture.lecture_project.remove(project) ;
        affiche_projects(frame, lecture);
    }

    public void create2_project(){

        frame.setLayout(null);
        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents();
    
        String subject = ((JTextField)(components[3])).getText();
        String deadline = ((JTextField)(components[4])).getText();
        String explication = ((JTextField)(components[5])).getText();
    
        if (! MyDate.verif_date(deadline)){

            ((JLabel)(components[7])).setVisible(true); 
            frame.revalidate();
            frame.repaint();
            create_project();
        }
        else {
            ((JLabel)(components[7])).setVisible(false);
            frame.revalidate();
            frame.repaint();
            Project pro = new Project(lecture, subject, new MyDate(deadline), explication); 
            lecture.add_project(pro);
            Menu.refresh(frame, 0);
            String t = " Your project  has been successfully created \n"  + pro.toString() + "\n If you want to add pairs, go to 'My projects', select your project and add yours pairs there ";   
            JLabel texte = new JLabel("<html>" + t.replace("\n", "<br/>") + "</html>");
            texte.setLayout(null);
            texte.setBounds(300, 400, 1000, 100);
            texte.setVisible(true);
            frame.add(texte); 
            frame.revalidate();
            frame.repaint();
            JButton OK = new JButton("OK");

            OK.setBounds(300, 600, 150, 25);
            frame.add(OK); 
            OK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){ 
                        Menu.refresh(frame, 0); 
                    }
                });

            }
            
    
        }

    public void add_pairs(Project project){
        Menu.refresh(frame, 0);
        ArrayList<Pair> pairs = Project.get_list_project_pair().get(project) ;
        ArrayList<Student> students = project.alone ;
        
        Table_pair model_pair = new Table_pair(pairs);
        Table_student model_student = new Table_student(students);
        JTable table_pair = new JTable(model_pair);
        JTable table_student = new JTable(model_student);
        
        table_student.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_student.getSelectionModel().setSelectionMode(2); 
        JScrollPane scrollPaneStudent = new JScrollPane(table_student);
        JScrollPane scrollPanePair = new JScrollPane(table_pair);
        scrollPaneStudent.setPreferredSize(new Dimension(300, 150)); // Exemple de taille
        scrollPanePair.setPreferredSize(new Dimension(300, 150));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneStudent, scrollPanePair);
        splitPane.setDividerLocation(500); 
        splitPane.setOneTouchExpandable(true); 
        frame.setLayout(new BorderLayout());

        
        JButton back = new JButton("back to menu");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                frame.setLayout(null);
            }
        });

        JButton button_add = new JButton("Add");
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 

                //JLabel error = new JLabel("It's the same student, please retry to create a new Pair"); 
                int selectedRow = table_student.getSelectedRow();
                if (selectedRow >= 0) {
                    if (Table_pair.getStudent(1) == null) {
                        //STUDENT 1
                        Table_pair.setStudent(1, students.get(selectedRow));
                    }
                    else {
                        //STUDENT 2
                        if (students.get(selectedRow).getStudent_number() == Table_pair.getStudent(1).getStudent_number() ){
                            //error.setVisible(true);
                            Table_pair.setStudent(1, null);
                            //frame.add(error);


                        }
                        else {
                            //error.setVisible(false);
                            Table_pair.setStudent(2, students.get(selectedRow));
                            Pair pair = new Pair(project, Table_pair.getStudent(1), Table_pair.getStudent(2), null) ;
                            project.alone.remove( Table_pair.getStudent(1)) ; 
                            project.alone.remove( Table_pair.getStudent(2)) ; 
                            Table_pair.setStudent(1, null);
                            Table_pair.setStudent(2, null);
                            Project.get_list_project_pair().get(project).add(pair); 
                            

                        }
                        add_pairs(project);
                        
                        
                        
                    }
                }
            }
        });
       
 
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(button_add);
        buttonBox.add(back);
        buttonBox.add(Box.createHorizontalStrut(10)); 

        //buttonBox.add(error); 

        buttonBox.add(Box.createHorizontalStrut(10)); 
        frame.setLayout(new BorderLayout());
        //frame.pack(); 
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.setVisible(true); 
        
    
    }

    public void manipulation_project(Project project,String action_project) {
        switch (action_project) {
            case "Check this project" :
            project_features(project) ; 
            break ; 

            case "Grade students" : 
            grade_students(project); 
            break ; 

            case "Add Pairs" :
            add_pairs(project); 
            break ; 

            case "Remove project" : 
            int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this project?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) { remove_project(project);  } 
            else {if (result == JOptionPane.CANCEL_OPTION) {affiche_projects(frame, lecture);}}
            break ; 
        }

    }

    public void project_features(Project project){

        Table_features model = new Table_features(project); 
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton backButton = new JButton("back to menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                frame.setLayout(null);
                Container contentPane = frame.getContentPane(); 
                Component[] components = contentPane.getComponents(); 
                for (Component co : components){co.setVisible(true);}
            }
        });

        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        for (Component co : components){co.setVisible(false);}
        frame.setLayout(new BorderLayout());
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(backButton);
        buttonBox.add(Box.createHorizontalStrut(10)); 
        buttonBox.add(backButton);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        
        
    }

    public void check_all_projects(){
       
        ArrayList<Project> projects = lecture.lecture_project; 
        if (projects.size() == 0) { 
            int result = JOptionPane.showConfirmDialog(frame, "You don't have any project !", null, JOptionPane.OK_OPTION);
            if (result == JOptionPane.OK_OPTION){ 
                Menu.refresh(frame, 0);
            }      
        }
        else {
            Menu.refresh(frame,0);
            affiche_projects(frame, lecture); 
    }
             
    }

    public void affiche_projects(JFrame frame, Lecture lecture){

        ArrayList<Project> projects2 = lecture.lecture_project ; 
        Table_project model = new Table_project(projects2);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton check = new JButton("Check this project");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project project = projects2.get(selectedRow);
                    manipulation_project(project,"Check this project"); 
                }
            }
        });

        JButton remove = new JButton ("Remove this project"); 
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project project = projects2.get(selectedRow);
                    manipulation_project(project,"Remove project"); 
                }
            }
        });


        JButton grade_student = new JButton ("Grade students"); 
        grade_student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project project = projects2.get(selectedRow);
                    manipulation_project(project,"Grade students"); 
                }
            }
        });


        JButton add_pairs = new JButton("Add Pairs");
        add_pairs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project project = projects2.get(selectedRow);
                    System.out.println(project.toString()); 
                    manipulation_project(project,"Add Pairs"); 

                }
            }
        });

        JButton backButton = new JButton("back to menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                frame.setLayout(null);
                Container contentPane = frame.getContentPane(); 
                Component[] components = contentPane.getComponents(); 
                for (Component co : components){co.setVisible(true);}
            }
        });

            Container contentPane = frame.getContentPane(); 
            Component[] components = contentPane.getComponents(); 
            for (Component co : components){co.setVisible(false);}
            frame.setLayout(new BorderLayout());
            Box buttonBox = Box.createHorizontalBox();
            buttonBox.add(check);
            buttonBox.add(add_pairs);
            buttonBox.add(grade_student);
            buttonBox.add(remove);
            buttonBox.add(Box.createHorizontalStrut(10)); 
            buttonBox.add(backButton);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonBox, BorderLayout.SOUTH);
            frame.revalidate();
            frame.repaint();

    }

    public void write_grade(Project project, Pair pair){
        Menu.refresh(frame, 0);
        frame.setLayout(null); 

        JLabel oral_grade = new JLabel("Oral grade");
        oral_grade.setBounds(100, 200, 300, 25);
        frame.add(oral_grade);

        JLabel s1_grade =  new JLabel("Student 1 grade ( "+ pair.getStudent1().getFirstname() + " " +pair.getStudent1().getLastname()+ ")");
        s1_grade.setBounds(100, 230, 300, 25);
        frame.add(s1_grade);

        JLabel s2_grade = new JLabel("Student 2 grade ( "+ pair.getStudent2().getFirstname() + " " +pair.getStudent2().getLastname()+ ")");
        s2_grade.setBounds(100, 260, 300, 25);
        frame.add(s2_grade);

        JLabel due_date = new JLabel("due_date");
        due_date.setBounds(100, 290, 300, 25);
        frame.add(due_date);

        JTextField oral_grade_text = new JTextField(20);
        oral_grade_text.setBounds(400, 200, 300, 25);
        frame.add(oral_grade_text);

        JTextField s1_grade_text = new JTextField(20);
        s1_grade_text.setBounds(400, 230, 300, 25);
        frame.add(s1_grade_text);

        JTextField s2_grade_text = new JTextField(20);
        s2_grade_text.setBounds(400, 260, 300, 25);
        frame.add(s2_grade_text);

        JTextField due_date_text = new JTextField(20);
        due_date_text.setBounds(400, 290, 300, 25);
        frame.add(due_date_text);

        JButton OK = new JButton("OK"); 
        OK.setBounds(400, 320, 300, 25); 
        frame.add(OK); 

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    Container contentPane = frame.getContentPane(); 
                    Component[] components = contentPane.getComponents(); 
                    String oral_grade = ((JTextField)(components[4])).getText(); 
                    String s1_grade = ((JTextField)(components[5])).getText(); 
                    String s2_grade = ((JTextField)(components[6])).getText(); 
                    String due_date = ((JTextField)(components[7])).getText(); 
                    

                    if (Pair.verif_grade(oral_grade, s1_grade, s2_grade) && MyDate.verif_date(due_date)){
                        pair.setDueDate(new MyDate(due_date));
                        pair.setOralGrade(Double.parseDouble(oral_grade));
                        pair.setS1Grade(Double.parseDouble(s1_grade)); 
                        pair.setS2Grade(Double.parseDouble(s2_grade));
                        int result = JOptionPane.showConfirmDialog(frame, "Your pair have been graduated", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) { grade_students(project);  }  
                    }
                    else {
                        write_grade( project, pair) ; 
                    } 
                
            }
    });
            
        frame.revalidate();
        frame.repaint();

    }

    public void grade_students(Project project){ 
        Menu.refresh(frame,0); 
        frame.setLayout(null); 

        ArrayList<Pair> pairs = Project.get_list_project_pair().get(project) ; 
        Table_pair model = new Table_pair(pairs);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton grade = new JButton("Grade this pair");
        grade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                Pair pair = pairs.get(selectedRow) ;
                if (pair.getGrade() != -1){
                    int result = JOptionPane.showConfirmDialog(frame, "You have already gradead this pair, put 'Annuler' to go back and 'OK' if you want to change the grade", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) { 
                        pair.setOralGrade(-1);
                        pair.setS1Grade(-1);
                        pair.setS2Grade(-1);
                        write_grade(project, pair); } 
                    else {
                        grade_students(project);
                        
                    }
                }
                else {
                    write_grade(project,pair);
                }
                }}); 

        JButton backButton = new JButton("back to menu");
        backButton.addActionListener(new ActionListener() {
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
        buttonBox.add(backButton);
        buttonBox.add(grade);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();

    }
    

          
          

        
    }
    
       




    

