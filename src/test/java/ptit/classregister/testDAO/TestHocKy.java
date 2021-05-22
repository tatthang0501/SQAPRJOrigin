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

import ptit.data.HocKyRepository;
import ptit.models.HocKy;
//Test các chức năng của lớp HocKyRepository
// Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestHocKy {
    @Autowired
    HocKyRepository hkRepo;

    //Test tạo một đối tượng HocKy
    @Test
    @Order(1)
    public void testCreate(){
        HocKy test = new HocKy();
        test.setId(100);
        test.setMota("Mô tả test học kỳ");
        test.setTen("Tên test học kỳ");
        hkRepo.save(test);
        assertNotNull(hkRepo.findById(100).get());
        assertEquals(hkRepo.findById(100).get().getTen(), "Tên test học kỳ");
    }

    //Test lấy một dòng trong bảng HocKy
    @Test
    @Order(2)
    public void testSingle(){
        HocKy test = hkRepo.findById(100).get();
        assertEquals(test.getTen(), "Tên test học kỳ");
        assertEquals(test.getMota(), "Mô tả test học kỳ");
    }

    //Test lấy hết các dòng trong bảng HocKy
    @Test
    @Order(3)
    public void testGetAll(){
        List<HocKy> listFound = (List<HocKy>) hkRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    // Test sửa một dòng trong bảng HocKy
    @Test
    @Order(4)
    public void testUpdate(){
        HocKy testUpdate = hkRepo.findById(100).get();
        testUpdate.setMota("Sửa mô tả test học kỳ");
        hkRepo.save(testUpdate);
        assertEquals(hkRepo.findById(100).get().getMota(), "Sửa mô tả test học kỳ");
    }

    //Test xóa một dòng trong bảng HocKy
    @Test
    @Order(5)
    public void testDelete(){
        hkRepo.deleteById(100);
        assertNotEquals(hkRepo.existsById(100), true);
    }
}
