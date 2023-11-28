package pck;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;

public class General_List {
	
    public static ArrayList<Student> student_list = new ArrayList<>();  
    public static HashMap<Lecture,ArrayList<Education>> lecture_education = new HashMap<>();  
    public static ArrayList<Lecture> list_lecture  = new ArrayList<>(); 
    public static ArrayList<Education> list_education = new ArrayList<>(); 
    public static HashMap<Education, ArrayList<Student>> list_education_student = new HashMap<>() ; 
    public static Teacher teacher ;
    public static HashMap<Project, ArrayList<Pair>> project_pair = new HashMap<>(); 
    
   
    public General_List() {
    	
    }
   
    public static void get_list_education(){
    //L3
    list_education.add( new Education ("MIAGE","Alternance", "L3")); 
    list_education.add( new Education ("MIAGE","Initiale", "L3"));
    list_education.add( new Education ("IDD","Initiale", "L3"));
    list_education.add( new Education ("MIAGE","Continue", "L3"));
    list_education.add( new Education ("IDD","Continue", "L3")) ; 
    //M1
    list_education.add( new Education ("MIAGE","Alternance", "M1")); 
    list_education.add( new Education ("MIAGE","Initiale", "M1"));
    list_education.add( new Education ("IDD","Initiale", "M1"));
    list_education.add( new Education ("MIAGE","Continue", "M1"));
    list_education.add( new Education ("IDD","Continue", "M1"));

    //M2
    list_education.add( new Education ("MIAGE_ID","Alternance", "M2"));
    list_education.add( new Education ("MIAGE_ID","Initiale", "M2"));
    list_education.add( new Education ("MIAGE_IF","Alternance", "M2"));
    list_education.add( new Education ("MODO","Initiale", "M2")); 
    list_education.add( new Education ("MIAGE_STIN","Initiale", "M2"));
    list_education.add( new Education ("MIAGE_STIN","Alternance", "M2"));
    list_education.add( new Education ("IASD","Initiale", "M2")); 
    list_education.add( new Education ("IASD","Alternance", "M2")); 

    for (Education education : list_education){
        list_education_student.put(education, new ArrayList<Student>()); 
    }
}

    public static void get_list_student (){
        String[] firstname_list = {"Lucas", "Liam", "Noah", "Ethan", "Léo", "Louis", "Adam", "Thomas", "Nathan", "Gabriel",
        "Hugo", "Arthur", "Jules", "Maxime", "Alexandre", "Paul", "Antoine", "Victor", "Raphaël", "Mathis",
        "Samuel", "Théo", "Matteo", "Enzo", "Evan", "Eliott", "Axel", "Tom", "Gabin", "Sacha", "Maël",
        "Rayan", "Noé", "Célian", "Milo", "Mael", "Timéo", "Ilan", "Nolan", "Elias", "Adam", "Augustin",
        "Matis", "Ewen", "Diego", "Isaac", "Léon", "Ayden", "Lenny", "Nino", "Malo", "Lyam", "Kylian",
        "Léandro", "Lorenzo", "Marceau", "Ruben", "Amir", "Antonin", "Côme", "Théodore", "Anatole", "Emma", "Jade", "Louise", "Alice", "Chloé", "Lina", "Léa", "Mila", "Anna", "Inès",
        "Manon", "Léna", "Zoé", "Camille", "Eva", "Clara", "Maëlys", "Olivia", "Rose", "Julia",
        "Charlotte", "Ambre", "Romane", "Lola", "Ava", "Nina", "Agathe", "Léonie", "Lucie", "Sarah",
        "Mathilde", "Éléna", "Margaux", "Lisa", "Lison", "Lilou", "Alicia", "Margot", "Elise", "Amandine",
        "Océane", "Gabrielle", "Romy", "Célia", "Apolline", "Laure", "Élodie", "Mélanie", "Héloïse",
        "Soline", "Aurélie", "Axelle", "Maëlle", "Iris", "Capucine", "Clémence", "Diane", "Elsa", "Fanny",
        "Jasmine", "Morgane", "Naomi", "Noémie", "Pauline", "Roxane"};

        String[] lastname_list = {"Martin", "Bernard", "Thomas", "Petit", "Robert", "Richard", "Durand", "Dubois", "Moreau", "Laurent",
        "Simon", "Michel", "Lefebvre", "Leroy", "Roux", "David", "Bertrand", "Morel", "Fournier", "Girard",
        "Bonnet", "Dupuis", "Fontaine", "Lemaire", "Lemoine", "Mercier", "Dupont", "Lefevre", "Garnier", "Faure",
        "Rousseau", "Blanc", "Gauthier", "Sauvage", "Leclerc", "Guillaume", "Lucas", "Muller", "Vidal", "Henry",
        "Roussel", "Colin", "Picard", "Robin", "Dufour", "Chevalier", "Masson", "Legrand", "Guerin", "Perez",
        "Joly", "Lopez", "Deschamps", "Martin", "Roger", "Lacoste", "Leclercq", "Bourgeois", "Perrin", "Poirier",
        "Marchand", "Leconte", "Ferrand", "Renard", "Duval", "Gomez", "Blanchard", "Huet", "Dumas", "Fleury",
        "Navarro", "Meyer", "Jacquet", "Gerard", "Boucher", "Fournier", "Pierre", "Millet", "Baron", "Camus",
        "Leroux", "Jacob", "Monnet", "Langlois", "Lefort", "Perrot", "Gallet", "Lejeune", "Aubert", "Bataille",
        "Lebrun", "Lamy", "Carré", "Grenier", "Joubert", "Lacour", "Vasseur", "Regnier", "Rodriguez", "Brun",
        "Collet", "Lemoine", "Léger", "Pascal", "Salaun", "Maillet", "Adam", "Barre", "Riviere", "Caron",
        "Guillot", "Pannier", "Chauvin", "Gilbert", "Philippe", "Leduc", "Guillou", "Guillet", "Marchal",
        "Da Silva", "Besson", "Guyot", "Schmitt", "Guichard", "Tessier", "Hervé", "Blin", "Vincent", "Moreau",
        "Legendre", "Laroche", "Le Gall", "Perrier", "Le Roux", "Renault"} ;
        
        long student_number = 223513 ; 
        for (int i = 0 ; i<  firstname_list.length; i++){
            for (int j = 0 ; j< (lastname_list.length)/5 ; j++){
            	student_number+=1 ; 
                Random random = new Random(); 
                int formation = random.nextInt(18); 
                Student student = new Student(firstname_list[i], lastname_list[j], student_number, list_education.get(formation));
                student_list.add(student) ;
                list_education_student.get(list_education.get(formation)).add(student); 
            }   
        }
    }

