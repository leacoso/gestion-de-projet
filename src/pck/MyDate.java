package pck;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//This function permits to manipulates the date of the due_date and the dealine. 

public class MyDate implements Serializable {
    
	private static final long serialVersionUID = 1L;
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
    
    //Getters

    public int get_year(){return year ;}

    public int get_month(){return month;}

    public int get_day(){return day;}
    
    public boolean equals(MyDate date ) {
    	return date.year == this.year && date.month == this.month && date.day == this.day; 
    }
    //This function verifies whether the date is in a correct form (DD/MM/YYYY).
    public static boolean verif_date(String date){

        String format = "\\d{2}/\\d{2}/\\d{4}";
        Set<Integer> mois1 = new HashSet<>(Arrays.asList(1,3,5,7,8,10,12));
        Set<Integer> mois2 = new HashSet<>(Arrays.asList(2,4,6,9,11));

        
        if (date.matches(format) == false || date == null ){ return false ; }
        if (Integer.parseInt(date.substring(6, 10)) < 2023 ){ return false ; } // Before 2023
        if (mois1.contains(Integer.parseInt(date.substring(3, 5))))  {
            if (Integer.parseInt(date.substring(0, 2)) > 31 || Integer.parseInt(date.substring(0, 2)) <= 0 ){return false ; }
            else {return true ; }
        }
        else {
            if (mois2.contains(Integer.parseInt(date.substring(3, 5))))  {
                if (Integer.parseInt(date.substring(0, 2)) > 30 || Integer.parseInt(date.substring(0, 2)) <= 0 ){return false ; }
            else {return true ; }
            
            }
        }
       
        return false ; 
    }
    
    public String toString(){ 
    	if( day< 10 && month<10) {return "0" + day + "/" + "0" + month + "/" + year;}
    	if( day< 10) {return "0" + day + "/" + month + "/" + year;}
    	if( month< 10) {return   day + "/" + "0" + month + "/" + year;}
    	return day + "/" + month + "/" + year; }
}


   


    

    
    
    

    

