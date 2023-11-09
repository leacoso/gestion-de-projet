import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private int id; 
    private Lecture matiere ; 
    private String sujet ; 
    private MyDate deadline ;
    private String explication ; 
    private int nombre_de_groupes = 0 ; 
    private static int nb_id = 1 ;  
    public static HashMap<Project, ArrayList<Pair> > list_project_pair = new HashMap<>(); 
    
    public Project(Lecture matiere, String sujet, MyDate myDate, String explication){
        id = nb_id ; 
        nb_id++ ;
        this.explication = explication; 
        this.matiere = matiere;
        this.sujet = sujet;
        deadline = myDate;
        nombre_de_groupes = 0;
        add_project(); 
    
    }

    public Project(){
        id = nb_id ; 
        nb_id++ ; 
        nombre_de_groupes = 0 ; 
        sujet = null; 
        matiere = null; 
        deadline = null ; 
        explication = null; 
    }

    public void add_project(){
        list_project_pair.put(this, new ArrayList<>()); 
    }

    public static void add_pair_to_project(Project project, Pair p){
        list_project_pair.get(project).add(p); 
    }

    public static void add_pairs_to_project(Project project , ArrayList<Pair> list_pairs){
        list_project_pair.get(project).addAll(list_pairs); 
    }
   
    public int getid() {
        return id;
    }

    public void setMatiere(Lecture matiere) {
        this.matiere = matiere;
    }

    public Lecture getMatiere() {
        return matiere;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getSujet() {
        return sujet;
    }

    public void setdeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    public MyDate getdeadline() {
        return deadline;
    }

    public void add_groupe(){
        nombre_de_groupes += 1;
    }

    public int get_nb_groupe(){
        return nombre_de_groupes;
    }
    
    public String toString(){
        return " ID :  " + String.valueOf(id) + " \n  Subject : "   +  sujet + "\n deadline  : " + deadline.toString(); 
    }

   

}
