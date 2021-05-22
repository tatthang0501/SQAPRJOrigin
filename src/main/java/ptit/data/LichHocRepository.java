package ptit.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ptit.models.LichHoc;

public interface LichHocRepository extends CrudRepository<LichHoc, Integer> {
    @Query(value = "SELECT * FROM lichhoc WHERE lhpid = ?1", nativeQuery = true)
    List<LichHoc> findLichLHP(int khpId);

    @Query(value = "SELECT * FROM lichhoc WHERE giangvienid = ?1", nativeQuery = true)
    List<LichHoc> findDaDKLHP(int gvId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lichhoc SET giangvienid = ?1 WHERE id = ?2", nativeQuery = true)
    int updateDangKy(int gvId, int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lichhoc SET giangvienid = null WHERE giangvienid = ?1", nativeQuery = true)
    int xoaHetDangKy(int gvId);

    @Modifying
    @Transactional
    @Query(value = "DELETE from lichhoc WHERE id = ?1", nativeQuery = true)
    public void deleteById(int id);
}
