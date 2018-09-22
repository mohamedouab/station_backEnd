package station.service;

import org.springframework.stereotype.Service;
import station.dto.CuveDto;
import station.entity.Cuve;
import station.entity.Pompe;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by abdou on 10/12/2017.
 */
public interface CuveService {

    void create(CuveDto cuveDto);

    List<CuveDto> findAll();

    CuveDto findById(Integer id);

    Cuve addPompeToCuve(Pompe pompe, Cuve cuve);

    int consulterRest(Integer id);

    void deposer(Integer id, Integer quantite);

    void updateStock(Integer id, Integer quantite);
}
