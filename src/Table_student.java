import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

//This class create a table to print students
class Table_student extends AbstractTableModel {
    private final ArrayList<Student> students;
    private final String[] columnNames = {"student number", "firstname", "lastname", "education"}; 

    public Table_student(ArrayList<Student> students) { this.students = students; }

    @Override
    public int getRowCount() { return students.size(); }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0: return student.getStudent_number();
            case 1: return student.getFirstname();
            case 2: return student.getLastname();
            case 3: return student.getEducation().toString();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) { return columnNames[column];}


}


