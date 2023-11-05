import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionProjects implements ActionListener{
    public Project project ; 
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
        switch (action){

            //case "Generate the student list" :
            case "Add a new project": 
            JButton b = (JButton )e.getSource(); 
            JPanel p = (JPanel) b.getParent(); 
            // Verify that we don't have text
            Component[] ce = p.getComponents(); 
            if (ce.length > 4) {
            for (int i = 4 ; i< ce.length ; i++){p.remove(i);}
            }
            create_project(frame, lecture, p); 
            break ; 

            case "Remove a project":
             

            case "Check my projects":
        }
    }

    public static void create_project(JFrame frame, Lecture lecture, JPanel p) {
                
        JLabel nameproject = new JLabel("Project Name");
        nameproject.setBounds(300, 200, 150, 25);
        p.add(nameproject);

        JLabel deadline = new JLabel("Deadline");
        deadline.setBounds(300, 240, 150, 25);
        p.add(deadline);


        JTextField nameproject_text = new JTextField(20);
        nameproject_text.setBounds(500, 200, 150, 25);
        p.add(nameproject_text);


        JTextField deadline_text = new JTextField(20);
        deadline_text.setBounds(500, 240, 150, 25);
        p.add(deadline_text);
    
        JButton create_project = new JButton("Create project");
        create_project.setBounds(400, 300, 150, 25);
        p.add(create_project);

        p.revalidate();
        p.repaint();
        nameproject.setVisible(true);
        deadline.setVisible(true);
        nameproject_text.setVisible(true);
        deadline_text.setVisible(true);
        create_project.setVisible(true);
        //frame.add(p);
        p.revalidate();
        p.repaint();
        create_project.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
    
            JButton bouton = (JButton) e.getSource();
            JPanel panel = (JPanel)bouton.getParent();
            
            String subject = ((JTextField)(panel.getComponent(6))).getText();; 
            String deadline = ((JTextField)(panel.getComponent(7))).getText();
            Project pro = new Project(lecture, subject, new MyDate(deadline)); 
            String t = " Your project  has been successfully created \n"  + pro.toString() ;   
            JLabel texte = new JLabel("<html>" + t.replace("\n", "<br/>") + "</html>");
                   
            texte.setBounds(500, 300, 1000, 1000);
            texte.setHorizontalAlignment(JLabel.CENTER);
            texte.setVerticalAlignment(JLabel.CENTER);
            texte.setBounds(0, 0, texte.getWidth(), texte.getHeight());
            texte.setVisible(true);
            panel.revalidate(); 
            panel.repaint();
            panel.add(texte);
            Component[] ce = p.getComponents(); 
            for (int i = 4; i<= 8 ; i++){
                Component c = ce[i] ; 
                panel.remove(c); 

            }
            panel.revalidate();
            panel.repaint();

            
            
            }
    }
        );
   
    
        }

       

}
    

