package pck;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pair implements Serializable {

   
   private static final long serialVersionUID = 1L;
   private int id ;
   private Project project ; 
   private Student student1 ; 
   private Student student2 ; 
   private double oral_grade ; 
   private double grade_s1 ;  
   private double grade_s2 ; 
   private MyDate due_date ;  //Permits to calculate the grade with the late. 
   
   
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

   public String toString(){ return student1.toString() + " " +  student2.toString() ; }
   
   public boolean equals(Pair pair) {
	   return pair.id == this.id && pair.project.equals(this.project); 
   }
  
   // This function calculates the joint grade of the pair, taking into account the pair's submission delay
   public double calcul_final_grade(double grade, MyDate deadline, MyDate duDate){

       //If the project has more than one month late then the grade will be 0. 
       // One point is deducted for 3 days of delay
	   
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate d1 = LocalDate.parse(deadline.toString(), formatter);
       LocalDate d2 = LocalDate.parse(duDate.toString(), formatter);
       if (ChronoUnit.DAYS.between(d1, d2) >30){return 0.0 ; }
       if (ChronoUnit.DAYS.between(d1, d2)/3 < 0) {return grade ;}
       return Math.max(0.0, grade-ChronoUnit.DAYS.between(d1, d2)/3) ; 
     
   }

   //This function checks whether the grade is in the correct format (If g1, g2, g3  are double type)
   public static boolean verif_grade(String g1, String g2, String g3){ 
	   if( g1.matches("[+-]?\\d*(\\.\\d+)?") && g2.matches("[+-]?\\d*(\\.\\d+)?") && g3.matches("[+-]?\\d*(\\.\\d+)?") == false ) {return false ; }
	   if( Double.parseDouble(g1) > 20.0 || Double.parseDouble(g1) < 0.0 || Double.parseDouble(g2) > 20.0 || Double.parseDouble(g2) < 0.0
			   || Double.parseDouble(g3) > 20.0 || Double.parseDouble(g3) < 0.0) {return false ; }
	   return true ; 
   }

   public double final_grade_s1() {
	   return  (oral_grade +  grade_s1 )/2 ; 
   }
   
   public double final_grade_s2() {
	   return  (oral_grade +  grade_s2 )/2 ; 
   }
}

