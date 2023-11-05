import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class List {
    public static ArrayList<Student> student_list = new ArrayList<>();  
    public static HashMap<Lecture,ArrayList<Education>> lecture_education = new HashMap<>();  
    public static ArrayList<Lecture> list_lecture = new ArrayList<>(); 
    public static ArrayList<Education> list_education = new ArrayList<>(); 
    public static HashMap<Education, ArrayList<Student>> list_education_student = new HashMap<Education, ArrayList<Student>>(); 
    

    public static void get_list_education(){
    //L3
    list_education.add( new Education ("MIAGE","Alternance", "L3")); 
    list_education.add( new Education ("MIAGE","Initiale", "L3"));
    list_education.add( new Education ("IDD","Initiale", "L3"));
    list_education.add( new Education ("MIAGE","Continue", "L3"));
    list_education.add( new Education ("IDD","Continue", "L3"));

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
         
        int begin = 223513 ; 
        for (int i = 0 ; i<  firstname_list.length; i++){
         
            int etu = Integer.parseInt(String.valueOf(begin) + String.valueOf(i));
            
            Random random = new Random(); 
            int formation = random.nextInt(18); 
            Student student = new Student(firstname_list[i], lastname_list[i], etu, list_education.get(formation), null);
            student_list.add(student) ;
            
            if (list_education_student.get(list_education.get(formation)).isEmpty()){  
                list_education_student.get(list_education.get(formation)).add(student) ; 
            }
            
        }


    }
    
    
    //MAGE L3
    /* base de données relationnelles
     * Java-Objet
     * Introduction to logic
     * Analyse de données
     * algo dans les graphes
     * ingenierie des SI 1
     * 
     * System exploi
     * critical thinking
     * reseaux 
     * PL
     * ngeniere des SI 2
    M1 MIAGE ALT
    PO avancee
    intro machine learning
    system et gestion de bdd
    System d'ino 1
    systeme et algo repartis
    SI avancée 2
    IA et raisonnement
    prgrammation web

    M1 MIAGE INITALE
    Artificial intelligence
    PO avancee
    Systeme et algo repartis 
    system info 1
    machine learning et app
    graph theory
    system info avancee
    programmation web 
    computer ethic and data protectio 
    securité des reseaux 

    M1 IDD
    Algorithmic and advanced pro
    graph theory
    artificial intelligence
    system et algo repartis 
    game theory
    POO avancée
    computional
    machne learninglogic theory
    ML project /data science


    MODO
    Graphes et application 


    */
    
    public static void main(String args[]){
        get_list_education(); 
        //System.out.println(list_education); 
        get_list_student();
        //System.out.println(student_list); 
        System.out.println(list_education_student); 
     


    }
    
  
}


    



