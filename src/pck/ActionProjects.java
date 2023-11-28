package pck;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Component;


public class ActionProjects implements ActionListener{
    public JFrame frame ;  // current frame
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
 
            case "create2 my project": 
            create2_project();
            break;
        }
    }

    //create_project and create2_project create a project with name, subject, deadline. 
    public void create_project() {
        Menu.refresh(frame, 0);
        frame.setLayout(null);

        JLabel nameproject = new JLabel("Project Name");
        nameproject.setBounds(100, 200, 200, 25);
        frame.add(nameproject);

        JLabel deadline = new JLabel("Deadline (DD/MM/YYYY)");
        deadline.setBounds(100, 230, 200, 25);
        frame.add(deadline);

        JLabel explication = new JLabel("Explication");
        explication.setBounds(100, 250, 200, 25);
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
   
    public void create2_project(){

        frame.setLayout(null);
        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents();
    
        String subject = ((JTextField)(components[3])).getText();
        String deadline = ((JTextField)(components[4])).getText();
        String explication = ((JTextField)(components[5])).getText();
    
        if (! MyDate.verif_date(deadline)){

            JOptionPane.showConfirmDialog(frame, "Your format is wrong, Please retry", "Wrong format", JOptionPane.DEFAULT_OPTION);
            create_project();
        }

        else {

            Project pro = new Project(lecture, subject, new MyDate(deadline), explication); 
            lecture.add_project(pro);
            JOptionPane.showConfirmDialog(frame, "Your project has been successfully created \n"  + pro.toString() + "\n If you want to add pairs, go to 'My projects', select your project and add yours pairs there ", "Confirmation", JOptionPane.DEFAULT_OPTION);  
            Menu.refresh(frame, 0);

        }
    }

    //This function verify that there exists at least one project.
    public void check_all_projects(){
       
        ArrayList<Project> projects = lecture.get_lecture_project(); 
        if (projects.size() == 0) { 
            //No project
            JOptionPane.showConfirmDialog(frame, "You don't have any project !", null, JOptionPane.DEFAULT_OPTION);
            Menu.refresh(frame, 0);
       
        }
        else {
            Menu.refresh(frame,0);
            print_projects(frame, lecture);
    }
             
    }
    
    //This function prints in a table all the projects of the lecture
    public void print_projects(JFrame frame, Lecture lecture){

        ArrayList<Project> projects2 = lecture.get_lecture_project() ; 
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
                    manipulation_project(project,"Add Pairs"); 

                }
            }
        });
        
        JButton remove_pairs = new JButton("Remove pair");
        remove_pairs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project project = projects2.get(selectedRow);
                    manipulation_project(project,"Remove pair"); 

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
            buttonBox.add(remove_pairs); 
         
            buttonBox.add(Box.createHorizontalStrut(10)); 
            buttonBox.add(backButton);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonBox, BorderLayout.SOUTH);
            frame.revalidate();
            frame.repaint();

    }

    //This function manages various actions on a project, such as displaying project details, grading students, adding pairs, and deleting the project, based on the specified action
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
            else {if (result == JOptionPane.CANCEL_OPTION) {print_projects(frame, lecture);}}
            break ; 
            
            case "Remove pair" : 
            remove_pair(project); 
            break ; 
            
        }

    }

    //This function prints all the caracteristics of the projects ( best grade, average, number of pairs...)
    public void project_features(Project project){

        Table_features model = new Table_features(project); 
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                frame.setLayout(null);
                check_all_projects();
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
   
    //This function permits to the teacher to grade all the pairs in the project 'project'
    public void grade_students(Project project){
    	
        Menu.refresh(frame,0); 
        frame.setLayout(null); 

        ArrayList<Pair> pairs = Project.get_list_project_pair().get(project) ; //Retrieve all the pairs from the project
        Table_pair model = new Table_pair(pairs);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton grade = new JButton("Grade this pair"); 
        grade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selected = table.getSelectedRow(); // Select the pair you want to grade
                if (selected == -1){JOptionPane.showConfirmDialog(frame, "You have to select one pair", "No pair selected", JOptionPane.DEFAULT_OPTION);}  
                else {
                    Pair pair = pairs.get(selected) ;
                    if (pair.getGrade() != -1){ // The pair have been already gradead. 
                        int result = JOptionPane.showConfirmDialog(frame, "You have already gradead this pair, put 'Annuler' to go back and 'OK' if you want to change the grade", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {  // The teacher want to change the grade
                            pair.setOralGrade(-1);
                            pair.setS1Grade(-1);
                            pair.setS2Grade(-1);
                            write_grade(project, pair); } 
                        else { 
                            grade_students(project); // The teacher moves on to another pair. 
                        }
                    }
                    else {
                        write_grade(project,pair);
                    }

                }         
                
            }}); 

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0); 
                check_all_projects();                
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
    
    //This funtion grades the pair 'pair' in the project 'project'
    public void write_grade(Project project, Pair pair){
        Menu.refresh(frame, 0);
        frame.setLayout(null); 

        JLabel oral_grade = new JLabel("Oral grade /20");
        oral_grade.setBounds(100, 200, 300, 25);
        frame.add(oral_grade);

        JLabel s1_grade =  new JLabel("Student 1 grade ( "+ pair.getStudent1().getFirstname() + " " +pair.getStudent1().getLastname()+ ") /20");
        s1_grade.setBounds(100, 230, 300, 25);
        frame.add(s1_grade);

        JLabel s2_grade = new JLabel("Student 2 grade ( "+ pair.getStudent2().getFirstname() + " " +pair.getStudent2().getLastname()+ ") /20");
        s2_grade.setBounds(100, 260, 300, 25);
        frame.add(s2_grade);

        String due = "due_date" + "\n" + "deadline : " + project.getdeadline().toString(); 
        JLabel due_date = new JLabel("<html>" + due.replace("\n", "<br/>") + "</html>"); 
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
                        JOptionPane.showConfirmDialog(frame, "Your pair have been graduated\n" 
                        + pair.getStudent1().getFirstname() + " " +pair.getStudent1().getLastname() + " : " + pair.final_grade_s1() +"\n" 
                        + pair.getStudent2().getFirstname() + " " +pair.getStudent2().getLastname() + " : " + pair.final_grade_s2() +"\n"
                        , "Confirmation", JOptionPane.DEFAULT_OPTION);
                        grade_students(project);  
                    }
                    else {
                        JOptionPane.showConfirmDialog(frame, "Your grades are not in the correct format, please retry", "Wrong format", JOptionPane.DEFAULT_OPTION);
                        write_grade( project, pair) ; 
                    } 
                
            }
    });
            
        frame.revalidate();
        frame.repaint();

    }

     /*  This function allows adding pairs to a specific project. It displays two tables: one for existing pairs and another for students without pairs. 
    Users can select students and pair them together. If an attempt is made to add the same student twice, an alert is displayed. */
    public void add_pairs(Project project){
    	
        Menu.refresh(frame, 0);
        
        ArrayList<Pair> pairs = General_List.get_pairs_from_project(project); 
        ArrayList<Student> students = project.IsAlone();
        Table_pair model_pair = new Table_pair(pairs);
        Table_student model_student = new Table_student(students);
        JTable table_pair = new JTable(model_pair);
        JTable table_student = new JTable(model_student);
        
        table_student.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_student.getSelectionModel().setSelectionMode(2); 

        JScrollPane scrollPaneStudent = new JScrollPane(table_student);
        JScrollPane scrollPanePair = new JScrollPane(table_pair);

        scrollPaneStudent.setPreferredSize(new Dimension(300, 150));
        scrollPanePair.setPreferredSize(new Dimension(300, 150));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneStudent, scrollPanePair);
        splitPane.setDividerLocation(500); 
        splitPane.setOneTouchExpandable(true); 
        frame.setLayout(new BorderLayout());

    
        JButton back = new JButton("Back to menu");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
                check_all_projects(); 
                
            }
        });

        JButton button_add = new JButton("Add");
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 

                int selectedRow = table_student.getSelectedRow();
                if (selectedRow >= 0) {
                    //Student 1
                    if (Table_pair.getStudent(1) == null) { Table_pair.setStudent(1, students.get(selectedRow));}
                    else {
                        if (students.get(selectedRow).getStudent_number() == Table_pair.getStudent(1).getStudent_number()){
                        	JOptionPane.showConfirmDialog(frame, "We cannot add the same students to a pair, Please add another pair", "Wrong pair", JOptionPane.DEFAULT_OPTION);
                            Table_pair.setStudent(1, null);
                        }
                        else {
                            //Student 2
                            Table_pair.setStudent(2, students.get(selectedRow));
                            Pair pair = new Pair(project, Table_pair.getStudent(1), Table_pair.getStudent(2), null) ; 
                            Table_pair.setStudent(1, null);
                            Table_pair.setStudent(2, null);
                            General_List.project_pair.get(project).add(pair); 
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
        frame.setLayout(new BorderLayout());
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.setVisible(true); 
        
    
    }
    
    
     //This function removes the project to the database
    public void remove_project(Project project){
        Project.get_list_project_pair().remove(project) ; 
        lecture.get_lecture_project().remove(project) ;
        print_projects(frame, lecture);
    }
    
    public void remove_pair(Project project) {
    	ArrayList<Pair> pairs = General_List.get_pairs_from_project(project); 
    	Table_pair model = new Table_pair(pairs);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        
                   
        JButton remove = new JButton ("remove this pair"); 
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                	Pair pair = (Pair) pairs.get(selectedRow) ; 
                	General_List.get_pairs_from_project(project).remove(selectedRow); 
                	
                }
                
                remove_pair(project); 
            }
        });
        
        
        
        
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
        buttonBox.add(remove);

        
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonBox, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();


    
    	
    }
         
          

        
    }
    
       




    

