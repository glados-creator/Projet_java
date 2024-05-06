package olympic.model;

/**
 * Participant
 */
public interface Participant {
    /**
     * getNom
     * @return nom de l equipe ou du joueur
     */
    public String getNom();
    /**
     * participe
     * @return score
     */
    default public double participe(Epreuve ep){
        return ep.simuleEpreuve().indexOf(this);
    }

    public double getCapa();

}