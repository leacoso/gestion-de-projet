import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
            my_projects();
            break; 

            case "Grade students" :
            break ;  

            case "Check all my projects" :
            check_all_projects();  
            break ; 

            case "Generate the students list" :
            check_all_projects();  
            break ;

            case "create2 my project": 
            create2_project();
            break;
            
            



         
        }
    }

    public void different_grades(Project p,HashMap<Project, ArrayList<Pair>> list_project_pair){
        // Création d'un tableau pour stocker les notes pour obtenir la meilleure, la pire,
        // la moyenne et la médiane

        ArrayList<Double> dif_grades = new ArrayList<>();

        //pour chaque binome de la liste des binomes du Projet p
        for (ArrayList<Pair> pairs : list_project_pair.values()) {
            for (Pair pair : pairs) {
                System.out.println(pair.getGrade());
                dif_grades.add(pair.getGrade());
            }
        }

        // Trier dans l'odre croissant les notes
        Collections.sort(dif_grades);

        // Pire note
        System.out.println(dif_grades.get(0));

        // Meilleure note
        int lastIndex = dif_grades.size() - 1;
        System.out.println(dif_grades.get(lastIndex));

        // Moyenne
        double sum = 0.0;
        for (double grade : dif_grades) {
            sum += grade;
        }

        double average = sum / dif_grades.size();
        System.out.println("Moyenne des notes : " + average);

        // Médiane
         double median;
         int size = dif_grades.size();
 
         if (size % 2 == 0) {
             // Si la taille de la liste est paire, la médiane est la moyenne des deux valeurs du milieu
             int middleIndex1 = size / 2 - 1;
             int middleIndex2 = size / 2;
             median = (dif_grades.get(middleIndex1) + dif_grades.get(middleIndex2)) / 2.0;
         } else {
             // Si la taille de la liste est impaire, la médiane est la valeur du milieu
             int middleIndex = size / 2;
             median = dif_grades.get(middleIndex);
         }
 
         // Affichage de la médiane
         System.out.println("Médiane : " + median);
     }

    

    public void create_project() {
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
        create_project.addActionListener(new ActionProjects("create2 my project", frame, lecture));
}

    public void remove_project(){
        
    }

    public void create2_project(){
       
        Container contentPane = frame.getContentPane(); 
        Component[] components = contentPane.getComponents(); 
        //while (((JTextField)(contentPane.getComponent(3))).getText().isEmpty())
        String subject = ((JTextField)(contentPane.getComponent(3))).getText();
        String deadline = ((JTextField)(contentPane.getComponent(4))).getText();
        String explication = ((JTextField)(contentPane.getComponent(5))).getText();
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

    
            

    public void my_projects(){ 

        JButton grade_students = new JButton("Grade students"); 
        grade_students.setBounds(700, 70, 200, 25) ; 
        frame.add(grade_students);
        grade_students.addActionListener(new ActionProjects("Grade students", frame, lecture));
        
        JButton check = new JButton("Check all my projects"); 
        check.setBounds(700, 100, 200, 25) ; 
        frame.add(check);
        grade_students.setVisible(true);
        check.setVisible(true);
        frame.revalidate(); 
        frame.repaint(); 
        //Menu.refresh(frame, 6); 
        check.addActionListener(new ActionProjects("Check all my projects", frame, lecture));

    }

    public void check_all_projects(){
       
        ArrayList<Project> projects = lecture.lecture_project; 
        if (projects.size() == 0) { 
            JLabel project_null = new JLabel("You don't have any project ! "); 
            project_null.setBounds(300, 100, 200, 200);
            frame.add(project_null); 
            project_null.setVisible(true);
            JButton OK = new JButton("OK");
            OK.setBounds(300, 230, 150, 25);
            frame.add(OK); 
            frame.revalidate(); 
            frame.repaint();
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Container contentPane = frame.getContentPane(); 
                    Component[] components = contentPane.getComponents(); 
                    frame.remove(components[components.length -2]); 
                    frame.remove(components[components.length -1]); 
                    frame.revalidate();
                    frame.repaint();
                }
            });
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

        JButton modifyButton = new JButton("Modify");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Project selectedProject = projects2.get(selectedRow);
                }
            }
        });

        JButton backButton = new JButton("back to menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.refresh(frame,0);
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
            buttonBox.add(modifyButton);
            buttonBox.add(Box.createHorizontalStrut(10)); 
            buttonBox.add(backButton);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonBox, BorderLayout.SOUTH);

            frame.revalidate();
            frame.repaint();

    }



          
          

        
    }
    
       




    

