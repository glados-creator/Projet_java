package olympic.graphic;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PaysFictif {
    private final SimpleIntegerProperty classement;
    private final SimpleStringProperty nom;
    private final SimpleIntegerProperty medailleOr;
    private final SimpleIntegerProperty medailleArgent;
    private final SimpleIntegerProperty medailleBronze;

    public PaysFictif(Integer classement, String nom, Integer medailleOr, Integer medailleArgent, Integer medailleBronze) {
        this.classement = new SimpleIntegerProperty(classement);
        this.nom = new SimpleStringProperty(nom);
        this.medailleOr = new SimpleIntegerProperty(medailleOr);
        this.medailleArgent = new SimpleIntegerProperty(medailleArgent);
        this.medailleBronze = new SimpleIntegerProperty(medailleBronze);
    }

    // Getters and setters
    public int getClassement() { return classement.get(); }
    public String getNom() { return nom.get(); }
    public int getMedailleOr() { return medailleOr.get(); }
    public int getMedailleArgent() { return medailleArgent.get(); }
    public int getMedailleBronze() { return medailleBronze.get(); }
}