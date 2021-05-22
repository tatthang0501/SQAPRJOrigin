package ptit.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.TuanHoc;

public interface TuanHocRepository extends CrudRepository<TuanHoc, Integer>{
    @Query(value="SELECT * FROM tuanhoc WHERE lichhocid = ?1", nativeQuery = true)
    List<TuanHoc> findByLichHocId(int lhId);
}
