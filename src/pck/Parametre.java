package pck;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;




public class Parametre implements ActionListener{
    private JFrame frame ;  
    private String action ; 
 
    public Parametre(JFrame f, String action){
        frame = f; 
        this.action = action; }

    @Override
    public void actionPerformed(ActionEvent e) {
        Menu.refresh(frame,0);
        switch (action) {

            case "Deconnexion": 

            Menu.refresh(frame, 0); //Remove all the components (Label, Text) of the frame. 
            frame.setJMenuBar(null);  //Remove the menu with the lectures
            Menu.identification(frame);
            break ; 

            case "A propos":

            Menu.refresh(frame, 0);
            String resume = "About ScholarProjects\n"
            		+ "\n"
            		+ "Your Course and Project Management Assistant\n"
            		+ "\n"
            		+ "Welcome to ScholarProjects, the tool designed for educators looking to simplify the management of their courses and student projects. Our application offers a centralized platform where you can not only access all your courses but also enhance them according to your needs.\n"
            		+ "\n"
            		+ "Key Features:\n"
            		+ "\n"
            		+ "Complete Course Management: Easily access all your courses. You have the freedom to add new ones according to your teaching program.\n"
            		+ "\n "
            		+ "Project Administration :  Each course can be associated with one or more projects. You can add new projects, modify them, or delete them as your curriculum evolves.\n"
            		+ "\n Team Management and Evaluation :  For each project, organize your students into teams. You can create, modify, and assign grades to evaluate their performance.\n"
            		+ "\n Adding Courses and Students : Our flexible system allows you to easily add new courses to your program. Moreover, enrolling new students in your existing courses is a breeze.\n"
            		+ "\n Intuitive Interface : Designed for educators, our interface is intuitive and easy to use."; 
                            

            JLabel message = new JLabel("<html>" + resume.replace("\n", "<br/>") + "</html>");            
            message.setBounds(20, 20, 960, 560);
            frame.add(message);
            message.setVisible(true);
            frame.revalidate(); 
            frame.repaint(); 
            break; 

            case "Exit" :
            General_List.saveData(); 
            System.exit(0); 
            break ;  
 
            case "Add a new lecture" : 
            add_new_lecture(); 
                }
            }
    
    public void add_new_lecture() {
    	Menu.refresh(frame, 0);
    	Teacher teacher = General_List.teacher ; 
    	ArrayList<Lecture> total_lectures =(ArrayList<Lecture>) General_List.list_lecture.clone() ; 
    	ArrayList<Lecture> teacher_lectures = teacher.get_subject(); 
    	for (Lecture lec : teacher_lectures) {
    		General_List.remove_from_list_lecture(total_lectures, lec);
    	}
    	Table_lecture model = new Table_lecture(total_lectures);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JButton add = new JButton("Add this lecture"); 
        add.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                	Lecture lecture = (Lecture) total_lectures.get(selectedRow) ; 
                	teacher.get_subject().add(lecture); 
                	JOptionPane.showConfirmDialog(frame, "Your lecture have been added", "Confirmation", JOptionPane.DEFAULT_OPTION);
                	Menu.createMenu(frame, teacher); 
                }
                
                
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
            
           
