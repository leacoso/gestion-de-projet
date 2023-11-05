import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Teacher extends Person {
    private static  Map<String, String> user_password = new HashMap<>();
    private static Map<String, ArrayList<String>> user_subject = new HashMap<>(); 
    private static Map<String, Teacher> user_teacher = new HashMap<>();

    public Teacher(String name, String p){
        super(name,p); 
    }

    public Teacher(String name, String p, String user, String pass, ArrayList<String> matieres){
        this(name,p); 
        user_password.put(user, pass); 
        user_subject.put(user,matieres); 
    }


    public static boolean verif(String user, String password){
        if ( !user_password.containsKey(user)){
            return false ; 
        }        if (user_password.get(user).equalsIgnoreCase(password) == false){
            return false ; 
        }
        return true; 
    }

    public static void ajout_user_password(String user, String password){user_password.put(user, password); }
    
    public String get_user(){ 
        for (Map.Entry<String, Teacher> entry : user_teacher.entrySet()) {
            if (entry.getValue().equals(this)) {
                return entry.getKey();
            }
        }
        return null ; 
    }

    public static ArrayList<String> get_subject(String user){
        if (user_subject.containsKey(user)) {
            return user_subject.get(user); 
        } 
        return null ; 
    }

    public static Teacher get_teacher(String user){
        if (user_subject.containsKey(user)) {
            return user_teacher.get(user); 
        } 
        return null ; 
    }
    public static void ajout_user_subject(String user, ArrayList<String> sub){user_subject.put(user, sub); }
    public static void ajout_user_teacher(String user, Teacher t){user_teacher.put(user, t); }
    

    
    
    
}

