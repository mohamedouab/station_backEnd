package station.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import station.entity.Pompe;
import station.entity.PompeHistorique;

/**
 * Created by abdou on 10/12/2017.
 */
@Repository
public interface PompeHistoriqueDao extends  JpaRepository <PompeHistorique,Long>{
}
