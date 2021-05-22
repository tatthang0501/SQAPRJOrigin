package ptit.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.MonHocKyHoc;

public interface MonHocKyHocRepository extends CrudRepository<MonHocKyHoc, Integer>{
    @Query(value="SELECT * from monhockyhoc WHERE kyhocid = ?1", nativeQuery = true)
    List<MonHocKyHoc> getListMHKH(int kyhocID);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE from monhockyhoc WHERE id = ?1", nativeQuery = true)
    public void deleteById(int id);
}
