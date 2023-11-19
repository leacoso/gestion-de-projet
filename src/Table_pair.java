import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

//This class create a table to print all the pairs of a project. 
class Table_pair extends AbstractTableModel {
    private final ArrayList<Pair> pairs;
    private final String[] columnNames = {"id", "Student1", "Student2", "Grade"}; 
    private static Student selectedstudent1 = null; 
    private static Student selectedstudent2 = null; 
    

    public Table_pair(ArrayList<Pair> pairs) {this.pairs = pairs;}

    @Override
    public int getRowCount() { return pairs.size(); }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pair pair = pairs.get(rowIndex);
        switch (columnIndex) {
            case 0: return pair.getId();
            case 1: return pair.getStudent1().toString2();
            case 2: return pair.getStudent2().toString2();
            case 3 :return pair.getGrade() ; 
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) { return columnNames[column]; }

    public void add_pair_table(Student student1, Student student2, Project project) {
        if (student1 != null && student2 != null ) {
            Pair pair = new Pair(project, student1, student1, null);
            pairs.add(pair);
            fireTableRowsInserted(pairs.size() - 1, pairs.size() - 1);
        }
    }

    public static void setStudent(int i, Student student){
        if (i ==1) { selectedstudent1 = student ;}
        else { selectedstudent2 = student ; }
    }

    public static Student getStudent(int i){
        if (i ==1){ return selectedstudent1 ;  }
        else { return selectedstudent2 ;}
    }
    
}


