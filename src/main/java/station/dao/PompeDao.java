package station.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import station.entity.Pompe;

/**
 * Created by abdou on 10/12/2017.
 */
@Repository
public interface PompeDao extends  JpaRepository <Pompe,Integer>{

    @Query("update Pompe p set p.index = :index where p.id = :id")
    void updateIndexById(@Param("id") Integer id, @Param("index") int index);
}
