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

import ptit.data.TuanHocRepository;
import ptit.models.LichHoc;
import ptit.models.TuanHoc;
import ptit.data.LichHocRepository;


//Test các chức năng của lớp TuanHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestTuanHoc {
    @Autowired
    TuanHocRepository thRepo;
    @Autowired
    LichHocRepository lhRepo;

    //Test tạo một dòng trong bảng TuanHoc
    @Test
    @Order(1)
    public void testCreate() {
        TuanHoc test = new TuanHoc();
        test.setId(100);
        LichHoc lh = lhRepo.findById(1).get();
        test.setLh(lh);
        test.setMota("test kip hoc");
        test.setTen(100);
        thRepo.save(test);
        assertNotNull(thRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng TuanHoc
    @Test
    @Order(2)
    public void testSingle(){
        TuanHoc test = thRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getLh().getId(), 1);
        assertEquals(test.getTen(), 100);
    }

    //Test lấy tất cả các dòng trong bảng TuanHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<TuanHoc>listFound = (List<TuanHoc>) thRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng TuanHoc
    @Test
    @Order(4)
    public void testUpdate(){
        TuanHoc test = thRepo.findById(100).get();
        test.setTen(102);
        thRepo.save(test);
        assertEquals(thRepo.findById(100).get().getTen(), 102);
    }

    //Test xóa một dòng trong bảng TuanHoc
    @Test
    @Order(5)
    public void testDelete(){
        thRepo.deleteById(100);
        assertEquals(thRepo.existsById(100), false);
    }

    //Test lấy danh sách qua id lịch học
    @Test
    @Order(6)
    public void testGetAllByLHId(){
        //Lấy danh sách ngày học của lịch học có id 1
        List<TuanHoc> listFound = (List<TuanHoc>) thRepo.findByLichHocId(1);
        assertEquals(16, listFound.size());
        assertEquals(1, listFound.get(0).getTen());
    }
}
