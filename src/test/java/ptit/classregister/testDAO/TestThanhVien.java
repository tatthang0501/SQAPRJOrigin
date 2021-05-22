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

import ptit.data.UserRepository;
import ptit.models.ThanhVien;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestThanhVien {
    
    @Autowired
    UserRepository tvRepo;

    //Test tạo ra một dòng trong bảng thanhvien
    @Test
    @Order(1)
    public void testCreate(){
        ThanhVien tv = new ThanhVien();
        tv.setId(100);
        tv.setDiaChi(null);
        tv.setUsername("username test");
        tv.setPassword("password test");
        tv.setNgaySinh("1999-05-01");
        tv.setEmail("test@gmail.com");
        tv.setDt("test phone");
        tv.setGhichu("test ghi chu");
        tv.setVitri("test vitri");
        tv.setHo("test ho");
        tv.setDem("test dem");
        tv.setTen("test ten");
        tvRepo.save(tv);
        assertNotNull(tvRepo.findById(100).get());
        assertEquals(tvRepo.findById(100).get().getUsername(), "username test");
    }

    //Test lấy ra một dòng trong bảng thanhvien
    @Test
    @Order(2)
    public void testSingle(){
        ThanhVien test = tvRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getTen(), "test ten");
    }

    //Test lấy ra tất cả các dòng trong bảng thanhvien
    @Test
    @Order(3)
    public void testGetAll(){
        List<ThanhVien> listFound = tvRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng thanhvien
    @Test
    @Order(4)
    public void testUpdate(){
        ThanhVien tv = tvRepo.findById(100).get();
        tv.setTen("sua ten");
        tv.setDem("sua dem");
        tvRepo.save(tv);
        assertEquals(tvRepo.findById(100).get().getTen(), "sua ten");
        assertEquals(tvRepo.findById(100).get().getDem(), "sua dem");

    }

    //Test xóa một dòng trong bảng thanh
    @Test
    @Order(5)
    public void testDelete(){
        tvRepo.deleteById(100);
        assertEquals(tvRepo.existsById(100), false);
    }
}
