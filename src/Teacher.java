import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Teacher extends Person {
    private String user; 
    private String pass ; 
    private static  Map<String, String> user_password = new HashMap<>();
    private static Map<String, ArrayList<Lecture>> user_subject = new HashMap<>(); 
    private static Map<String, Teacher> user_teacher = new HashMap<>();

    public Teacher(){
        super(); 
    }
    
    public Teacher(String name, String p){ super(name,p); } 

    public Teacher(String name, String p, String user, String pass, ArrayList<Lecture> matieres){
        this(name,p); 
        user_password.put(user,pass); 
        user_subject.put(user,matieres); 
    }

    // This function verify if the Teacher is in the database
    public static boolean verif(String user, String password){
        if ( !user_password.containsKey(user)){ return false ; }        
        if (user_password.get(user).equalsIgnoreCase(password) == false){ return false ; }
        return true; 
    }

    // This function add a Teacher in the database
    public static void ajout_user_password(String user, String password){user_password.put(user, password); }
    
    //This function give the user of the Teacher 
    public String get_user(){ 
        for (Map.Entry<String, Teacher> entry : user_teacher.entrySet()) {
            if (entry.getValue().equals(this)) {return entry.getKey();}
        }
        return null ; 
    }

    //This function give the subjects of the Teacher
    public static ArrayList<Lecture> get_subject(String user){
        if (user_subject.containsKey(user)) {
            return user_subject.get(user); 
        } 
        return null ; 
    }

    // This function return all the lectures as String 
    public static ArrayList<String> lecture_to_string(ArrayList<Lecture> sub){
        ArrayList<String> list = new ArrayList<>(); 
        for (Lecture lecture : sub){
            list.add(lecture.toString()); 
        }
        return list; 
    }

    //This function return the teacher associated to the user 
    public static Teacher get_teacher(String user){
        if (user_subject.containsKey(user)) { return user_teacher.get(user);} 
        return null ; 
    }
    //These functions add a new Teacher 
    public static void ajout_user_subject(String user, ArrayList<Lecture> sub){user_subject.put(user, sub); }
    public static void ajout_user_teacher(String user, Teacher t){user_teacher.put(user, t); }

}

