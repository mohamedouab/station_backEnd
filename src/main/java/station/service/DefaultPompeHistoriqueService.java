package station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import station.dao.PompeHistoriqueDao;
import station.dto.PompeDto;
import station.entity.Pompe;
import station.entity.PompeHistorique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdou on 27/01/2018.
 */

@Service
public class DefaultPompeHistoriqueService implements PompeHistoriqueService {

    @Autowired
    private PompeHistoriqueDao pompeHistoriqueDao;

    public List<PompeDto> findAll() {
        List<PompeHistorique> listPome = pompeHistoriqueDao.findAll();
        List<PompeDto> listPomeDto = new ArrayList<PompeDto>();
        for (PompeHistorique pompe : listPome) {
            PompeDto pompeDto = new PompeDto();
            pompeDto.setId(pompe.getPompe().toString());
            pompeDto.setIndex(Integer.toString(pompe.getIndex()));
            pompeDto.setLasteUpdate(pompe.getLastUpdate());
            if (pompe.getLastIndex() == null) {
                pompeDto.setLastIndex("0");
            } else {
                pompeDto.setLastIndex(Integer.toString(pompe.getLastIndex()));

            }
            listPomeDto.add(pompeDto);
        }
        return listPomeDto;
    }

    public void create(Pompe pompe) {
        PompeHistorique pompeHistorique = new PompeHistorique();
        pompeHistorique.setPompe(pompe.getId());
        pompeHistorique.setIndex(pompe.getIndex());
        pompeHistorique.setLastUpdate(pompe.getLastUpdate());
        pompeHistorique.setCuve(pompe.getCuve() != null ? pompe.getCuve().getId() : null);
        pompeHistorique.setLastIndex(pompe.getLastIndex());
        pompeHistoriqueDao.save(pompeHistorique);
    }


}
