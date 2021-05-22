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

import ptit.data.DiaChiRepository;
import ptit.models.DiaChi;
//Test các chức năng của lớp DiaChiRepository
// Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestDiaChi {
    @Autowired
    DiaChiRepository dcRepo;

    //Test tạo một đối tượng DiaChi
    @Test
    @Order(1)
    public void testCreate(){
        DiaChi test = new DiaChi();
        test.setId(100);
        test.setPhuongxa("test phuongxa");
        test.setQuanhuyen("test quanhuyen");
        test.setSonha("test so nha");
        test.setTinhthanh("test tinh thanh");
        test.setToanha("test toanha");
        test.setXompho("test xompho");
        dcRepo.save(test);
        assertNotNull(dcRepo.findById(100).get());
    }

    //Test lấy một dòng trong bảng DiaChi
    @Test
    @Order(2)
    public void testSingle(){
        DiaChi test = dcRepo.findById(100).get();
        assertEquals(test.getPhuongxa(), "test phuongxa");
        assertEquals(test.getQuanhuyen(), "test quanhuyen");
        assertEquals(test.getId(), 100);
    }

    //Test lấy hết các dòng trong bảng DiaChi
    @Test
    @Order(3)
    public void testGetAll(){
        List<DiaChi> listFound = (List<DiaChi>) dcRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    // Test sửa một dòng trong bảng DiaChi
    @Test
    @Order(4)
    public void testUpdate(){
        DiaChi testUpdate = dcRepo.findById(100).get();
        testUpdate.setPhuongxa("sua phuongxa");
        dcRepo.save(testUpdate);
        assertEquals(dcRepo.findById(100).get().getPhuongxa(), "sua phuongxa");
    }

    //Test xóa một dòng trong bảng DiaChi
    @Test
    @Order(5)
    public void testDelete(){
        dcRepo.deleteById(100);
        assertNotEquals(dcRepo.existsById(100), true);
    }
}
