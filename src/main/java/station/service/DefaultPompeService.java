package station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import station.dao.CuveDao;
import station.dao.PompeDao;
import station.dto.PompeDto;
import station.entity.Cuve;
import station.entity.Pompe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */
@Service
public class DefaultPompeService implements PompeService {
    @Autowired
    PompeDao pompeDao;

    @Autowired
    CuveDao cuveDao;

    @Autowired
    DefaultCuveService cuveService;

    @Autowired
    DefaultPompeHistoriqueService pompeHistorique;

    public void create(PompeDto pompeDto) {
        Pompe pompe = new Pompe();
        pompe.setId(Integer.valueOf(pompeDto.getId()));
        pompe.setIndex(Integer.parseInt(pompeDto.getIndex()));
        pompe.setLastUpdate(new java.util.Date());
        pompeDao.save(pompe);
    }

    public void connectPompeToCuve(Integer idPompe, Integer idCuve) {
        deconnectPompeToCuve(idPompe);
        Cuve cuve = cuveDao.findById(idCuve).get();
        Pompe pompe = pompeDao.findById(idPompe).get();
        pompe.setCuve(cuve);
        pompeDao.saveAndFlush(pompe);
        cuveService.addPompeToCuve(pompe, cuve);
        return;
    }

    public List<PompeDto> findAll() {
        List<Pompe> listPome = pompeDao.findAll();
        List<PompeDto> listPomeDto = new ArrayList<PompeDto>();
        for (Pompe pompe : listPome) {
            PompeDto pompeDto = new PompeDto();
            pompeDto.setId(pompe.getId().toString());
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

    public int calculateRendement(Integer id, int index) {
//        java.util.Optional<Pompe> pompe = pompeDao.findById(id);
//        int vent = index - pompe.get().getIndex();
        // return vent * 380;
        return 1;
    }

    public void updateIndex(PompeDto pompeDto) {
        Pompe pompe = pompeDao.findById(Integer.valueOf(pompeDto.getId())).get();

        pompe.setId(Integer.valueOf(pompeDto.getId()));
        pompe.setLastIndex(pompe.getIndex());
        pompe.setIndex(Integer.parseInt(pompeDto.getIndex()));
        pompe.setLastUpdate(new java.util.Date());
        pompeDao.saveAndFlush(pompe);
        pompeHistorique.create(pompe);
        Integer quatite = pompe.getIndex() - pompe.getLastIndex();
        cuveService.updateStock(pompe.getCuve().getId(),quatite);
    }

    public void deconnectPompeToCuve(Integer idPompe) {
        java.util.Optional<Pompe> pompe = pompeDao.findById(idPompe);
        Pompe pomToUpdate = pompe.get();
        if (pomToUpdate.getCuve() != null) {
            Cuve cuve = cuveDao.findById(pomToUpdate.getCuve().getId()).get();
            int i = 0;
            for (Pompe p : cuve.getPompes()) {
                if (p.getId().equals(idPompe)) {
                    cuve.getPompes().remove(i);
                    break;
                }
                i++;
            }
            cuveDao.saveAndFlush(cuve);
            pomToUpdate.setCuve(null);
            pompeDao.saveAndFlush(pomToUpdate);
        }
    }
}
