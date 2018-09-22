package station.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import station.entity.Cuve;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by abdou on 10/12/2017.
 */
@Repository
public interface CuveDao extends JpaRepository <Cuve,Integer> {
}
