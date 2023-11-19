
public class Education {

    private static int nb_id = 0 ; 
    private final int id ; 
    private String level ; 
    public enum name  {IDD, MIAGE, MIAGE_IF, MIAGE_ID, MODO, MIAGE_STIN, IASD}
    public enum promotion {Initiale, Alternance, Continue}
    private name education_name ; 
    private promotion promo ; 


    public Education(name education_name, promotion promo, String level){
        this.education_name = education_name; 
        this.promo = promo ; 
        this.level = level ; 
        nb_id ++ ; 
        id = nb_id ; 
    }



    public Education(String ed, String p, String level) {
        this(name.valueOf(ed.toUpperCase()), promotion.valueOf(p), level) ; 
    }

    public String toString(){ return education_name.name() + " " + promo.name() + " " + level; }

    //Getters 
    public int getEducationId() { return id; }
    public String getNiv(){return level; }
    public name getName() { return education_name; }
    public promotion getPromotion() { return promo; }

    //Setters
    public void setName(name name) { this.education_name = name ; }
    public void setPromotion(promotion promotion) { this.promo = promotion; }

    

  
  
}