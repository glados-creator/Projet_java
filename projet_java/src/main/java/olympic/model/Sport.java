package olympic.model;

/**
 * Sport
 */
public abstract class Sport {

    protected String nom;
    protected String uniter;

    public String GetNom(){return this.nom;} 
    public String GetUniter(){return this.uniter;}
}