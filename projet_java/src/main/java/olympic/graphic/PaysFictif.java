package olympic.graphic;

import javafx.beans.property.SimpleStringProperty;

public class PaysFictif {
    private final Integer classement;
    private final String nom;
    private final Integer medailleOr;
    private final Integer medailleArgent;
    private final Integer medailleBronze;

    public PaysFictif(Integer classement, String nom, Integer medailleOr, Integer medailleArgent, Integer medailleBronze) {
        this.classement = classement;
        this.nom = nom;
        this.medailleOr = medailleOr;
        this.medailleArgent = medailleArgent;
        this.medailleBronze = medailleBronze;
    }

    // Getters and setters
    public int getClassement() { return classement; }
    public String getNom() { return nom; }
    public int getMedailleOr() { return medailleOr; }
    public int getMedailleArgent() { return medailleArgent; }
    public int getMedailleBronze() { return medailleBronze; }

    @Override
    public String toString() {
        return "{" +
                "classement=" + classement +
                ", nom=" + nom +
                ", medailleOr=" + medailleOr +
                ", medailleArgent=" + medailleArgent +
                ", medailleBronze=" + medailleBronze +
                "}";
    
    }
}