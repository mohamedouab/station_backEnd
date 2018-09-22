package station.service;

import station.dto.PompeDto;
import station.entity.Pompe;

import java.util.List;

/**
 * Created by abdou on 27/01/2018.
 */
public interface PompeHistoriqueService {

    public List<PompeDto> findAll();

    public void create(Pompe pompe);


}
