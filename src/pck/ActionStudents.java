package pck;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;


//This class allows access to all the features concerning a lecture
public class ActionStudents implements ActionListener {
    public Lecture lecture ; 
    public JFrame frame ; 
   

    public ActionStudents(JFrame frame, Lecture lecture){
        this.frame = frame; 
        this.lecture = lecture; 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Menu.refresh(frame,0);
        ArrayList<Student> total_list = General_List.student_list ; 
        ArrayList<Student> list_lecture = lecture.get_lecture_student_list();  
        ArrayList<Student> list_not_in_lecture = (ArrayList<Student>) total_list.clone(); 
        for (Student s :list_lecture ) {
        	General_List.remove_from_list(list_not_in_lecture, s);
        }
        print_students_not_in_lecture(list_not_in_lecture); 
        
    }
    
  
    public void add_student_in_lecture(Student student, Lecture lecture) {
    	ArrayList <Education> educations = General_List.get_education_from_lecture(lecture);
        for (Education ed : educations ){
        	General_List.get_student_from_education(ed).add(student); }
    }


    public void print_students_not_in_lecture(ArrayList<Student> list) {
    		Menu.refresh(frame, 0);
            Table_student model = new Table_student(list);
            JTable table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(table);
            
            JButton add = new JButton("Add this student"); 
            add.addActionListener(new ActionListener() {
            	
            	@Override
            	public void actionPerformed(ActionEvent e) {
            		int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                    	Student student = (Student) list.get(selectedRow) ; 
                    	add_student_in_lecture(student,lecture);
                    	General_List.remove_from_list(list, student) ; 
                    }
                    
                    print_students_not_in_lecture(list); 
                    
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
            buttonBox.add(add);

            
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonBox, BorderLayout.SOUTH);
            frame.revalidate();
            frame.repaint();


        }
    
    
   
}
  