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

import ptit.data.GiangVienKhoaRepository;
import ptit.data.KhoaRepository;
import ptit.data.UserRepository;
import ptit.models.GiangVienKhoa;
import ptit.models.Khoa;
import ptit.models.ThanhVien;

//Test các chức năng của lớp GiangVienRepository
// Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestGiangVienKhoa {
    
    @Autowired
    GiangVienKhoaRepository gvkRepo;

    @Autowired
    UserRepository tvRepo;

    @Autowired
    KhoaRepository kRepo;
    //Test tạo đối tượng GiangVienKhoa
    @Test
    @Order(1)
    public void testCreate(){
        GiangVienKhoa test = new GiangVienKhoa();
        test.setId(100);

        ThanhVien tv = tvRepo.findById(1).get();
        test.setGiangVien(tv);
        Khoa k = kRepo.findById(1).get();
        k.setId(1);
        test.setKhoa(k);
        
        gvkRepo.save(test);
        assertNotNull(gvkRepo.findById(100).get());
        assertEquals(gvkRepo.findById(100).get().getGiangVien().getId(), 1);
    }

    //Test lấy một đối tượng GiangVienKhoa
    @Test
    @Order(2)
    public void testSingle(){
        GiangVienKhoa test = gvkRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getKhoa().getTen(), "CNTT");
        assertEquals(test.getGiangVien().getId(), 1);
    }

    // Test lấy tất cả dòng trong bảng GiangVienKhoa
    @Test
    @Order(3)
    public void testGetAll(){
        List<GiangVienKhoa> listFound = (List<GiangVienKhoa>) gvkRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng GiangVienKhoa
    @Test
    @Order(4)
    public void testUpdate(){
        GiangVienKhoa test = gvkRepo.findById(100).get();
        ThanhVien tv = tvRepo.findById(2).get();
        test.setGiangVien(tv);
        gvkRepo.save(test);
        assertEquals(gvkRepo.findById(100).get().getGiangVien(),tv);
    }

    //Test xóa một dòng trong bảng GiangVienKhoa
    @Test
    @Order(5)
    public void testDelete(){
        gvkRepo.deleteById(100);
        assertEquals(gvkRepo.existsById(100), false);
    }

}
