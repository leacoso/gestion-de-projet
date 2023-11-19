import java.util.ArrayList;
import java.util.List;


public class Lecture {

    private String name ; 
    private String grade ; 
    private ArrayList<Student> lecture_student = new ArrayList<>(); 
    private ArrayList<Project> lecture_project = new ArrayList<>(); 


    public Lecture(String n){
        if (n.length() == 0  || n == null){
            name = null ;
            grade = null ; 
        }
        else { name_grade(n);}
       
    }

    public void name_grade(String n){
        String[] list = n.split(",");
        String name = list[0].trim();
        String grade = list[1].trim();
        this.name = name ; 
        this.grade = grade ; 
    }

    //Getters
    public String get_name(){ return name; }
    public String get_grade(){ return grade; }
    public ArrayList<Student> get_lecture_student(){ return lecture_student ;}
    public ArrayList<Project> get_lecture_project(){ return lecture_project ;}

    public String toString(){ return name + " , "  + grade ; }

    //This function generates the student list of the lecture. 
    public void lecture_student_list(){
        ArrayList<Education> educations = General_List.lecture_education.get(this); 
        for (Education ed : educations ){ lecture_student.addAll(General_List.list_education_student.get(ed)); }
    }

    public void add_project(Project p){ lecture_project.add(p);}
   

    
}
