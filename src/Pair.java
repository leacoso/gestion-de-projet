public class Pair {

     private int id ;
    private Project project ; 
    private Student student1 ; 
    private Student student2 ; 
    private double oral_grade ; 
    private double grade_s1 ;  
    private double grade_s2 ; 
    private MyDate due_date ;  //Permits to calcule the grade with the late. 
    
    

    public Pair(Project project, Student student1, Student student2, MyDate due_date ){
        this.project = project; 
        this.student1 = student1; 
        this.student2 = student2 ; 
        this.due_date = due_date ; 
        oral_grade = -1 ; 
        grade_s1 = -1 ; 
        grade_s2 = -1; 
        id = project.get_nb_groupe(); 
        project.add_groupe();
    }

    //Getters
    public double getGrade(){return oral_grade ; }

    public Project getProject(){return project; }

    public Student getStudent1(){return student1;}

    public Student getStudent2(){return student2; }

    public MyDate getDue_date(){return due_date; }

    public int getId(){return id ; }

    //Setters
    public void setOralGrade(double n){ oral_grade = calcul_final_grade(n, project.getdeadline(), due_date) ; }

    public void setS1Grade(double n){grade_s1 = n ; }

    public void setS2Grade(double n){grade_s2 = n ; }

    public void setDueDate(MyDate date){due_date = date ; }

    public String toString(){ return student1.toString2() + " " +  student2.toString2() ; }
    
    // This function calculates the joint grade of the pair, taking into account the pair's submission delay
    public double calcul_final_grade(double grade, MyDate deadline, MyDate duDate){

        //If the project has more than one month late then the grade will be 0. 
        // One point is deducted for 3 days of delay

        if (deadline.get_month() == 12){
            if (duDate.get_month() > 1 || duDate.get_month() < 12){return 0.0 ; }
            else {return Math.max(0.0,grade - ( 31- ( deadline.get_day() + (duDate.get_day()))) /3); }
        }
        
        else {
            if (duDate.get_month() - deadline.get_month() > 1)  {return 0.0; }
            if (duDate.get_month() - deadline.get_month()  == 0) {return Math.max(0.0, grade - (duDate.get_day() - deadline.get_day())/3);  } 
            else {return Math.max(0.0, grade - (duDate.get_day() + 31- deadline.get_day())/3) ; }
            
        }
      
    }

    //This function checks whether the grade is in the correct format (If g1, g2, g3  are double type)
    public static boolean verif_grade(String g1, String g2, String g3){ return g1.matches("[+-]?\\d*(\\.\\d+)?") && g2.matches("[+-]?\\d*(\\.\\d+)?") && g3.matches("[+-]?\\d*(\\.\\d+)?");}

}
