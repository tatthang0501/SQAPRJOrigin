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
import ptit.data.LopHocPhanRepository;
import ptit.data.UserRepository;
import ptit.models.LichHoc;
import ptit.models.LopHocPhan;
import ptit.models.ThanhVien;


//Test các chức năng của lớp LichHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestLichHoc {
    @Autowired
    LichHocRepository khRepo;
    @Autowired
    LichHocRepository lhRepo;
    @Autowired
    LopHocPhanRepository lhpRepo;
    @Autowired
    UserRepository tvRepo;

    //Test tạo một dòng trong bảng LichHoc
    @Test
    @Order(1)
    public void testCreate() {
        LichHoc test = new LichHoc();
        test.setId(100);
        test.setTuanHoc(null);
        test.setKipHoc(null);
        test.setNgayHoc(null);
        test.setTen("test ten");
        test.setPhong("test phong");
        test.setNhomTH(100);

        LopHocPhan lhp = lhpRepo.findById(1).get();
        ThanhVien gv = tvRepo.findById(1).get();
        test.setLhp(lhp);
        test.setGv(gv);
        khRepo.save(test);
        assertNotNull(khRepo.findById(100).get());
    }

    //Test lấy một dòng trong bảng LichHoc
    @Test
    @Order(2)
    public void testSingle(){
        LichHoc test = khRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getGv().getId(), 1);
        assertEquals(test.getLhp().getId(), 1);
        assertEquals(test.getTen(), "test ten");
    }

    //Test lấy tất cả các dòng trong bảng LichHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<LichHoc>listFound = (List<LichHoc>) khRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng LichHoc
    @Test
    @Order(4)
    public void testUpdate(){
        LichHoc test = khRepo.findById(100).get();
        test.setTen("sua ten");
        khRepo.save(test);
        assertEquals(khRepo.findById(100).get().getTen(), "sua ten");
    }

    //Test xóa một dòng trong bảng LichHoc
    @Test
    @Order(5)
    public void testDelete(){
        khRepo.deleteById(100);
        assertEquals(khRepo.existsById(100), false);
    }

    //Test lấy lịch học qua id LopHocPhan
    @Test
    @Order(6)
    public void testGetByLhpId(){
        List<LichHoc> listTest = lhRepo.findLichLHP(1);
        assertEquals(1, listTest.size());
        assertEquals(1, listTest.get(0).getNhomTH());
    }

    //Test lấy lịch dạy đã đăng ký thông qua id giảng viên
    @Test
    @Order(7)
    public void testGetByGVId(){
        // Xóa hết tất cả các đăng ký của giảng viên có id là 1
        lhRepo.xoaHetDangKy(1);
        //Tìm lịch dạy của giảng viên có id là 1
        //Đăng ký cho giảng viên dạy lớp có id là 1
        lhRepo.updateDangKy(1, 1);
        List<LichHoc> listTest = lhRepo.findDaDKLHP(1);
        assertEquals(1, listTest.size());
        assertEquals("Nhập môn công nghệ phần mềm", listTest.get(0).getTen());
    }

    //Test cập nhật đăng ký lịch dạy cho giảng viên
    @Order(8)
    @Test
    public void testUpdateCourse(){
        //Giảng viên chưa đăng ký lịch dạy nào
        // Xóa hết tất cả các đăng ký của giảng viên có id là 1
        lhRepo.xoaHetDangKy(1);
        //Cập nhật lớp học có id 1,2,3 cho giảng viên này
        lhRepo.updateDangKy(1, 1);
        lhRepo.updateDangKy(1, 2);
        lhRepo.updateDangKy(1, 3);
        //Kiểm tra dữ liệu update
        List<LichHoc> listTest = lhRepo.findDaDKLHP(1);
        assertEquals(3, listTest.size());
        assertEquals(1, listTest.get(0).getLhp().getId());
        //Reset trạng thái ban đầu cho database
        lhRepo.xoaHetDangKy(1);
    }

    @Order(9)
    @Test
    public void testDeleteAllByGVId(){
        // Xóa hết tất cả các đăng ký của giảng viên có id là 1
        lhRepo.xoaHetDangKy(1);
        //Kiểm tra dữ liệu sau khi xóa
        List<LichHoc> listTest = lhRepo.findDaDKLHP(1);
        assertEquals(0, listTest.size());
    }
}
