package station.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by abdou on 23/01/2018.
 */

@Entity
@Table(name = "POMPEHISTORIQUE")
public class PompeHistorique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDPOMPE")
    private Integer pompe;

    @Column(name = "CHIFFRE")
    private Integer index;

    @Column(name = "ANCIENINDEX")
    private Integer lastIndex;

    @Column(name = "LASTUPDATE")
    private Date lastUpdate;

    @Column(name = "IDCUVE")
    private Integer cuve;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(Integer lastIndex) {
        this.lastIndex = lastIndex;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getPompe() {
        return pompe;
    }

    public void setPompe(Integer pompe) {
        this.pompe = pompe;
    }

    public Integer getCuve() {
        return cuve;
    }

    public void setCuve(Integer cuve) {
        this.cuve = cuve;
    }
}
