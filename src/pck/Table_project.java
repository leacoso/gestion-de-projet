package pck;


import javax.swing.table.AbstractTableModel;

import java.io.Serializable;
import java.util.ArrayList;

//This class create a table to print all the projects of a lecture. 
public class Table_project extends AbstractTableModel implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private final ArrayList<Project> projects;
    private final String[] columnNames = {"ID", "subject", "deadline"}; 

    public Table_project(ArrayList<Project> projects) {this.projects = projects; }

    @Override
    public int getRowCount() { return projects.size(); }

    @Override
    public int getColumnCount() {return columnNames.length; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project project = projects.get(rowIndex);
        switch (columnIndex) {
            case 0: return project.getid();
            case 1: return project.getSujet();
            case 2: return project.getdeadline().toString();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {return columnNames[column]; }
}



