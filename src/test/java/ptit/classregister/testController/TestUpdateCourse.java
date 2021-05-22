package ptit.classregister.testController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import ptit.common.JwtUtils;
import ptit.data.LichHocRepository;
import ptit.models.LichHocView;

//Test request tới URL localhost:8080/updatedangky lưu danh sách đăng ký
// Nguyễn Tất Thắng
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class TestUpdateCourse {
    
    @Autowired(required = true)
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    LichHocRepository lhRepo;
    // Test update danh sách thành công, các lớp học phần chọn chưa được đăng ký và có lịch không trùng nhau
    @Test
    @Order(1)
    public void testUpdateCourseSuccessful() throws JsonProcessingException, Exception{
        //Xóa hết thông tin đăng ký ban đầu
        lhRepo.xoaHetDangKy(1);
        // Chuẩn bị dữ liệu, có 2 lớp học phần
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        //Sử dụng token của user có ID là 1
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/updatedangky", 42L)
        .header("Authorization", "Bearer " + token).contentType("application/json")
        .content(objectMapper.writeValueAsString(listTest)))
        .andExpect(status().isOk());
        
        // Kiểm tra dữ liệu đã update
        assertEquals(2, lhRepo.findDaDKLHP(1).size());
        assertEquals(1, lhRepo.findDaDKLHP(1).get(0).getGv().getId());

        lhRepo.xoaHetDangKy(1);
        // Trả lại trạng thái ban đầu cho database
    }

    // Test update danh sách không thành công, không có môn học nào trong mảng
    @Test
    @Order(2)
    public void testBlankListUpdateCourse() throws JsonProcessingException, Exception{
        //Chuẩn bị dữ liệu rỗng
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        //Sử dụng token của user có ID là 1
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/updatedangky", 42L)
        .header("Authorization", "Bearer " + token).contentType("application/json")
        .content(objectMapper.writeValueAsString(listTest)))
        .andExpect(status().isNotAcceptable());
        // Status trả về là 406
        assertEquals(0, lhRepo.findDaDKLHP(1).size());
        //Kiểm tra số lượng đã đăng ký
    }

    //Test update danh sách khi có môn học đã được đăng ký
    @Test
    @Order(3)
    public void testRegisteredUpdateCourse() throws JsonProcessingException, Exception{
        //Xóa hết thông tin đăng ký ban đầu
        lhRepo.xoaHetDangKy(1);
        //Chuẩn bị dữ liệu lớp học phần
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        //Thuộc tính true cho biết lớp học phần này đã được đăng ký
        lvh1.setDaDK(true);
        listTest.add(lvh1);
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/updatedangky", 42L)
        .header("Authorization", "Bearer " + token).contentType("application/json")
        .content(objectMapper.writeValueAsString(listTest)))
        .andExpect(status().isForbidden()).andExpect(content()
        .string(containsString("PhÃ¡t hiá»n gian láº­n, há»§y bá» ÄÄng kÃ½!")));

        assertEquals(0, lhRepo.findDaDKLHP(1).size());
        //Kiểm tra số lượng đã đăng ký
        //Status trả về của request là 403
    }


    //Test update danh sách khi có môn học trùng lịch ngày học và kíp học với nhau
    @Test
    @Order(4)
    public void testSameDateUpdateCourse() throws JsonProcessingException, Exception{
        //Xóa hết thông tin đăng ký ban đầu
        lhRepo.xoaHetDangKy(1);
        //Chuẩn bị dữ liệu lớp học phần, có 2 lớp học phần với ngày học là thứ 2 và kíp học là 1,2
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(1);
        kip2.add(2);
        List<Integer> ngay2 = new ArrayList<Integer>();
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/updatedangky", 42L)
        .header("Authorization", "Bearer " + token).contentType("application/json")
        .content(objectMapper.writeValueAsString(listTest)))
        .andExpect(status().isNotAcceptable()).andExpect(content()
        .string(containsString("CÃ³ lá»p há»c bá» trÃ¹ng lá»ch, vui lÃ²ng thá»­ láº¡i")));

        assertEquals(0, lhRepo.findDaDKLHP(1).size());
        //Kiểm tra số lượng đã đăng ký
        //Status trả về của request là 406
    }

    //Test update danh sách khi người dùng chưa đăng nhập vào hệ thống
    @Test
    @Order(5)
    public void testUpdateCourseNotLogin() throws JsonProcessingException, Exception{
        //Xóa hết thông tin đăng ký ban đầu
        lhRepo.xoaHetDangKy(1);
        // Chuẩn bị dữ liệu, có 2 lớp học phần
        ArrayList<LichHocView> listTest = new ArrayList<LichHocView>();
        LichHocView lvh1 = new LichHocView();
        lvh1.setId(1);
        lvh1.setTen("Nhập môn công nghệ phần mềm");
        lvh1.setSoTC(3);
        lvh1.setPhong("A2");
        lvh1.setNhomTH(1);
        lvh1.setSiSoToiDa(50);
        List<Integer>kip = new ArrayList<Integer>();
        kip.add(1);
        kip.add(2);
        List<Integer> ngay = new ArrayList<Integer>();
        ngay.add(2);
        List<Integer> tuan = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan.add(i);
        lvh1.setKipHoc(kip);
        lvh1.setTuanHoc(tuan);
        lvh1.setNgayHoc(ngay);
        lvh1.setDaDK(false);
        listTest.add(lvh1);

        LichHocView lvh2 = new LichHocView();
        lvh2.setId(2);
        lvh2.setTen("Nhập môn công nghệ phần mềm");
        lvh2.setSoTC(3);
        lvh2.setPhong("A2");
        lvh2.setNhomTH(1);
        lvh2.setSiSoToiDa(45);
        List<Integer>kip2 = new ArrayList<Integer>();
        kip2.add(3);
        kip2.add(4);
        List<Integer> ngay2 = new ArrayList<Integer>();
        ngay2.add(2);
        List<Integer> tuan2 = new ArrayList<Integer>();
        for(int i = 1; i <= 16; i++) tuan2.add(i);
        lvh2.setKipHoc(kip2);
        lvh2.setTuanHoc(tuan2);
        lvh2.setNgayHoc(ngay2);
        lvh2.setDaDK(false);
        listTest.add(lvh2);

        //Không sử dụng token
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/updatedangky")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(listTest)))
        .andExpect(status().isUnauthorized()).andExpect(content()
        .string(containsString("ChÆ°a ÄÄng nháº­p, vui lÃ²ng ÄÄng nháº­p trÆ°á»c khi thá»±c hiá»n ÄÄng kÃ½ mÃ´n há»c")));
        
        // Kiểm tra dữ liệu đã update
        assertEquals(0, lhRepo.findDaDKLHP(1).size());

        lhRepo.xoaHetDangKy(1);
        // Trả lại trạng thái ban đầu cho database
    }
}
