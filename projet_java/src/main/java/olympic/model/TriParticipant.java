package olympic.model;

import java.util.Comparator;

public class TriParticipant implements Comparator<Participant>{

    public int compare(Participant p1, Participant p2){
        return (int) (p1.getCapa()-p2.getCapa());
    }
}