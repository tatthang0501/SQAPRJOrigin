package ptit.classregister.testDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ptit.data.HocKyRepository;
import ptit.data.KyHocRepository;
import ptit.data.NamHocRepository;
import ptit.models.HocKy;
import ptit.models.KyHoc;
import ptit.models.NamHoc;

//Test các chức năng của lớp KyHocRepository
// Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestKyHoc {
    @Autowired
    KyHocRepository khRepo;
    @Autowired
    HocKyRepository hkRepo;
    @Autowired
    NamHocRepository nhRepo;

    //Test tạo một dòng trong bảng KyHoc
    @Test
    @Order(1)
    public void testCreate() {
        KyHoc test = new KyHoc();
        test.setId(100);
        HocKy hkTest = hkRepo.findById(1).get();
        NamHoc nhTest = nhRepo.findById(1).get();
        test.setHk(hkTest);
        test.setNh(nhTest);
        khRepo.save(test);
        assertNotNull(khRepo.findById(100).get());
    }

    //Test lấy một dòng trong bảng KyHoc
    @Test
    @Order(2)
    public void testSingle(){
        KyHoc test = khRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getHk().getId(), 1);
        assertEquals(test.getNh().getId(), 1);
    }

    //Test lấy tất cả các dòng trong bảng KyHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<KyHoc>listFound = (List<KyHoc>) khRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng KyHoc
    @Test
    @Order(4)
    public void testUpdate(){
        KyHoc test = khRepo.findById(100).get();
        HocKy hkTest = hkRepo.findById(2).get();
        test.setHk(hkTest);
        khRepo.save(test);
        assertEquals(khRepo.findById(100).get().getHk().getId(), 2);
    }

    //Test xóa một dòng trong bảng KyHoc
    @Test
    @Order(5)
    public void testDelete(){
        khRepo.deleteById(100);
        assertEquals(khRepo.existsById(100), false);
    }
}
