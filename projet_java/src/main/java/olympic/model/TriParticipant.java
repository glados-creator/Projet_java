package olympic.model;

import java.util.Comparator;

/** class TriParticipant implements Comparator[Participant] */
public class TriParticipant implements Comparator<Participant>{
    /** compare
     * @param p1 Participant
     * @param p2 Participant
     * @return int comparaison de capacité
     */
    public int compare(Participant p1, Participant p2){
        // TODO : modif pour que ca soit avec les coef
        return (int) (p1.getCapa()-p2.getCapa());
    }
}