    public static ArrayList<Education> get_array_ed( int[] elements){
        ArrayList<Education> list = new ArrayList<>(); 
        for (int i : elements){
            list.add(list_education.get(i)); 
        }
        return list; 
    }
    
    public static void get_lecture_education(){
        
        lecture_education.put(new Lecture("Base de données relationnelles, L3"), get_array_ed(new int[] {1, 2}));
        lecture_education.put(new Lecture("Intro to logic, L3"), get_array_ed(new int[] {1, 2}));  
        lecture_education.put(new Lecture("Machine learning, L3"), get_array_ed(new int[] {2}));
        lecture_education.put(new Lecture("Algorithme dans les graphes, L3"), get_array_ed(new int[] {1, 2})); 
        lecture_education.put(new Lecture("Systeme d'exploitation, L3"), get_array_ed(new int[] {1, 2})); 
        lecture_education.put(new Lecture("Reseaux, L3"), get_array_ed(new int[] {2}));
        lecture_education.put(new Lecture("Java-Objet, L3"), get_array_ed(new int[] {1}));
        lecture_education.put(new Lecture("Analyse de données, L3"), get_array_ed(new int[] {1})); 
        lecture_education.put(new Lecture("Ingenierie des SI 1, L3"), get_array_ed(new int[] {1}));

        lecture_education.put(new Lecture("Programmation objet avancée, M1"), get_array_ed(new int[] {7, 6}));
        lecture_education.put(new Lecture("Introduction au machine learning, M1"), get_array_ed(new int[] {5})); 
        lecture_education.put(new Lecture("Systeme et gestion de base de données, M1"), get_array_ed(new int[] {5})); 
        lecture_education.put(new Lecture("Systeme d'information, M1"), get_array_ed(new int[] {5})); 
        lecture_education.put(new Lecture("IA et raisonnement, M1"), get_array_ed(new int[] {5})); 
        lecture_education.put(new Lecture("Programmation Web, M1"), get_array_ed(new int[] {5})); 

        lecture_education.put(new Lecture("Intelligence artificielle, M1"), get_array_ed(new int[] {7, 6})); 
        lecture_education.put(new Lecture("Systeme et algorithmes repartis, M1"), get_array_ed(new int[] {7}));
        lecture_education.put(new Lecture("Graph theory, M1"), get_array_ed(new int[] {7, 6}));
        lecture_education.put(new Lecture("Systeme d'information avancé, M1"), get_array_ed(new int[] {6})); 
        lecture_education.put(new Lecture("Programmation Web, M1"), get_array_ed(new int[] {6})); 
        lecture_education.put(new Lecture("Systeme d'information avancé, M1"), get_array_ed(new int[] {6})); 
        lecture_education.put(new Lecture("Securite des reseaux, M1"), get_array_ed(new int[] {6})); 

        lecture_education.put(new Lecture("Algorithmiques et programmation avancée, M1"), get_array_ed(new int[] {6})); 
        lecture_education.put(new Lecture("Game theory, M1"), get_array_ed(new int[] {7})); 
        lecture_education.put(new Lecture("Computional method for optimization, M1"), get_array_ed(new int[] {7})); 
        lecture_education.put(new Lecture("Projet ML Data, M1"), get_array_ed(new int[] {7})); 

        lecture_education.put(new Lecture("Graphes et applications, M2"), get_array_ed(new int[] {13}));
        lecture_education.put(new Lecture("Programmation par contraintes, M2"), get_array_ed(new int[] {13})); 
        lecture_education.put(new Lecture("Algorithmiques pour l'approximation, M2"), get_array_ed(new int[] {13})); 

        lecture_education.put(new Lecture("Graphes et applications, M2"), get_array_ed(new int[] {12})); 
        lecture_education.put(new Lecture("Entrepots de données, M2"), get_array_ed(new int[] {11, 12, 15})); 
        lecture_education.put(new Lecture("Optimization for machine learning, M2"), get_array_ed(new int[] {12})); // M2 MIAGE ID ALt
        lecture_education.put(new Lecture("Programmation par contraintes, M2"), get_array_ed(new int[] {12})); // M2 MIAGE ID ALt
        lecture_education.put(new Lecture("Visualisation des données, M2"), get_array_ed(new int[] {12, 11})); // M2 MIAGE ID ALt et I
        lecture_education.put(new Lecture("data Mining, M2"), get_array_ed(new int[] {11})); // M2 MIAGE ID I

        lecture_education.put(new Lecture("data science, M2"), get_array_ed(new int[] {14, 15})); // M2 STIN Alt et I
        lecture_education.put(new Lecture("SQL-NoSQL, M2"), get_array_ed(new int[] {14, 15})); // M2 STIN Alt et I

        Set<Lecture> keys = lecture_education.keySet(); 
        General_List.list_lecture = new ArrayList<>(keys) ; 
        /*for (Lecture key : keys) {
            key.lecture_student_list();  
        } */
    }
    
