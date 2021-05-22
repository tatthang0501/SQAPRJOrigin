package ptit.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.BoMon;

public interface BoMonRepository extends CrudRepository<BoMon, Integer>{
    @Query(value="SELECT * FROM bomon WHERE khoa_id = ?1",nativeQuery = true)
    List<BoMon> getListBoMon(int khoaId);
}
