package pck;


import java.util.ArrayList;

public class Teacher extends Person {
    private static final long serialVersionUID = 1L;
	private String user; 
    private String pass ; 
    private ArrayList<Lecture> subjects ; 
    
    /*public static  Map<String, String> user_password = new HashMap<>();
    public static Map<String, ArrayList<Lecture>> user_subject = new HashMap<>(); 
    public static Map<String, Teacher> user_teacher = new HashMap<>();*/

    public Teacher(){
        super(); 
    }
    
    public Teacher(String name, String p){ super(name,p); } 

    public Teacher(String name, String firstname, String user, String pass, ArrayList<Lecture> matieres){
        this(name,firstname); 
        this.user = user ; 
        this.pass = pass ; 
        this.subjects = matieres ; 
   }

    // This function verify if the Teacher is in the database
    /*public static boolean verif(String user, String password){
        if ( !user_password.containsKey(user)){ return false ; }        
        if (user_password.get(user).equalsIgnoreCase(password) == false){ return false ; }
        return true; 
    }*/
    
    public static boolean verif(String user, String password) {
    
    	return ((General_List.teacher.get_user().equalsIgnoreCase(user) ) && (General_List.teacher.get_pass().equalsIgnoreCase(password))); 
    	
    }
    
    public String get_pass() {
    	return pass ; 
    }
    
    //This function give the user of the Teacher 
    public String get_user(){ 
        return user ; 
    }

    //This function give the subjects of the Teacher
    public ArrayList<Lecture> get_subject(){
    	return subjects ;       
    }

    // This function return all the lectures as String 
    public static ArrayList<String> lecture_to_string(ArrayList<Lecture> sub){
        ArrayList<String> list = new ArrayList<>(); 
        for (Lecture lecture : sub){
            list.add(lecture.toString()); 
        }
        return list; 
    }

    public boolean equals (Teacher t) {
    	return t.user == this.user && t.pass == this.pass ; 
    }
    public String toString() {
    	return firstname + " " +  lastname ; 
    }
}

