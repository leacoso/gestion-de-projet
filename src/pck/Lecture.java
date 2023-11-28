package pck;

import java.io.Serializable;
import java.util.ArrayList;

public class Lecture implements Serializable {

    private static final long serialVersionUID = 1L;
	private String name ; 
    private String grade ; 
    
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
    
    public ArrayList<Project> get_lecture_project(){
    	ArrayList<Project> list = new ArrayList<>(); 
    	for (Project project : General_List.project_pair.keySet()) {
    		if ( project.getMatiere().get_name().equalsIgnoreCase(this.get_name()) && project.getMatiere().get_grade().equalsIgnoreCase(this.get_grade()))
    		{list.add(project);}	
    	}
    		
    	return list ;   
    }
    
    public ArrayList<Student> get_lecture_student_list(){
    	ArrayList<Student> list = new ArrayList<>(); 
    	ArrayList <Education> educations = General_List.get_education_from_lecture(this);
        for (Education ed : educations ){
        	list.addAll(General_List.get_student_from_education(ed));}
    	return list ; 
    }	

    public boolean equals(Lecture l2) {
    	return this.name.equalsIgnoreCase(l2.name) && l2.grade.equalsIgnoreCase(l2.grade);  	
    }
    
    public String toString(){ return name + " , "  + grade ; }

    //This function generates the student list of the lecture. 
   
    public void add_project(Project p){ General_List.project_pair.put(p, new ArrayList<>());}
   
    

    
}
