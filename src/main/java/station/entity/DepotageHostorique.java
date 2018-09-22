package station.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by abdou on 23/01/2018.
 */
@Entity
@Table(name = "DEPOTAGEHOSTORIQUE")
public class DepotageHostorique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDCUVE")
    private Integer cuve;

    @Column(name = "QUANTITE")
    private Integer quantite;

    @Column(name = "DATE")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCuve() {
        return cuve;
    }

    public void setCuve(Integer cuve) {
        this.cuve = cuve;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
