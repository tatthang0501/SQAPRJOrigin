package ptit.classregister.testDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ptit.data.LopHocPhanRepository;
import ptit.data.MonHocKyHocRepository;
import ptit.models.LichHoc;
import ptit.models.LopHocPhan;
import ptit.models.MonHocKyHoc;


//Test các chức năng của lớp LopHocPhanRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestLopHocPhan {
    @Autowired
    LopHocPhanRepository lhpRepo;
    @Autowired
    MonHocKyHocRepository mhlhpRepo;

    //Test tạo một dòng trong bảng LopHocPhan
    @Test
    @Order(1)
    public void testCreate() {
        LopHocPhan test = new LopHocPhan();
        test.setId(100);
        MonHocKyHoc mhkhTest = mhlhpRepo.findById(1).get();
        test.setMhkh(mhkhTest);
        test.setMota("test mo ta");
        test.setSisotoida(100);
        test.setTen("test ten");
        lhpRepo.save(test);
        assertNotNull(lhpRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng LopHocPhan
    @Test
    @Order(2)
    public void testSingle(){
        LopHocPhan test = lhpRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getMhkh().getId(), 1);
        assertEquals(test.getTen(), "test ten");
    }

    //Test lấy tất cả các dòng trong bảng LopHocPhan
    @Test
    @Order(3)
    public void testGetAll(){
        List<LopHocPhan>listFound = (List<LopHocPhan>) lhpRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng LopHocPhan
    @Test
    @Order(4)
    public void testUpdate(){
        LopHocPhan test = lhpRepo.findById(100).get();
        test.setTen("sua ten");
        lhpRepo.save(test);
        assertEquals(lhpRepo.findById(100).get().getTen(), "sua ten");
    }

    //Test xóa một dòng trong bảng LopHocPhan
    @Test
    @Order(5)
    public void testDelete(){
        lhpRepo.deleteById(100);
        assertEquals(lhpRepo.existsById(100), false);
    }

    // Test lấy danh sách lophocphan từ id monhockyhoc
    @Test
    @Order(6)
    public void testGetByMHKHId(){
        // Lấy danh sách từ mhkh có id là 1
        List<LopHocPhan>listFound = (List<LopHocPhan>) lhpRepo.getLHPByMHKHId(1);
        assertEquals(5, listFound.size());
        assertEquals(1, listFound.get(0).getId());
        assertEquals(5, listFound.get(4).getId());
    }

}
