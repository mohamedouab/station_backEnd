package station.dto;

/**
 * Created by abdou on 19/01/2018.
 */
public class DepotageRequest {
    private Integer quantite;
    private  Integer idCuve;

    public DepotageRequest() {
    }

    public DepotageRequest(Integer quantite, Integer idCuve) {
        this.quantite = quantite;
        this.idCuve = idCuve;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getIdCuve() {
        return idCuve;
    }

    public void setIdCuve(Integer idCuve) {
        this.idCuve = idCuve;
    }
}
