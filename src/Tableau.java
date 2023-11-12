import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tableau extends JFrame {
    

    public Tableau() {
        
        JFrame frame = new JFrame(); 
        JButton button = new JButton("Retour");
        JLabel label = new JLabel("label"); 

        frame.add(label); 
        JPanel existingPanel = new JPanel();
        existingPanel.setLayout(new FlowLayout());
        existingPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Container contentPane = frame.getContentPane(); 
                Component[] components = contentPane.getComponents(); 
                for (Component co : components){frame.remove(co);}
                frame.revalidate(); 
                frame.repaint(); 
                //frame.remove(components[components.length-1]);
                /*for (Component co : components){
                    System.out.println(co.getClass()); 
                }*/
          }
     
        });

        Object[][] data = {
                {"1", "John Doe", "30"},
                {"2", "Jane Doe", "25"},
                {"3", "Bob Smith", "40"}} ; 
        

        Object[] columns = {"ID", "Nom", "Âge"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        //existingPanel.add(existingPanel, BorderLayout.NORTH);
        existingPanel.add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(existingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Tableau tableau = new Tableau(); 
    }

    
}
