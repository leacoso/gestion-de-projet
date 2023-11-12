import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

public class GestionProject implements ActionListener {
    private JFrame frame; 
    private Lecture lecture; 
    private String id_string ; 
    private Project projet ; 

    public GestionProject(JFrame f, Lecture lecture, String pro){
        frame = f; 
        this.lecture = lecture ; 
        id_string = pro ; 
    }

    @Override
    public void actionPerformed(ActionEvent e){}/* 
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        addDataToModel(model, "John", 25, "Male");
        Object[][] data = {}; 
        String id =(id_string.split(","))[0].trim();
        for (Project project : lecture.lecture_project){
            if (project.getid() == Integer.valueOf(id)){
                projet = project ; 
            }
        }
        //Affichage de mes binômes 
        ArrayList<Pair> pairs = Project.list_project_pair.get(projet);
        Object[][] data ; 
        for (Pair pair : pairs){
            data
        }
        JTable tableau = new JTable(l, new String[]{"Id", "Student 1", "Student 2", "due date", "oral grade"});


    }*/


    
}
