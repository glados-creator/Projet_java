package olympic.graphic;

import java.util.Comparator;

import olympic.model.Pays;

public class TriPays implements Comparator<Pays>{

    @Override
    public int compare(Pays o1, Pays o2) {
        int b1  = o1.getMedaille_bronze() * 1;
        int b2  = o2.getMedaille_bronze() * 1;

        int a1 = o1.getMedaille_argent() * 10;
        int a2 = o2.getMedaille_argent() * 10;

        int or1 = o1.getMedaille_or() * 100;
        int or2 = o2.getMedaille_or() * 100;
        return (b1 + a1 + or1) - (b2 + a2 + or2);
    }
    
}
