package olympic.model;

// TODO: sync with datamanager

// TODO : implement comparable ?

/**
 * Participant
 */
public interface Participant {
    /**
     * participe
     * 
     * @param ep Epreuve
     * @return double
     */
    default public double participe(Epreuve ep) {
        return (getForce() * ep.getSport().getCoef_Force()) + (getAgilite() * ep.getSport().getCoef_Agilite())
                + (getEndurance() * ep.getSport().getCoef_Endurance());
    }

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom();

    /**
     * getForce
     * 
     * @return double
     */
    public double getForce();

    /**
     * getagilite
     * 
     * @return double
     */
    public double getAgilite();

    /**
     * getEndurance
     * 
     * @return double
     */
    public double getEndurance();

    /**
     * getOrigine
     * 
     * @return double
     */
    public Pays getOrigine();
}