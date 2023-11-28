package pck;



import java.io.Serializable;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


class Table_lecture extends AbstractTableModel implements Serializable {
   
   	private static final long serialVersionUID = 1L;
	private final ArrayList<Lecture> lectures;
    private final String[] columnNames = {"name", "grade"}; 

    public Table_lecture(ArrayList<Lecture> lectures) { this.lectures = lectures; }

    @Override
    public int getRowCount() { return lectures.size(); }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lecture lecture = lectures.get(rowIndex);
        switch (columnIndex) {
            case 0: return lecture.get_name();
            case 1: return lecture.get_grade();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) { return columnNames[column];}


}



