package ptit.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.KipHoc;

public interface KipHocRepository extends CrudRepository<KipHoc, Integer>{
    @Query(value="SELECT * FROM kiphoc WHERE lichhocid = ?1", nativeQuery = true)
    List<KipHoc> findByLichHocId(int lhId);
}
