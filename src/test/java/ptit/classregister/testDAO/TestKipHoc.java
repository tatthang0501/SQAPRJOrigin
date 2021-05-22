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

import ptit.data.KipHocRepository;
import ptit.data.LichHocRepository;
import ptit.models.KipHoc;
import ptit.models.LichHoc;


//Test các chức năng của lớp KipHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestKipHoc {
    @Autowired
    KipHocRepository khRepo;
    @Autowired
    LichHocRepository lhRepo;

    //Test tạo một dòng trong bảng KipHoc
    @Test
    @Order(1)
    public void testCreate() {
        KipHoc test = new KipHoc();
        test.setId(100);
        LichHoc lh = lhRepo.findById(1).get();
        test.setLh(lh);
        test.setMota("test kip hoc");
        test.setTen(100);
        khRepo.save(test);
        assertNotNull(khRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng KipHoc
    @Test
    @Order(2)
    public void testSingle(){
        KipHoc test = khRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getLh().getId(), 1);
        assertEquals(test.getTen(), 100);
    }

    //Test lấy tất cả các dòng trong bảng KipHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<KipHoc>listFound = (List<KipHoc>) khRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng KipHoc
    @Test
    @Order(4)
    public void testUpdate(){
        KipHoc test = khRepo.findById(100).get();
        test.setTen(102);
        khRepo.save(test);
        assertEquals(khRepo.findById(100).get().getTen(), 102);
    }

    //Test xóa một dòng trong bảng KipHoc
    @Test
    @Order(5)
    public void testDelete(){
        khRepo.deleteById(100);
        assertEquals(khRepo.existsById(100), false);
    }

    // Test lấy danh sách Kiphoc theo id của Lichhoc
    @Test
    @Order(6)
    public void testGetByLichHocId(){
        //Kiểm tra KipHoc của LichHoc có id là 1
        List<KipHoc> listTest = khRepo.findByLichHocId(1);
        assertEquals(listTest.size(), 2);
        assertEquals(listTest.get(0).getTen(), 1);
    }
}
