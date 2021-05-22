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

import ptit.data.NamHocRepository;
import ptit.models.NamHoc;



//Test các chức năng của lớp NamHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestNamHoc {
    @Autowired
    NamHocRepository nhRepo;

    //Test tạo một dòng trong bảng NamHoc
    @Test
    @Order(1)
    public void testCreate() {
        NamHoc test = new NamHoc();
        test.setId(100);
        test.setMota("test mota");
        test.setTen("test ten");
        nhRepo.save(test);
        assertNotNull(nhRepo.findById(100).get());
    }

    //Test lấy một dòng trong bảng NamHoc
    @Test
    @Order(2)
    public void testSingle(){
        NamHoc test = nhRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getTen(), "test ten");
        assertEquals(test.getMota(), "test mota");
    }

    //Test lấy tất cả các dòng trong bảng NamHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<NamHoc>listFound = (List<NamHoc>) nhRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng NamHoc
    @Test
    @Order(4)
    public void testUpdate(){
        NamHoc test = nhRepo.findById(100).get();
        test.setTen("sua ten");
        nhRepo.save(test);
        assertEquals(nhRepo.findById(100).get().getTen(), "sua ten");
    }

    //Test xóa một dòng trong bảng NamHoc
    @Test
    @Order(5)
    public void testDelete(){
        nhRepo.deleteById(100);
        assertEquals(nhRepo.existsById(100), false);
    }
}
