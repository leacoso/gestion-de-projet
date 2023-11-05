import java.util.List;

public class Student extends Person {
    private int student_number ;  
    private Education education ; 
    private List<Project> projects;
 


    public Student(String pe, String nom){
        super(pe, nom); 
    }

    public Student(String firstname, String lastname, int student_number, Education education,  List<Project> projects){
        super(firstname, lastname); 
        this.education = education; 
        this.student_number = student_number ;  
        this.projects = projects ; 
          
    }
    
    public void set_formation (Education f){education = f; }
    public String toString() {return firstname + " " + lastname + " " + student_number + " " + education.toString();}
    public double getStudent_number() {return student_number;}
    public Education getEducation() {return education;}
    public void setProjects(List<Project> projects) {this.projects = projects;}
    public List<Project> getProjects() {return projects;}
    

    

    

}