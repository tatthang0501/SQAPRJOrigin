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

import ptit.data.LichHocRepository;
import ptit.data.NgayHocRepository;
import ptit.models.LichHoc;
import ptit.models.NgayHoc;


//Test các chức năng của lớp NgayHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestNgayHoc {
    @Autowired
    NgayHocRepository nhRepo;
    @Autowired
    LichHocRepository lhRepo;

    //Test tạo một dòng trong bảng NgayHoc
    @Test
    @Order(1)
    public void testCreate() {
        NgayHoc test = new NgayHoc();
        test.setId(100);
        LichHoc lh = lhRepo.findById(1).get();
        test.setLh(lh);
        test.setMota("test kip hoc");
        test.setTen(100);
        nhRepo.save(test);
        assertNotNull(nhRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng NgayHoc
    @Test
    @Order(2)
    public void testSingle(){
        NgayHoc test = nhRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getLh().getId(), 1);
        assertEquals(test.getTen(), 100);
    }

    //Test lấy tất cả các dòng trong bảng NgayHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<NgayHoc>listFound = (List<NgayHoc>) nhRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng NgayHoc
    @Test
    @Order(4)
    public void testUpdate(){
        NgayHoc test = nhRepo.findById(100).get();
        test.setTen(102);
        nhRepo.save(test);
        assertEquals(nhRepo.findById(100).get().getTen(), 102);
    }

    //Test xóa một dòng trong bảng KipHoc
    @Test
    @Order(5)
    public void testDelete(){
        nhRepo.deleteById(100);
        assertEquals(nhRepo.existsById(100), false);
    }

    //Test lấy danh sách qua id lịch học
    @Test
    @Order(6)
    public void testGetAllByLHId(){
        //Lấy danh sách ngày học của lịch học có id 1
        List<NgayHoc> listFound = (List<NgayHoc>) nhRepo.findByLichHocId(1);
        assertEquals(1, listFound.size());
        assertEquals(2, listFound.get(0).getTen());
    }
}
