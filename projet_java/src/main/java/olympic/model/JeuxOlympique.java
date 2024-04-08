package olympic.model;
import java.util.Objects;

/**
 * JeuxOlympique
 */
public class JeuxOlympique {

    private String annee;
    private String lieux;


    public JeuxOlympique() {
    }

    public JeuxOlympique(String annee, String lieux) {
        this.annee = annee;
        this.lieux = lieux;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getLieux() {
        return this.lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public JeuxOlympique annee(String annee) {
        setAnnee(annee);
        return this;
    }

    public JeuxOlympique lieux(String lieux) {
        setLieux(lieux);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JeuxOlympique)) {
            return false;
        }
        JeuxOlympique jeuxOlympique = (JeuxOlympique) o;
        return Objects.equals(annee, jeuxOlympique.annee) && Objects.equals(lieux, jeuxOlympique.lieux);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annee, lieux);
    }

    @Override
    public String toString() {
        return "{" +
            " annee='" + getAnnee() + "'" +
            ", lieux='" + getLieux() + "'" +
            "}";
    }
    

}