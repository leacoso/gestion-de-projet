import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Project {
    private int id; 
    private Lecture lecture ; 
    private String sujet ; 
    private MyDate deadline ;
    private String explication ; 
    private int number_of_groups = 0 ; 
    private static int nb_id = 1 ;  
    private static HashMap<Project, ArrayList<Pair> > list_project_pair = new HashMap<>(); 
    public ArrayList<Student> alone  = new ArrayList<>();
    
    public Project(Lecture lecture, String sujet, MyDate myDate, String explication){
        // Initialization and incrementation of project ID
        id = nb_id ; 
        nb_id++ ;
        // Setting project details
        this.explication = explication; 
        this.lecture = lecture;
        this.sujet = sujet;
        deadline = myDate;
        number_of_groups = 0;
        // Adding the project to the list of projects
        add_project(); 
        // Initializing list of students without groups
        alone = lecture.get_lecture_student() ; 
    }

    public Project(){
        id = nb_id ; 
        nb_id++ ; 
        number_of_groups = 0 ; 
        sujet = null; 
        lecture = null; 
        deadline = null ; 
        explication = null; 
    }

    // Methods for managing projects and their associated pairs, getters, setters, and utility functions

    public void add_project(){ list_project_pair.put(this, new ArrayList<>()); }

    public  static HashMap<Project, ArrayList<Pair> > get_list_project_pair(){ return list_project_pair ; }

    public static void add_pair_to_project(Project project, Pair p){ list_project_pair.get(project).add(p); }

    public static void add_pairs_to_project(Project project , ArrayList<Pair> list_pairs){ list_project_pair.get(project).addAll(list_pairs);}
   
    public int getid() {return id;}

    public String getExplication(){return explication ; }

    public Lecture getMatiere() {return lecture;}

    public String getSujet() { return sujet;}

    public MyDate getdeadline() {return deadline;}

    public void setMatiere(Lecture lecture) {this.lecture = lecture;}

    public void setSujet(String sujet) { this.sujet = sujet;}

    public void setdeadline(MyDate deadline) {this.deadline = deadline;}

    public void add_groupe(){number_of_groups += 1;}

    public int get_nb_groupe(){ return number_of_groups;}
    
    public String toString(){return " ID :  " + String.valueOf(id) + " \n  Subject : "   +  sujet + "\n deadline  : " + deadline.toString(); }

    public String get_title(){return id + " , " + sujet ; }

    //This function calculates different grades statistics based on a choice parameter
    public double different_grades(int choice){
        ArrayList<Pair> pairs = Project. get_list_project_pair().get(this); 
        int lenght = pairs.size(); 
        
        ArrayList<Double> dif_grades = new ArrayList<>();
        if (choice<1 ){choice = 1; }
        if (choice > 5){choice = 5; }

        
        int nb = 0 ; 
        for (Pair pair : pairs) {
            if (pair.getGrade() != -1){
                nb ++ ; 
                dif_grades.add(pair.getGrade());
            }  
        }
        Collections.sort(dif_grades);
        
        switch (choice) {

            case 1: // Worst grade
            if (dif_grades.size() == 0 ){ return -1 ;}
            return dif_grades.get(0);
        
            case 2: //Best grade
            if (dif_grades.size() == 0 ){ return -1 ;}
            int last = dif_grades.size() - 1;
            return dif_grades.get(last);
            
            case 3: //Average 
            if (dif_grades.size() == 0 ){ return -1 ;}
            double sum = 0.0;
            for (double grade : dif_grades) {sum += grade;}
            double average = sum / dif_grades.size();
            return average ; 
            
            case 4: //Median
            if (dif_grades.size() == 0 ){ return -1 ;}
            int size = dif_grades.size();
             if (size % 2 == 0) {
                 // Si la taille de la liste est paire, la médiane est la moyenne des deux valeurs du milieu
                 int middleIndex1 = size / 2 - 1;
                 int middleIndex2 = size / 2;
                 return (dif_grades.get(middleIndex1) + dif_grades.get(middleIndex2)) / 2.0;
             } else {
                 // Si la taille de la liste est impaire, la médiane est la valeur du milieu
                 int middleIndex = size / 2;
                 return dif_grades.get(middleIndex);
             }
               
            case 5 : //Number of pairs
            return lenght ; 

            default:
                break;
        }
        
        return -1 ; 

    }

}