    public static void get_teacher(){
        ArrayList<Lecture> lecture = new ArrayList<>(); 
        lecture.add(list_lecture.get(0)); 
        lecture.add(list_lecture.get(1)); 
        lecture.add(list_lecture.get(2)); 
        Teacher t = new Teacher ("Khaddouja", "ZELLAMA", "myuser", "mypassword", lecture); 
        General_List.teacher = t ; 
        
   }

    public static boolean contains_the_key(Lecture lecture) {
    	for (Lecture lec : lecture_education.keySet() ) {
    		if (lec.equals(lecture)){
    			return true; 
    		}
    	}
    	return false ; 
    }
    
    public static void initData(){

        get_list_education();
        get_list_student();
        get_lecture_education();
        get_teacher();
        
    }
    
    public static void loadData() { ReadObject.read(); }
    
    public static void saveData() { WriteObject.write();}
    
    public static ArrayList<Education> get_education_from_lecture(Lecture lecture){
    	for (Lecture lec : General_List.lecture_education.keySet()) {
    		if (lec.equals(lecture)) {return General_List.lecture_education.get(lec);}	
    	}
    	return null ; 
    }

    public static ArrayList<Student> get_student_from_education(Education ed){
    	for (Education education : list_education_student.keySet()) {
    		if (education.equals(ed)) {return list_education_student.get(education) ; }
    	}
    	
    	return null ;
    } 
    
    public static ArrayList<Pair> get_pairs_from_project(Project project){
    	for (Project p : project_pair.keySet()) {
    		if( p.equals(project)) {return project_pair.get(p) ; }
    	}
    	return null ; 
    }
    
    public static void remove_from_list(ArrayList<Student> list, Student student) {
    	ArrayList<Student> list2 = new ArrayList<>(list) ; 
    	for (Student s : list2 ) {
    		if (s.equals(student)) {list.remove(s); }
    	}
    	
    }
    
    public static void remove_from_list_lecture(ArrayList<Lecture> list, Lecture lecture) {
    	ArrayList<Lecture> list2 = new ArrayList<>(list) ; 
    	for (Lecture l : list2 ) {
    		if (l.equals(lecture)) {list.remove(l); }
    	}
    	
    }
    
    
  
    }
    
  



    



