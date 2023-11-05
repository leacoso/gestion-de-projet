import java.util.ArrayList;


public class Lecture {
    private String name ; 
    private String grade ; 
    public static ArrayList<Student> lecture_student ;

    public Lecture(String n){
        name_grade(n);
        lecture_student_list();
    }

    public void name_grade(String n){
        String[] list = n.split(",");
        String name = list[0].trim();
        String grade = list[1].trim();
    }

    public String get_name(){
        return name; 
    }
    public String get_grade(){
        return grade; 
    }
    public void lecture_student_list(){
        ArrayList<Education> educations = List.lecture_education.get(this); 
        for (Education ed : educations ){
            lecture_student.addAll(List.list_education_student.get(ed)); 
        }
    }
   

    
}
