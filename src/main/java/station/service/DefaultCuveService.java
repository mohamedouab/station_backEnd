package station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import station.dao.CuveDao;
import station.dto.CuveDto;
import station.entity.Cuve;
import station.entity.Pompe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */
@Service
public class DefaultCuveService implements CuveService {
    @Autowired
    CuveDao cuveDao;

    public void create(CuveDto cuveDto) {
        Cuve cuve = new Cuve();
        cuve.setId(cuveDto.getId());
        cuve.setCapacite(cuveDto.getCapacite());
        cuveDao.save(cuve);
    }

    public CuveDto findById(Integer id) {
        java.util.Optional<Cuve> cuve = cuveDao.findById(id);
        CuveDto cuveDto = new CuveDto();
        cuveDto.setId(cuve.get().getId());
        cuveDto.setCapacite(cuve.get().getCapacite());
        return cuveDto;
    }

    public Cuve addPompeToCuve(Pompe pompe, Cuve cuve) {
        cuve.getPompes().add(pompe);
        cuveDao.saveAndFlush(cuve);
        return cuve;
    }

    public List<CuveDto> findAll() {
        List<Cuve> listCuve = cuveDao.findAll();
        List<CuveDto> listCuveDto = new ArrayList<CuveDto>();
        for (Cuve cuve : listCuve) {
            CuveDto cuveDto = new CuveDto();
            cuveDto.setId(cuve.getId());
            cuveDto.setCapacite(cuve.getCapacite());
            cuveDto.setContenu(cuve.getContenu());
            cuveDto.setLastdepot(cuve.getLastdepot());
            listCuveDto.add(cuveDto);
        }
        return listCuveDto;
    }

    public int consulterRest(Integer id) {
        Cuve cuve = cuveDao.findById(id).get();
        return cuve.getPompes().size();
    }

    public void deposer(Integer id, Integer quantite) {
        Cuve cuve = cuveDao.findById(id).get();
        cuve.setContenu(quantite);
        cuve.setLastdepot(new Date());
        cuveDao.saveAndFlush(cuve);
    }

    public void updateStock(Integer id, Integer quantite) {

        Cuve cuve = cuveDao.findById(id).get();
        cuve.setContenu( cuve.getContenu()-quantite);
        cuveDao.saveAndFlush(cuve);
    }
}
