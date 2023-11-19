import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private long student_number ;  
    private Education education ; 
   
    public Student(String firstname, String lastname){
        super(firstname, lastname); 
    }
    public Student(String firstname, String lastname, long student_number, Education education,  List<Project> projects){
        this(firstname, lastname); 
        this.education = education; 
        this.student_number = student_number ;  
     
    }

    public String toString2(){ return  firstname + " " + lastname ;  }

    // This function return the Student of the student number id
    public static Student get_student(long id){
        ArrayList<Student> list = General_List.student_list ; 
        int id_int = (int) id - 223513 ; 
        return list.get(id_int) ;   
    }

    public void set_formation (Education f){education = f; }
    public String toString() {return firstname + " " + lastname + " " + student_number + " " + education.toString();}
    public double getStudent_number() {return student_number;}
    public Education getEducation() {return education;}
  


}