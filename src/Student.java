import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class Student extends Person {
    private long student_number ;  
    private Education education ; 
    private List<Project> projects;
 
    public Student(String pe, String nom){
        super(pe, nom); 
    }

    public Student(String firstname, String lastname, long student_number, Education education,  List<Project> projects){
        super(firstname, lastname); 
        this.education = education; 
        this.student_number = student_number ;  
        this.projects = projects ; 
    }

    public String toString2(){
        return  firstname + " " + lastname ;  
    }

    public static Student get_student(long id){
        ArrayList<Student> list = General_List.student_list ; 
        int id_int = (int) id - 223513 ; 
        return list.get(id_int) ; 
        
         
    }
   


    public void set_formation (Education f){education = f; }
    public String toString() {return firstname + " " + lastname + " " + student_number + " " + education.toString();}
    public double getStudent_number() {return student_number;}
    public Education getEducation() {return education;}
    public void setProjects(List<Project> projects) {this.projects = projects;}
    public List<Project> getProjects() {return projects;}


}