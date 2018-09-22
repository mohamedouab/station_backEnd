package station.dto;


import java.util.Date;

/**
 * Created by abdou on 27/12/2017.
 */

public class PompeDto {
    private String id;
    private String index;
    private String lastIndex;
    private Date lasteUpdate;
    private Integer recette;


    public PompeDto() {
    }

    public PompeDto(String id, String index, String lastIndex, Date lasteUpdate, Integer recette) {
        this.id = id;
        this.index = index;
        this.lastIndex = lastIndex;
        this.lasteUpdate = lasteUpdate;
        this.recette = recette;
    }

    public Integer getRecette() {
        return recette;
    }

    public void setRecette(Integer recette) {
        this.recette = recette;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(String lastIndex) {
        this.lastIndex = lastIndex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLasteUpdate() {
        return lasteUpdate;
    }

    public void setLasteUpdate(Date lasteUpdate) {
        this.lasteUpdate = lasteUpdate;
    }
}
