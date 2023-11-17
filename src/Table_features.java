import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

public class Table_features extends AbstractTableModel{
    
    private final String[] columnNames = {"Name ", "Value"}; 
    private Project project ; 
    
    public Table_features(Project project ){
        this.project = project;
    }
    @Override
    public int getRowCount() {
        return 10; 
    }

    @Override
    public int getColumnCount() {
        return 2 ;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if (columnIndex == 0 ){
            switch(rowIndex){
                case 0 : return "ID";
                case 1 : return "Subject" ; 
                case 2 : return "Lecture"; 
                case 3 :return "Deadline" ; 
                case 4 : return "explication" ; 
                case 5 : return  "worst grade";
                case 6 : return "Best grade" ;
                case 7 : return "Average"; 
                case 8 : return "Median"; 
                case 9 : return "Number of pairs" ;
                default: return null; 
            }
        }

        else {
            switch(rowIndex){
                case 0 : return project.getid(); 
                case 1 : return project.getSujet() ;
                case 2 : return project.getMatiere(); 
                case 3 : return project.getdeadline().toString() ; 
                case 4 : return project.getExplication() ;
                case 5 : return  project.different_grades(1); 
                case 6 : return project.different_grades(2);
                case 7 : return project.different_grades(3);
                case 8 : return project.different_grades(4);
                case 9 : return project.different_grades(5); 
                default: return null;
            }
        }  
       
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


}



