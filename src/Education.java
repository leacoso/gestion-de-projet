public class Education {
    private static int nb_id = 0 ; 
    private final int id ; 
    private String niv ; 
    public enum name  {IDD, MIAGE, MIAGE_IF, MIAGE_ID, MODO, MIAGE_STIN, IASD}
    public enum promotion {Initiale, Alternance, Continue}
    private name education_name ; 
    private promotion promo ; 


    public Education(name education_name, promotion promo, String niv){
        this.education_name = education_name; 
        this.promo = promo ; 
        this.niv = niv ; 
        nb_id ++ ; 
        id = nb_id ; 
    }
    public Education(String ed, String p, String niv) {
        this(name.valueOf(ed.toUpperCase()), promotion.valueOf(p), niv) ; 
    }

    public String toString(){
        return education_name.name() + " " + promo.name() + " " + niv; 
    }

    public int getEducationId() {
        return id;
    }

    public String getNiv(){return niv; }

    public void setName(name name) {
        this.education_name = name;
    }

    public name getName() {
        return education_name;
    }

    public void setPromotion(promotion promotion) {
        this.promo = promotion;
    }

    public promotion getPromotion() {
        return promo;
    }

  
  
}