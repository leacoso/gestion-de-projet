import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class MyDate {
    private int year ; 
    private int month; 
    private int day; 

    public MyDate(){

        LocalDate date = LocalDate.now();
        year = date.getYear();
        month = date.getMonthValue(); 
        day = date.getDayOfMonth(); 
    }

    public static boolean verif_date(String date){

        String format = "\\d{2}/\\d{2}/\\d{4}";
        Set<Integer> mois1 = new HashSet<>(Arrays.asList(1,3,5,7,8,10,12));
        Set<Integer> mois2 = new HashSet<>(Arrays.asList(2,4,6,9,11));

        
        if (date.matches(format) == false || date == null ){
            return false ; 
        }
        if (Integer.parseInt(date.substring(6, 10)) < 2023 ){
            return false ; }
        if (mois1.contains(Integer.parseInt(date.substring(3, 5))))  {
            if (Integer.parseInt(date.substring(0, 2)) > 31 || Integer.parseInt(date.substring(0, 2)) <= 0 ){
                
                return false ; 
            }
            else {
                return true ; 
            }
        }
        else {
            if (mois2.contains(Integer.parseInt(date.substring(3, 5))))  {
                if (Integer.parseInt(date.substring(0, 2)) > 30 || Integer.parseInt(date.substring(0, 2)) <= 0 ){
                     
                    return false ; 
            }
            else {
                return true ; 
            }
            
            }
        }
       
        return false ; 
    }

    public MyDate(String date)  {
    
        day = Integer.parseInt(date.substring(0,2)); 
        month = Integer.parseInt(date.substring(3,5)); 
        year = Integer.parseInt(date.substring(6,10)); 
    }

    public int get_year(){
        return year ; 
    }

    public int get_month(){
        return month; 
    }
    public int get_day(){
        return day; 
    }

    public int calculate_late(MyDate deadline, MyDate rendu){
        // We suppose that if the late is more than one month, the note is 0
    
        // Case deadline.month = 12
        if (deadline.month == 12){
            if (rendu.month < 11 ){return 0; }
        }
        
        if (rendu.month - deadline.month > 1){return 0; }
        if (rendu.month - deadline.month == 1){
            return (31 - deadline.day) + rendu.day ; 
        }
        return rendu.day-deadline.day ; 

    }

    public String toString(){
        return day + "/" + month + "/" + year; 
    }


    public static void main(String[] args){
        String s = null ; 
        System.out.println(verif_date(s)); 
    }
}


   


    

    
    
    

    

