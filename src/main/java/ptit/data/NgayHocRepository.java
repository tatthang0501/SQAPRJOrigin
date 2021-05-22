package ptit.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.NgayHoc;

public interface NgayHocRepository extends CrudRepository<NgayHoc,Integer>{
    @Query(value="SELECT * FROM ngayhoc WHERE lichhocid = ?1", nativeQuery = true)
    List<NgayHoc> findByLichHocId(int lhId);
}
