import java.time.LocalDate;


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

    }


    

    
    
    

    

