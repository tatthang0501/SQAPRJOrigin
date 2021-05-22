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

import ptit.data.KyHocRepository;
import ptit.data.MonHocKyHocRepository;
import ptit.data.MonHocRepository;
import ptit.models.KyHoc;
import ptit.models.MonHoc;
import ptit.models.MonHocKyHoc;


//Test các chức năng của lớp MonHocKyHocRepository
//Nguyễn Tất Thắng
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestMonHocKyHoc {
    @Autowired
    MonHocKyHocRepository mhkhRepo;
    @Autowired
    MonHocRepository mhRepo;
    @Autowired
    KyHocRepository khRepo;

    //Test tạo một dòng trong bảng MonHocKyHoc
    @Test
    @Order(1)
    public void testCreate() {
        MonHocKyHoc test = new MonHocKyHoc();
        test.setId(100);
        MonHoc monHocTest = mhRepo.findById(1).get();
        test.setMh(monHocTest);
        KyHoc khTest = khRepo.findById(1).get();
        test.setKyhoc(khTest);
        mhkhRepo.save(test);
        assertNotNull(mhkhRepo.findById(100).get());
    }

    // //Test lấy một dòng trong bảng MonHocKyHoc
    @Test
    @Order(2)
    public void testSingle(){
        MonHocKyHoc test = mhkhRepo.findById(100).get();
        assertNotNull(test);
        assertEquals(test.getKyhoc().getId(), 1);
        assertEquals(test.getMh().getId(), 1);
    }

    //Test lấy tất cả các dòng trong bảng MonHocKyHoc
    @Test
    @Order(3)
    public void testGetAll(){
        List<MonHocKyHoc>listFound = (List<MonHocKyHoc>) mhkhRepo.findAll();
        assertNotNull(listFound);
        assertNotEquals(listFound.size(), 0);
    }

    //Test sửa một dòng trong bảng MonHocKyHoc
    @Test
    @Order(4)
    public void testUpdate(){
        MonHocKyHoc test = mhkhRepo.findById(100).get();
        MonHoc mhTest = mhRepo.findById(2).get();
        test.setMh(mhTest);
        mhkhRepo.save(test);
        assertEquals(mhkhRepo.findById(100).get().getMh().getId(), 2);
    }

    //Test xóa một dòng trong bảng MonHocKyHoc
    @Test
    @Order(5)
    public void testDelete(){
        mhkhRepo.deleteById(100);
        assertEquals(mhkhRepo.existsById(100), false);
    }

    //Test lấy danh sách từ id kỳ học
    @Test
    @Order(6)
    public void testGetByKHId(){
        // Lấy danh sách từ kỳ học có id là 2
        List<MonHocKyHoc>listFound = (List<MonHocKyHoc>) mhkhRepo.getListMHKH(2);
        assertEquals(19, listFound.size());
        assertEquals("Nhập môn công nghệ phần mềm", listFound.get(0).getMh().getTen());
    }
}
