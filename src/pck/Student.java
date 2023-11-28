package pck;


import java.util.ArrayList;

public class Student extends Person {
	
    
	private static final long serialVersionUID = 1L;
	private long student_number ;  
    private Education education ; 
   
    public Student(String firstname, String lastname){
        super(firstname, lastname); 
    }
    public Student(String firstname, String lastname, long student_number, Education education){
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
    public boolean equals(Student s) {
    	return s.student_number - this.student_number == 0 ; 
    }
    


}
