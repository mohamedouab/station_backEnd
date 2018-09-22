package station.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */
@Entity
@Table(name = "CUVE")
public class Cuve implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CAPACITE")
    private int capacite;

    @Column(name = "CONTENU")
    private Integer contenu;


    @Column(name = "LASTDEPOT")
    private Date lastdepot;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "LIAISON",
                    joinColumns = {@JoinColumn(name = "CUVE_ID", referencedColumnName = "ID")},
                    inverseJoinColumns = {@JoinColumn(name = "POMPE_ID", referencedColumnName = "ID", unique = true)}
            )
    private List<Pompe> pompes;

    public Cuve() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Pompe> getPompes() {
        if (pompes == null) {
            pompes = new ArrayList<Pompe>();
        }
        return pompes;
    }

    public void setPompes(List<Pompe> pompes) {
        this.pompes = pompes;
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
