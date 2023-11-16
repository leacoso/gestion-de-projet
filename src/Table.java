import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface Table {
    private final ArrayList<Object> list;
    private final String[] columnNames ; 
   

    public Table(ArrayList<Object> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex); 
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void add_pair_table(Student student1, Student student2, Project project) {
        if (student1 != null && student2 != null ) {
            Pair pair = new Pair(project, student1, student1, null);
            pairs.add(pair);
            fireTableRowsInserted(pairs.size() - 1, pairs.size() - 1);
        }
    }
    public static void setStudent(int i, Student student){
        if (i ==1){
            selectedstudent1 = student ; 
        }
        else {
            selectedstudent2 = student ; 
        }
    }

    public static Student getStudent(int i){
        if (i ==1){
            return selectedstudent1 ; 
        }
        
        else {
            return selectedstudent2 ; 
        }
    }
}



    
}
