public class Pair {
    private Project project ; 
    private Student student1 ; 
    private Student student2 ; 
    private MyDate due_date ; 
    private double grade;
    
    public double getGrade() {
        return grade;
    }

    private int id ; 

    public Pair(Project project, Student student1, Student student2, MyDate due_date ){
        this.project = project; 
        this.student1 = student1; 
        this.student2 = student2 ; 
        this.due_date = due_date ; 
        id = project.get_nb_groupe(); 
        project.add_groupe();
    }

    public Project getProject(){
        return project; 
    }
    
    public Student getStudent1(){
        return student1; 
    }

    public Student getStudent2(){
        return student2; 
    }

    public MyDate getDue_date(){
        return due_date; 
    }

    public int getId(){
        return id ; 
    }
    
}
