package olympic.model;

/**
 * Sport
 */
public abstract class Sport {

    private String nom;
    private String uniter;

    public Sport(String nom, String uniter) {
        this.nom = nom;
        this.uniter = uniter;
    }

    public String GetNom() {
        return this.nom;
    }

    public String GetUniter() {
        return this.uniter;
    }
}