package station.dto;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by abdou on 03/02/2018.
 */
public class EmployeDto {

    private Integer id;

    private String nom;

    private String prenom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
