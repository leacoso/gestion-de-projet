import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionLectures implements ActionListener {
    public Lecture lecture ; 
    public JFrame frame ; 
    public String action ; 

    public ActionLectures(JFrame frame, String action){
        this.frame = frame; 
        this.action = action ; 
    }

    public Lecture find_Lecture(String name1, String niveau1){
        for (Lecture lecture : List.list_lecture){
            if ((lecture.get_name().equalsIgnoreCase(name1)) && (lecture.get_grade().equalsIgnoreCase(niveau1))){
                return lecture ; 
            }
        } 
        return null; 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand(); 
        String[] list = action.split(",");
        Lecture lecture = find_Lecture(list[0].trim(), list[1].trim());

        JButton generate_student_list = new JButton("Generate the student list");
        generate_student_list.setBounds(100, 40, 150, 25);
        frame.add(generate_student_list);

        JButton add_project = new JButton("Add a new project");
        add_project.setBounds(300, 40, 150, 25);
        frame.add(add_project);

        JButton remove_project = new JButton("Remove a project");
        remove_project.setBounds(500, 40, 150, 25);
        frame.add(remove_project);

        JButton check_project = new JButton("Check my projects");
        check_project.setBounds(700, 40, 150, 25);
        frame.add(check_project);

        frame.revalidate();
        frame.repaint();
        generate_student_list.setVisible(true);
        add_project.setVisible(true);
        remove_project.setVisible(true);
        check_project.setVisible(true);
        //generate_student_list.addActionListener(new ActionList("Generate the student list", frame,lecture));
        add_project.addActionListener(new ActionProjects("Add a new project", frame, lecture));
        remove_project.addActionListener(new ActionProjects("Remove a project", frame, lecture));
        check_project.addActionListener(new ActionProjects("Check my projects", frame, lecture));
        Container contentPane = frame.getContentPane(); 
            Component[] components = contentPane.getComponents(); 
            for (int i = 0 ; i<components.length; i++ ){
                System.out.println(components[i].getClass()); 
            }   
        }
}
  