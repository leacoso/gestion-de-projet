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

    public Lecture find_Lecture(String name1, String niveau1){
        for (Lecture lecture : List.list_lecture){
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
            Menu.refresh_menu(frame); 
            JMenuBar menubar = frame.getJMenuBar();
            JMenu current_lecture = new JMenu(action); 
            menubar.add(current_lecture); 
            JMenuItem add_project = new JMenuItem("Add a new project");
            current_lecture.add(add_project);
            JMenuItem generate_student_list = new JMenuItem("Generate the students list");
            current_lecture.add(generate_student_list);
            JMenuItem check_project = new JMenuItem("My projects");
            current_lecture.add(check_project);
            generate_student_list.addActionListener(new ActionLectures(frame, action ,2)); //actionn = lecture
            add_project.addActionListener(new ActionProjects("Add a new project", frame, lecture));
            check_project.addActionListener(new ActionProjects("My projects", frame, lecture));
            frame.revalidate();
            frame.repaint();
            break; 

            case 2 : 
            //Generate the student list 
            affiche_students(); 
            break; 
            



        }


    }

    public void affiche_students(){
        ArrayList<Student> students = lecture.lecture_student ;
        Table_student model = new Table_student(students);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JButton modifyButton = new JButton("Modify");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Student selectedProject = students.get(selectedRow);
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
  