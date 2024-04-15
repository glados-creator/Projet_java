package olympic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Sport
 */
public abstract class Sport {
    /** String nom */
    private String nom;
    /** String uniter */
    private String uniter;
    /** List[Epreuve] les_epreuves */
    private List<Epreuve> les_epreuves;

    /**
     * Sport
     * @param nom String
     * @param uniter String
     */
    public Sport(String nom, String uniter) {
        this.nom = nom;
        this.uniter = uniter;
        les_epreuves = new ArrayList<>();
    }

    /**
     * GetNom
     * @return String
     */
    public String GetNom() {
        return this.nom;
    }

    /**
     * GetUniter
     * @return String
     */
    public String GetUniter() {
        return this.uniter;
    }

    /**
     * ajouter_epreuve
     * @param epreuve Epreuve
     */
    public void ajouter_epreuve(Epreuve epreuve){
        les_epreuves.add(epreuve);
    }
    /**
     * les_epreuves admin
     * @return List[Epreuve] 
     */
    public List<Epreuve> les_epreuves(){
        return les_epreuves;
    }
}