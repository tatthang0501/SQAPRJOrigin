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

import ptit.data.KhoaRepository;
import ptit.models.Khoa;

//Test các chức năng của lớp KhoaRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestKhoa {
    @Autowired
    KhoaRepository kRepo;

    @Test
    // Test tạo đối tượng khoa
    @Order(1)
    public void testCreate() {
        Khoa test = new Khoa();
        test.setId(1000);
        test.setTen("Khoa test số 1");
        test.setBoMon(null);
        test.setMota("Mô tả khoa 1");
        kRepo.save(test);
        assertNotNull(kRepo.findById(1000).get());
    }

    // Test lấy ra một đối tượng khoa
    @Test
    @Order(2)
    public void testSingle() {
        Khoa test = kRepo.findById(1000).get();
        assertNotNull(test);
        assertEquals(1000, test.getId());
        assertEquals("Khoa test số 1", test.getTen());
    }

    // Test lấy hết các dòng trong bảng khoa
    @Test
    @Order(3)
    public void testGetAll(){
        List<Khoa> listFound = (List<Khoa>) kRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    // Test sửa 1 dòng trong bảng khoa
    @Test
    @Order(4)
    public void testUpdate(){
        Khoa test = kRepo.findById(1000).get();
        test.setTen("Sửa khoa test số 1");
        test.setMota("Sửa mô tả khoa test số 1");
        kRepo.save(test);
        assertNotEquals("Khoa test số 1", kRepo.findById(1000).get().getTen());
        assertNotEquals("Mô tả khoa 1", kRepo.findById(1000).get().getMota());
        assertEquals("Sửa khoa test số 1", kRepo.findById(1000).get().getTen());
        assertEquals("Sửa mô tả khoa test số 1", kRepo.findById(1000).get().getMota());
    }

    //Test xóa 1 dòng trong bảng khoa
    @Test
    @Order(5)
    public void testDelete(){
        kRepo.deleteById(1000);
        assertEquals(kRepo.existsById(1000), false);
    }
}
