package station.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import station.entity.Employe;

/**
 * Created by abdou on 03/02/2018.
 */
public interface EmployeDao extends JpaRepository<Employe,Long> {
}
