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
     * @param ep Epreuve  
     * @return double
     */
    default public double participe(Epreuve ep){
        return ep.simuleEpreuve().indexOf(this);
    }
    /**
     * getCapa pour avoir les capacité calculé
     * @return double , moyenne des capacité d'équipe / sum coef epreuve x coef athlete
     */
    public double getCapa();

}