package ptit.classregister.testDAO;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import ptit.data.BoMonRepository;
import ptit.data.HocKyRepository;
import ptit.models.BoMon;
import ptit.models.Khoa;

//Test Các chức năng của lớp BoMonRepository
// Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestBoMon {
    
    @Autowired
    BoMonRepository bmRepo;

    @Autowired
    HocKyRepository hkRepo;
    
    //Test tạo đối tượng bộ môn
    @Test
    @Order(1)
    public void testCreate(){
        BoMon bm = new BoMon();
        bm.setId(1000);
        bm.setTen("Bộ môn test 1");
        Khoa k = new Khoa();
        k.setId(1);
        bm.setKhoa(k);
        bm.setMota("Bộ môn test 1");
        bm.setDsMonHoc(null);
        bm.setDsGiangVien(null);
        bmRepo.save(bm);
        assertNotNull(bmRepo.findById(1000).get());
    }

    // Test lấy tất cả các dòng trong bảng bộ môn   
    @Test
    @Order(2)
    public void testReadAll(){
        List<BoMon> listFound = (List<BoMon>) bmRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test lấy dòng vừa thêm vào bảng
    @Test
    @Order(3)
    public void testSingleRow(){
        BoMon bm = bmRepo.findById(1000).get();
        assertEquals(bm.getTen(),"Bộ môn test 1");
        assertEquals(bm.getKhoa().getId(), 1);
    }
    
    //Test sửa dữ liệu trong bảng
    @Test
    @Order(4)
    public void testUpdate(){
        BoMon bm = bmRepo.findById(1000).get();
        bm.setTen("Sửa bộ môn test 1");
        bmRepo.save(bm);
        assertNotEquals("Bộ môn test 1", bmRepo.findById(1000).get().getTen());
        assertEquals("Sửa bộ môn test 1", bmRepo.findById(1000).get().getTen());
    }

    //Test xóa dữ liệu trong bảng
    @Test
    @Order(5)
    public void testDelete(){
        bmRepo.deleteById(1000);
        assertEquals(bmRepo.existsById(1000), false);
    }

    //Test lấy danh sách bộ môn từ id khoa
    @Test
    @Order(6)
    public void testGetAllByKhoaID(){
        List<BoMon> listBM =  bmRepo.getListBoMon(1);
        //Kiểm tra list lấy từ CSDL khác null
        assertNotNull(listBM);
        //Kiểm tra số lượng bộ môn lấy được từ CSDL
        assertEquals(listBM.size(), 2);
        //Kiểm tra id của bộ môn thứ nhất
        assertEquals(listBM.get(0).getId(), 1);
        // //Kiểm tra id của bộ môn thứ hai
        assertEquals(listBM.get(1).getId(), 2);
        // //Kiểm tra tên của bộ môn thứ nhất
        assertEquals(listBM.get(0).getTen(), "Công nghệ phần mềm");
        // //Kiểm tra tên của bộ môn thứ hai
        assertEquals(listBM.get(1).getTen(), "Trí tuệ nhân tạo");
        // //Kiểm tra id khoa của 2 bộ môn
        assertEquals(listBM.get(0).getKhoa().getId(), 1);
        assertEquals(listBM.get(1).getKhoa().getId(), 1);
    }
}
