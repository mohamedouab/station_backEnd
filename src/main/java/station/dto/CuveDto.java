package station.dto;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by abdou on 01/01/2018.
 */
public class CuveDto {
    private Integer id;
    private Integer capacite;

    private Integer contenu;
    private Date lastdepot;

    public CuveDto() {
    }

    public CuveDto(Integer id, Integer capacite) {
        this.id = id;
        this.capacite = capacite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getContenu() {
        return contenu;
    }

    public void setContenu(Integer contenu) {
        this.contenu = contenu;
    }

    public Date getLastdepot() {
        return lastdepot;
    }

    public void setLastdepot(Date lastdepot) {
        this.lastdepot = lastdepot;
    }
}
