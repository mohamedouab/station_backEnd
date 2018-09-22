package station.dto;

/**
 * Created by abdou on 19/01/2018.
 */
public class ConnectionRequest {
    private Integer idPompe;
    private  Integer idCuve;

    public ConnectionRequest() {
    }

    public ConnectionRequest(Integer idPompe, Integer idCuve) {
        this.idPompe = idPompe;
        this.idCuve = idCuve;
    }

    public Integer getIdPompe() {
        return idPompe;
    }

    public void setIdPompe(Integer idPompe) {
        this.idPompe = idPompe;
    }

    public Integer getIdCuve() {
        return idCuve;
    }

    public void setIdCuve(Integer idCuve) {
        this.idCuve = idCuve;
    }
}
