import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        switch (action){

            //case "Generate the student list" :
            case "Add a new project":
            create_project(); 
            break ; 

            case "Remove a project":
            remove_project();
            break; 
             

            case "Check my projects":
            check_my_projects();
            break; 
        }
    }

    public void create_project() {
    
        JLabel nameproject = new JLabel("Project Name");
        nameproject.setBounds(300, 200, 150, 25);
        frame.add(nameproject);

        JLabel deadline = new JLabel("Deadline");
        deadline.setBounds(300, 240, 150, 25);
        frame.add(deadline);


        JTextField nameproject_text = new JTextField(20);
        nameproject_text.setBounds(500, 200, 150, 25);
        frame.add(nameproject_text);


        JTextField deadline_text = new JTextField(20);
        deadline_text.setBounds(500, 240, 150, 25);
        frame.add(deadline_text);
    
        JButton create_project = new JButton("Create project");
        create_project.setBounds(400, 300, 150, 25);
        frame.add(create_project);

        frame.revalidate();
        frame.repaint();
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
            String subject = ((JTextField)(contentPane.getComponent(6))).getText();; 
            String deadline = ((JTextField)(contentPane.getComponent(7))).getText();
            Project pro = new Project(lecture, subject, new MyDate(deadline)); 
            String t = " Your project  has been successfully created \n"  + pro.toString() ;   
            JLabel texte = new JLabel("<html>" + t.replace("\n", "<br/>") + "</html>");
            
            texte.setBounds(500, 300, 1000, 1000);
            texte.setHorizontalAlignment(JLabel.CENTER);
            texte.setVerticalAlignment(JLabel.CENTER);
            texte.setBounds(0, 0, texte.getWidth(), texte.getHeight());
            texte.setVisible(true);
            frame.revalidate(); 
            frame.repaint();
            frame.add(texte);
            for (int i = 4; i<= 8 ; i++){
                frame.remove(components[i]);  
            }
            frame.revalidate();
            frame.repaint();
            JButton ok = new JButton("OK");
            ok.setBounds(500, 400, 150, 25);
            frame.add(ok); 
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Container contentPane = frame.getContentPane(); 
                    Component[] components = contentPane.getComponents(); 
                    frame.remove(components[4]);
                    frame.remove(components[5]);
                    frame.revalidate(); 
                    frame.repaint();
                }
            });

            }

    });

}

    public void remove_project(){
        
    }

    public void check_my_projects(){

    }

}


    

