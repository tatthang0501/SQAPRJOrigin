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

import ptit.data.MonHocRepository;
import ptit.models.BoMon;
import ptit.models.MonHoc;
import ptit.data.BoMonRepository;


//Test các chức năng của lớp MonHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestMonHoc {
    @Autowired
    MonHocRepository mhRepo;
    @Autowired
    BoMonRepository bmRepo;

    //Test tạo một dòng trong bảng MonHoc
    @Test
    @Order(1)
    public void testCreate() {
        MonHoc test = new MonHoc();
        test.setId(100);
        test.setMota("test mota");
        test.setSoTC(3);
        test.setTen("test ten");
        BoMon boMon = bmRepo.findById(1).get();
        test.setBoMon(boMon);
        mhRepo.save(test);
        assertNotNull(mhRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng MonHoc
    @Test
    @Order(2)
    public void testSingle(){
        MonHoc test = mhRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getBoMon().getId(), 1);
        assertEquals(test.getTen(), "test ten");
    }

    //Test lấy tất cả các dòng trong bảng MonHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<MonHoc>listFound = (List<MonHoc>) mhRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng MonHoc
    @Test
    @Order(4)
    public void testUpdate(){
        MonHoc test = mhRepo.findById(100).get();
        test.setTen("sua test ten");
        mhRepo.save(test);
        assertEquals(mhRepo.findById(100).get().getTen(), "sua test ten");
    }

    //Test xóa một dòng trong bảng MonHoc
    @Test
    @Order(5)
    public void testDelete(){
        mhRepo.deleteById(100);
        assertEquals(mhRepo.existsById(100), false);
    }

    //Test lấy danh sách môn học từ id của bộ môn
    @Test
    @Order(6)
    public void testGetByBMId(){
        //Lấy danh sách từ bộ môn có id là 1
        List<MonHoc>listFound = mhRepo.getListMHByBoMonID(1);
        assertEquals(5, listFound.size());
        assertEquals("Nhập môn công nghệ phần mềm", listFound.get(0).getTen());
    }
}
