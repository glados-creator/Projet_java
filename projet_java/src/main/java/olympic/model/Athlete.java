package olympic.model;

/**
 * Athlete
 */
public class Athlete implements Participant {

    /** private String Nom */
    private final String Nom;
    /** private String Prenom */
    private final String Prenom;
    /** private boolean Sex */
    private boolean Sex;
    /** private double force */
    private double force;
    /** private double Agilite */
    private double Agilite;
    /** private double endurance */
    private double endurance;

    /** private Pays Origine */
    private final Pays Origine;
    /** private Equipe membre */
    private Equipe membre;

    /**
     * constructeur
     * 
     * @param Nom       String
     * @param Prenom    String
     * @param Sex       boolean
     * @param force     double
     * @param Agilite   double
     * @param endurance double
     * @param Origine   Pays
     */
    public Athlete(String Nom, String Prenom, boolean Sex, double force, double Agilite, double endurance, Pays Origine) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Sex = Sex;
        this.force = force;
        this.Agilite = Agilite;
        this.endurance = endurance;
        this.Origine = Origine;
    }

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom() {
        return Nom;
    }

    /**
     * getPrenom
     * 
     * @return String
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * getSex
     * 
     * @return boolean
     */
    public boolean getSex() {
        return Sex;
    }

    /**
     * setSex_a admin
     * 
     * @param Sex boolean
     */
    public void setSex_a(boolean Sex) {
        this.Sex = Sex;
    }

    /**
     * getForce
     * 
     * @return double
     */
    public double getForce() {
        return force;
    }

    /**
     * setForce_a admin
     * 
     * @param force double
     */
    public void setForce_a(double force) {
        this.force = force;
    }

    /**
     * getAgilite
     * 
     * @return double
     */
    public double getAgilite() {
        return Agilite;
    }

    /**
     * setAgilite_a admin
     * 
     * @param Agilite double
     */
    public void setAgilite_a(double Agilite) {
        this.Agilite = Agilite;
    }

    /**
     * getEndurance
     * 
     * @return double
     */
    public double getEndurance() {
        return endurance;
    }

    /**
     * setEndurance_a admin
     * 
     * @param endurance double
     */
    public void setEndurance_a(double endurance) {
        this.endurance = endurance;
    }

    /**
     * getOrigine
     * 
     * @return double
     */
    public Pays getOrigine() {
        return Origine;
    }

    /**
     * isMembre
     * 
     * @return boolean , si l'athlete est dans une equipe
     */
    public boolean isMembre() {
        return !(membre == null);
    }

    /**
     * ajoute_equipe
     * 
     * @param membre Equipe , l'equipe auquel il fait partie
     */
    public void setMembre(Equipe membre) {
        this.membre = membre;
    }

    /**
     * getMembre
     * 
     * @return Equipe , equipe auquel l'athlete fait parti , null sinon
     */
    public Equipe getMembre() {
        return membre;
    }

    /** void removeMembre */
    public void removeMembre() {
        membre = null;
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                "'Nom':'" + getNom() + "'" +
                ", 'Sex':'" + getSex() + "'" +
                ", 'force':'" + getForce() + "'" +
                ", 'Agilite':'" + getAgilite() + "'" +
                ", 'endurance':'" + getEndurance() + "'" +
                "}";
    }

}
