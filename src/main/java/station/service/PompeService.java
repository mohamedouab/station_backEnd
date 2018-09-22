package station.service;

import station.dto.PompeDto;
import station.entity.Pompe;

import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */
public interface PompeService {

    public void create(PompeDto pompeDto);

    public void connectPompeToCuve(Integer idPompe, Integer idCuve);

    public List<PompeDto> findAll();


    public int calculateRendement(Integer id, int index);

    public void updateIndex(PompeDto pompeDto);

    public void deconnectPompeToCuve(Integer idPompe);

}
