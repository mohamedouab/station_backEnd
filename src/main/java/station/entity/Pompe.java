package station.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */

@Entity
@Table(name="POMPE")
public class Pompe implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CHIFFRE")
    private Integer index;

    @Column(name = "DERNIERECHIFFRE")
    private Integer lastIndex;

    @Column(name = "LASTUPDATE")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "CUVE")
    private Cuve cuve;

    public Pompe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Cuve getCuve() {
        return cuve;
    }

    public void setCuve(Cuve cuve) {
        this.cuve = cuve;
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
}
